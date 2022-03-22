package com.codegym.service;

import com.codegym.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService {
    private List<Song> songs = new ArrayList<>();

    public List<Song> findAll(){
        return songs;
    }

    public void add(Song song){
        songs.add(song);
    }
}
