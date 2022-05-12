package com.tstodolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoginVO")
public class LoginVO {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	    private int id;
	 
	 
	 @Column(name = "userid")
	private String userid;
	 
	 @Column(name = "password")
	private String password;
	 
	 @Column(name = "createdOn")
		private String createdOn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public LoginVO()
    {
     super();
    }
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginVO(int id, String userid, String password, String createdOn) {
		super();
		this.id = id;
		this.userid = userid;
		this.password = password;
		this.createdOn = createdOn;
	}
	
	 
		
}
