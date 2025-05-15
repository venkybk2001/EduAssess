package com.springboot.jpa.mvc.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.mvc.Entity.LinkBean;

@Repository
public interface LinkRepo  extends JpaRepository<LinkBean, Integer> {
}
