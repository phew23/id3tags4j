/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pussykill.mp3;

import in.pussykill.id3.v2.ID3v2Constants;
import in.pussykill.id3.v2.ID3v2Tag;
import in.pussykill.id3.v2.ID3v2TagBody;
import in.pussykill.id3.v2.ID3v2TagHeader;
import in.pussykill.id3.v2.v0_0.ID3v200Tag;
import in.pussykill.id3.v2.v3_0.ID3v230Tag;
import in.pussykill.id3.v2.v4_0.ID3v240Tag;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author phew
 */
public class MP3Utilities {
    
    public static MP3File init(final String path) throws FileNotFoundException, 
            IOException {
        
        ID3v2TagHeader id3v2TagHeader = null;
        ID3v2TagBody id3v2TagBody = null;
        ID3v2Tag id3v2Tag = null;
        
        RandomAccessFile raf = new RandomAccessFile(new File(path), "rw");
        
        byte[] id3v2TagHeaderBytes = 
                new byte[ID3v2Constants.ID3V2_TAG_HEADER_LENGTH];
        
        raf.seek(0);
        raf.read(id3v2TagHeaderBytes, 0, 10);
        
        id3v2TagHeader = new ID3v2TagHeader(id3v2TagHeaderBytes);
        
        if(id3v2TagHeader.getID3v2Version() == 
                ID3v2Constants.ID3V2_MINOR_VERSION_V2_BYTE)
            id3v2Tag = new ID3v200Tag(id3v2TagHeader, id3v2TagBody);
        else if(id3v2TagHeader.getID3v2Version() == 
                ID3v2Constants.ID3V2_MINOR_VERSION_V3_BYTE)
            id3v2Tag = new ID3v230Tag(id3v2TagHeader, id3v2TagBody);
        else if(id3v2TagHeader.getID3v2Version() == 
                ID3v2Constants.ID3V2_MINOR_VERSION_V4_BYTE)
            id3v2Tag = new ID3v240Tag(id3v2TagHeader, id3v2TagBody);
        
        return new MP3File(id3v2Tag);
    }
    
}
