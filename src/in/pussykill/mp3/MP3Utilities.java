/*
 * This file is part of id3tags4j, an ID3 tag library for Java.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package in.pussykill.mp3;

import in.pussykill.id3.v2.ID3v2Constants;
import in.pussykill.id3.v2.ID3v2Tag;
import in.pussykill.id3.v2.ID3v2TagBody;
import in.pussykill.id3.v2.ID3v2TagHeader;
import in.pussykill.id3.v2.frames.ID3v2Frame;
import in.pussykill.id3.v2.frames.ID3v2FrameUtilities;
import in.pussykill.id3.v2.frames.ID3v2TextFrameBody;
import in.pussykill.id3.v2.v0_0.ID3v200Tag;
import in.pussykill.id3.v2.v3_0.ID3v230FrameHeader;
import in.pussykill.id3.v2.v3_0.ID3v230Tag;
import in.pussykill.id3.v2.v4_0.ID3v240Tag;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class handles the creation of {@link MP3Files}.
 * @author phew
 */
public class MP3Utilities {
    
    //TODO: search for "ID3" indicator, return new MP3File(null) if no ID3v2Tag 
    //found.
    /**
     * Creates a new {@link MP3File}.
     * @param path Path to the MP3 file to be read.
     * @return A new {@link MP3File} object.
     * @throws FileNotFoundException is thrown when the specified file does not 
     *         exist
     * @throws IOException is thrown when the specified file could not be read
     */
    public static MP3File init(final String path) throws FileNotFoundException, 
            IOException {
        
        ID3v2TagHeader id3v2TagHeader;
        ID3v2Tag id3v2Tag = null;
        
        RandomAccessFile raf = new RandomAccessFile(new File(path), "rw");
        
        byte[] id3v2TagHeaderBytes = 
                new byte[ID3v2Constants.ID3V2_TAG_HEADER_LENGTH];
        
        raf.seek(0);
        raf.read(id3v2TagHeaderBytes, 0, 10);
        
        id3v2TagHeader = new ID3v2TagHeader(id3v2TagHeaderBytes);
        
        if(id3v2TagHeader.getMinorVersionByte() == 
                ID3v2Constants.ID3V200_MINOR_VERSION)
            id3v2Tag = parseID3v200Tag(id3v2TagHeader, raf);
        else if(id3v2TagHeader.getMinorVersionByte() == 
                ID3v2Constants.ID3V230_MINOR_VERSION)
            id3v2Tag = parseID3v230Tag(id3v2TagHeader, raf);
        else if(id3v2TagHeader.getMinorVersionByte() == 
                ID3v2Constants.ID3V240_MINOR_VERSION)
            id3v2Tag = parseID3v240Tag(id3v2TagHeader, raf);
        
        return new MP3File(id3v2Tag);
    }
    
    /**
     * Creates a new {@link ID3v200Tag} read from the {@link MP3File}.
     * @param id3v2TagHeader The {@link ID3v2TagHeader} of the MP3.
     * @return A new {@link ID3v200Tag}.
     */
    private static ID3v200Tag parseID3v200Tag(final ID3v2TagHeader id3v2TagHeader,
            final RandomAccessFile raf) {       
        
        ID3v2TagBody id3v2TagBody = null;
        return new ID3v200Tag(id3v2TagHeader, id3v2TagBody);
    }
    
    /**
     * Creates a new {@link ID3v230Tag} read from the {@link MP3File}.
     * @param id3v2TagHeader The {@link ID3v2TagHeader} of the MP3.
     * @return A new {@link ID3v230Tag}.
     *
     * @throws IOException Is thrown when i/o errors occure reading the MP3 file.
     */
    private static ID3v230Tag parseID3v230Tag(final ID3v2TagHeader id3v2TagHeader, 
            final RandomAccessFile raf) throws IOException {
        
        final int tagBodyLength = id3v2TagHeader.getTagBodyLength();
        byte[] tagBody = new byte[tagBodyLength];
        raf.read(tagBody, 0, tagBodyLength);
        
        ID3v2Frame[] id3v2Frames = new ID3v2Frame[0];
        //A ID3v2Frame has to be at least 11 bytes in size (10 header + 1 body)
        while(tagBody.length > 10) {
            
            /* 
             * copy first 10 bytes of the body into a new array, the first 10
             * bytes of the ID3v2 tag body are the header bytes of the first
             * ID3v2 frame.
             */
            byte[] frameHeader = Arrays.copyOfRange(tagBody, 0, 10);
            ID3v230FrameHeader id3v230FrameHeader = 
                    new ID3v230FrameHeader(frameHeader);
          
            //as soon as nothing else but padding is read we can stop parsing
            if(!isID3v2Frame(id3v230FrameHeader.getIdentifier()))
                break;
            
            /*
             * print frame identifier ("TPE1", "TIT2" etc.)
             */
            System.out.println("Found: " + id3v230FrameHeader.getIdentifier());

            //copy all bytes of the frame into one array
            byte[] frame = Arrays.copyOfRange(tagBody, 0, 
                    id3v230FrameHeader.getFrameBodyLength() + 10);
            
            //copy all the frame's body bytes into one array
            byte[] frameBody = Arrays.copyOfRange(frame, 10, 
                    id3v230FrameHeader.getFrameBodyLength() + 10);
            
            //cut the frame header off the id3v2 tag body
            tagBody = Arrays.copyOfRange(tagBody, 
                    //start at header length (10 bytes) + frame body length (dynamic)
                    id3v230FrameHeader.getFrameBodyLength() + 10, 
                    //and copy the rest of the array, excluding the first frame that
                    //we just have parsed above:
                    //== complete tag length - (10 bytes frame header + frame body length)
                    (tagBody.length - 1) - (id3v230FrameHeader.getFrameBodyLength() + 10));
            
           if(isID3v2TextFrame(id3v230FrameHeader.getIdentifier())) {
               ID3v2TextFrameBody id3v2TextFrameBody = ID3v2FrameUtilities.parseID3v2TextFrame(frameBody);
               id3v2Frames = Arrays.copyOf(id3v2Frames, id3v2Frames.length + 1);
               id3v2Frames[id3v2Frames.length - 1] = new ID3v2Frame(id3v230FrameHeader, id3v2TextFrameBody);
           }
            
            
        }
        
        ID3v2TagBody id3v2TagBody = new ID3v2TagBody(id3v2Frames);
        return new ID3v230Tag(id3v2TagHeader, id3v2TagBody);
        
    }
    
    //TODO: maybe replace this with byte[0] >= 'A' && byte[0] <= Z etc. for
    //      performance, hence REGEX is very ressource-taking.
    /**
     * @param identifier The identifier of the alleged frame.
     * @return True if the identifier indicates that it actually is a frame; false otherwise.
     */
    private static boolean isID3v2Frame(final String identifier) {
        Pattern frames = 
                Pattern.compile("[A-Z][A-Z](?:[A-Z]|[0-9])|[A-Z][A-Z][A-Z](?:[A-Z]|[0-9])");
        Matcher matcher = frames.matcher(identifier);
        if(matcher.matches())
            return true;
        return false;
    }
    
    /**
     * @param identifier The identifier of the frame located in its {@link ID3v2FrameHeader}.
     * @return True if the frame is a text frame; false otherwise.
     */
    private static boolean isID3v2TextFrame(final String identifier) {
        Pattern textFrames = 
                Pattern.compile("T(?:[A-Z](?:[A-Z]|[0-9])|[A-Z][A-Z](?:[A-Z]|[0-9]))");
        Matcher matcher = textFrames.matcher(identifier);
        if(matcher.matches())
            return true;
        return false;
    }
    
    /**
     * Creates a new {@link ID3v240Tag} read from the {@link MP3File}.
     * @param id3v2TagHeader The {@link ID3v2TagHeader} of the MP3.
     * @return A new {@link ID3v240Tag}.
     */
    private static ID3v240Tag parseID3v240Tag(final ID3v2TagHeader id3v2TagHeader,
            final RandomAccessFile raf) {
        
        ID3v2TagBody id3v2TagBody = null;
        return new ID3v240Tag(id3v2TagHeader, id3v2TagBody);
    }
    
    
    
    
}
