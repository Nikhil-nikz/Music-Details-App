package com.ma.MusicDetailsApp.Repository;

import com.ma.MusicDetailsApp.entity.MusicApp;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<MusicApp,Integer> {

}
