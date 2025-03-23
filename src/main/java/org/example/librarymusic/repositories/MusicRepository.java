package org.example.librarymusic.repositories;

import org.example.librarymusic.models.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;


public interface MusicRepository extends JpaRepository<Music, Long> {
    @Query("SELECT m FROM Music m " +
            "LEFT JOIN m.groups g " +
            "WHERE (:song IS NULL OR m.song LIKE %:song%) " +
            "AND (:group IS NULL OR g.name = :group) " +
            "AND (:link IS NULL OR m.link = :link) " +
            "AND (:released IS NULL OR m.released = :released)"
    )
    Page<Music> searchAll(@Param("song") String song,
                              @Param("group") String group,
                              @Param("link") String link,
                              @Param("released") Date released,
                              Pageable pageable);

    Optional<Music> findBySongAndGroups_Name(String song, String group);
}
