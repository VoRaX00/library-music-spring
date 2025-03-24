package org.example.librarymusic.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.librarymusic.models.*;
import org.example.librarymusic.services.MusicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@Slf4j
@Tag(name = "music_controller")
@RequestMapping("/musics")
public class MusicController {
    private final MusicService musicService;

    @PostMapping
    public ResponseEntity<MusicGetDto> createMusic(@RequestBody MusicCreateDto musicCreateDto) {
        log.debug("creating music {}", musicCreateDto);
        var music = musicService.save(musicCreateDto);
        log.debug("successfully created music {}", music);
        return new ResponseEntity<>(music, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void updateMusic(@RequestBody MusicUpdateDto updateDto, @PathVariable Long id) {
        log.debug("updating music {}", updateDto);
        musicService.fullUpdate(id, updateDto);
        log.debug("successfully updated music {}", updateDto);
    }

    @PatchMapping("/{id}")
    public void patchMusic(@RequestBody MusicUpdateDto musicUpdateDto, @PathVariable Long id) {
        log.debug("partial updating music {}", musicUpdateDto);
        musicService.partialUpdate(id, musicUpdateDto);
        log.debug("successfully partial updated music {}", musicUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMusic(@PathVariable Long id) {
        log.debug("deleting music {}", id);
        musicService.delete(id);
        log.debug("successfully deleted music {}", id);
    }

    @GetMapping("/song")
    public MusicGetDto getMusic(@RequestParam String song, @RequestParam String group) {
        log.debug("getting music where song = {} and group = {}", song, group);
        var music =  musicService.get(song, group);
        log.debug("successfully getting music {}", music);
        return music;
    }

    @GetMapping("/{page}")
    public Page<MusicGetDto> getAllMusics(
            @RequestParam(required = false) String song,
            @RequestParam(required = false) String group,
            @RequestParam(required = false) String link,
            @RequestParam(required = false) LocalDate released,
            @RequestParam(defaultValue = "4") Integer countSongs,
            @PathVariable Integer page) {


        var filters = MusicFiltersDto.builder()
                .song(song)
                .group(group)
                .link(link)
                .released(released)
                .build();

        log.debug("getting all musics by filters {}", filters);
        var musics = musicService.getAll(filters, PageRequest.of(page, countSongs));
        log.debug("successfully getting musics {}", musics);
        return musics;
    }

    @GetMapping("/text/{page}")
    public MusicGetTextDto getMusicText(@PathVariable Integer page,
                               @RequestParam String song,
                               @RequestParam String group,
                               @RequestParam Integer countVerse) {
        log.info("getting text");
        var musicTextDto =  musicService.getText(song, group, countVerse, page);
        log.debug("successfully getting musicText {}", musicTextDto);
        return musicTextDto;
    }
}
