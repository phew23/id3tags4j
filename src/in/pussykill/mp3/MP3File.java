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

import in.pussykill.id3.v2.*;
import in.pussykill.id3.v2.frames.ID3v2Frame;
import in.pussykill.id3.v2.frames.ID3v2FrameHeader;
import in.pussykill.id3.v2.frames.ID3v2TextFrameBody;
import in.pussykill.id3.v2.frames.selectors.ID3v2Frames;
import in.pussykill.id3.v2.v0_0.ID3v200Tag;
import in.pussykill.id3.v2.v3_0.ID3v230FrameHeader;
import in.pussykill.id3.v2.v3_0.ID3v230Tag;
import in.pussykill.id3.v2.v4_0.ID3v240Tag;
import java.io.File;

/**
 * This class represents a MP3 file.
 * @author phew
 */
public class MP3File {
    
    private final File file;
    private final ID3v2Tag id3v2Tag;
    
    /**
     * Creates a new MP3File with the given tag.
     * @param id3v2Tag - {@link ID3v2Tag} for this MP3File.
     */
    public MP3File(final File file, final ID3v2Tag id3v2Tag) {
        this.file = file;
        this.id3v2Tag = id3v2Tag;
    }
    
    /**
     * @return The {@link File} object for this MP3File.
     */
    public File getFile() {
        return file;
    }
    
    /**
     * @return The {@link ID3v2Tag} for this MP3File object.
     */
    public ID3v2Tag getID3v2Tag() {
        return id3v2Tag;
    }
    
    /**
     * @return True if this MP3File has an {@link ID3v2Tag}; false otherwise;
     */
    public boolean hasID3v2Tag() {
        return id3v2Tag != null;
    }
    
    /**
     * @return true if this MP3File has an {@link ID3v200Tag}; false otherwise
     */
    public boolean hasID3v200Tag() {
        return id3v2Tag instanceof ID3v200Tag;
    }
    
    /**
     * @return True if this MP3File has an {@link ID3v230Tag}; false otherwise;
     */
    public boolean hasID3v230Tag() {
        return id3v2Tag instanceof ID3v230Tag;
    }
    
    /**
     * @return True if this MP3File has an {@link ID3v240Tag}; false otherwise.
     */
    public boolean hasID3v240Tag() {
        return id3v2Tag instanceof ID3v240Tag;
    }
    
    public void setArtist(final String artist, final ID3v2Charsets charset) {
        ID3v2TagHeader id3v2TagHeader = id3v2Tag.getTagHeader();
        ID3v2TagBody id3v2TagBody = id3v2Tag.getTagBody();
        ID3v2Frame id3v2Frame = id3v2TagBody.getFrameByType(ID3v2Frames.TPE1);
        if(id3v2Frame == null) {
            return;
            //create and add a new frame here
        }
        
        ID3v2FrameHeader frameHeader = id3v2Frame.getFrameHeader();
        ID3v2TextFrameBody frameBody = 
                (ID3v2TextFrameBody) id3v2Frame.getFrameBody();
        
        //use ISO-8859-1 by default
        byte encoding = ID3v2Constants.ID3V2_TEXT_ENCODING_ISO_8859_1;
        if(charset == ID3v2Charsets.Unicode)
            encoding = ID3v2Constants.ID3V2_TEXT_ENCODING_UNICODE;
        
        byte[] newValue = ID3v2Utilities.getBytes(artist, encoding);
        
        //update the ID3v2FrameHeader with the new ID3v2FrameBody size
        if(frameHeader instanceof ID3v230FrameHeader) {
            ID3v230FrameHeader id3v230FrameHeader = (ID3v230FrameHeader) frameHeader;
            id3v230FrameHeader.setFrameBodyLength(newValue.length + 1);
        }
        
        frameBody.setInformation(newValue, encoding);
    } 
    
}
