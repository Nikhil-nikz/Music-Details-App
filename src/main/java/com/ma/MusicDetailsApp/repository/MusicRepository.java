package com.ma.MusicDetailsApp.repository;

import com.ma.MusicDetailsApp.dto.MusicAppDto;
import com.ma.MusicDetailsApp.entity.MusicApp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MusicRepository extends CrudRepository<MusicApp,Integer> {

   List<MusicAppDto> getMusicByLanguage(String language);
   MusicApp getMusicBySinger(String language);

   List<MusicApp> findByGenre(String genre);

   List<MusicApp> findByReleaseYear(int releaseYear);


   MusicApp getMusicByMovie(String movie);

}
