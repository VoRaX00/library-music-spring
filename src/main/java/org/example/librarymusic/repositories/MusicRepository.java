package org.example.librarymusic.repositories;

import org.example.librarymusic.models.Music;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MusicRepository implements IMusicRepository{
    @Override
    public Optional<Long> save(Music music) {
        return Optional.of(1L);
    }
}
