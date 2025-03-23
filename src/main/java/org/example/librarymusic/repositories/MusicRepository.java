package org.example.librarymusic.repositories;

import org.example.librarymusic.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MusicRepository extends CrudRepository<Music, Long>, CustomMusicRepository {
}
