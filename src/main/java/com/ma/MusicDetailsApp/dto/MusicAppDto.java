package com.ma.MusicDetailsApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MusicAppDto {
    private int id;
    private String singer;
    private String producer;
    private String lyricist;
    private String musicDirector;
    private String language;
    private String genre;
    private int releaseYear;
    private String trackName;
    private String movie;


}
