/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;
import de.umass.lastfm.ImageSize;

/**
 *
 * @author brunolarosa
 */
public class LastFMUtil {

    private static String lastFMKey = "564ddd75dbc03f61d54eec39d95b4b97";

    public static void readArtist(entities.Artist artist) {
        Artist artistFM = Artist.getInfo(artist.getName(), lastFMKey);
        //artist.setBio(artistFM.getWikiSummary().replace("\"", "\\\""));
        artist.setImageURL(artistFM.getImageURL(ImageSize.LARGE));
    }

    public static void readAlbum(entities.Album album) {
        Album albumFM = Album.getInfo(album.getArtist().getName(), album.getTitle(), lastFMKey);
        if (null != albumFM) {
            album.setImageURL(albumFM.getImageURL(ImageSize.LARGE));
            album.setReleaseDate(albumFM.getReleaseDate());
        }
    }
}
