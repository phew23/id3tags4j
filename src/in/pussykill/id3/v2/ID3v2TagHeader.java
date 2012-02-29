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
package in.pussykill.id3.v2;

/**
 * This class represents an ID3v2TagHeader.
 * @author phew
 */
public class ID3v2TagHeader {
    
    private final byte[] id;
    private final byte[] version;
    private final byte flags;
    private final byte[] size;

    /**
     * Creates a new ID3v2TagHeader from the given byte chain.
     * @param b - Array of bytes containing ID3v2TagHeader data.
     */
    public ID3v2TagHeader(final byte[] b) {
        id = new byte[] { b[0], b[1], b[2] };
        version = new byte[] { b[3], b[4] };
        flags = new Byte(b[5]);
        size = new byte[] { b[6], b[7], b[8], b[9] };
    }
    
    /**
     * @return The identifier as String object.
     */
    public String getIdString() {
        return new String(id);
    }
    
    /**
     * @return The minor version byte of this {@link ID3v2Tag}.
     */
    public byte getID3v2Version() {
        return version[0];
    }
    
    /**
     * The flags byte's bits indicate if a flag is set or not.
     * @return The flag byte.
     */
    public byte getFlagsByte() {
        return flags;
    }
    
    /**
     * @return The length of the {@link ID3v2TagBody} for this {@link ID3v2Tag},
     *         located in its header.
     */
    public int getID3v2TagBodyLength() {
        return ID3v2Converter.id3v2TagHeaderSizeToInteger(size);
    }
    
    @Override
    public String toString() {
        return getClass().getName() + "=[id=" + id[0] + id[1] + id[2] + 
                ", version=" + version[0] + "." + version[1] + "]";
    }
    
}
