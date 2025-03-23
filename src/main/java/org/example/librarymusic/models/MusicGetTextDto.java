package org.example.librarymusic.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MusicGetTextDto {
    private String song;
    private List<GroupDto> groups;
    private String text;
}
