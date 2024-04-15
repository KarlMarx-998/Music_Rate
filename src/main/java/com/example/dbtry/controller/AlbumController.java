package com.example.dbtry.controller;

import de.umass.lastfm.Album;
import de.umass.lastfm.Caller;
import de.umass.lastfm.Track;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class AlbumController {

//    @PostMapping ("/album-info")
//    public String postAlbumInfo(@RequestParam("artistName") String artistName,
//                         @RequestParam("albumName") String albumName,
//                         Model model) {
//
//        Caller.getInstance().setUserAgent("MusicRate");
//        String apiKey = "6dbf52676f656a2f3b09a01641bcefe5";
//
//        try{
//            Album album = Album.getInfo(artistName, albumName, apiKey);
//            model.addAttribute("album", album);
//
//            List<Track> tracks = (List<Track>) album.getTracks();
//            System.out.println("Album: " + album.getName());
//            System.out.println("Tracks: ");
//            for(int i =0; i < tracks.size(); i++){
//                System.out.println("track " + (i+1) + ":" + tracks.get(i).getName());
//            }
//
//        }catch (RuntimeException e){
//            model.addAttribute("error", e.getMessage());
//        }
//
//        return "album-info";
//    }

    @GetMapping("/album-info")
    public String albumPage(@RequestParam("artistName") String artistName,
                            @RequestParam("albumName") String albumName,
                            Model model){
        Caller.getInstance().setUserAgent("MusicRate");
        String apiKey = "6dbf52676f656a2f3b09a01641bcefe5";

        try{
            Album album = Album.getInfo(artistName, albumName, apiKey);
            model.addAttribute("album", album);

            List<Track> tracks = (List<Track>) album.getTracks();
            System.out.println("Album: " + album.getName());
            System.out.println("Tracks: ");
            for(int i =0; i < tracks.size(); i++){
                System.out.println("track " + (i+1) + ":" + tracks.get(i).getName());
            }

        }catch (RuntimeException e){
            model.addAttribute("error", e.getMessage());
        }
        return "album-info";
    }
}
