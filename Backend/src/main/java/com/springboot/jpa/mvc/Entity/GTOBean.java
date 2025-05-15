package com.springboot.jpa.mvc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GTO_TABLE")
public class GTOBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GTO_ID")
	public int id;
	@Column(name = "GTO_CODE")
	public String code;
	@Column(name = "GTO_OUTPUT")
	public String output;
	public GTOBean() {
		super();
	}
	
	public GTOBean(String code) {
		super();
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	@Override
	public String toString() {
		return "GTOBean [id=" + id + ", code=" + code + "]";
	}
	
	
	
}
