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
 * This abstract class represents all ID3v2Tags.
 * @author phew
 */
public abstract class ID3v2Tag {
    
    private final ID3v2TagHeader id3v2TagHeader;
    private final ID3v2TagBody id3v2TagBody;
    
    /**
     * Creates a new abstract ID3v2Tag from the given {@link ID3v2TagHeader}
     * and {@link ID3v2TagBody}.
     * @param id3v2TagHeader - The tag's header.
     * @param id3v2TagBody  - The tag's body.
     */
    public ID3v2Tag(ID3v2TagHeader id3v2TagHeader, ID3v2TagBody id3v2TagBody) {
        this.id3v2TagHeader = id3v2TagHeader;
        this.id3v2TagBody = id3v2TagBody;
    }
    
    /**
     * @return {@link ID3v2TagHeader} object for this {@link ID3v2Tag}.
     */
    public ID3v2TagHeader getID3v2TagHeader() {
        return id3v2TagHeader;
    }
    
    /**
     * @return {@link ID3v2TagBody} object for this {@link ID3v2Tag}.
     */
    public ID3v2TagBody getID3v2TagBody() {
        return id3v2TagBody;
    }
    
}
