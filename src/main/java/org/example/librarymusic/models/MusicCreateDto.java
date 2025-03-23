package org.example.librarymusic.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class MusicCreateDto {
    private String song;
    private String text;
    private String link;
    private List<String> groups;
    private LocalDate released;
}
