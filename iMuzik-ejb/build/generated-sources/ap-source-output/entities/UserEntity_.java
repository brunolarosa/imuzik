package entities;

import entities.Playlist;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-15T01:34:16")
@StaticMetamodel(UserEntity.class)
public class UserEntity_ { 

    public static volatile SingularAttribute<UserEntity, Integer> id;
    public static volatile SingularAttribute<UserEntity, String> lastName;
    public static volatile SingularAttribute<UserEntity, String> email;
    public static volatile SingularAttribute<UserEntity, Boolean> admin;
    public static volatile ListAttribute<UserEntity, Playlist> myPlaylists;
    public static volatile SingularAttribute<UserEntity, String> firstName;
    public static volatile SingularAttribute<UserEntity, String> password;

}