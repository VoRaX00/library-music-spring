package org.example.librarymusic.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MusicGetTextDto {
    private String song;
    private List<Group> groups;
    private String text;
}
