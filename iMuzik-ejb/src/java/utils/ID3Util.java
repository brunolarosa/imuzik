/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Album;
import entities.Artist;
import entities.Category;
import entities.Song;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.facelets.TagException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.farng.mp3.MP3File;
import org.farng.mp3.id3.AbstractID3v2;
import org.farng.mp3.id3.ID3v1;
import org.farng.mp3.id3.ID3v2_2;
import sessions.AlbumManager;
import sessions.ArtistManager;
import sessions.CategoryManager;

/**
 *
 * @author brunolarosa
 */
public class ID3Util {

    private static ArtistManager artistManager = lookupArtistManager();
    private static AlbumManager albumManager = lookupAlbumManager();
    private static CategoryManager categoryManager = lookupCategoryManager();

    public static Song readFile(File file) {

        Song song = null;

        Long lastMod = file.lastModified();
        String nameFile = file.getName();
        String absolutePath = file.getAbsolutePath();


        try {
            if (nameFile.endsWith("mp3")) {

                MP3File mp3File;
                try {
                    mp3File = new MP3File(file);
                } catch (TagException e) {
                    mp3File = null;
                }

                if (null != mp3File) {
                    song = new Song(absolutePath);

                    if (mp3File.hasID3v1Tag()) {

                        ID3v1 id3v1 = mp3File.getID3v1Tag();

                        if (null != id3v1) {
                            
                            song.setTitle(id3v1.getTitle());

                            String artists = id3v1.getArtist();

                            if (artists.equals("")) {
                                artists = "Inconnu";
                            }

                            String[] artistsList = artists.split(", ");


                            Artist artist = artistManager.getByName(artistsList[0].trim());

                            if (null == artist) {
                                artist = new Artist(artistsList[0].trim());
                            }
                            song.setArtist(artist);

                            String albumTitle = id3v1.getAlbum();
                            Album album = albumManager.getAlbum(albumTitle, artist);

                            if (null == album) {
                                album = new Album(albumTitle, artist);
                            }

                            album.getSongs().add(song);

                            song.setAlbum(album);
                            artist.getAlbums().add(album);
                            
                            String categoryName = id3v1.getSongGenre();
                            
                            System.out.println(categoryName);
                            
                            if(categoryName.equals("")) {
                                categoryName = "Inconnu";
                            }
                            
                            Category category = categoryManager.getCategoryByName(categoryName);
                            if(null == category) {
                                category = new Category(categoryName);
                            }
                            
                            song.setCategory(category);



                        }

                    } else if (mp3File.hasID3v2Tag()){
                        AbstractID3v2 id3v2 = mp3File.getID3v2Tag();
                        String album = id3v2.getSongTitle();
                        
                        song.getId();
                    }


                }

            }
        } catch (Exception e) {
             
        }

        return song;
    }

    private static ArtistManager lookupArtistManager() {
        try {

            Context context = new InitialContext();
            return (ArtistManager) context.lookup("java:global/iMuzik/iMuzik-ejb/ArtistManager");

        } catch (NamingException ex) {
            Logger.getLogger(ID3Util.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private static AlbumManager lookupAlbumManager() {
        try {

            Context context = new InitialContext();
            return (AlbumManager) context.lookup("java:global/iMuzik/iMuzik-ejb/AlbumManager");

        } catch (NamingException ex) {
            Logger.getLogger(ID3Util.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private static CategoryManager lookupCategoryManager() {
        try {

            Context context = new InitialContext();
            return (CategoryManager) context.lookup("java:global/iMuzik/iMuzik-ejb/CategoryManager");

        } catch (NamingException ex) {
            Logger.getLogger(ID3Util.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
