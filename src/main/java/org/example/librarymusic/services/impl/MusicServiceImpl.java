package org.example.librarymusic.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.librarymusic.exceptions.ConflictException;
import org.example.librarymusic.exceptions.NotFoundException;
import org.example.librarymusic.mappers.MusicMapper;
import org.example.librarymusic.models.*;
import org.example.librarymusic.repositories.GroupRepository;
import org.example.librarymusic.repositories.MusicRepository;
import org.example.librarymusic.services.MusicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {
    private final MusicRepository musicRepository;
    private final GroupRepository groupRepository;

    @Override
    @Transactional
    public MusicGetDto save(MusicCreateDto musicCreateDto) {
        var songExists = musicRepository.existsBySongAndGroups_Name(musicCreateDto.getSong(), musicCreateDto.getGroups());
        if (songExists) {
            throw new ConflictException("Song already exists");
        }

        var music = MusicMapper.INSTANCE.toModel(musicCreateDto);
        List<Group> savedGroups = new ArrayList<>();
        for(var group : music.getGroups()) {
            var exists = groupRepository.findByName(group.getName());
            if(exists.isEmpty()) {
                savedGroups.add(groupRepository.save(group));
            } else {
                savedGroups.add(exists.get());
            }
        }

        music.setGroups(savedGroups);
        var result = musicRepository.save(music);
        return MusicMapper.INSTANCE.toMusicGetDto(result);
    }

    @Override
    public void fullUpdate(Long id, MusicUpdateDto updateDto) {
        var found = musicRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Music not found"));

        found.setSong(updateDto.getSong());
        found.setText(updateDto.getText());
        found.setLink(updateDto.getLink());
        found.setGroups(updateDto.getGroups());
        found.setReleased(updateDto.getReleased());
        musicRepository.save(found);
    }

    @Override
    public void partialUpdate(Long id, MusicUpdateDto updateDto) {
        var found = musicRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Music not found"));

        if (updateDto.getSong() != null) {
            found.setSong(updateDto.getSong());
        }
        if (updateDto.getText() != null) {
            found.setText(updateDto.getText());
        }
        if (updateDto.getLink() != null) {
            found.setLink(updateDto.getLink());
        }
        if (updateDto.getGroups() != null) {
            found.setGroups(updateDto.getGroups());
        }
        if (updateDto.getReleased() != null) {
            found.setReleased(updateDto.getReleased());
        }
        musicRepository.save(found);
    }

    @Override
    public void delete(Long id) {
        musicRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Music not found"));
        musicRepository.deleteById(id);
    }

    @Override
    public Page<MusicGetDto> getAll(MusicFiltersDto filtersDto, Pageable pageable) {
        Page<Music> musics = musicRepository.searchAll(filtersDto.getSong(), filtersDto.getGroup(),
                filtersDto.getLink(), filtersDto.getReleased(), pageable);
        return musics.map(MusicMapper.INSTANCE::toMusicGetDto);
    }

    @Override
    public MusicGetDto get(String song, String group) {
        var music = musicRepository.findBySongAndGroups_Name(song, group)
                .orElseThrow(() -> new NotFoundException("Music not found"));
        return MusicMapper.INSTANCE.toMusicGetDto(music);
    }

    @Override
    public MusicGetTextDto getText(String song, String group, Integer countVerse, Integer page) {
        var music = musicRepository.findBySongAndGroups_Name(song, group)
                .orElseThrow(() -> new NotFoundException("Music not found"));
        var verses = music.getText().split("\n\n");

        var start = countVerse * (page - 1);
        var end = start + countVerse;
        var verseList = Arrays.asList(verses).subList(start, Math.min(end, verses.length));

        return MusicGetTextDto.builder()
                .song(music.getSong())
                .text(String.join("\n\n", verseList))
                .groups(music.getGroups())
                .build();
    }
}
