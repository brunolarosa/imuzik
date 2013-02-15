/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dominiquec
 */
@Stateless
@LocalBean
public class UserManager {

    @PersistenceContext(unitName = "iMuzik-ejbPU")
    private EntityManager em;

    public void createUser(String email, String firstName,String lastName, String password) {
        UserEntity user = new UserEntity(email, firstName, lastName, password);
        if(getAllUserEntities().size() == 0)
            user.setAdmin(true);
        persist(user);
    }

      public List<UserEntity> getAllUserEntities() {

        Query query = em.createNamedQuery("UserEntity.findAll");
        return query.getResultList();
    }
    
    public void persist(Object object) {
        em.persist(object);
    }

    public UserEntity getUserByID(int id) {
        return em.find(UserEntity.class, id);
    }

    public UserEntity getUserByEmail(String email) {
        Query query = em.createNamedQuery("UserEntity.findByEmail");
        query.setParameter("email", email);
        List<UserEntity> UserEntities = query.getResultList();
        if (!UserEntities.isEmpty()) {
            return UserEntities.get(0);
        }
        return null;
    }

    public UserEntity getUser(String email, String password) {
        UserEntity user = getUserByEmail(email);
        if ((user != null) && (user.getPassword().contentEquals(password))) {
            return user;
        }
        return null;
    }

    public void addPlaylist(UserEntity user, Playlist playlist) {
        user.getMyPlaylists().add(playlist);
        em.merge(user);
    }

    public void addSongPlaylist(UserEntity user, int playlistID, Song song) {
        for (Playlist playlist : user.getMyPlaylists()) {
            if (playlist.getId() == playlistID) {
                PlaylistItem playlistItem = new PlaylistItem(song, playlist.getPlaylistItems().size());
                playlist.getPlaylistItems().add(playlistItem);
                em.merge(user);
            }
        }
    }
}
