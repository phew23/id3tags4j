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

/**
 * This class holds all frame related constants.
 * @author phew
 */
public class ID3v2FrameConstants {
    
    /*
     * 
     * APIC frame
     * 
     */
    
    /*
     * MIME types
     */
    
    /** jpeg MIME */
    public static final String APIC_MIME_JPEG = "images/jpeg";
    /** png MIME */
    public static final String APIC_MIME_PNG = "images/png";
    
    /*
     * Picture types
     */
    
    /** other */
    public static final byte APIC_TYPE_OTHER = 0x00;
    /** 32x32 pixels 'file icon' (PNG only) */
    public static final byte APIC_TYPE_FILE_ICON = 0x01;
    /** other file icon */
    public static final byte APIC_TYPE_OTHER_FILE_ICON = 0x02;
    /** cover (front) */
    public static final byte APIC_TYPE_COVER_FRONT = 0x03;
    /** cover (back) */
    public static final byte APIC_TYPE_COVER_BACK = 0x04;
    /** leaflet page */
    public static final byte APIC_TYPE_LEAFLET_PAGE = 0x05;
    /** media (e.g. label side of CD) */
    public static final byte APIC_TYPE_MEDIA = 0x06;
    /** lead artist/lead performer/soloist */
    public static final byte APIC_TYPE_LEAD_ARTIST = 0x07;
    /** artist/performer */
    public static final byte APIC_TYPE_ARTIST = 0x08;
    /** conductor */
    public static final byte APIC_TYPE_CONDUCTOR = 0x09;
    /** band/orchestra */
    public static final byte APIC_TYPE_BAND = 0x0A;
    /** composer */
    public static final byte APIC_TYPE_COMPOSER = 0x0B;
    /** lyricist/text writer */
    public static final byte APIC_TYPE_TEXT_WRITER = 0x0C;
    /** recording location */
    public static final byte APIC_TYPE_RECORDING_LOCATION = 0x0D;
    /** during recording */
    public static final byte APIC_TYPE_DURING_RECORDING = 0x0E;
    /** during performance */
    public static final byte APIC_TYPE_DURING_PERFORMANCE = 0x0F;
    /** movie/video screen capture */
    public static final byte APIC_TYPE_VIDEO_SCREEN_CAPTURE = 0x10;
    /** a bright coloured fish */
    public static final byte APIC_TYPE_A_BRIGHT_COLOURED_FISH = 0x11;
    /** illustration */
    public static final byte APIC_TYPE_ILLUSTRATION = 0x12;
    /** band/artist logotype */
    public static final byte APIC_TYPE_ARTIST_LOGOTYPE = 0x13;
    /** publisher/studio logotype */
    public static final byte APIC_TYPE_PUBLISHER_LOGOTYPE = 0x14;
    
    public ID3v2FrameConstants() {
        throw new AssertionError();
    }
    
}
