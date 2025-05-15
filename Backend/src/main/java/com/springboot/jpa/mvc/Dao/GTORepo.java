package com.springboot.jpa.mvc.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.mvc.Entity.GTOBean;

@Repository
public interface GTORepo  extends JpaRepository<GTOBean, Integer> {
	
	@Query(value = "SELECT q FROM GTOBean q ORDER BY RAND() LIMIT 1")
	Optional<GTOBean> findRandomGTO();
	
	
}
