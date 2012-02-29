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

import in.pussykill.id3.v2.ID3v2Converter;
import in.pussykill.id3.v2.ID3v2FrameHeader;

/**
 * This class represents a ID3v230FrameHeader
 * @author phew
 */
public class ID3v230FrameHeader extends ID3v2FrameHeader {
    
    private final byte[] id;
    protected final byte[] size;
    private final byte[] flags;
    
    public ID3v230FrameHeader(byte[] b) {
        id = new byte[] { b[0], b[1], b[2], b[3] };
        size = new byte[] { b[4], b[5], b[6], b[7] };
        flags = new byte[] { b[8], b[9] };
    }
    
    @Override
    public String getIdentifierString() {
        return new String(id);
    }

    @Override
    public int getID3v2FrameBodyLength() {
        return ID3v2Converter.id3v2FrameHeaderSizeToInteger(size);
    }


    
}
