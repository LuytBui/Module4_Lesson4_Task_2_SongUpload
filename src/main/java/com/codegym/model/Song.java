package com.codegym.model;

public class Song {
    private String name;
    private String artist;
    private String genre;
    private String fileName;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Song() {
    }

    public Song(String name, String artist, String genre, String fileName) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.fileName = fileName;
    }
}
