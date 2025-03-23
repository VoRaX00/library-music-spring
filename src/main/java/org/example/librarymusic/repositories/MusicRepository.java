package org.example.librarymusic.repositories;

import org.example.librarymusic.models.Group;
import org.example.librarymusic.models.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface MusicRepository extends JpaRepository<Music, Long> {
    @Query("SELECT m FROM Music m " +
            "LEFT JOIN m.groups g " +
            "WHERE (:song IS NULL OR m.song = :song) " +
            "AND (:group IS NULL OR g.name = :group) " +
            "AND (:link IS NULL OR m.link = :link) " +
            "AND (:released IS NULL OR m.released = :released)"
    )
    Page<Music> searchAll(@Param("song") String song,
                              @Param("group") String group,
                              @Param("link") String link,
                              @Param("released") LocalDate released,
                              Pageable pageable);

    Optional<Music> findBySongAndGroups_Name(String song, String group);

    @Query("SELECT EXISTS (SELECT 1 FROM Music m JOIN m.groups g " +
            "WHERE m.song = :song AND g.name IN :groupNames)")
    boolean existsBySongAndGroups_Name(@Param("song") String song,
                                       @Param("groupNames") List<String> group);
}
