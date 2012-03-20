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

import in.pussykill.id3.v2.frames.ID3v2Frame;
import in.pussykill.id3.v2.frames.selectors.ID3v2FrameSelector;
import in.pussykill.id3.v2.frames.selectors.ID3v2Frames;
import java.util.Arrays;

/**
 * This class represents all ID3v2 tag bodies.
 * @author phew
 */
public class ID3v2TagBody {
    
    private final ID3v2Frame[] frames;
   
    public ID3v2TagBody(ID3v2Frame[] frames) {
        this.frames = frames;
    }
    
    /**
     * @return All ID3v2 frames of this ID3v2 tag body.
     */
    public ID3v2Frame[] getFrames() {
        return frames;
    }
    
    /**
     * @param selector {@link ID3v2FrameSelector} to select certain from the 
     *                 ID3v2 tag body.
     * @return All frames matching the {@link ID3v2FrameSelector}'s criterias.
     */
    public ID3v2Frame[] getFramesBySelector(ID3v2FrameSelector selector) {
        ID3v2Frame[] selectedFrames = new ID3v2Frame[0];
        for(ID3v2Frame frame : frames) {
            if(selector.wants(frame)) {
                selectedFrames = Arrays.copyOf(selectedFrames, 
                        selectedFrames.length + 1);
                selectedFrames[selectedFrames.length - 1] = frame;
            }
        }
        return selectedFrames;
    }
    
    /**
     * @param frameType - {@link ID3v2Frames} member to be collected.
     * @return The first {@link ID3v2Frame} of the specified type found within
     *         the ID3v2TagBody.
     */
    public ID3v2Frame getFrameByType(ID3v2Frames frameType) {
        for(ID3v2Frame frame : frames) {
            if(frame.getID3v2FrameHeader().getIdentifier()
                    .equals(String.valueOf(frameType))) {
                return frame;
            }
        }
        return null;
    }
    
    /**
     * @param frameType - {@link ID3v2Frames} member to be collected.
     * @return {@link ID3v2Frame}[] containing all frames of the wanted type.
     */
    public ID3v2Frame[] getFramesByType(ID3v2Frames frameType) {
        ID3v2Frame[] id3v2Frames = new ID3v2Frame[0];
        for(ID3v2Frame frame : frames) {
            if(frame.getID3v2FrameHeader().getIdentifier()
                    .equals(String.valueOf(frameType))) {
                id3v2Frames = Arrays.copyOf(id3v2Frames, 
                        id3v2Frames.length + 1);
                id3v2Frames[id3v2Frames.length - 1] = frame;
            }
        }
        return id3v2Frames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(this.getClass().getSimpleName());
        sb.append("=[\n");
        for(int i = 0; i < frames.length; i++) {
            sb.append("\t\t");
            sb.append(frames[i]);
            if(i < frames.length - 1)
                sb.append(",\n");
            else
                sb.append("\n");
        }
        sb.append("\t]");
        return sb.toString();
    }
    
}
