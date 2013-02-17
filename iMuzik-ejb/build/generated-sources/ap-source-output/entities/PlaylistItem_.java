package entities;

import entities.Song;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-17T18:12:38")
@StaticMetamodel(PlaylistItem.class)
public class PlaylistItem_ { 

    public static volatile SingularAttribute<PlaylistItem, Integer> id;
    public static volatile SingularAttribute<PlaylistItem, Song> song;
    public static volatile SingularAttribute<PlaylistItem, Integer> pos;

}