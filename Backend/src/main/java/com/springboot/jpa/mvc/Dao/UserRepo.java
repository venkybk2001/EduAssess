package com.springboot.jpa.mvc.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.mvc.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	int countByUsername(String username);
    User findByUsername(String username);
    List<User> findByRole(int role);
    
}
