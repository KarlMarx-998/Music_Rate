package com.example.dbtry.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Artist")
public class MyArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double rating;

    private String tags;

    private String summary;

    private int listeners;


    public MyArtist(){};

    public MyArtist(Long id, String name,Double rating, String tags, String summary, int listeners) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.tags = tags;
        this.summary = summary;
        this.listeners = listeners;
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

    public String getTags() {
        return tags;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating ;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getListeners() {
        return listeners;
    }

    public void setListeners(int listeners) {
        this.listeners = listeners;
    }
}