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
import in.pussykill.id3.v2.frames.ID3v2AttachedPictureFrameBody;
import in.pussykill.id3.v2.frames.ID3v2Frame;
import in.pussykill.id3.v2.frames.ID3v2FrameBody;
import in.pussykill.mp3.MP3File;
import in.pussykill.mp3.MP3Utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main class containing main function for testing.
 * @author phew
 */
public class Main {
    
    public static void main(String... args) {
        try {
            
           File[] mp3s = new File("files").listFiles();
           for(File f : mp3s) {
                MP3File mp3 = MP3Utilities.init(f.getAbsolutePath());
                if(!mp3.hasID3v2Tag())
                    continue;
                
                System.out.println(f.getName() + " " + mp3.getID3v2Tag()
                        .getID3v2TagHeader().getVersion());
                
                ID3v2Tag id3v2Tag = mp3.getID3v2Tag();
                ID3v2Frame[] id3v2Frames = id3v2Tag.getID3v2TagBody().getID3v2Frames();
                int count = 0;
                for(ID3v2Frame frame : id3v2Frames) {
                    count++;
                    ID3v2FrameBody body = frame.getID3v2FrameBody();
                    if(body instanceof ID3v2AttachedPictureFrameBody) {
                        ID3v2AttachedPictureFrameBody apicBody = 
                                (ID3v2AttachedPictureFrameBody) body;
                        System.out.println(apicBody);
                        //apicBody.savePictureTo("C:\\", count + "yo");
                    }
                }
                
           }
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
}
