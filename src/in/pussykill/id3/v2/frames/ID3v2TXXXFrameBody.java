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
package in.pussykill.id3.v2.frames;

import in.pussykill.id3.v2.ID3v2Utilities;

/**
 * This class represents all user defined text information frames ('TXXX').
 * @author phew
 */
public class ID3v2TXXXFrameBody extends ID3v2FrameBody {
    
    private final byte encoding;
    private final byte[] description;
    private final byte[] value;
    
    public ID3v2TXXXFrameBody(final byte[] b, final byte encoding, final byte[]
            description, final byte[] value) {
        super(b);
        this.encoding = encoding;
        this.description = description;
        this.value = value;
    }

    /**
     * @return The charset the body's text is encoded with.
     */
    public String getEncoding() {
        return ID3v2Utilities.getEncoding(encoding);
    }
    
    /**
     * @return The description of this user defined text information frame.
     */
    public String getDescription() {
        return ID3v2Utilities.getString(description, encoding);
    }
    
    /**
     * @return The actual value of this user defined text information frame.
     */
    public String getValue() {
        return ID3v2Utilities.getString(value, encoding);
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "=[encoding=" + getEncoding() +
                ", description=" + getDescription() + ", value=" + getValue() +
                "]";
    }
    
}
