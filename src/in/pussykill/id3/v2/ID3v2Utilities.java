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

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * This class handles the ID3v2 string encoding.
 * @author phew
 */
public class ID3v2Utilities {
    
    /**
     * Returns a String encoded with the given encoding.
     * @param encoding The byte that holds information about the charset the
     *                 byte[] was encoded with.
     * @param b A byte[] holding the ID3v2 text.
     * @return A new String encoded with the charset indicated in the encoding
     *         byte.
     */
    public static String getString(byte[] b, byte encoding) {
        try {
            if(encoding == ID3v2Constants.ID3V2_TEXT_ENCODING_ISO_8859_1)
                return new String(b, "ISO-8859-1");
            if(encoding == ID3v2Constants.ID3V2_TEXT_ENCODING_UNICODE)
                return new String(b, "Unicode");
        }
        catch(UnsupportedEncodingException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
    /**
     * Returns a byte[] encoded with the given encoding.
     * @param encoding The byte that holds information about the charset the
     *                 String was encoded with.
     * @param s A String holding the ID3v2 text.
     * @return A new byte[] encoded with the charset indicated in the encoding
     *         byte.
     */
    public static byte[] getBytes(String s, byte encoding) {
        if(encoding == ID3v2Constants.ID3V2_TEXT_ENCODING_ISO_8859_1) {
            Charset charset = Charset.forName("ISO-8859-1");
            return s.getBytes(charset);
        }
        else if(encoding == ID3v2Constants.ID3V2_TEXT_ENCODING_UNICODE) {
            Charset charset = Charset.forName("Unicode");
            return s.getBytes(charset);
        }
        return null;
    }
    
    /**
     * @param encoding The byte indicating the encoding.
     * @return The charset as String.
     */
    public static String getEncoding(byte encoding) {
        switch(encoding) 
        {
            case ID3v2Constants.ID3V2_TEXT_ENCODING_ISO_8859_1:
                return "ISO-8859-1";
            case ID3v2Constants.ID3V2_TEXT_ENCODING_UNICODE:
                return "Unicode";
            default:
                return "ISO-8859-1";
        }
    }
    
    public ID3v2Utilities() {
        throw new AssertionError();
    }
    
}
