package com.ma.MusicDetailsApp.service.impl;

import com.ma.MusicDetailsApp.exception.IdNotFoundException;
import com.ma.MusicDetailsApp.mapper.MusicMapper;
import com.ma.MusicDetailsApp.repository.MusicRepository;
import com.ma.MusicDetailsApp.service.MusicService;
import com.ma.MusicDetailsApp.dto.MusicAppDto;
import com.ma.MusicDetailsApp.entity.MusicApp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class MusicServiceImp implements MusicService {

    private MusicRepository repository;


    @Override
    public MusicAppDto saveMusic(MusicAppDto dto) {
      MusicApp app =   MusicMapper.mapToMusicApp(dto);
       MusicApp saveApp =  repository.save(app);
       return MusicMapper.mapTomusicAppDto(saveApp);
    }

    @Override
    public MusicAppDto getMusicById(int id) {
      MusicApp app=  repository.findById(id).orElseThrow(()-> new IdNotFoundException("the music details is not found for id"+id));
      return MusicMapper.mapTomusicAppDto(app);

    }

    @Override
    public List<MusicAppDto> getAllMusic() {
      Iterable<MusicApp>  apps=  repository.findAll();
      List<MusicAppDto> list=new ArrayList<>();
      Iterator<MusicApp>  it = apps.iterator();
      while(it.hasNext()){
        MusicApp ap=  it.next();
          System.out.println(ap);
          MusicMapper.mapTomusicAppDto(ap);
       list.add(ap);
      }
        return list;
    }

    @Override
    public MusicAppDto updateMusic(int id, MusicAppDto dtos) {
        MusicApp app=  repository.findById(id).orElseThrow(()-> new IdNotFoundException("the music details is not found for id"+id));

        app.setSinger(dtos.getSinger());
        app.setProducer(dtos.getProducer());
        app.setLyricist(dtos.getMusicDirector());
        app.setMusicDirector(dtos.getMusicDirector());
        app.setLanguage(dtos.getLanguage());
        app.setGenre(dtos.getGenre());
        app.setReleaseYear(dtos.getReleaseYear());
        app.setTrackName(dtos.getTrackName());
        app.setMovie(dtos.getMovie());

        MusicApp apps = repository.save(app);

        return MusicMapper.mapTomusicAppDto(apps);
    }

    @Override
    public void deleteMusicById(int id) {
        MusicApp app=  repository.findById(id).orElseThrow(()-> new IdNotFoundException("the music details is not found for id"+id));

         repository.deleteById(id);

    }

    @Override
    public List<MusicAppDto> getMusicByLanguage(String language) {
        Iterable<MusicApp>  apps=  repository.findAll();
        List<MusicAppDto> list=new ArrayList<>();
        Iterator<MusicApp>  it = apps.iterator();
        while(it.hasNext()){
            MusicApp ap=  it.next();
            System.out.println(ap);
            MusicMapper.mapTomusicAppDto(ap);
            list.add(ap);
        }
        return list;
    }

    @Override
    public MusicAppDto getMusicBySinger(String singer) {
      MusicApp dto=    repository.getMusicBySinger(singer);
      return  MusicMapper.mapTomusicAppDto(dto);
    }

//    @Override
//    public MusicAppDto getMusicByGenre(String genre) {
//
//        MusicApp dtos =    repository.getMusicByGenre(genre);
//        return MusicMapper.mapTomusicAppDto(dtos);





    public List<MusicAppDto> getByGenre(String genre) {

            List<MusicApp> musicApps = repository.findByGenre(genre);

            List<MusicAppDto> musicAppDtos = new ArrayList<>();

            for (MusicApp musicApp : musicApps) {
                MusicAppDto musicAppDto = new MusicAppDto();

                musicAppDto.setSinger(musicApp.getSinger());
                musicAppDto.setProducer(musicApp.getProducer());
                musicAppDto.setGenre(musicApp.getGenre());
                musicAppDto.setMusicDirector(musicApp.getMusicDirector());
                musicAppDto.setLyricist(musicApp.getLyricist());
                musicAppDto.setLanguage(musicApp.getLanguage());
                musicAppDto.setReleaseYear(musicApp.getReleaseYear());
                musicAppDto.setTrackName(musicApp.getTrackName());
                musicAppDto.setMovie(musicApp.getMovie());
                musicAppDto.setId(musicApp.getId());


                musicAppDtos.add(musicAppDto);
            }


            return musicAppDtos;
        }



    public List<MusicAppDto> getByReleaseYear(int releaseYear) {

        List<MusicApp> musicApps = repository.findByReleaseYear( releaseYear);

        List<MusicAppDto> musicAppDtos = new ArrayList<>();

        for (MusicApp musicApp : musicApps) {
            MusicAppDto musicAppDto = new MusicAppDto();

            musicAppDto.setSinger(musicApp.getSinger());
            musicAppDto.setProducer(musicApp.getProducer());
            musicAppDto.setGenre(musicApp.getGenre());
            musicAppDto.setMusicDirector(musicApp.getMusicDirector());
            musicAppDto.setLyricist(musicApp.getLyricist());
            musicAppDto.setLanguage(musicApp.getLanguage());
            musicAppDto.setReleaseYear(musicApp.getReleaseYear());
            musicAppDto.setTrackName(musicApp.getTrackName());
            musicAppDto.setMovie(musicApp.getMovie());
            musicAppDto.setId(musicApp.getId());


            musicAppDtos.add(musicAppDto);
        }


        return musicAppDtos;
    }

    @Override
    public MusicAppDto getMusicByMovie(String movie) {
        MusicApp dto=    repository.getMusicByMovie(movie);
        return  MusicMapper.mapTomusicAppDto(dto);
    }
}






