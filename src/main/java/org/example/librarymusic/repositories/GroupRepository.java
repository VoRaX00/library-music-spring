package org.example.librarymusic.repositories;

import org.example.librarymusic.models.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GroupRepository extends CrudRepository<Group, Long> {
    Optional<Group> findByName(String name);
}
