package com.springboot.jpa.mvc.Dao;

import java.util.List;

//student interface interact with database

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.mvc.Entity.Log;

@Repository
public interface LogRepo extends JpaRepository<Log, Integer>
{
	int countByUserIdAndTestId(int userid, int testid);
	int countByUserIdAndTestIdAndVerify(int userid, int testid, int verify);
	
	@Query("SELECT l FROM Log l WHERE l.user.id = :userId AND l.test.id = :testId")
	List<Log> findByUserIdAndTestId(@Param("userId") int userId, @Param("testId") int testId);
	
	List<Log> findBySubmitAndVerify(int submit, int verify);
	
	@Query("SELECT COUNT(l) > 0 FROM Log l WHERE l.question.id = :questionId")
	public boolean existsByQuestionId(@Param("questionId") int questionId);

	@Modifying
	@Query("UPDATE Log SET question.id = NULL WHERE question.id= :questionId")
	void setQuestionIdToNull(@Param("questionId") int questionId);
	
	@Query("SELECT COUNT(l) > 0 FROM Log l WHERE l.user.id = :userId")
	public boolean existsByUserId(@Param("userId") int userId);
	
	@Modifying
	@Query("UPDATE Log SET user.id = NULL WHERE user.id= :userId")
	void setUserIdToNull(@Param("userId") int userId);
	
	List<Log> findByTest_Id(int testId);
}
