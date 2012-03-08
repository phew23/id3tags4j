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
 * This class represents all ID3v2 text frames.
 * @author phew
 */
public class ID3v2TextFrame extends ID3v2Frame {
    
    protected byte[] b;
    
    public ID3v2TextFrame() {
        //init super
    }
 
    /*
     * TODO:DO I REALLY NEED THIS? CHECK THE PROS N CONS
     */

    @Override
    public String getIdentifier() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public byte[] getHeaderBytes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public byte[] getBodyBytes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
