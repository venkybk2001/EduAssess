package com.springboot.jpa.mvc.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.jpa.mvc.Entity.VideoSession;

@Repository
public interface VideoSessionRepo  extends JpaRepository<VideoSession, Integer> {

}
