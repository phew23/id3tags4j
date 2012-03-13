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
    
    
    public static ID3v2CommentsFrameBody parseID3v2CommentsFrameBody(
            final byte[] b) {
        byte[] body = Arrays.copyOfRange(b, 4, b.length);
        byte encoding = b[0];
        byte[] language = new byte[] { b[1], b[2], b[3] };
        byte[] description = new byte[0];
        byte[] text = new byte[0];
        
        /* The seperator seperating the description from the actual comments
         * text is a 0x00-byte in ISO-8859-1 and two 0x00 bytes in Unicode.
         *             ISO-8859-1: 0x00
         *                Unicode: 0x00 0x00
         * ID3v2CommentsFrameBody: <encoding><desc><seperator><text>
         */
        byte[] seperator;
        //ISO-8859-1
        if(encoding == ID3v2Constants.ID3V2_TEXT_ENCODING_ISO_8859_1)
            seperator = ID3v2Constants.ID3V2_TEXT_SEPERATOR_ISO_8859_1;
        //Unicode
        else if(encoding == ID3v2Constants.ID3V2_TEXT_ENCODING_UNICODE)
            seperator = ID3v2Constants.ID3V2_TEXT_SEPERATOR_UNICODE;
        //default (should be ISO-8859-1)
        else
            seperator = ID3v2Constants.ID3V2_TEXT_SEPERATOR_ISO_8859_1;
        
        //search the position of $00 (00) within the byte array
        int seperatorPos = search(body, seperator);
        
        //<desc>0x00<text>
        if(seperatorPos > 0) {
            description = Arrays.copyOfRange(body, 0, seperatorPos - 1);
            text = Arrays.copyOfRange(body, 
                    seperatorPos + seperator.length, body.length);
        }
        //0x00<text>
        else if(seperatorPos == 0) {
            text = Arrays.copyOfRange(body, 
                    seperatorPos + seperator.length, body.length);
        }
        //<description> (no seperator found, -1)
        else {
            description = body;
        }
        
        return new ID3v2CommentsFrameBody(b, encoding, language, description,
                text);
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
            while (j>0 && pattern[j] != pattern[i])
                j = failure[j - 1];
            if (pattern[j] == pattern[i])
                j++;
            failure[i] = j;
        }
        return failure;
    }
    
}
