package com.springboot.jpa.mvc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Adding the Question

@Entity
@Table(name = "QUESTION_TABLE")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID")
	public int id;
	@Column(name = "QUESTION_NAME")
	public String name;
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
	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + "]";
	}
	public Question(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
