package com.tstodolist.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ToDo")
public class ToDo {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "todoid")
	    private int todoid;
	
	 public int getTodoid() {
		return todoid;
	}
	public void setTodoid(int todoid) {
		this.todoid = todoid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "id")
		private String id;
	 
	@Column(name = "toDoName")
	private String toDoName;
	public String getToDoName() {
		return toDoName;
	}
	public void setToDoName(String toDoName) {
		this.toDoName = toDoName;
	}
	public String getToDoStatus() {
		return toDoStatus;
	}
	public void setToDoStatus(String toDoStatus) {
		this.toDoStatus = toDoStatus;
	}
	public String getToDodesc() {
		return toDodesc;
	}
	public void setToDodesc(String toDodesc) {
		this.toDodesc = toDodesc;
	}
	public Timestamp getToDoCreatedDate() {
		return toDoCreatedDate;
	}
	public void setToDoCreatedDate(Timestamp toDoCreatedDate) {
		this.toDoCreatedDate = toDoCreatedDate;
	}
	public Timestamp getToDoModifedDate() {
		return toDoModifedDate;
	}
	public void setToDoModifedDate(Timestamp toDoModifedDate) {
		this.toDoModifedDate = toDoModifedDate;
	}
	public String getPrevDesc() {
		return prevDesc;
	}
	public void setPrevDesc(String prevDesc) {
		this.prevDesc = prevDesc;
	}
	public String getToDoType() {
		return toDoType;
	}
	public void setToDoType(String toDoType) {
		this.toDoType = toDoType;
	}
	 @Column(name = "toDoStatus")
	private String toDoStatus;
	 @Column(name = "toDodesc")
	private String toDodesc;
	 @Column(name = "toDoCreatedDate")
	private Timestamp toDoCreatedDate;
	 @Column(name = "toDoModifedDate")
	private Timestamp toDoModifedDate;
	 @Column(name = "prevDesc")
	private String prevDesc;
	 @Column(name = "toDoType")
		private String toDoType;
	 
	 public String getToDoOn() {
		return toDoOn;
	}
	public void setToDoOn(String toDoOn) {
		this.toDoOn = toDoOn;
	}
	@Column(name = "toDoOn")
		private String toDoOn;
	
	
	
	
	 
}
