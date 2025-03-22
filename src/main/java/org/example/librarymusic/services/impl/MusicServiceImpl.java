package org.example.librarymusic.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.librarymusic.models.Music;
import org.example.librarymusic.models.MusicCreateDto;
import org.example.librarymusic.models.MusicUpdateDto;
import org.example.librarymusic.repositories.MusicRepository;
import org.example.librarymusic.services.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {
    private final MusicRepository musicRepository;

    @Override
    public Music save(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public MusicUpdateDto update(Long id, MusicUpdateDto music) {
        var found = musicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND), "Music not found");


    }

    @Override
    public Music save(MusicCreateDto music) {
        return null;
    }

    @Override
    public void update(MusicUpdateDto music) {

    }

    @Override
    public void updatePartial(Map<String, Object> params) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Music> getAll(Music music, Integer countSongs, Integer page) {
        return null;
    }

    @Override
    public Music get(String song, String group) {
        return null;
    }

    @Override
    public String getText(String song, String group) {
        return null;
    }
}
