package org.example.librarymusic.controllers;

import lombok.AllArgsConstructor;
import org.example.librarymusic.mappers.MusicMapper;
import org.example.librarymusic.models.Music;
import org.example.librarymusic.models.MusicDto;
import org.example.librarymusic.services.MusicService;
import org.springframework.web.bind.annotation.*;

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
}
