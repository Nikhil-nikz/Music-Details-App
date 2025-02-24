package com.ma.MusicDetailsApp.MusicRepository;

import com.ma.MusicDetailsApp.Exception.IdNotFoundException;
import com.ma.MusicDetailsApp.Mapper.MusicMapper;
import com.ma.MusicDetailsApp.Repository.MusicRepository;
import com.ma.MusicDetailsApp.Service.impl.MusicServiceImp;
import com.ma.MusicDetailsApp.dto.MusicAppDto;
import com.ma.MusicDetailsApp.entity.MusicApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MusicServiceImpTest {

    @Mock
    private MusicRepository repository;

    @Mock
    private MusicMapper musicMapper;

    @InjectMocks
    private MusicServiceImp musicService;

    private MusicAppDto musicAppDto;
    private MusicApp musicApp;

    @BeforeEach
    void setUp() {
        musicAppDto = new MusicAppDto();
        musicAppDto.setSinger("K.S.Chithra");
        musicAppDto.setProducer("Rajamani");
        musicAppDto.setLyricist("Kaithapram");
        musicAppDto.setMusicDirector("Kaithapram");
        musicAppDto.setLanguage("Malayalam");
        musicAppDto.setGenre("romantic");
        musicAppDto.setReleaseYear(1993);
        musicAppDto.setTrackName("Aatirambile");
        musicAppDto.setMovie("Kalapani");

        musicApp = new MusicApp();
        musicApp.setSinger("K.S.Chithra");
        musicApp.setProducer("Rajamani");
        musicApp.setLyricist("Kaithapram");
        musicApp.setMusicDirector("Kaithapram");
        musicApp.setLanguage("Malayalam");
        musicApp.setGenre("romantic");
        musicApp.setReleaseYear(1993);
        musicApp.setTrackName("Aatirambile");
        musicApp.setMovie("Kalapani");
    }

    @Test
    void testSaveMusic() {

        when(musicMapper.mapToMusicApp(musicAppDto)).thenReturn(musicApp); // Ensure correct conversion
        when(repository.save(musicApp)).thenReturn(musicApp);
        when(musicMapper.mapTomusicAppDto(musicApp)).thenReturn(musicAppDto);


        MusicAppDto savedMusic = musicService.saveMusic(musicAppDto);
        assertNotNull(savedMusic);
        assertEquals("K.S.Chithra", savedMusic.getSinger());
        verify(repository, times(1)).save(musicApp);
    }

    @Test
    void testGetMusicByIdFound() {

        when(repository.findById(1)).thenReturn(Optional.of(musicApp));
        when(MusicMapper.mapTomusicAppDto(musicApp)).thenReturn(musicAppDto);


        MusicAppDto music = musicService.getMusicById(1);
        assertNotNull(music);
        assertEquals(1993, music.getReleaseYear());
        assertEquals("K.S.Chithra", music.getSinger());
    }

    @Test
    void testGetMusicByIdNotFound() {

        when(repository.findById(1)).thenReturn(Optional.empty());


        assertThrows(IdNotFoundException.class, () -> musicService.getMusicById(1));
    }

    @Test
    void testUpdateMusic() {

        when(repository.findById(1)).thenReturn(Optional.of(musicApp));
        when(MusicMapper.mapTomusicAppDto(musicApp)).thenReturn(musicAppDto);


        musicAppDto.setTrackName("Marrikoodinullil");
        when(repository.save(musicApp)).thenReturn(musicApp); // Ensure save is correctly mocked

        MusicAppDto updatedMusic = musicService.updateMusic(1, musicAppDto);


        assertNotNull(updatedMusic);
        assertEquals("Marrikoodinullil", updatedMusic.getTrackName());
        verify(repository, times(1)).save(musicApp);
    }

    @Test
    void testDeleteMusicById() {

        when(repository.findById(1)).thenReturn(Optional.of(musicApp));


        musicService.deleteMusicById(1);
        verify(repository, times(1)).deleteById(1);
    }
}
