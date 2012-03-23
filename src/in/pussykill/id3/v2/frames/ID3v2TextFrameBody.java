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
import java.util.Arrays;

/**
 * This class represents all ID3v2 text frame bodies.
 * @author phew
 */
public class ID3v2TextFrameBody extends ID3v2FrameBody {
    
    private byte encoding;
    private byte[] information;
    
    public ID3v2TextFrameBody(final byte[] b, final byte encoding, 
            final byte[] information) {
        super(b);
        this.encoding = encoding;
        this.information = information;
    }
    
    /**
     * @return The charset the body's text is encoded with.
     */
    public String getEncoding() {
        return ID3v2Utilities.getEncoding(encoding);
    }
    
    /**
     * @return The actual text read from this ID3v2 text frame body.
     */
    public String getInformation() {
        return ID3v2Utilities.getString(information, encoding);
    }
    
    /**
     * @param information The new text for this text frame body.
     */
    public void setInformation(byte[] information, byte encoding) {
        this.encoding = encoding;
        this.information = information;
        
        //update the super class ID3v2FrameBody with the new data
        byte[] buffer = new byte[] { encoding };
        for(byte b : information) {
            buffer = Arrays.copyOf(buffer, buffer.length + 1);
            buffer[buffer.length - 1] = b;
        }
        super.setBytes(buffer);
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "=[encoding=" + getEncoding() +
                ", text=" + getInformation() + "]";
    }
    
}
