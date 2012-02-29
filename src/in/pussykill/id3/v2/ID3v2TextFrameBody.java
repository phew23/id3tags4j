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

/**
 * This class represents all ID3v2 text frames.
 * @author phew
 */
public class ID3v2TextFrameBody {
    
    private final byte encoding;
    private final byte[] information;
    
    public ID3v2TextFrameBody(final byte encoding, final byte[] information) {
        this.encoding = encoding;
        this.information = information;
    }
    
    /**
     * @return The text read from this ID3v2 text frame body.
     */
    public String getText() {
        try {
            if(encoding == ID3v2Constants.ID3V2_TEXT_ENCODING_ISO_8859_1)
                return new String(information, "ISO-8859-1");
            if(encoding == ID3v2Constants.ID3V2_TEXT_ENCODING_UNICODE)
                return new String(information, "Unicode");
        } 
        catch(UnsupportedEncodingException e) {
            System.err.println(e);
        }
        return null;
    }
    
}
