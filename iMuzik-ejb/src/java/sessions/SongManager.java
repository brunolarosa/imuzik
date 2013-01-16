/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Album;
import entities.Artist;
import entities.Category;
import entities.Song;
import java.io.File;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractID3v2;
import utils.ID3Util;

/**
 *
 * @author brunolarosa
 */
@Stateless
@LocalBean
public class SongManager {
    
    @PersistenceContext(unitName = "iMuzik-ejbPU")
    private EntityManager em;
    
    
    public void createSong(Song song) {
        persist(song);        
    }
    
    

    public void persist(Object object) {
        em.persist(object);
    }
    
    
    public Song getSong(int id) {
        return em.find(Song.class, id);
    }
    
    public void createSongWithFile(File file) {
        
        
        String nameFile = file.getName();
        String absolutePath = file.getAbsolutePath();
        
        try {
            if (nameFile.endsWith("mp3")) {

                MP3File mp3File;
                try {
                    mp3File = new MP3File(file);
                } catch (javax.faces.view.facelets.TagException e) {
                    mp3File = null;
                }

                if (null != mp3File) {
                    
                    Song song = new Song(absolutePath);
                    
                    ID3Util.readID3Tag(mp3File, song);
                    
                    createSong(song);


                }

            }
        } catch (Exception e) {
             
        }  
        
    }
    
    
}
