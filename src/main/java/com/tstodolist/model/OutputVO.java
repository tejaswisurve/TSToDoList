package com.tstodolist.model;

import java.util.List;

public class OutputVO {
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	private String statusCode;
	private List<ToDo> todolist;
	public List<ToDo> getTodolist() {
		return todolist;
	}
	public void setTodolist(List<ToDo> todolist) {
		this.todolist = todolist;
	}
}
