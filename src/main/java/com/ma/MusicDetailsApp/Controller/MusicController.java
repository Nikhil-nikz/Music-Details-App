package com.ma.MusicDetailsApp.Controller;

import com.ma.MusicDetailsApp.Service.MusicService;
import com.ma.MusicDetailsApp.dto.MusicAppDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/music")
public class MusicController {

 private MusicService service;

 @PostMapping
    public ResponseEntity<MusicAppDto> saveMusic(@RequestBody MusicAppDto dto){
       MusicAppDto savedMusic =   service.saveMusic(dto);
       return new ResponseEntity<>(savedMusic, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MusicAppDto> getMusicById(@PathVariable("id") int id){
      MusicAppDto dt = service.getMusicById(id);
      return ResponseEntity.ok(dt);
    }

    @GetMapping
    public ResponseEntity<List<MusicAppDto>> getAllMusic(){
     List<MusicAppDto> list=  service.getAllMusic();
     return ResponseEntity.ok(list);
    }

    @PutMapping("{id}")
    public ResponseEntity<MusicAppDto> updateMusic(@PathVariable("id") int id,
                                                   @RequestBody MusicAppDto dto){
       MusicAppDto dtos= service.updateMusic(id,dto);
       return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMusicById(@PathVariable("id") int id){
        service.deleteMusicById(id);
        return ResponseEntity.ok("The details are deleted Successfully");
    }
}
