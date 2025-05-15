package com.springboot.jpa.mvc.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.mvc.Entity.MCQBean;

@Repository
public interface MCQRepo extends JpaRepository<MCQBean, Integer>{
	
	@Query(value = "SELECT q FROM MCQBean q ORDER BY RAND() LIMIT 1")
	Optional<MCQBean> findRandomMCQ();
}
