package org.example.librarymusic.repositories;

import org.example.librarymusic.models.Music;

import java.util.Optional;

public interface MusicRepository {
    Optional<Long> save(Music music);
}
