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
import in.pussykill.id3.v2.ID3v2Utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author phew
 */
public class ID3v2AttachedPictureFrameBody extends ID3v2FrameBody {
    
    private final byte encoding;
    private final byte[] mimeType;
    private final byte pictureType;
    private final byte[] description;
    private final byte[] pictureData;
    
    public ID3v2AttachedPictureFrameBody(final byte[] b, final byte encoding, 
            final byte[] mimeType, final byte pictureType, 
            final byte[] description, final byte[] pictureData)  {
        super(b);
        this.encoding = encoding;
        this.mimeType = mimeType;
        this.pictureType = pictureType;
        this.description = description;
        this.pictureData = pictureData;
    }
    
     /**
     * @return The charset the body's text is encoded with.
     */
    public String getEncoding() {
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
    
    /**
     * @return The MIME type of the attached picture.
     */
    public String getMimeType() {
        return new String(mimeType);
    }
    
    /**
     * @return The picture type of the APIC frame.
     */
    public String getPictureType() {
        switch(pictureType) {
            case ID3v2FrameConstants.APIC_TYPE_OTHER:
                return "Other";
            case ID3v2FrameConstants.APIC_TYPE_FILE_ICON:
                return "32x32 pixels 'file icon' (PNG only)";
            case ID3v2FrameConstants.APIC_TYPE_OTHER_FILE_ICON:
                return "Other file icon";
            case ID3v2FrameConstants.APIC_TYPE_COVER_FRONT:
                return "Cover (front)";
            case ID3v2FrameConstants.APIC_TYPE_COVER_BACK:
                return "Cover (back)";
            case ID3v2FrameConstants.APIC_TYPE_LEAFLET_PAGE:
                return "Leaflet page";
            case ID3v2FrameConstants.APIC_TYPE_MEDIA:
                return "Media";
            case ID3v2FrameConstants.APIC_TYPE_LEAD_ARTIST:
                return "Lead artist/lead performer/soloist";
            case ID3v2FrameConstants.APIC_TYPE_ARTIST:
                return "Artist/performer";
            case ID3v2FrameConstants.APIC_TYPE_CONDUCTOR:
                return "Conductor";
            case ID3v2FrameConstants.APIC_TYPE_BAND:
                return "Band/Orchestra";
            case ID3v2FrameConstants.APIC_TYPE_COMPOSER:
                return "Composer";
            case ID3v2FrameConstants.APIC_TYPE_TEXT_WRITER:
                return "Lyricist/text writer";
            case ID3v2FrameConstants.APIC_TYPE_RECORDING_LOCATION:
                return "Recording Location";
            case ID3v2FrameConstants.APIC_TYPE_DURING_RECORDING:
                return "During recording";
            case ID3v2FrameConstants.APIC_TYPE_DURING_PERFORMANCE:
                return "During performance";
            case ID3v2FrameConstants.APIC_TYPE_VIDEO_SCREEN_CAPTURE:
                return "Movie/video screen capture";
            case ID3v2FrameConstants.APIC_TYPE_A_BRIGHT_COLOURED_FISH:
                return "A bright coloured fish";
            case ID3v2FrameConstants.APIC_TYPE_ILLUSTRATION:
                return "Illustration";
            case ID3v2FrameConstants.APIC_TYPE_ARTIST_LOGOTYPE:
                return "Band/artist logotype";
            case ID3v2FrameConstants.APIC_TYPE_PUBLISHER_LOGOTYPE:
                return "Publisher/Studio logotype";
            default:
                return "Unknown";
        }
    }
    
    /**
     * @return The description of the picture.
     */
    public String getDescription() {
        return ID3v2Utilities.getString(description, encoding);
    }
    
    /**
     * @return The actual picture's data.
     */
    public byte[] getPictureData() {
        return pictureData;
    }
  
    //TODO: change this cuz it might not have a mimeType, should default to
    //      JPEG then?!
    /**
     * Extracts the attached picture.
     * @param path The path to save the picture to.
     * @param name The name to save the picture under.
     * @return True if the picture could be extracted; false otherwise.
     */
    public boolean savePictureTo(final String path, final String name) {
        String extension = ".jpeg";
        if(getMimeType().equalsIgnoreCase(ID3v2FrameConstants.APIC_MIME_PNG))
            extension = ".png";
        
        StringBuilder builder = new StringBuilder(path);
        if(!builder.toString().endsWith(System.getProperty("file.separator")))
            builder.append(System.getProperty("file.separator"));
        
        builder.append(name);
        builder.append(extension);
        
        try {
            File f = new File(builder.toString());
            FileOutputStream output = new FileOutputStream(f);
            output.write(pictureData);
            output.close();
        }
        catch(FileNotFoundException e) { return false; }
        catch(IOException e) { return false; }
        
        return true;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "=[encoding=" + getEncoding() + 
                ", mimeType=" + getMimeType() + ", pictureType=" + 
                getPictureType() + ", description=" + getDescription() + "]";
    }
    
    
}
