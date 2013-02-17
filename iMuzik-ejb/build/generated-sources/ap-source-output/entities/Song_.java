package entities;

import entities.Album;
import entities.Artist;
import entities.Category;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-17T08:24:07")
@StaticMetamodel(Song.class)
public class Song_ { 

    public static volatile SingularAttribute<Song, Integer> id;
    public static volatile SingularAttribute<Song, String> title;
    public static volatile SingularAttribute<Song, Category> category;
    public static volatile SingularAttribute<Song, Album> album;
    public static volatile SingularAttribute<Song, Integer> number;
    public static volatile SingularAttribute<Song, Artist> artist;
    public static volatile SingularAttribute<Song, String> url;

}