package com.springboot.jpa.mvc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MCQ_TABLE")
public class MCQBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MCQ_ID")
	public int id;
	@Column(name = "MCQ_CATEGORY")
	public String category;
	@Column(name = "MCQ_QUE")
	public String que;
	@Column(name = "MCQ_OPT_A")
	public String optA;
	@Column(name = "MCQ_OPT_B")
	public String optB;
	@Column(name = "MCQ_OPT_C")
	public String optC;
	@Column(name = "MCQ_OPT_D")
	public String optD;
	@Column(name = "MCQ_ANS")
	public char ans;
	
	
	public MCQBean() {
		super();
	}
	
	public MCQBean(String category, String que, String optA, String optB, String optC, String optD, char ans) {
		super();
		this.category = category;
		this.que = que;
		this.optA = optA;
		this.optB = optB;
		this.optC = optC;
		this.optD = optD;
		this.ans = ans;
	}


	public int getId() {
		return id;
	}

	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getQue() {
		return que;
	}


	public void setQue(String que) {
		this.que = que;
	}


	public String getOptA() {
		return optA;
	}


	public void setOptA(String optA) {
		this.optA = optA;
	}


	public String getOptB() {
		return optB;
	}


	public void setOptB(String optB) {
		this.optB = optB;
	}


	public String getOptC() {
		return optC;
	}


	public void setOptC(String optC) {
		this.optC = optC;
	}


	public String getOptD() {
		return optD;
	}


	public void setOptD(String optD) {
		this.optD = optD;
	}


	public char getAns() {
		return ans;
	}


	public void setAns(char ans) {
		this.ans = ans;
	}


	@Override
	public String toString() {
		return "MCQBean [id=" + id + ", que=" + que + ", optA=" + optA + ", optB=" + optB + ", optC=" + optC + ", optD="
				+ optD + ", ans=" + ans + "]";
	}
	
	
	
	
}
