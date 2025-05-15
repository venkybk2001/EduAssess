package com.springboot.jpa.mvc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LINK_TABLE")
public class LinkBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LINK_ID")
	public int linkId;
	@Column(name = "LINK_URL")
	public String linkString;
	
	public LinkBean() {
		super();
	}

	public LinkBean(int linkId, String linkString) {
		super();
		this.linkId = linkId;
		this.linkString = linkString;
	}

	public int getLinkId() {
		return linkId;
	}

	public String getLinkString() {
		return linkString;
	}

	public void setLinkString(String linkString) {
		this.linkString = linkString;
	}

	@Override
	public String toString() {
		return "LinkBean [linkId=" + linkId + ", linkString=" + linkString + "]";
	}
	
	
	
}
