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
 * This class represents all 'PRIV' frame bodies.
 * @author phew
 */
public class ID3v2PRIVFrameBody extends ID3v2FrameBody {
    
    private byte[] ownerIdentifier;
    private byte[] privateData;
    
    public ID3v2PRIVFrameBody(final byte[] b, final byte[] ownerIdentifier, 
            final byte[] privateData) {
        super(b);
        this.ownerIdentifier = ownerIdentifier;
        this.privateData = privateData;
    }
    
    /**
     * @return A String representation of the owner identifier.
     */
    public String getOwnerIdentifier() {
        return new String(ownerIdentifier);
    }
    
    /**
     * @return The private data.
     */
    public byte[] getPrivateData() {
        return privateData;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "=[ownerIdentifier=" + 
                getOwnerIdentifier() + ", privateDataLength=" + 
                privateData.length + "]";
    }
    
}
