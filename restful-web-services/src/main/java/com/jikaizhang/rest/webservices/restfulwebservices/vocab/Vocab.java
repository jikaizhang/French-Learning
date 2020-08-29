package com.jikaizhang.rest.webservices.restfulwebservices.vocab;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vocab {
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String french;
	private String english;
	private Date dateAdded;
//	private boolean revised;
	
	// default constructor
	protected Vocab() {
		
	}
	
	public Vocab(long id, String username, String french, String english, Date dateAdded) {
		super();
		this.id = id;
		this.username = username;
		this.french = french;
		this.english = english;
		this.dateAdded = dateAdded;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFrench() {
		return french;
	}
	public void setFrench(String french) {
		this.french = french;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vocab other = (Vocab) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
