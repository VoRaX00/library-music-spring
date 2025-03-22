package org.example.librarymusic.services;

import lombok.RequiredArgsConstructor;
import org.example.librarymusic.models.Music;
import org.example.librarymusic.repositories.IMusicRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusicService implements IMusicService {
    private final IMusicRepository musicRepository;

    @Override
    public Optional<Long> save(Music music) {
        return musicRepository.save(music);
    }
}
