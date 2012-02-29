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
 * This class represents all ID3v2 text frames.
 * @author phew
 */
public class ID3v2TextFrame extends ID3v2Frame {
    
    public ID3v2TextFrame(final ID3v2FrameHeader id3v2FrameHeader,
            final ID3v2FrameBody id3v2FrameBody) {
        super(id3v2FrameHeader, id3v2FrameBody);
    }
    
    /*
     * 
     * DO I REALLY NEED THIS? CHECK THE PROS N CONS
     * 
     * 
     */
    
}
