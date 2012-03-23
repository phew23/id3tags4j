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

/**
 * This class represents all user defined URL link frame bodies.
 * @author phew
 */
public class ID3v2WXXXFrameBody extends ID3v2FrameBody {
    
    private final byte encoding;
    private final byte[] description;
    private final byte[] url;
    
    //TODO: this needs to be tested still, couldn't find a mp3 using that - so far
    public ID3v2WXXXFrameBody(final byte[] b, final byte encoding, final byte[] 
            description, final byte[] url) {
        super(b);
        this.encoding = encoding;
        this.description = description;
        this.url = url;
    }
    
    /**
     * @return The charset the frame body's text has been encoded with.
     */
    public String getEncoding() {
        return ID3v2Utilities.getEncoding(encoding);
    }
    
    /**
     * @return The description of this frame body.
     */
    public String getDescription() {
        return ID3v2Utilities.getString(description, encoding);
    }
    
    /**
     * @return The URL of this frame body.
     */
    public String getURL() {
        return new String(url);
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "=[encoding=" + getEncoding() +
                ", description=" + getDescription() + ", url=" + getURL() + "]";
    }
    
}
