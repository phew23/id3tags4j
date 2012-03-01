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
 * This class represents all ID3v2 tag bodies.
 * @author phew
 */
public class ID3v2TagBody {
    
    private final ID3v2Frame[] frames;
   
    //TODO:
    //this is to be initialized with MP3Utilities.parseFrames() or something
    //similiar. ID3v2TagBody body = new ID3v2TagBody(
    //MP3Utilities.parseFrames(bytes));
    public ID3v2TagBody(ID3v2Frame[] frames) {
        this.frames = frames;
    }
    
   
    
    
}
