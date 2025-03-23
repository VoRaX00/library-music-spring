package org.example.librarymusic.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MusicUpdateDto {
    private String song;
    private String text;
    private String link;
    private List<Group> groups;
    private Date released;
}
