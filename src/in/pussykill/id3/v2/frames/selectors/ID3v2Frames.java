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
package in.pussykill.id3.v2.frames.selectors;

/**
 * This enumeration holds all different frame types.
 * @author phew
 */
public enum ID3v2Frames {
    /*
     * v2.0
     */
    
    /** recommended buffer size */
    BUF, 
    /** play counter */
    CNT,
    /** comments */
    COM,
    /** audio encryption */
    CRA,
    /** encrypted meta frame */
    CRM,
    /** event timing codes */
    ETC,
    /** equalization */
    EQU,
    /** general encapsulated object */
    GEO,
    /** involved people list */
    IPL,
    /** linked information */
    LNK,
    /** music CD identifier */
    MCI,
    /** MPEG location lookup table */
    MLL,
    /** attached picture */
    PIC,
    /** popularimeter */
    POP,
    /** reverb */
    REV,
    /** relative volume adjustment */
    RVA,
    /** synchronized lyric/text */
    SLT,
    /** synced tempo codes */
    STC,
    /** album/movie/show title */
    TAL,
    /** BPM (beats per minute) */
    TBP,
    /** composer */
    TCM,
    /** content type */
    TCO,
    /** copyright message */
    TCR,
    /** date */
    TDA,
    /** playlist delay */
    TDY,
    /** encoded by */
    TEN,
    /** file type */
    TFT,
    /** time */
    TIM,
    /** initial key */
    TKE,
    /** language(s) */
    TLA,
    /** length */
    TLE,
    /** media type */
    TMT,
    /** original artist(s)/performer(s) */
    TOA,
    /** original filename */
    TOF,
    /** original lyricist(s)/text writer(s) */
    TOL,
    /** original release year */
    TOR,
    /** original album/movie/show title */
    TOT,
    /** lead artist(s)/lead performer(s)/soloist(s)/performing group */
    TP1,
    /** band/orchestra/accompaniment */
    TP2,
    /** conductor/performer refinement */
    TP3,
    /** interpreted, remived or otherwise midified by */
    TP4,
    /** part of a set */
    TPA,
    /** publisher */
    TPB,
    /** ISRC (international standard recording code) */
    TRC,
    /** recording dates */
    TRD,
    /** track number/position in set */
    TRK,
    /** size */
    TSI,
    /** software/hardware and settings used for encoding */
    TSS,
    /** content group description */
    TT1,
    /** title/songname/content description */
    TT2,
    /** subtitle/description refinement */
    TT3,
    /** lyricist/text writer */
    TXT,
    /** user defined text information frame */
    TXX,
    /** year */
    TYE,
    /** unique file identifier */
    UFI,
    /** unsynchronized lyric/text transcription */
    ULT,
    /** official audio file webpage */
    WAF,
    /** official artist/performer webpage */
    WAR,
    /** official audio source webpage */
    WAS,
    /** commercial information */
    WCM,
    /** copyright/legal information */
    WCP,
    /** publishers official webpage */
    WPB,
    /** user defined URL link frame */
    WXX,


    
    

    /*
     * v3.0/v4.0 
     */
    
    /** audio encryption */
    AENC,
    /** attached picture */
    APIC,
    /** comments */
    COMM,
    /** commercial frame */
    COMR,
    /** encryption method registration */
    ENCR,
    /** equalization */
    EQUA,
    /** event timing codes */
    ETCO,
    /** general encapsulated object */
    GEOB,
    /** group identification registration */
    GRID,
    /** involved people list */
    IPLS,
    /** linked information */
    LINK,
    /** music cd information */
    MCDI,
    /** MPEG location lookup table */
    MLLT,
    /** ownership frame */
    OWNE,
    /** private frame */
    PRIV,
    /** play counter */
    PCNT,
    /** popularimeter */
    POPM,
    /** position synchronisation frame */
    POSS,
    /** recommended buffer size */
    RBUF,
    /** relative volume adjustment */
    RVAD,
    /** reverb */
    RVRB,
    /** synchronized lyric/text */
    SYLT,
    /** synchronized tempo codes */
    SYCT,
    /** album/movie/show title */
    TALB,
    /** bpm (beats per minute) */
    TBPM,
    /** composer */
    TCOM,
    /** content type */
    TCON,
    /** copyright message */
    TCOP,
    /** date */
    TDAT,
    /** playlist delay */
    TDLY,
    /** encoded by */
    TENC,
    /** lyrics/text writer */
    TEXT,
    /** file type */
    TFLT,
    /** time */
    TIME,
    /** content group description */
    TIT1,
    /** title/songname/content description */
    TIT2,
    /** subtitle/description refinement */
    TIT3,
    /** initial key */
    TKEY,
    /** language(s) */
    TLAN,
    /** length */
    TLEN,
    /** media type */
    TMED,
    /** original album/movie/show title */
    TOAL,
    /** original filename */
    TOFN,
    /** original lyricist(s)/text writer(s) */
    TOLY,
    /** original artist(s)/performer(s) */
    TOPE,
    /** original release year */
    TORY,
    /** file owner/licensee */
    TOWN,
    /** lead performer(s)/soloist(s) */
    TPE1,
    /** band/orchestra/accompaniment */
    TPE2,
    /** conductor/performer refinement */
    TPE3,
    /** interpreted, remixed or otherwise modified by */
    TPE4,
    /** part of a set */
    TPOS,
    /** publisher */
    TPUB,
    /** track number/position in set */
    TRCK,
    /** recording dates */
    TRDA,
    /** internet radio station name */
    TRSN,
    /** internet radio station owner */
    TRSO,
    /** size */
    TSIZ,
    /** IRSC (international standard recording code) */
    TSRC,
    /** software/hardware and settings used for encoding */
    TSSE,
    /** year */
    TYER,
    /** user defined text information frame */
    TXXX,
    /** unique file identifier */
    UFID,
    /** terms of use */
    USER,
    /** unsynchronized lyric/text transcription */
    USLT,
    /** commercial information */
    WCOM,
    /** copyright/legal information */
    WCOP,
    /** official audio file webpage */
    WOAF,
    /** official artist/performer webpage */
    WOAR,
    /** official audio source webpage */
    WOAS,
    /** official internet radio station homepage */
    WORS,
    /** payment */
    WPAY,
    /** publishers official webpage */
    WPUB,
    /** user defined URL link frame */
    WXXX
    
//TODO: add additional v4.0 frames - how do we check if the right enum member
    //was used for ie. getFrame(ID3v2Frame.V40FRAME) where V40FRAME is a v4.0 frame
    //as argument while the tagheader tells us its id3v2 v2.0 tag?
    
    /*
     * probably its best to do a check, if(id3v2Header.getVersion() == ID3v2Constants.ID3V2_V20_BYTE)
     * {
     *      if(String.valueOf(ID3v2Frame.V40FRAME).length == 4)
     *              throw new unsupportedframeexception();
     * }
     * 
     * not really the most sexy possibility but it should do the job
     */
    
}
