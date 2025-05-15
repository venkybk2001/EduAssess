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
@Table(name = "GTO_LOG_TABLE")
public class GTOLog{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GTO_LOG_ID")
	public int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_WITH_GTO_LOGS") 
	public User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TEST_WITH_GTO_LOGS") 
	public Test test;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GTO_WITH_GTO_LOGS") 
	public GTOBean gtoBean;
	@Column(name = "GTO_LOG_ANSWER")
	public String answer;
	@Column(name = "GTO_LOG_SUBMIT_STATUS")
	public int submit;
	public GTOLog() {
		super();
	}
	public int getId() {
		return id;
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
	public GTOBean getGtoBean() {
		return gtoBean;
	}
	public void setGtoBean(GTOBean gtoBean) {
		this.gtoBean = gtoBean;
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
		return "GTOLog [id=" + id + ", user=" + user + ", test=" + test + ", gtoBean=" + gtoBean + ", answer=" + answer
				+ ", submit=" + submit + "]";
	}
	
	
	
}
