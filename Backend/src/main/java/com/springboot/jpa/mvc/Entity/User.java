package com.springboot.jpa.mvc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "USER_TABLE")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	public int id;
	@Column(name = "USER_ALIAS_NAME")
	public String name;
	@Column(name = "USER_NAME")
	public String username;
	@Column(name = "USER_PASSWORD")
	public String password;
	@Column(name = "USER_ROLE")
	public int role;
	@Column(name = "USER_ACTIVE_STATUS", columnDefinition = "int default 1")
	public int activeStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}
	public User( String name, String username, String password, int role, int activeStatus) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.activeStatus = activeStatus;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
