package entities;

import entities.Artist;
import entities.Song;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-01-16T08:50:53")
@StaticMetamodel(Album.class)
public class Album_ { 

    public static volatile SingularAttribute<Album, Integer> id;
    public static volatile SingularAttribute<Album, String> title;
    public static volatile ListAttribute<Album, Song> songs;
    public static volatile SingularAttribute<Album, Artist> artist;

}