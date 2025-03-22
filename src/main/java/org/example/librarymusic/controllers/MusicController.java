package org.example.librarymusic.controllers;

import lombok.AllArgsConstructor;
import org.example.librarymusic.mappers.MusicMapper;
import org.example.librarymusic.models.Music;
import org.example.librarymusic.models.MusicCreateDto;
import org.example.librarymusic.models.MusicUpdateDto;
import org.example.librarymusic.services.MusicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MusicController {
    private final MusicService musicService;

    @PostMapping("/music")
    public Music createMusic(@RequestBody MusicCreateDto musicCreateDto) {
        var music = MusicMapper.INSTANCE.toModel(musicCreateDto);
        System.out.println(music);
        return musicService.save(music);
    }

    @PutMapping("/music/{id}")
    public void updateMusic(@RequestBody MusicUpdateDto updateDto, @PathVariable String id) {
        return musicService.update(updateDto);
    }

    @PatchMapping("/music/{id}")
    public Music patchMusic(@RequestBody MusicCreateDto musicCreateDto, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/music/{id}")
    public void deleteMusic(@PathVariable Long id) {
        musicService.delete(id);
    }

    @GetMapping("/music")
    public MusicCreateDto getMusic(@RequestParam String song, @RequestParam String group) {
        return null;
    }

    @GetMapping("/music")
    public List<MusicCreateDto> getAllMusics(@RequestParam String song, @RequestParam String group,
                                             @RequestParam String list, @RequestParam String released) {
        return null;
    }

    @GetMapping("/music/{id}/text")
    public String getMusicText(@PathVariable Long id) {
        return null;
    }
}
