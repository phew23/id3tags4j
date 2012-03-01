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
package in.pussykill.id3.v2.v3_0;

/**
 * This interface holds predefined functions for the ID3v2 v3.0 
 * {@link ID3v230FrameHeader} flags.
 * @author phew
 * 
 * 
 * An ID3v2 v3.0 frame header holds two flag bytes. Certain bits of those bytes
 * are considered as flags. The bytes and the flags are described as below.
 * See <http://www.id3.org/id3v2.3.0> for more details.
 * 
 * +----------------------+----------------------+
 * |     1st flag byte    |     2nd flag byte    |
 * | (frame status flags) | (frame format flags) |
 * +----------------------+----------------------+
 * |       %abc00000      |       %ijk00000      |
 * +----------------------+----------------------+
 * 
 *      Flag meanings (1st byte):
 * 
 *  a - Tag alter preservation
 *          This flag tells the software what to do with this frame if it is 
 *          unknown and the tag is altered in any way. This applies to all 
 *          kinds of alterations, including adding more padding and reorder-
 *          ing the frames.
 * 
 *  b - File alter preservation
 *          This flag tells the software what to do with this frame if it is 
 *          unknown and the file, excluding the tag, is altered. This does 
 *          not apply when the audio is completely replaced with other audio
 *          data. 
 * 
 *  c - Read only
 *          This flag, if set, tells the software that the contents of this 
 *          frame is intended to be read only. Changing the contents might 
 *          break something, e.g. a signature. If the contents are changed, 
 *          without knowledge in why the frame was flagged read only and 
 *          without taking the proper means to compensate, e.g. 
 *          recalculating the signature, the bit should be cleared. 
 * 
 * 
 * 
 *      Flag meanings (2nd byte):
 * 
 *  i - Compression
 *          This flag indicates whether or not the frame is compressed.
 * 
 *  j - Encryption
 *          This flag indicates wether or not the frame is enrypted. If set 
 *          one byte indicating with which method it was encrypted will be 
 *          appended to the frame header. See section 4.26. for more 
 *          information about encryption method registration.
 * 
 *  k - Grouping identity
 *          This flag indicates whether or not this frame belongs in a group 
 *          with other frames. If set a group identifier byte is added to 
 *          the frame header. Every frame with the same group identifier 
 *          belongs to the same group. 
 *
 */
public interface ID3v230FrameHeaderFlagInterface {
    
    /**
     * <b>Tag alter preservation</b><br>
     * 
     * This flag tells the software what to do with this frame if it is unknown 
     * and the tag is altered in any way. This applies to all kinds of 
     * alterations, including adding more padding and reordering the frames.
     * 
     * @return True if the tag alter preservation bit is set; false otherwise.
     */
    public boolean hasTagAlterPreservation();

    /** 
     * <b>File alter preservation</b><br>
     * 
     * This flag tells the software what to do with this frame if it is unknown 
     * and the file, excluding the tag, is altered. This does not apply when the 
     * audio is completely replaced with other audio data.
     * 
     * @return True if the file alter preservation bit is set; false otherwise.
     */
    public boolean hasFileAlterPreservation();
          
    /**
     * <b>Read only</b><br>
     * 
     * This flag, if set, tells the software that the contents of this frame is 
     * intended to be read only. Changing the contents might break something, 
     * e.g. a signature. If the contents are changed, without knowledge in why 
     * the frame was flagged read only and without taking the proper means to 
     * compensate, e.g. recalculating the signature, the bit should be cleared. 
     * 
     * @return True if the read only bit is set; false otherwise.
     */
    public boolean isReadOnly();

    /**
     * <b>Compression</b><br>
     * 
     * This flag indicates whether or not the frame is compressed.
     * 
     * @return True if the compression bit is set; false otherwise.
     */
    public boolean isCompressed();

    /**
     * <b>Encryption</b><br>
     *
     * This flag indicates wether or not the frame is enrypted. If set one byte
     * indicating with which method it was encrypted will be appended to the 
     * frame header. See section 4.26. for more information about encryption 
     * method registration.
     * 
     * @return True if the encryption bit is set; false otherwise.
     */
    public boolean isEncrypted();

    /**
     * <b>Grouping identity</b><br>
     * 
     * This flag indicates whether or not this frame belongs in a group with 
     * other frames. If set a group identifier byte is added to the frame 
     * header. Every frame with the same group identifier belongs to the same 
     * group. 
     * 
     * @return True if the grouping bit is set; false otherwise.
     */
    public boolean isGrouped();
    
}
