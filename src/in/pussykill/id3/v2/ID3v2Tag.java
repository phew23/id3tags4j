/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pussykill.id3.v2;

/**
 * This abstract class represents all ID3v2Tags.
 * @author phew
 */
public abstract class ID3v2Tag 
{
    
    private final ID3v2TagHeader id3v2TagHeader;
    private final ID3v2TagBody id3v2TagBody;
    
    /**
     * Creates a new abstract ID3v2Tag from the given {@link ID3v2TagHeader}
     * and {@link ID3v2TagBody}.
     * @param id3v2TagHeader - The tag's header.
     * @param id3v2TagBody  - The tag's body.
     */
    public ID3v2Tag(ID3v2TagHeader id3v2TagHeader, ID3v2TagBody id3v2TagBody)
    {
        this.id3v2TagHeader = id3v2TagHeader;
        this.id3v2TagBody = id3v2TagBody;
    }
    
    /**
     * @return {@link ID3v2TagHeader} object for this {@link ID3v2Tag}.
     */
    public ID3v2TagHeader getID3v2TagHeader() {
        return id3v2TagHeader;
    }
    
    /**
     * @return {@link ID3v2TagBody} object for this {@link ID3v2Tag}.
     */
    public ID3v2TagBody getID3v2TagBody() {
        return id3v2TagBody;
    }
    
}
