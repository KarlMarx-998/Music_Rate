package com.example.dbtry.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Album")
public class MyAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long artistId;

    private Double rating;

    private Integer listeners;

    private String tags;
    private Date releaseDate;

    public MyAlbum(){

    }

    public MyAlbum(Long id, String name, Long artistId, Double rating, Integer listeners, String tags, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
        this.rating = rating;
        this.listeners = listeners;
        this.tags = tags;
        this.releaseDate = releaseDate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getListeners() {
        return listeners;
    }

    public void setListeners(Integer listeners) {
        this.listeners = listeners;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
