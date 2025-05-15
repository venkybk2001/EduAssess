package com.springboot.jpa.mvc.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//for add the test

@Entity
@Table(name = "TEST_TABLE")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEST_ID")
	public int id;
	@Column(name = "TEST_NAME")
	public String name;
	@Column(name = "TEST_CATEGORY")
	public String category;
	@Column(name = "TEST_START_TIME")
	public Date startTime;
	@Column(name = "TEST_END_TIME")
	public Date endTime;
	@Column(name = "TEST_QUE_COUNT")
	public int questionCount;
	@Column(name = "TEST_PASS_COUNT")
	public int passingCount;
	@Column(name = "TEST_RESULT")
	public String result;
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
	public Date getStart() {
		return startTime;
	}
	public void setStart(Date start) {
		this.startTime = start;
	}
	public Date getEnd() {
		return endTime;
	}
	public void setEnd(Date end) {
		this.endTime = end;
	}
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	public int getPassingCount() {
		return passingCount;
	}
	public void setPassingCount(int passingCount) {
		this.passingCount = passingCount;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", start=" + startTime + ", end=" + endTime + ", questionCount="
				+ questionCount + ", passingCount=" + passingCount + ", result=" + result + "]";
	}
	public Test(int id, String name, Date start, Date end, int questionCount, int passingCount, String result) {
		super();
		this.id = id;
		this.name = name;
		this.startTime = start;
		this.endTime = end;
		this.questionCount = questionCount;
		this.passingCount = passingCount;
		this.result = result;
	}
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
