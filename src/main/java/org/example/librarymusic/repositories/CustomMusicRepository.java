package org.example.librarymusic.repositories;

import org.example.librarymusic.models.Music;

import java.util.List;
import java.util.Optional;

public interface CustomMusicRepository {
    Optional<List<Music>> getAll(Music music, Integer countSongs, Integer page);
    Optional<Music> get(String song, String group);
    Optional<String> getText(String song, String group);
}
