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
 * This abstract class represents all ID3v2Tags.
 * @author phew
 */
public abstract class ID3v2Tag {
    
    protected final ID3v2TagHeader id3v2TagHeader;
    protected final ID3v2TagBody id3v2TagBody;
    
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
    public ID3v2TagHeader getTagHeader() {
        return id3v2TagHeader;
    }
    
    /**
     * @return {@link ID3v2TagBody} object for this {@link ID3v2Tag}.
     */
    public ID3v2TagBody getTagBody() {
        return id3v2TagBody;
    }
    
    /**
     * @return The total length of this ID3v2 tag.
     */
    public int length() {
        return id3v2TagHeader.length() + id3v2TagBody.length();
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "=[\n" + id3v2TagHeader +
                ",\n" + id3v2TagBody +"\n]";
    }
    
}
