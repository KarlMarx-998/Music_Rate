package com.example.dbtry;

import com.example.dbtry.entity.MyArtist;



public class ArtistMapper {
    public static MyArtist mapFromLastFmArtist(de.umass.lastfm.Artist lastFmArtist) {
        MyArtist myArtist = new MyArtist();
        myArtist.setName(lastFmArtist.getName());
        myArtist.setTags(String.join(", ",(lastFmArtist.getTags())));
        myArtist.setSummary(lastFmArtist.getWikiSummary());
        myArtist.setListeners((lastFmArtist.getListeners()));

        return myArtist;
    }
}
