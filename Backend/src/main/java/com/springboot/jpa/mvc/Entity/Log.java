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


//Student Interface


@Entity
@Table(name = "QUE_LOG_TABLE")
public class Log{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOG_ID")
	public int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_WITH_QUE_LOGS") 
	public User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TEST_WITH_QUE_LOGS") 
	public Test test;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QUESTION_WITH_QUE_LOGS") 
	public Question question;
	@Column(name = "LOG_ANSWER", columnDefinition = "TEXT")
	public String answer;
	@Column(name = "LOG_SUBMIT_STATUS")
	public int submit;
	@Column(name = "LOG_VERIFY_STATUS")
	public int verify;
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
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
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
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", user=" + user + ", test=" + test + ", question=" + question + ", answer=" + answer
				+ ", submit=" + submit + ", verify=" + verify + "]";
	}
	public Log(int id, User user, Test test, Question question, String answer, int submit, int verify) {
		super();
		this.id = id;
		this.user = user;
		this.test = test;
		this.question = question;
		this.answer = answer;
		this.submit = submit;
		this.verify = verify;
	}
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
