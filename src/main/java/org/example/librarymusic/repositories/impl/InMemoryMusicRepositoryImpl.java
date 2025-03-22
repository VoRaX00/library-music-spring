package org.example.librarymusic.repositories.impl;

import org.example.librarymusic.models.Music;
import org.example.librarymusic.repositories.MusicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryMusicRepositoryImpl implements MusicRepository {
    @Override
    public Optional<Long> save(Music music) {
        return Optional.of(1L);
    }
}
