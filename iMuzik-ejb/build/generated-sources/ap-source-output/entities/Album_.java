package entities;

import entities.Artist;
import entities.Song;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-17T16:18:57")
@StaticMetamodel(Album.class)
public class Album_ { 

    public static volatile SingularAttribute<Album, Integer> id;
    public static volatile SingularAttribute<Album, String> title;
    public static volatile SingularAttribute<Album, Date> releaseDate;
    public static volatile ListAttribute<Album, Song> songs;
    public static volatile SingularAttribute<Album, Artist> artist;
    public static volatile SingularAttribute<Album, String> imageURL;

}