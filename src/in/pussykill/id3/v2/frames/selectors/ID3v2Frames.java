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
//TODO: the above is all id3v2 v3.0 stuff, can enum inherit from enum?!
    
}
