package org.example.librarymusic.models;

import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class MusicDto {
    private String song;
    private String text;
    private String link;
    private List<String> groups;
    private Date released;
}
