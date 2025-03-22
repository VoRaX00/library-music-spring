package org.example.librarymusic.services;

import org.example.librarymusic.models.Music;
import org.example.librarymusic.models.MusicDto;

import java.util.List;
import java.util.Optional;

public interface MusicService {
    Music save(Music music);
    void update(Music music);
    void delete(Long id);
    Optional<List<Music>> getAll(Music music, Integer countSongs, Integer page);
    Optional<Music> get(String song, String group);
    Optional<String> getText(String song, String group);
}
