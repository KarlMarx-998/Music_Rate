package com.example.dbtry;

import com.example.dbtry.entity.MyAlbum;
public class AlbumMapper {
    public static MyAlbum mapFromLastFmAlbum(de.umass.lastfm.Album lastFmAlbum, long artistId){
        MyAlbum myAlbum = new MyAlbum();

        myAlbum.setName(lastFmAlbum.getName());
        myAlbum.setRating(10.0);
        myAlbum.setArtistId(artistId);
        myAlbum.setListeners(lastFmAlbum.getListeners());
        myAlbum.setTags(String.join(", ",(lastFmAlbum.getTags())));
        myAlbum.setReleaseDate(lastFmAlbum.getReleaseDate());



        return myAlbum;
    }
}
