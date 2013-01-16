/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Song;
import java.io.File;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.ID3v1;

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
    
    public static Song lectureFile(File file) {
        Song song = null;

        Long lastModif = file.lastModified();
        String nameFile = file.getName();
        String absolutePath = file.getAbsolutePath();

        try {
            if (nameFile.substring(nameFile.length() - 4, nameFile.length()).equals(".mp3")) {

                MP3File mp3File;
                try {
                    mp3File = new MP3File(file);
                } catch (TagException e) {
                    mp3File = null;
                }

                if (null != mp3File) {

                    /*
                     * CAS ID3 v1
                     */
                    if (mp3File.hasID3v1Tag()) {

                        ID3v1 id3 = mp3File.getID3v1Tag();

                        if (null != id3) {
                            song = new Song(absolutePath);
                            
                            song.setTitle(id3.getTitle());

                            String artists = id3.getArtist();
                            System.out.println(artists);

                        }

                    }


                }

            }
        } catch (Exception e) {
            song = null;
        }

        return song;

    }
    
    
    
}
