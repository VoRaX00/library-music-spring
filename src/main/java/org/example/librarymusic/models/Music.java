package org.example.librarymusic.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "song")
    private String song;

    @Column(name = "text")
    private String text;

    @Column(name = "link")
    private String link;

    @Column(name = "released")
    private Date released;

    @ManyToMany
    @JoinTable(
            name = "musics_groups",
            joinColumns = @JoinColumn(name = "music_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Collection<Group> groups;

}