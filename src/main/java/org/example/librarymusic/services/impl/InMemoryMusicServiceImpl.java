package org.example.librarymusic.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.librarymusic.models.Music;
import org.example.librarymusic.repositories.MusicRepository;
import org.example.librarymusic.services.MusicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InMemoryMusicServiceImpl implements MusicService {
    private final MusicRepository musicRepository;

    @Override
    public Music save(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public void update(Music music) {

    }

    @Override
    public void delete(Long id) {

    }

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
