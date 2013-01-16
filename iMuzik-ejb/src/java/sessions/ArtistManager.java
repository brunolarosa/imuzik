/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Artist;
import entities.Song;
import java.io.File;
import java.util.Collection;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.io.FileUtils;
import utils.ID3Util;

/**
 *
 * @author brunolarosa
 */
@Stateless
@LocalBean
public class ArtistManager {

    @PersistenceContext(unitName = "iMuzik-ejbPU")
    private EntityManager em;

    public void createArtist(Artist artist) {
        em.persist(artist);
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Artist> getAllArtists() {

        Query query = em.createNamedQuery("Artist.findAll");
        return query.getResultList();
    }

    public Artist getByName(String name) {

        System.out.println("------------"+name);
        if (null != name) {
            Query query = em.createNamedQuery("Artist.findByName");
            query.setParameter("name", name);
            List<Artist> artists = query.getResultList();

            if (artists.size() == 1) {
                return artists.get(0);
            }
        }
        return null;
    }

    public void update(Artist artist) {
        em.merge(artist);
    }
}
