package com.springboot.jpa.mvc.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.jpa.mvc.Entity.MCQLog;

public interface MCQLogRepo extends JpaRepository<MCQLog, Integer>{
	
	int countByUserIdAndTestId(int userid, int testid);
	
	 @Query("SELECT m FROM MCQLog m WHERE m.user.id = :userId AND m.test.id = :testId")
	 List<MCQLog> findByUserIdAndTestId(@Param("userId") int userId, @Param("testId") int testId);

	@Query("SELECT COUNT(l) > 0 FROM MCQLog l WHERE l.user.id = :userId")
	public boolean existsByUserId(@Param("userId") int userId);
	
	@Modifying
	@Query("UPDATE MCQLog SET user.id = NULL WHERE user.id= :userId")
	void setUserIdToNull(@Param("userId") int userId);
	
	@Query("SELECT COUNT(l) > 0 FROM MCQLog l WHERE l.mcqBean.id = :mcqId")
	public boolean existsByMCQId(@Param("mcqId") int mcqId);
	
	@Modifying
	@Query("UPDATE MCQLog SET mcqBean.id = NULL WHERE mcqBean.id= :mcqId")
	void setMCQIdToNull(@Param("mcqId") int mcqId);
	
	List<MCQLog> findByTest_Id(int testId);
	
	
}
