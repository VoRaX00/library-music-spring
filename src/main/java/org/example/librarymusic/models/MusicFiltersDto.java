package org.example.librarymusic.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class MusicFiltersDto {
    private String song;
    private String group;
    private String link;
    private LocalDate released;
}
