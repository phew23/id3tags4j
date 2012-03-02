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
 * This class handles different conversions.
 * @author phew
 */
public class ID3v2Converter {
    
    /**
     * Converts the size byte array to Integer.
     * @param b byte[] buffer containing the {@link ID3v2TagHeader}'s  four 
     *            'size'-bytes
     * @return The length of the {@link ID3v2TagBody} as Integer.
     */
    public static int id3v2TagHeaderSizeToInteger(final byte[] b) {
        return ((b[0] & 0xFF) << 21) + ((b[1] & 0xFF) << 14) + 
        	   ((b[2] & 0xFF) << 7) + (b[3] & 0xFF);
    }
    
    /**
     * Converts the integer to a byte array.
     * @param s Integer size
     * @return  The 'size'-byte array.
     */
    public static byte[] id3v2TagHeaderSizeToByteArray(final int s) {
        final byte[] b = new byte[4];
        b[0] = (byte) ((s & 0x0FE00000) >> 21);
        b[1] = (byte) ((s & 0x001FC000) >> 14);
        b[2] = (byte) ((s & 0x00003F80) >> 7);
        b[3] = (byte) (s & 0x0000007F);
        return b;
    }
    
    /**
     * Converts the size byte array to Integer.
     * @param b byte[] buffer containing {@link ID3v2FrameHeader}'s four 
     *            'size'-bytes
     * @return The length of the {@link ID3v2FrameBody} as Integer.
     */
    public static int id3v2FrameHeaderSizeToInteger(final byte[] b) {
        return ((b[0] & 0xFF) << 24) + ((b[1] & 0xFF) << 16) + 
                ((b[2] & 0xFF) << 8) + (b[3] & 0xFF);
    }
    
    /**
     * Converts the integer to a byte array.
     * @param s Integer size
     * @return The 'size'-byte array.
     */
    public static byte[] id3v2FrameHeaderSizeToByteArray(final int s) {
        final byte[] b = new byte[4];
        b[0] = (byte) ((s & 0x0FE00000) >> 24);
        b[1] = (byte) ((s & 0x001FC000) >> 16);
        b[2] = (byte) ((s & 0x00003F80) >> 8);
        b[3] = (byte) (s & 0x0000007F);
        return b;
    }
    
    /**
     * Does a bitwise check if the given byte's bit at pos is set.
     * @param b - Byte to be examined.
     * @param pos - Bit's position within the byte. 7 is the leftmost bit, 0 is
     *              the rightmost bit.
     * @return True if the bit is set; false otherwise.
     */
    public static boolean isBitSet(byte b, int pos) {
        //a byte only has 8 bits
        if(pos > 7 || pos < 0)
            return false;
        return (b & (0x01 << pos)) != 0;
    }
    
    public ID3v2Converter() {
        throw new AssertionError();
    }
    
}
