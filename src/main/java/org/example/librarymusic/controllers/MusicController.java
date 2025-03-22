package org.example.librarymusic.controllers;

import lombok.AllArgsConstructor;
import org.example.librarymusic.mappers.MusicMapper;
import org.example.librarymusic.models.Music;
import org.example.librarymusic.models.MusicDto;
import org.example.librarymusic.services.MusicService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MusicController {
    private final MusicService musicService;

    @PostMapping("/music")
    public Music createMusic(@RequestBody MusicDto musicDto) {
        var music = MusicMapper.INSTANCE.toModel(musicDto);
        System.out.println(music);
        return musicService.save(music);
    }

    @PutMapping("/music/{id}")
    public Music updateMusic(@RequestBody MusicDto musicDto, @PathVariable String id) {
        return null;
    }

    @PatchMapping("/music/{id}")
    public Music patchMusic(@RequestBody MusicDto musicDto, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/music/{id}")
    public void deleteMusic(@PathVariable Long id) {
        musicService.delete(id);
    }

    @GetMapping("/music")
    public MusicDto getMusic(@RequestParam String song, @RequestParam String group) {
        return null;
    }

    @GetMapping("/music")
    public List<MusicDto> getAllMusics(@RequestParam String song, @RequestParam String group,
                                       @RequestParam String list, @RequestParam String released) {
        return null;
    }

    @GetMapping("/music/{id}/text")
    public String getMusicText(@PathVariable Long id) {
        return null;
    }
}
