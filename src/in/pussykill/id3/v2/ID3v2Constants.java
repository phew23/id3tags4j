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
 * This class holds the most important ID3v2 constants.
 * @author phew
 */
public class ID3v2Constants {
    
        /*
         * Miscellaneous constants
         */
    
        public static final int ID3V2_TAG_HEADER_LENGTH = 10;
        public static final byte[] ID3V2_TEXT_SEPERATOR_ISO_8859_1 
                = new byte[] { 0x00 };
        public static final byte[] ID3V2_TEXT_SEPERATOR_UNICODE
                = new byte[] { 0x00, 0x00 };
        
        
                
        /*
	 * ID3v2 text encoding bytes
	 */
	public static final int ID3V2_TEXT_ENCODING_ISO_8859_1 = 0x00;
	public static final int ID3V2_TEXT_ENCODING_UNICODE = 0x01;
    
        
        
	/*
	 * ID3v2 minor version bytes
	 */
	/** ID3v2 v2.x minor version byte */
	public static final int ID3V200_MINOR_VERSION = 0x02;
	/** ID3v2 v3.x minor version byte */
	public static final int ID3V230_MINOR_VERSION = 0x03;
	/** ID3v2 v4.x minor version byte */
	public static final int ID3V240_MINOR_VERSION = 0x04;
       
        
        
	/*
	 * ID3v2 v2.0 tag header flag byte masks
	 */
        public static final int 
                ID3V200_TAG_HEADER_FLAG_UNSYNCHRONIZATION_SCHEME = 0x07;
        public static final int ID3V200_TAG_HEADER_FLAG_COMPRESSION = 0x06;
        
        
        
        /*
         * ID3v2 v3.0 tag header flag byte masks
         */
        public static final int 
                ID3V230_TAG_HEADER_FLAG_UNSYNCHRONIZATION_SCHEME = 0x07;
        public static final int ID3V230_TAG_HEADER_FLAG_EXTENDED_HEADER = 0x06;
        public static final int 
                ID3V230_TAG_HEADER_FLAG_EXPERIMENTAL_INDICATOR = 0x05;
        
        /*
         * ID3v2 v3.0 frame header status flag byte masks
         */
        public static final int 
                ID3V230_FRAME_HEADER_STATUS_FLAG_TAG_ALTER_PRESERVATION = 0x07;
        public static final int
                ID3V230_FRAME_HEADER_STATUS_FLAG_FILE_ALTER_PRESERVATION = 0x06;
        public static final int
                ID3V230_FRAME_HEADER_STATUS_FLAG_READ_ONLY = 0x05;
        
        /*
         * ID3v2 v3.0 frame header format flag byte masks
         */
        public static final int
                ID3V230_FRAME_HEADER_FORMAT_FLAG_COMPRESSION = 0x07;
        public static final int
                ID3V230_FRAME_HEADER_FORMAT_FLAG_ENCRYPTION = 0x06;
        public static final int
                ID3V230_FRAME_HEADER_FORMAT_FLAG_GROUPING_IDENTITY = 0x05;
        
        
        
        /*
         * ID3v2 v4.0 tag header flag byte masks
         */
        /* We do not really need those as ID3v230 has the same values and 
         * ID3v240Tag inherits the ID3v2TagHeader flag methods from 
         * ID3v230Tag.
         * 
        public static final int 
                ID3V240_TAG_HEADER_FLAG_UNSYNCHRONIZATION_SCHEME = 0x07;
	public static final int ID3V240_TAG_HEADER_FLAG_EXTENDED_HEADER = 0x06;
        public static final int 
                ID3V240_TAG_HEADER_FLAG_EXPERIMENTAL_INDICATOR = 0x05;
        */
        public static final int ID3V240_TAG_HEADER_FLAG_FOOTER = 0x04;
        
        /*
         * ID3v2 v4.0 frame header status flag byte masks
         */
        public static final int 
                ID3V240_FRAME_HEADER_STATUS_FLAG_TAG_ALTER_PRESERVATION = 0x06;
        public static final int
                ID3V240_FRAME_HEADER_STATUS_FLAG_FILE_ALTER_PRESERVATION = 0x05;
        public static final int
                ID3V240_FRAME_HEADER_STATUS_FLAG_READ_ONLY = 0x04;
        
        /*
         * ID3v2 v4.0 frame header format flag byte masks
         */
        public static final int
                ID3V240_FRAME_HEADER_FORMAT_FLAG_GROUPING_IDENTITY = 0x06;
        public static final int
                ID3V240_FRAME_HEADER_FORMAT_FLAG_COMPRESSION = 0x03;
        public static final int
                ID3V240_FRAME_HEADER_FORMAT_FLAG_ENCRYPTION = 0x02;
        public static final int
                ID3V240_FRAME_HEADER_FORMAT_FLAG_UNSYNCHRONIZATION = 0x01;
        public static final int
                ID3V240_FRAME_HEADER_FORMAT_FLAG_DATA_LENGTH_INDICATOR = 0x00;
        
	
        
	public ID3v2Constants() {
		throw new AssertionError();
	}
	
}
