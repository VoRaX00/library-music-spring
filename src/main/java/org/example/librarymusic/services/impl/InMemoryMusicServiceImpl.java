package org.example.librarymusic.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.librarymusic.models.Music;
import org.example.librarymusic.repositories.MusicRepository;
import org.example.librarymusic.services.MusicService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InMemoryMusicServiceImpl implements MusicService {
    private final MusicRepository musicRepository;

    @Override
    public Optional<Long> save(Music music) {
        return musicRepository.save(music);
    }
}
