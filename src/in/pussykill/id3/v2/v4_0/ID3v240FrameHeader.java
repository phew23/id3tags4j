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
package in.pussykill.id3.v2.v4_0;

import in.pussykill.id3.v2.ID3v2Constants;
import in.pussykill.id3.v2.ID3v2Converter;
import in.pussykill.id3.v2.v3_0.ID3v230FrameHeader;

/**
 * This class represents an IDv2 4.0 frame header.
 * @author phew
 */
public class ID3v240FrameHeader extends ID3v230FrameHeader implements 
        ID3v240FrameHeaderFlagInterface {
    
    //TODO: jdoc for flag bit methods
    public ID3v240FrameHeader(byte[] b) {
        super(b);
    }

    @Override
    public boolean hasTagAlterPreservation() {
        return ID3v2Converter.isBitSet(flags[0], 
                ID3v2Constants.ID3V240_FRAME_HEADER_STATUS_FLAG_TAG_ALTER_PRESERVATION);
    }

    @Override
    public boolean hasFileAlterPreservation() {
        return ID3v2Converter.isBitSet(flags[0], 
                ID3v2Constants.ID3V240_FRAME_HEADER_STATUS_FLAG_FILE_ALTER_PRESERVATION);
    }

    @Override
    public boolean isReadOnly() {
        return ID3v2Converter.isBitSet(flags[0], 
                ID3v2Constants.ID3V240_FRAME_HEADER_STATUS_FLAG_READ_ONLY);
    }

    @Override
    public boolean isCompressed() {
        return ID3v2Converter.isBitSet(flags[1], 
                ID3v2Constants.ID3V240_FRAME_HEADER_FORMAT_FLAG_COMPRESSION);
    }

    @Override
    public boolean isEncrypted() {
        return ID3v2Converter.isBitSet(flags[1], 
                ID3v2Constants.ID3V240_FRAME_HEADER_FORMAT_FLAG_ENCRYPTION);
    }
    
    @Override
    public boolean isGrouped() {
        return ID3v2Converter.isBitSet(flags[1], 
                ID3v2Constants.ID3V240_FRAME_HEADER_FORMAT_FLAG_GROUPING_IDENTITY);
    }
    
    @Override
    public boolean isUnsynchronized() {
        return ID3v2Converter.isBitSet(flags[1], 
                ID3v2Constants.ID3V240_FRAME_HEADER_FORMAT_FLAG_UNSYNCHRONIZATION);
    }

    @Override
    public boolean hasDataLengthIndicator() {
        return ID3v2Converter.isBitSet(flags[1], 
                ID3v2Constants.ID3V240_FRAME_HEADER_FORMAT_FLAG_DATA_LENGTH_INDICATOR);
    }
    
    @Override
    public int getID3v2FrameBodyLength() {
        //TODO:
        //the size of the body is not encapsulated as in a usual v3.0 tag,
        //it rather uses 7 bits, ignoring the MSB (which is always unset).
        //while v3.0 uses: $00 00 00 00 == 4 bytes
        //      v4.0 uses: %0xxxxxxx %0xxxxxxx %0xxxxxxx %0xxxxxxx == 4 bytes
        //while the MSB is always 0.
        
        //therefore we use this ID3v2Converter method to determine the size
        //just like in an ID3v2TagHeader, where all 8 bits of the 4 bytes 
        //are used.
        return ID3v2Converter.id3v2TagHeaderSizeToInteger(size);
    }
    
}
