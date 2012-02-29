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
import in.pussykill.id3.v2.v0_0.ID3v200Tag;
import in.pussykill.id3.v2.v3_0.ID3v230Tag;
import in.pussykill.id3.v2.v4_0.ID3v240Tag;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

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
        ID3v2TagBody id3v2TagBody = null;
        ID3v2Tag id3v2Tag = null;
        
        RandomAccessFile raf = new RandomAccessFile(new File(path), "rw");
        
        byte[] id3v2TagHeaderBytes = 
                new byte[ID3v2Constants.ID3V2_TAG_HEADER_LENGTH];
        
        raf.seek(0);
        raf.read(id3v2TagHeaderBytes, 0, 10);
        
        id3v2TagHeader = new ID3v2TagHeader(id3v2TagHeaderBytes);
        
        if(id3v2TagHeader.getID3v2Version() == 
                ID3v2Constants.ID3V2_MINOR_VERSION_V2_BYTE)
            id3v2Tag = new ID3v200Tag(id3v2TagHeader, id3v2TagBody);
        else if(id3v2TagHeader.getID3v2Version() == 
                ID3v2Constants.ID3V2_MINOR_VERSION_V3_BYTE)
            id3v2Tag = new ID3v230Tag(id3v2TagHeader, id3v2TagBody);
        else if(id3v2TagHeader.getID3v2Version() == 
                ID3v2Constants.ID3V2_MINOR_VERSION_V4_BYTE)
            id3v2Tag = new ID3v240Tag(id3v2TagHeader, id3v2TagBody);
        
        return new MP3File(id3v2Tag);
    }
    
}
