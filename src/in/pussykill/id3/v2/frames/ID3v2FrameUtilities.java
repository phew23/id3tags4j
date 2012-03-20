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

import in.pussykill.id3.v2.ID3v2Constants;
import java.util.Arrays;

/**
 * This class holds methods to parse frame bodies.
 * @author phew
 */
public class ID3v2FrameUtilities {
    
    /**
     * This method parses the text frame body.
     * @param b The text frame's body byte[]-Array.
     * @return {@link ID3v2TextFrameBody} object created from the given byte[].
     */
    public static ID3v2TextFrameBody parseID3v2TextFrameBody(final byte[] b) {
        final byte encoding = b[0];
        final byte[] information = Arrays.copyOfRange(b, 1, b.length);
        return new ID3v2TextFrameBody(b, encoding, information);
    }
    
    /**
     * This method parses the "COMM" frame body.
     * @param b The "COMM" frame's body byte[].
     * @return {@link ID3v2CommentsFrameBody} object created from the given 
     *         byte[].
     */
    public static ID3v2CommentsFrameBody parseID3v2CommentsFrameBody(
            final byte[] b) {
        final byte[] body = Arrays.copyOfRange(b, 4, b.length);
        final byte encoding = b[0];
        final byte[] language = new byte[] { b[1], b[2], b[3] };
        byte[] description = new byte[0];
        byte[] text = new byte[0];
        
        /* The seperator seperating the description from the actual comments
         * text is a 0x00-byte in ISO-8859-1 and two 0x00 bytes in Unicode.
         *             ISO-8859-1: 0x00
         *                Unicode: 0x00 0x00
         * ID3v2CommentsFrameBody: <encoding><desc><seperator><text>
         */
        //ID3v2 v3.0 only has ISO-8859-1 and Unicode encodings in frames;
        //ISO-8859-1 (by default)
        byte[] separator = ID3v2Constants.ID3V2_TEXT_SEPERATOR_ISO_8859_1;
        //Unicode
        if(encoding == ID3v2Constants.ID3V2_TEXT_ENCODING_UNICODE)
            separator = ID3v2Constants.ID3V2_TEXT_SEPERATOR_UNICODE;

        
        //search the position of $00 (00) within the byte array
        int separatorPos = search(body, separator);
        
        //<desc>0x00<text>
        if(separatorPos > 0) {
            description = Arrays.copyOfRange(body, 0, separatorPos - 1);
            text = Arrays.copyOfRange(body, 
                    separatorPos + separator.length, body.length);
        }
        //0x00<text>
        else if(separatorPos == 0) {
            text = Arrays.copyOfRange(body, 
                    separatorPos + separator.length, body.length);
        }
        //<description> (no seperator found, separatorPos < 0)
        else {
            description = body;
        }
        
        return new ID3v2CommentsFrameBody(b, encoding, language, description,
                text);
    }
    
    /**
     * This method parses the "APIC" frame body.
     * @param b The "APIC" frame's body byte[].
     * @return A new {@link ID3v2AttachedPictureFrameBody} created from the 
     *         given byte[].
     * 
     * Text encoding      $xx
     * MIME type          <text string> $00
     * Picture type       $xx
     * Description        <text string according to encoding> $00 (00)
     * Picture data       <binary data>
     */
    public static ID3v2AttachedPictureFrameBody 
            parseID3v2AttachedPictureFrameBody(final byte[] b) {
        final byte encoding = b[0];
        byte[] leftover = Arrays.copyOfRange(b, 1, b.length);
  
        final int mimeSeparatorPos = 
                search(leftover, ID3v2Constants.ID3V2_SINGLE_SEPERATOR);
        
        byte[] mimeType = new byte[0];
        
        if(mimeSeparatorPos > 0)
            mimeType = Arrays.copyOfRange(leftover, 0, mimeSeparatorPos);
        
        leftover = Arrays.copyOfRange(leftover, mimeSeparatorPos + 1, 
                leftover.length - mimeType.length);
                
        byte pictureType = leftover[0];

        leftover = Arrays.copyOfRange(leftover, 1, leftover.length);
        
        byte[] separator = ID3v2Constants.ID3V2_TEXT_SEPERATOR_ISO_8859_1;
        if(encoding == ID3v2Constants.ID3V2_TEXT_ENCODING_UNICODE)
            separator = ID3v2Constants.ID3V2_TEXT_SEPERATOR_UNICODE;
        
        int separatorPos = search(leftover, separator);

        byte[] description = Arrays.copyOfRange(leftover, 0, separatorPos);
        byte[] pictureData = Arrays.copyOfRange(leftover, 
                separatorPos + separator.length, leftover.length);
        
        return new ID3v2AttachedPictureFrameBody(b, encoding, mimeType, 
                pictureType, description, pictureData);
    }

    
    /**
     * Knuth-Morris-Pratt algorithm to find a byte[] within a byte[].
     * @param source byte[] to search for pattern.
     * @param pattern byte[] to match against.
     * @return The position of the pattern within the source or -1 if not found.
     */
    public static int search(byte[] source, byte[] pattern) {
        int[] failure = failure(pattern);
        int j = 0;
        for (int i = 0; i < source.length; i++) {
            while (j > 0 && pattern[j] != source[i])
                j = failure[j - 1];
            if (pattern[j] == source[i])
                j++;
            if (j == pattern.length)
                return i - pattern.length + 1;
        }
        return -1;
    }
    
    /**
     * Knuth-Morris-Pratt algorithm to find a byte[] within a byte[].
     * @param pattern Pattern to compute the failure for.
     * @return The failure as byte[].
     */
    private static int[] failure(byte[] pattern) {
        int[] failure = new int[pattern.length];
        int j = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[j] != pattern[i])
                j = failure[j - 1];
            if (pattern[j] == pattern[i])
                j++;
            failure[i] = j;
        }
        return failure;
    }
    
}
