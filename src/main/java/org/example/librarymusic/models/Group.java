package org.example.librarymusic.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private  Long id;

    @Column(name = "name", unique = true)
    private String name;
}
