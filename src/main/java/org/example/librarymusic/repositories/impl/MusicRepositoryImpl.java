package org.example.librarymusic.repositories.impl;

import org.example.librarymusic.models.Music;
import org.example.librarymusic.repositories.CustomMusicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class MusicRepositoryImpl implements CustomMusicRepository {
    @Override
    public Page<Music> getAll(String song, String group, String link, Date released, Pageable pageable) {
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
