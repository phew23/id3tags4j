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
package in.pussykill.id3.v2.v3_0;

import in.pussykill.id3.v2.ID3v2Constants;
import in.pussykill.id3.v2.ID3v2Tag;
import in.pussykill.id3.v2.ID3v2TagBody;
import in.pussykill.id3.v2.ID3v2TagHeader;

/**
 * This class represents an ID3v2 3.0 tag.
 * @author phew
 */
public class ID3v230Tag extends ID3v2Tag {
    
    public ID3v230Tag(final ID3v2TagHeader id3v2TagHeader, 
            final ID3v2TagBody id3v2TagBody) {
        super(id3v2TagHeader, id3v2TagBody);
    }
    
    //The isUnsynchronized() method still has to be tested
    /**
     * Tells if the {@link ID3v2Tag} is using unsynchronization or not.
     * @return true if the unsynchronized scheme bit is set; false otherwise
     */
    public boolean isUnsynchronized() {
        return (id3v2TagHeader.getFlagsByte() & 
                ID3v2Constants.ID3v2_UNSYNCHRONIZATION) != 0;
    }
    
    //The hasExtendedHeader() method still has to be tested
    /**
     * Tells if the {@link ID3v2Tag} has an extended header.
     * @return true if the extended header bit is set; false otherwise
     */
    public boolean hasExtendedHeader() {
        return (id3v2TagHeader.getFlagsByte() &
                ID3v2Constants.ID3v2_EXTENDED_HEADER) != 0;
    }
    
    //The isExperimental() method still has to be tested
    /**
     * Tells if the {@link ID3v2Tag} is at experimental stage.
     * @return true if the experimental indicator bit is set; false otherwise
     */
    public boolean isExperimental() {
        return (id3v2TagHeader.getFlagsByte() &
                ID3v2Constants.ID3v2_EXPERIMENTAL_INDICATOR) != 0;
    }
    
}
