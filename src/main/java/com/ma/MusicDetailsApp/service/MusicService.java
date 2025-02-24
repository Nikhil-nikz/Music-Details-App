package com.ma.MusicDetailsApp.service;

import com.ma.MusicDetailsApp.dto.MusicAppDto;

import java.util.List;

public interface MusicService {
    public MusicAppDto saveMusic(MusicAppDto dto);
    public MusicAppDto getMusicById(int id);
    public List<MusicAppDto> getAllMusic();
    public MusicAppDto updateMusic(int id,MusicAppDto dto);
    public void deleteMusicById(int id);
    public List<MusicAppDto> getMusicByLanguage(String language);

    public MusicAppDto getMusicBySinger(String singer);

    public List<MusicAppDto> getByGenre(String genre);

    public List<MusicAppDto> getByReleaseYear(int releaseYear);

    public MusicAppDto getMusicByMovie(String movie);

}
