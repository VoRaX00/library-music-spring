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

    @Mapping(source = "groups", target = "groups", qualifiedByName = "mapGroupsDto")
    MusicGetTextDto toMusicGetTextDto(Music music);

    @Named("mapGroups")
    default List<Group> mapGroups(List<GroupDto> groupNames) {
        if (groupNames == null || groupNames.isEmpty()) {
            return List.of();
        }
        return groupNames.stream()
                .map(groupDto -> {
                    Group group = new Group();
                    group.setName(groupDto.getName());
                    return group;
                }).collect(Collectors.toList());
    }

    @Named("mapGroupsDto")
    default List<GroupDto> mapGroupsDto(List<Group> groups) {
        if (groups == null || groups.isEmpty()) {
            return List.of();
        }
        return groups.stream()
                .map(group -> GroupDto.builder().name(group.getName()).build())
                .collect(Collectors.toList());
    }
}


