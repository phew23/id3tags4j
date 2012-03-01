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
 * This class represents an ID3v2 frame.
 * @author phew
 */
public abstract class ID3v2Frame {
    
    private final ID3v2FrameHeader id3v2FrameHeader;
    private final ID3v2FrameBody id3v2FrameBody;
    
    public ID3v2Frame(final ID3v2FrameHeader id3v2FrameHeader, 
            final ID3v2FrameBody id3v2FrameBody) {
        this.id3v2FrameHeader = id3v2FrameHeader;
        this.id3v2FrameBody = id3v2FrameBody;
    }
    
    /**
     * @return The frame's identifier as string.
     */
    public String getIdentifier() {
        return id3v2FrameHeader.getIdentifierString();
    }
    
    /**
     * @return The frame's {@link ID3v2FrameHeader}.
     */
    public ID3v2FrameHeader getID3v2FrameHeader() {
        return id3v2FrameHeader;
    }
    
    /**
     * @return The frame's {@link ID3v2FrameBody}.
     */
    public ID3v2FrameBody getID3v2FrameBody() {
        return id3v2FrameBody;
    }
    
}
