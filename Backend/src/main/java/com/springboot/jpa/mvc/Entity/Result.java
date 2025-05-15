package com.springboot.jpa.mvc.Entity;

public class Result {
	
	public int id;
	public String name;
	public String userName;
	public String studentName; 
	public int obtainMarks;
	public int outOfMarks;
	public int result;
	public String testDate;
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result(int id, String name, String userName, String studentName, int obtainMarks, int outOfMarks, int result, String testDate) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.studentName = studentName;
		this.obtainMarks = obtainMarks;
		this.outOfMarks = outOfMarks;
		this.result = result;
		this.testDate = testDate;
	}
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getObtainMarks() {
		return obtainMarks;
	}
	public void setObtainMarks(int obtainMarks) {
		this.obtainMarks = obtainMarks;
	}
	public int getOutOfMarks() {
		return outOfMarks;
	}
	public void setOutOfMarks(int outOfMarks) {
		this.outOfMarks = outOfMarks;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
}
