package org.example.librarymusic.services;

import org.example.librarymusic.models.Music;
import org.example.librarymusic.repositories.MusicRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MusicServiceImplTest {
    @InjectMocks
    private MusicService musicService;
    @Mock
    private MusicRepository musicRepository;

    @Test
    void save() {
        Mockito.when(musicRepository.save(Mockito.any())).thenReturn(new Music());
    }
}
