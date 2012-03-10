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
package in.pussykill.main;

import in.pussykill.id3.v2.ID3v2Tag;
import in.pussykill.id3.v2.frames.ID3v2Frame;
import in.pussykill.id3.v2.frames.ID3v2FrameBody;
import in.pussykill.id3.v2.frames.ID3v2TextFrameBody;
import in.pussykill.mp3.MP3File;
import in.pussykill.mp3.MP3Utilities;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main class containing main function for testing.
 * @author phew
 */
public class Main {
    
    public static void main(String... args) {
        try {
            
            MP3File mp3 = MP3Utilities.init("files/a.mp3");
            ID3v2Tag id3v2 = mp3.getID3v2Tag();
            ID3v2Frame[] id3v2Frames = id3v2.getID3v2TagBody().getID3v2Frames();
            for(ID3v2Frame frame : id3v2Frames) {
                ID3v2FrameBody id3v2FrameBody = frame.getID3v2FrameBody();
                if(id3v2FrameBody instanceof ID3v2TextFrameBody) {
                    ID3v2TextFrameBody id3v2TextFrameBody = (ID3v2TextFrameBody) id3v2FrameBody;
                    System.out.println(frame.getID3v2FrameHeader().getIdentifier() + ": " + id3v2TextFrameBody.getText());
                }
            }
            
            System.out.println(id3v2.getID3v2TagHeader().getVersion());
           
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
}
