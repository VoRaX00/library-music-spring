package org.example.librarymusic.repositories.impl;

import org.example.librarymusic.models.Music;
import org.example.librarymusic.repositories.CustomMusicRepository;
import org.example.librarymusic.repositories.MusicRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryMusicRepositoryImpl implements CustomMusicRepository {
    @Override
    public Optional<List<Music>> getAll(Music music, Integer countSongs, Integer page) {
        return Optional.empty();
    }

    @Override
    public Optional<Music> get(String song, String group) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getText(String song, String group) {
        return Optional.empty();
    }
}
