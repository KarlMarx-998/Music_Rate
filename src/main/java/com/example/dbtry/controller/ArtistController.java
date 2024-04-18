package com.example.dbtry.controller;

import com.example.dbtry.ArtistMapper;
import com.example.dbtry.DAO.ArtistRepository;
import com.example.dbtry.entity.MyArtist;
import de.umass.lastfm.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Controller
public class ArtistController {
    private final ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @GetMapping("/")
    public String showForm() {return "artist-form";}

        @PostMapping("/search")
    public String searchArtist(@RequestParam("artistName") String artistName, Model model){
        Caller.getInstance().setUserAgent("MusicRate");

        Optional<MyArtist> existingArtistOptional = Optional.ofNullable(artistRepository.findByNameIgnoreCase(artistName));

        String apiKey = "6dbf52676f656a2f3b09a01641bcefe5";

        if (existingArtistOptional.isPresent()){

        MyArtist existingArtist = existingArtistOptional.get();

        model.addAttribute("myArtist", existingArtist);

            try {
                Artist artist = Artist.getInfo(artistName, apiKey);
                model.addAttribute("artist", artist);
                String imageUrl = getImageUrl(artist.getName());
                model.addAttribute("imageUrl", imageUrl);

                List<Album> album = (List<Album>) Artist.getTopAlbums(artistName, apiKey)
                        .stream()
                        .filter(item-> !item.getName().equals("(null)"))
                        .collect(Collectors.toList());

                List<String> albums = new ArrayList<>();

                for (int i = 0; i < 5 && i < album.size(); i++) {
                    albums.add(album.get(i).getName());
                    System.out.println(albums.get(i));
                }

                model.addAttribute("albums", albums);

            }catch (RuntimeException e){
                model.addAttribute("error", e.getMessage());
            }
    } else {
            try {
                Artist artist = Artist.getInfo(artistName, apiKey);
                model.addAttribute("artist", artist);
                List<Album> album = (List<Album>) Artist.getTopAlbums(artistName, apiKey)
                        .stream()
                        .filter(item -> !item.getName().equals("(null)"))
                        .collect(Collectors.toList());

                List<String> albums = new ArrayList<>();

                for (int i = 0; i < 5 && i < album.size(); i++) {
                    albums.add(album.get(i).getName());
                    System.out.println(albums.get(i));
                }

                model.addAttribute("albums", albums);
                MyArtist myArtist = ArtistMapper.mapFromLastFmArtist(artist);
                MyArtist savedArtist = artistRepository.save(myArtist);
                model.addAttribute("myArtist", savedArtist);
            } catch (RuntimeException e) {
                model.addAttribute("error", e.getMessage());
            }

        }


        return "artist-info";

    }

    private String getImageUrl(String artistName) {
        try {
            String apiKey = "AIzaSyAoM50yYb9inGuFwFFr8DtZO_lHmF_V0uQ";
            String searchEngineId = "72a055435140d4ac0";
            String apiUrl = "https://www.googleapis.com/customsearch/v1?key=" + apiKey +
                    "&cx=" + searchEngineId +
                    "&q=" + URLEncoder.encode(artistName, "UTF-8") +
                    "&searchType=image";
            // Вызываем метод ImageTry.main() и получаем URL изображения
            return ImageUrl.getArtistImageUrl(apiUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
