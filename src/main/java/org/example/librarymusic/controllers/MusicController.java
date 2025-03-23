package org.example.librarymusic.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.librarymusic.models.*;
import org.example.librarymusic.services.MusicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@Tag(name = "music_controller")
public class MusicController {
    private final MusicService musicService;

    @PostMapping("/musics")
    public MusicGetDto createMusic(@RequestBody MusicCreateDto musicCreateDto) {
        return musicService.save(musicCreateDto);
    }

    @PutMapping("/musics/{id}")
    public void updateMusic(@RequestBody MusicUpdateDto updateDto, @PathVariable Long id) {
         musicService.fullUpdate(id, updateDto);
    }

    @PatchMapping("/musics/{id}")
    public void patchMusic(@RequestBody MusicUpdateDto musicUpdateDto, @PathVariable Long id) {
        musicService.partialUpdate(id, musicUpdateDto);
    }

    @DeleteMapping("/musics/{id}")
    public void deleteMusic(@PathVariable Long id) {
        musicService.delete(id);
    }

    @GetMapping("/musics/song")
    public MusicGetDto getMusic(@RequestParam String song, @RequestParam String group) {
        return musicService.get(song, group);
    }

    @GetMapping("/musics/{page}")
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

        return musicService.getAll(filters, PageRequest.of(page, countSongs));
    }

    @GetMapping("/musics/text/{page}")
    public MusicGetTextDto getMusicText(@PathVariable Integer page,
                               @RequestParam String song,
                               @RequestParam String group,
                               @RequestParam Integer countVerse) {
        return musicService.getText(song, group, countVerse, page);
    }
}
