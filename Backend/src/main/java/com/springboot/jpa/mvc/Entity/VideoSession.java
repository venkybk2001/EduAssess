package com.springboot.jpa.mvc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "VIDEO_LINKS_TABLE")
public class VideoSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VIDEO_ID")
	public int id;
	
	@Column(name = "VIDEO_SESSION_NAME")
	public String sessionName;
	
	@Column(name = "VIDEO_SESSION_LINK")
	public String sessionLink;

	public VideoSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoSession(String sessionName, String sessionLink) {
		super();
		this.sessionName = sessionName;
		this.sessionLink = sessionLink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getSessionLink() {
		return sessionLink;
	}

	public void setSessionLink(String sessionLink) {
		this.sessionLink = sessionLink;
	}

	@Override
	public String toString() {
		return "VideoSession [id=" + id + ", sessionName=" + sessionName + ", sessionLink=" + sessionLink + "]";
	}
	

}
