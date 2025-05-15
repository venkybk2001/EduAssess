package com.springboot.jpa.mvc.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.jpa.mvc.Entity.GTOLog;

public interface GTOLogRepo  extends JpaRepository<GTOLog, Integer>{
	
	int countByUserIdAndTestId(int userid, int testid);
	
	@Query("SELECT g FROM GTOLog g WHERE g.user.id = :userId AND g.test.id = :testId")
	List<GTOLog> findByUserIdAndTestId(@Param("userId") int userId, @Param("testId") int testId);
	
	@Query("SELECT COUNT(l) > 0 FROM GTOLog l WHERE l.user.id = :userId")
	public boolean existsByUserId(@Param("userId") int userId);

	@Modifying
	@Query("UPDATE GTOLog SET user.id = NULL WHERE user.id= :userId")
	void setUserIdToNull(@Param("userId") int userId);
	
	@Query("SELECT COUNT(l) > 0 FROM GTOLog l WHERE l.gtoBean.id = :gtoId")
	public boolean existsByGTOId(@Param("gtoId") int gtoId);
	
	@Modifying
	@Query("UPDATE GTOLog SET gtoBean.id = NULL WHERE gtoBean.id= :gtoId")
	void setGTOIdToNull(@Param("gtoId") int gtoId);
	
	List<GTOLog> findByTest_Id(int testId);
}
