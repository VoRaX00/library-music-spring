package org.example.librarymusic.mappers;

import org.example.librarymusic.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.jmx.export.annotation.ManagedOperation;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface MusicMapper {
    MusicMapper INSTANCE = Mappers.getMapper(MusicMapper.class);

    @Mapping(source = "groups", target = "groups", qualifiedByName = "mapGroups")
    Music toModel(MusicCreateDto musicCreateDto);

    MusicGetDto toMusicGetDto(Music music);

    @Named("mapGroups")
    default List<Group> mapGroups(List<String> groupNames) {
        if (groupNames == null || groupNames.isEmpty()) {
            return List.of();
        }
        return groupNames.stream()
                .map(name -> {
                    Group group = new Group();
                    group.setName(name);
                    return group;
                }).collect(Collectors.toList());
    }
}


