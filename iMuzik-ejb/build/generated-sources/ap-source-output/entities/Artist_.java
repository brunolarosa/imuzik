package entities;

import entities.Album;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-01-16T08:50:53")
@StaticMetamodel(Artist.class)
public class Artist_ { 

    public static volatile SingularAttribute<Artist, Integer> id;
    public static volatile SingularAttribute<Artist, String> name;
    public static volatile ListAttribute<Artist, Album> albums;

}