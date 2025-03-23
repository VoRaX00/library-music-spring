package org.example.librarymusic.repositories;

import org.example.librarymusic.models.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomMusicRepository {
    Page<Music> getAll(String song, String group, String link, Date released, Pageable pageable);
    Music get(String song, String group);
    String getText(String song, String group);
}
