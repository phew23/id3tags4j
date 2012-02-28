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
 * This class holds the most important ID3v2 constants.
 * @author phew
 */
public class ID3v2Constants {
	
	/*
	 * ID3v2 minor version bytes
	 */
	/** ID3v2 v2.x minor version byte */
	public static final int ID3V2_MINOR_VERSION_V2_BYTE = 0x02;
	/** ID3v2 v3.x minor version byte */
	public static final int ID3V2_MINOR_VERSION_V3_BYTE = 0x03;
	/** ID3v2 v4.x minor version byte */
	public static final int ID3V2_MINOR_VERSION_V4_BYTE = 0x04;
	
	/*
	 * ID3v2 text encoding bytes
	 */
	/** ID3v2 Unicode text encoding byte */
	public static final int ID3V2_TEXT_ENCODING_ISO_8859_1 = 0x00;
	/** ID3v2 ISO-8859-1 text encoding byte */
	public static final int ID3V2_TEXT_ENCODING_UNICODE = 0x01;
	
	/*
	 * ID3v2 flag byte masks
	 * 
	 * check which minor version can have which flags?
	 */
	public static final int ID3v2_UNSYNCHRONIZATION = 0x80;
	public static final int ID3v2_EXTENDED_HEADER = 0x40;
	public static final int ID3v2_EXPERIMENTAL = 0x20;
	public static final int ID3v2_COMPRESSION = 0x40;
	
	/*
	 * ID3v2 v4.0 specific byte masks
	 */
	public static final int ID3v240_FOOTER = 0x10;
	
	public ID3v2Constants() {
		throw new AssertionError();
	}
	
}
