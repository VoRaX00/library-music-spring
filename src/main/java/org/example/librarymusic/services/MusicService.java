package org.example.librarymusic.services;

import org.example.librarymusic.models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;

public interface MusicService {
    MusicGetDto save(MusicCreateDto music);
    void fullUpdate(Long id, MusicUpdateDto updateDto);
    void partialUpdate(Long id, MusicUpdateDto updateDto);
    void delete(Long id);
    Page<MusicGetDto> getAll(MusicFiltersDto filtersDto, Pageable pageable);
    MusicGetDto get(String song, String group);
    MusicGetTextDto getText(String song, String group, Integer countVerse, Integer page);
}
