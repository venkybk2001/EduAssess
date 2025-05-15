package com.springboot.jpa.mvc.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.mvc.Entity.Question;

////its interact with database

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>
{

	@Query(value = "SELECT q FROM Question q ORDER BY RAND() LIMIT 1")
	Optional<Question> findRandomQuestion();
	
	
	
}
