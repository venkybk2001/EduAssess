package com.springboot.jpa.mvc.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.mvc.Entity.Test;

@Repository
public interface TestRepo extends JpaRepository<Test, Integer>{
	
	List<Test> findByCategory(String category);
	
	@Query("SELECT t FROM Test t JOIN GTOLog g ON t.id = g.test.id WHERE g.user.id = :studentId AND t.category = :category")
	List<Test> findGtoTestsByUserAndCategory(@Param("category") String category, @Param("studentId") int studentId);
	 
	@Query("SELECT t FROM Test t JOIN MCQLog m ON t.id = m.test.id WHERE m.user.id = :studentId AND t.category = :category")
	List<Test> findmcqTestsByUserAndCategory(@Param("category") String category, @Param("studentId") int studentId);
	 
	@Query("SELECT t FROM Test t JOIN Log l ON t.id = l.test.id WHERE l.user.id = :studentId AND t.category = :category")
	List<Test> findWrittenTestsByUserAndCategory(@Param("category") String category, @Param("studentId") int studentId);
}
