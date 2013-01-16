/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author brunolarosa
 */
@Entity
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(nullable=false)
    private String title;
    
    private int number;
    
    @ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Album album;
    
    @ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Artist artist;
    
    @ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Category category;
    
    @Column(nullable=false)
    private String url;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNumber() {
        return String.valueOf(number);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Song() {}
    
    public Song(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Song[ id=" + id + " ]";
    }
    
}
