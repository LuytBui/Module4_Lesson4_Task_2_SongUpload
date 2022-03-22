package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class SongForm {
    public static List<String> allGenre = new ArrayList<>();
    static {
        allGenre.add("Pop");
        allGenre.add("Balad");
        allGenre.add("Country");
        allGenre.add("Hiphop");
        allGenre.add("EDM");
    }

    private String name;
    private String artist;
    private String genre;
    private MultipartFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public SongForm() {
    }

    public SongForm(String name, String artist, String genre, MultipartFile file) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.file = file;
    }
}
