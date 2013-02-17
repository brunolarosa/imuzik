package entities;

import entities.PlaylistItem;
import entities.UserEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-17T18:12:38")
@StaticMetamodel(Playlist.class)
public class Playlist_ { 

    public static volatile SingularAttribute<Playlist, Integer> id;
    public static volatile ListAttribute<Playlist, PlaylistItem> playlistItems;
    public static volatile SingularAttribute<Playlist, String> name;
    public static volatile SingularAttribute<Playlist, UserEntity> user;

}