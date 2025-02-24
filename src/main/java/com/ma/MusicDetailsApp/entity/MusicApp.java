package com.ma.MusicDetailsApp.entity;

import com.ma.MusicDetailsApp.dto.MusicAppDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "music")
public class MusicApp extends MusicAppDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
//    @Getter
//    @Setter
//    private String musicList;

//    public MusicApp(int id, String singer, String producer, String lyricist, String musicDirector, String language, String genre, int releaseYear, String trackName, String movie) {
//    }
}
