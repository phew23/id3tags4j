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

import in.pussykill.id3.v2.ID3v2Charsets;
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
    
    public static void main(String... args) throws FileNotFoundException, 
            IOException {

            File f = new File("files/q.mp3");
            MP3File mp3 = MP3Utilities.init(f);
            if(mp3.hasID3v2Tag())
                System.out.println(mp3.getID3v2Tag());
            File[] files = f.listFiles();

            mp3.setArtist("Yo yo yo", ID3v2Charsets.ISO_8859_1);
            
            System.out.println(mp3.getID3v2Tag());
    }
    
}
