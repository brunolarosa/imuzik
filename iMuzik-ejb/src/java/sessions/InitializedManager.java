/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Song;
import java.io.File;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.io.FileUtils;
import utils.ID3Util;

/**
 *
 * @author brunolarosa
 */
@Singleton
@Startup
@LocalBean
public class InitializedManager {

    @PersistenceContext(unitName = "iMuzik-ejbPU")
    private EntityManager em;

    @PostConstruct
    public void init() {

        File root = new File("/Users/brunolarosa/Desktop/MusicTest/");
        String[] extensions = {"mp3"};
        Collection<File> files = FileUtils.listFiles(root, extensions, true);


        for (File file : files) {
            Song song = ID3Util.readFile(file);
            em.persist(song);
        }

    }

    public void persist(Object object) {
        em.persist(object);
    }
}
