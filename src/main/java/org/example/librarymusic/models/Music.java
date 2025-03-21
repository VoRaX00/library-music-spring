package org.example.librarymusic.models;

import lombok.Data;

import java.lang.foreign.GroupLayout;
import java.util.Date;
import java.util.List;

@Data
public class Music {
    private Long id;
    private String song;
    private String text;
    private String link;
    private List<Group> groups;
    private Date released;
}