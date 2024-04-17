package com.example.dbtry;

import com.example.dbtry.entity.MyArtist;



public class ArtistMapper {
    public static MyArtist mapFromLastFmArtist(de.umass.lastfm.Artist lastFmArtist) {
        MyArtist myArtist = new MyArtist();
        myArtist.setName(lastFmArtist.getName());
        myArtist.setRating(10.0);
        myArtist.setTags(String.join(", ",(lastFmArtist.getTags())));
        String summary = lastFmArtist.getWikiSummary();

        // Удаляем ссылку на last.fm из summary, если она присутствует
        summary = summary.replaceAll("<a[^>]*>(.*?)</a>", "");
        myArtist.setSummary(summary);
        myArtist.setListeners((lastFmArtist.getListeners()));

        return myArtist;
    }
}
