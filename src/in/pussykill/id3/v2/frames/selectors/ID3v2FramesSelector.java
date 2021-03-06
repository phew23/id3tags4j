/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pussykill.id3.v2.frames.selectors;

import in.pussykill.id3.v2.frames.ID3v2COMMFrameBody;
import in.pussykill.id3.v2.frames.ID3v2Frame;
import in.pussykill.id3.v2.frames.ID3v2FrameBody;
import in.pussykill.id3.v2.frames.ID3v2TextFrameBody;

/**
 * This class can select certain frame types from the {@link ID3v2Frame}[].
 * @author phew
 */
public class ID3v2FramesSelector implements ID3v2FrameSelector {
    
    private final ID3v2Frames type;
    
    public ID3v2FramesSelector(ID3v2Frames type) {
        this.type = type;
    }

    /**
     * @param id3v2Frame {@link ID3v2Frame} type to select.
     * @return A new {@link ID3v2Frame}[] that contains all frames of the
     *         specified {@link ID3v2Frames} type.
     */
    @Override
    public boolean wants(ID3v2Frame id3v2Frame) {
        ID3v2FrameBody id3v2FrameBody = id3v2Frame.getFrameBody();
        switch(type) {
            case TXXX:
                return id3v2FrameBody instanceof ID3v2TextFrameBody;
            case COMM:
                return id3v2FrameBody instanceof ID3v2COMMFrameBody;
        }
        return false;
    }
    
}
