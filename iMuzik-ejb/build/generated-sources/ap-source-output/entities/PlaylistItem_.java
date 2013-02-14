package entities;

import entities.Song;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-14T11:28:27")
@StaticMetamodel(PlaylistItem.class)
public class PlaylistItem_ { 

    public static volatile SingularAttribute<PlaylistItem, Integer> id;
    public static volatile SingularAttribute<PlaylistItem, Song> song;
    public static volatile SingularAttribute<PlaylistItem, Integer> pos;

}