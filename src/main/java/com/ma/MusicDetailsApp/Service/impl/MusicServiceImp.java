package com.ma.MusicDetailsApp.Service.impl;

import com.ma.MusicDetailsApp.Exception.IdNotFoundException;
import com.ma.MusicDetailsApp.Mapper.MusicMapper;
import com.ma.MusicDetailsApp.Repository.MusicRepository;
import com.ma.MusicDetailsApp.Service.MusicService;
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
      MusicApp apps=  repository.findById(id).orElseThrow(()-> new IdNotFoundException("the music details is not found for id"+id));
      return MusicMapper.mapTomusicAppDto(apps);

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


}
