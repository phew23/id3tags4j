/*
 * This file is part of id3tags4j, a library for easy ID3 tag handling for Java.
 *
 * id3tags4j is free software; you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation (FSF).
 * Either version 3 of the License, or (at your option) any later version.
 * 
 * id3tags4j is distributed in the hope that it will be useful for somebody at 
 * some point, but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. Neither the author nor 
 * anybody related to this project can be held responsible for any inconvenience 
 * or failure caused by using this open source library. See the GNU General 
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with 
 * id3tags4j; if not, write to the Free Software Foundation (FSF), Inc., 59 
 * Temple Palace, Suite 330, Boston, MA  02111-1307  USA.
 */
package in.pussykill.id3.v2;

/**
 * This abstract class represents an ID3v2TagHeader.
 * @author phew
 */
public abstract class ID3v2TagHeader {
    
    private final byte[] id;
    private final byte[] version;
    private final byte flag;
    private final byte[] size;

    /**
     * Creates a new ID3v2TagHeader from the given byte chain.
     * @param b - Array of bytes containing ID3v2TagHeader data.
     */
    public ID3v2TagHeader(final byte[] b) {
        id = new byte[] { b[0], b[1], b[2] };
        version = new byte[] { b[3], b[4] };
        flag = new Byte(b[5]);
        size = new byte[] { b[6], b[7], b[8], b[9] };
    }
    
    /**
     * @return The identifier as String object.
     */
    public String getIdString() {
        return new String(id);
    }
    
    /**
     * @return The version of the {@link ID3v2Tag}, located in its header.
     */
    public String getVersionString() {
        return new StringBuilder().append(version[0]).append(".")
                .append(version[1]).toString();
    }
    
    /**
     * @return The length of the {@link ID3v2TagBody} for this {@link ID3v2Tag},
     * located in its header.
     */
    public int bodyLength() {
        return ((size[0] & 0xFF) << 21) + ((size[1] & 0xFF) << 14) + 
                ((size[2] & 0xFF) << 7) + (size[3] & 0xFF);
    }
    
}
