package org.example.librarymusic.services;

import org.example.librarymusic.models.Music;
import org.example.librarymusic.models.MusicCreateDto;
import org.example.librarymusic.models.MusicUpdateDto;

import java.util.List;
import java.util.Map;

public interface MusicService {
    Music save(MusicCreateDto music);
    void update(MusicUpdateDto music);
    void updatePartial(Map<String, Object> params);
    void delete(Long id);
    List<Music> getAll(Music music, Integer countSongs, Integer page);
    Music get(String song, String group);
    String getText(String song, String group);
}
