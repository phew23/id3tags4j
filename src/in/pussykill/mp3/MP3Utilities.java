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
import in.pussykill.id3.v2.frames.*;
import in.pussykill.id3.v2.v0_0.ID3v200Tag;
import in.pussykill.id3.v2.v3_0.ID3v230FrameHeader;
import in.pussykill.id3.v2.v3_0.ID3v230Tag;
import in.pussykill.id3.v2.v4_0.ID3v240Tag;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

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
    public static MP3File init(final File file) throws FileNotFoundException, 
            IOException {
        
        ID3v2TagHeader id3v2TagHeader;
        ID3v2Tag id3v2Tag = null;
        
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        
        byte[] id3v2TagHeaderBytes = 
                new byte[ID3v2Constants.ID3V2_TAG_HEADER_LENGTH];
        
        raf.seek(0);
        raf.read(id3v2TagHeaderBytes, 0, 10);
        
        id3v2TagHeader = new ID3v2TagHeader(id3v2TagHeaderBytes);
        
        if(id3v2TagHeader.getMinorVersion() == 
                ID3v2Constants.ID3V200_MINOR_VERSION)
            id3v2Tag = parseID3v200Tag(id3v2TagHeader, raf);
        else if(id3v2TagHeader.getMinorVersion() == 
                ID3v2Constants.ID3V230_MINOR_VERSION)
            id3v2Tag = parseID3v230Tag(id3v2TagHeader, raf);
        else if(id3v2TagHeader.getMinorVersion() == 
                ID3v2Constants.ID3V240_MINOR_VERSION)
            id3v2Tag = parseID3v240Tag(id3v2TagHeader, raf);
        
        return new MP3File(file, id3v2Tag);
    }
    
    /**
     * Creates a new {@link ID3v200Tag} read from the {@link MP3File}.
     * @param id3v2TagHeader The {@link ID3v2TagHeader} of the MP3.
     * @return A new {@link ID3v200Tag}.
     */
    private static ID3v200Tag parseID3v200Tag(final ID3v2TagHeader id3v2TagHeader,
            final RandomAccessFile raf) {       
        //TODO: to be implemented
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
            
            int frameBodyLen = id3v230FrameHeader.getFrameBodyLength();
          
            //as soon as nothing else but padding is read we can stop parsing
            if(!isID3v2Frame(id3v230FrameHeader.getIdentifierBytes())) {
                //TODO: calculate padding here
                break;
            }

            //copy all bytes of the frame into one array
            byte[] frame = Arrays.copyOfRange(tagBody, 0, frameBodyLen + 10);
            
            //copy all the frame's body bytes into one array
            byte[] frameBody = Arrays.copyOfRange(frame, 10, frameBodyLen + 10);
            
            //frame's length is header + body, header is always 10 bytes
            int frameLength = 10 + frameBodyLen;
            
            //cut the parsed frame off the ID3v2 tag body
            tagBody = Arrays.copyOfRange(tagBody, 
                    //start at header length (10 bytes) + frame body length (dynamic)
                    frameBodyLen + 10,
                    /*
                     * and copy the rest of the array, excluding the first frame that
                     * we just have parsed above:
                     * == complete tag length - (10 bytes frame header + frame body length)
                     */
                    tagBody.length);
            
            String identifier = id3v230FrameHeader.getIdentifier();
            ID3v2Frame id3v2Frame = null;
            
            //if this frame is a text frame then parse the text frame's body
           if(isID3v2TextFrame(id3v230FrameHeader.getIdentifierBytes())) {
               ID3v2TextFrameBody id3v2TextFrameBody = 
                       ID3v2FrameUtilities.parseID3v2TextFrameBody(frameBody);
               id3v2Frame = new ID3v2Frame(id3v230FrameHeader, 
                       id3v2TextFrameBody);
           }
           //if this frame is a TXXX frame let's parse the TXXX-frame's body
           else if(identifier.equals("TXXX")) {
               ID3v2TXXXFrameBody id3v2TXXXFrameBody = 
                       ID3v2FrameUtilities.parseID3v2TXXXFrameBody(frameBody);
               id3v2Frame = new ID3v2Frame(id3v230FrameHeader, 
                       id3v2TXXXFrameBody);
           }
           //if this frame is a COMM frame let's parse the COMM-framebody
           else if(identifier.equals("COMM")) {
                ID3v2COMMFrameBody id3v2COMMFrameBody = 
                       ID3v2FrameUtilities.parseID3v2COMMFrameBody(frameBody);
                id3v2Frame = new ID3v2Frame(id3v230FrameHeader, 
                       id3v2COMMFrameBody);
           }
           //if this frame is an APIC frame let's parse the APIC-framebody
           else if(identifier.equals("APIC")) {
                ID3v2APICFrameBody id3v2APICFrameBody =
                       ID3v2FrameUtilities.parseID3v2APICFrameBody(frameBody);
                id3v2Frame = new ID3v2Frame(id3v230FrameHeader, 
                       id3v2APICFrameBody);
           }
           else if(identifier.equals("PRIV")) {
               ID3v2PRIVFrameBody id3v2PRIVFrameBody =
                       ID3v2FrameUtilities.parseID3v2PRIVFrameBody(frameBody);
               id3v2Frame = new ID3v2Frame(id3v230FrameHeader,
                       id3v2PRIVFrameBody);
           }
           else if(identifier.equals("WXXX")) {
               ID3v2WXXXFrameBody id3v2WXXXFrameBody =
                       ID3v2FrameUtilities.parseID3v2WXXXFrameBody(frameBody);
               id3v2Frame = new ID3v2Frame(id3v230FrameHeader, 
                       id3v2WXXXFrameBody);
           }
           
           if(id3v2Frame != null) {
                id3v2Frames = Arrays.copyOf(id3v2Frames, id3v2Frames.length + 1);
                id3v2Frames[id3v2Frames.length - 1] = id3v2Frame;
           }
        }
        
        ID3v2TagBody id3v2TagBody = new ID3v2TagBody(id3v2Frames);
        return new ID3v230Tag(id3v2TagHeader, id3v2TagBody);
    }
    
    /**
     * Creates a new {@link ID3v240Tag} read from the {@link MP3File}.
     * @param id3v2TagHeader The {@link ID3v2TagHeader} of the MP3.
     * @return A new {@link ID3v240Tag}.
     */
    private static ID3v240Tag parseID3v240Tag(final ID3v2TagHeader id3v2TagHeader,
            final RandomAccessFile raf) {
        //TODO: to be implemented
        ID3v2TagBody id3v2TagBody = null;
        return new ID3v240Tag(id3v2TagHeader, id3v2TagBody);
    }
    
    private static boolean isID3v2Frame(final byte[] b) {
        //v3.0 and v4.0 identifiers have a length of 4 (ie. "TPE1", "TALB")
        if(b.length == 4) {
            if(b[0] >= 'A' && b[0] <= 'Z') {
                if(b[1] >= 'A' && b[1] <= 'Z') {
                    if(b[2] >= 'A' && b[2] <= 'Z') {
                        if((b[3] >= 'A' && b[3] <= 'Z') ||
                                (b[3] >= '0' && b[3] <= '9')) {
                            return true;
                        }
                    }
                }
            }
        }
        //v2.0 identifiers have a length of 3 (ie. "TP1", "TAB")
        else if(b.length == 3) {
            if(b[0] >= 'A' && b[0] <= 'Z') {
                if(b[1] >= 'A' && b[1] <= 'Z') {
                    if((b[2] >= 'A' && b[2] <= 'Z') ||
                            (b[2] >= '0' && b[2] <= '9')) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * @param b - The identifier byte[] located in the frames 
     *            {@link ID3v2FrameHeader}.
     * @return True if the frame is a text frame; false otherwise.
     */
    private static boolean isID3v2TextFrame(final byte[] b) {
        //v3.0 and v4.0 identifiers have a length of 4 (ie. "TPE1", "TALB")
        if(b.length == 4) {
            if(b[0] == 'T') {
                //'TXXX' frame is to be excluded, this is the user defined text
                //information frame.
                if(b[1] == 'X' && b[2] == 'X' && b[3] == 'X')
                    return false;
                if(b[1] >= 'A' && b[1] <= 'Z') {
                    if(b[2] >= 'A' && b[2] <= 'Z') {
                        if((b[3] >= 'A' && b[3] <= 'Z') || 
                                (b[3] >= '0' && b[3] <= '9')) {
                            return true;
                        }
                    }
                }
            }
        }
        //v2.0 identifiers have a length of 3 (ie. "TP1", "TAB")
        else if(b.length == 3) {
            if(b[0] == 'T') {
                //'TXX' is to be excluded, this is the user defined 
                //text information frame.
                if(b[1] == 'X' && b[2] == 'X')
                    return false;
                if(b[1] >= 'A' && b[1] <= 'Z') {
                    if((b[2] >= 'A' && b[2] <= 'Z') ||
                            (b[2] >= '0' && b[2] <= '9')) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /*
     *
     * @param identifier The identifier of the alleged frame.
     * @return True if the identifier indicates that it actually is a frame; false otherwise.
     *
    private static boolean isID3v2Frame(final String identifier) {
        Pattern frames = 
                Pattern.compile("[A-Z][A-Z](?:[A-Z]|[0-9])|[A-Z][A-Z][A-Z](?:[A-Z]|[0-9])");
        Matcher matcher = frames.matcher(identifier);
        if(matcher.matches())
            return true;
        return false;
    }
    
     *
     * @param identifier The identifier of the frame located in its {@link ID3v2FrameHeader}.
     * @return True if the frame is a text frame; false otherwise.
     *
    private static boolean isID3v2TextFrame(final String identifier) {
        Pattern textFrames = 
                Pattern.compile("T(?:[A-Z](?:[A-Z]|[0-9])|[A-Z][A-Z](?:[A-Z]|[0-9]))");
        Matcher matcher = textFrames.matcher(identifier);
        if(matcher.matches())
            return true;
        return false;
    }
    */
 
}
