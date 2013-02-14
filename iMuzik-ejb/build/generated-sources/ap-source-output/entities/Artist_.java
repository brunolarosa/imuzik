package entities;

import entities.Album;
import entities.Song;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-14T00:04:15")
@StaticMetamodel(Artist.class)
public class Artist_ { 

    public static volatile SingularAttribute<Artist, Integer> id;
    public static volatile SingularAttribute<Artist, String> bio;
    public static volatile SingularAttribute<Artist, String> name;
    public static volatile ListAttribute<Artist, Album> albums;
    public static volatile ListAttribute<Artist, Song> songs;
    public static volatile SingularAttribute<Artist, String> imageURL;

}