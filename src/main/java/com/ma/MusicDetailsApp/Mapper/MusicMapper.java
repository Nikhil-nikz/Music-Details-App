package com.ma.MusicDetailsApp.Mapper;

import com.ma.MusicDetailsApp.dto.MusicAppDto;
import com.ma.MusicDetailsApp.entity.MusicApp;

public class MusicMapper {

    public  static MusicAppDto mapTomusicAppDto(MusicApp app){
        return new MusicAppDto(
                app.getId(),
                app.getSinger(),
                app.getProducer(),
                app.getLyricist(),
                app.getMusicDirector(),
                app.getLanguage(),
                app.getGenre(),
                app.getReleaseYear(),
                app.getTrackName(),
                app.getMovie()
        );

    }

    public static MusicApp mapToMusicApp(MusicAppDto dto){
        return new MusicApp(
                dto.getId(),
                dto.getSinger(),
                dto.getProducer(),
                dto.getLyricist(),
                dto.getMusicDirector(),
                dto.getLanguage(),
                dto.getGenre(),
                dto.getReleaseYear(),
                dto.getTrackName(),
                dto.getMovie()

        );
    }

}
