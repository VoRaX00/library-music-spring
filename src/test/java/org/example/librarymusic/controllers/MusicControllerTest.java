package org.example.librarymusic.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.librarymusic.models.Group;
import org.example.librarymusic.models.GroupDto;
import org.example.librarymusic.models.MusicCreateDto;
import org.example.librarymusic.models.MusicGetDto;
import org.example.librarymusic.services.MusicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MusicControllerTest {
    @Mock
    private MusicService musicService;

    @InjectMocks
    private MusicController musicController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(musicController).build();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void createMusic() throws Exception {
        var now = LocalDate.now();
        MusicCreateDto musicCreateDto = new MusicCreateDto("song-test",
                "song-text", "http://example.com",
                List.of(
                        new GroupDto("Group-test1"),
                        new GroupDto("Group-test2")
                ), now);

        String musicJson = objectMapper.writeValueAsString(musicCreateDto);

        MusicGetDto musicGetDto = new MusicGetDto(
                1L,
                "song-test",
                List.of(
                        new Group(1L, "Group-test1"),
                        new Group(2L, "Group-test2")
                ),
                "http://example.com",
                now
            );

        String resultJson = objectMapper.writeValueAsString(musicGetDto);
        mockMvc.perform(post("/musics")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(musicJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").value(resultJson));

        verify(musicService, times(1)).save(musicCreateDto);
    }
}
