package com.springboot.jpa.mvc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MCQ_LOG_TABLE")
public class MCQLog{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MCQ_LOG_ID")
	public int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_WITH_MCQS") 
	public User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TEST_WITH_MCQS") 
	public Test test;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MCQ_WITH_MCQS") 
	public MCQBean mcqBean;
	@Column(name = "MCQ_LOG_ANSWER")
	public String answer;
	@Column(name = "MCQ_SUBMIT_STATUS")
	public int submit;
	
	public MCQLog() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public MCQBean getMcqBean() {
		return mcqBean;
	}
	public void setMcqBean(MCQBean mcqBean) {
		this.mcqBean = mcqBean;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getSubmit() {
		return submit;
	}
	public void setSubmit(int submit) {
		this.submit = submit;
	}
	
	@Override
	public String toString() {
		return "MCQLog [id=" + id + ", user=" + user + ", test=" + test + ", mcqBean=" + mcqBean 
				+ ", submit=" + submit + "]";
	}
	
}
