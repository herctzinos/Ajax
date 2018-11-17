/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Songs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Herc
 */
@Entity
@Table(name = "mp3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mp3.findAll", query = "SELECT m FROM Mp3 m")
    , @NamedQuery(name = "Mp3.findByTitle", query = "SELECT m FROM Mp3 m WHERE m.title = :title")
    , @NamedQuery(name = "Mp3.findById", query = "SELECT m FROM Mp3 m WHERE m.id = :id")
    , @NamedQuery(name = "Mp3.findByAlbum", query = "SELECT m FROM Mp3 m WHERE m.album = :album")
    , @NamedQuery(name = "Mp3.findByArtist", query = "SELECT m FROM Mp3 m WHERE m.artist = :artist")
    , @NamedQuery(name = "Mp3.findByYear", query = "SELECT m FROM Mp3 m WHERE m.year = :year")})
public class Mp3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "song")
    private byte[] song;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "album")
    private String album;
    @Lob
    @Column(name = "photo_url")
    private String photoUrl;
    @Column(name = "artist")
    private String artist;
    @Column(name = "year")
    private String year;
    @Lob
    @Column(name = "lyrics")
    private String lyrics;

    public Mp3() {
    }

    public Mp3(Integer id) {
        this.id = id;
    }

    public Mp3(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getSong() {
        return song;
    }

    public void setSong(byte[] song) {
        this.song = song;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mp3)) {
            return false;
        }
        Mp3 other = (Mp3) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Songs.Mp3[ id=" + id + " ]";
    }
    
}
