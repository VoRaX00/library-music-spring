package org.example.librarymusic.services;

import org.example.librarymusic.models.Music;

import java.util.Optional;

public interface MusicService {
    Optional<Long> save(Music music);
}
