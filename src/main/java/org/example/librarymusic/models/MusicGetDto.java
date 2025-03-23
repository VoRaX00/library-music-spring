package org.example.librarymusic.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class MusicGetDto {
    private Long id;
    private String song;
    private List<Group> groups;
    private String link;
    private LocalDate released;
}
