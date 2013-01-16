/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Album;
import entities.Artist;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author brunolarosa
 */
@Stateless
@LocalBean
public class AlbumManager {
    
    /* ENTITY MANAGER */
    @PersistenceContext(unitName = "iMuzik-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void createAlbum(Album album) {
        persist(album);
    }
    
    public List<Album> getAlbumsForArtist(Artist artist) {
        Query query = em.createNamedQuery("Album.findAlbumsForArtist");
        query.setParameter("artist", artist);
        return query.getResultList();
    }
    
    public Album getAlbum(String title, Artist artist) {
        Query query = em.createNamedQuery("Album.findAlbumByName");
        query.setParameter("title", title);
        query.setParameter("artist", artist);
        
        if(query.getResultList().size() == 1) {
            return (Album) query.getSingleResult();
        } else {
            return null;
        }
    }
    
}
