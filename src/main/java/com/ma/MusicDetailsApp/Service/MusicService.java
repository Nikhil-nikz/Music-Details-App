package com.ma.MusicDetailsApp.Service;

import com.ma.MusicDetailsApp.dto.MusicAppDto;
import com.ma.MusicDetailsApp.entity.MusicApp;

import java.util.List;

public interface MusicService {
    public MusicAppDto saveMusic(MusicAppDto dto);
    public MusicAppDto getMusicById(int id);
    public List<MusicAppDto> getAllMusic();
    public MusicAppDto updateMusic(int id,MusicAppDto dto);
    public void deleteMusicById(int id);
}
