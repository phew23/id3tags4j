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

import in.pussykill.id3.v2.ID3v2Tag;
import in.pussykill.id3.v2.v0_0.ID3v200Tag;
import in.pussykill.id3.v2.v3_0.ID3v230Tag;
import in.pussykill.id3.v2.v4_0.ID3v240Tag;

/**
 * This class represents a MP3 file.
 * @author phew
 */
public class MP3File {
    
    private final ID3v2Tag id3v2Tag;
    
    /**
     * Creates a new MP3File with the given tag.
     * @param id3v2Tag - {@link ID3v2Tag} for this MP3File.
     */
    public MP3File(ID3v2Tag id3v2Tag) {
        this.id3v2Tag = id3v2Tag;
    }
    
    /**
     * @return The {@link ID3v2Tag} for this MP3File object.
     */
    public ID3v2Tag getID3v2Tag() {
        return id3v2Tag;
    }
    
    /**
     * @return true if this MP3File has an {@link ID3v2Tag}; false otherwise
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
     * @return true if this MP3File has an {@link ID3v230Tag}; false otherwise
     */
    public boolean hasID3v230Tag() {
        return id3v2Tag instanceof ID3v230Tag;
    }
    
    /**
     * @return true if this MP3File has an {@link ID3v240Tag}; false otherwise
     */
    public boolean hasID3v240Tag() {
        return id3v2Tag instanceof ID3v240Tag;
    }
    
}
