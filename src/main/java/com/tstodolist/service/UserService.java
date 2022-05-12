package com.tstodolist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tstodolist.dao.UserDAO;
import com.tstodolist.model.LoginVO;
import com.tstodolist.model.ToDo;



@Service
public class UserService{

     @Transactional
     public int registerUser(LoginVO lLoginVO) {
     	
    	System.out.println("Inside registerUser method of UserService");
     	int  message = 0;
     	try
     	{
     		UserDAO userDAO = new  UserDAO ();
     		message = userDAO.registerUser(lLoginVO);
     	}
     	catch(Exception e)
     	{	
     		e.printStackTrace();
     	}
     	
         return message;
     }
     
     public int validateUser(LoginVO lLoginVO) {
      	
     	System.out.println("Inside validateUser method of UserService");
      	int  message = 0;
      	try
      	{
      		UserDAO userDAO = new  UserDAO ();
      		message = userDAO.validateUser(lLoginVO);
      	}
      	catch(Exception e)
      	{	
      		e.printStackTrace();
      	}
      	
          return message;
      }
     
	public int addToDo(ToDo todo) {
		System.out.println("Inside addToDo method of UserService");
		//List<ToDo> todolist = new ArrayList<ToDo>();
		int result = 0;
     	try
     	{
     		UserDAO userDAO = new  UserDAO ();
     		result = userDAO.addToDo(todo);
     	}
     	catch(Exception e)
     	{
     		
     		e.printStackTrace();
     	}
     	
         return result;
	}
	
	public List<ToDo> getToDoAfterUpdation(ToDo todo) {
		System.out.println("Inside getToDoAfterUpdation method of UserService");
		List<ToDo> todolist = new ArrayList<ToDo>();
     	try
     	{
     		 UserDAO userDAO = new  UserDAO ();
     		 todolist = userDAO.getToDoAfterUpdation(todo);
     	}
     	catch(Exception e)
     	{
     		
     		e.printStackTrace();
     	}
     	
         return todolist;
	}
	
	public List<ToDo> getToDo(LoginVO lLoginVO) {
		
		System.out.println("Inside getToDo method of UserService");
		List<ToDo> listtodo = new ArrayList<ToDo>();
     	try
     	{
     		 UserDAO userDAO = new  UserDAO ();
     		listtodo = userDAO.getToDo(lLoginVO);
     	}
     	catch(Exception e)
     	{
     		
     		e.printStackTrace();
     	}
     	
         return listtodo;
	}
	
public List<ToDo> getToDoByType(ToDo lToDo) {
		
		System.out.println("Inside getToDoByType method of UserService");
		List<ToDo> listtodo = new ArrayList<ToDo>();
     	try
     	{
     		 UserDAO userDAO = new  UserDAO ();
     		listtodo = userDAO.getToDoByType(lToDo);
     	}
     	catch(Exception e)
     	{
     		
     		e.printStackTrace();
     	}
     	
         return listtodo;
	}
	
	public int doneToDo(ToDo lToDoVO) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside doneToDo method of UserService");
		int result = 0;
		try
     	{
     		 UserDAO userDAO = new  UserDAO ();
     		result = userDAO.doneToDo(lToDoVO);
     	}
     	catch(Exception e)
     	{
     		
     		e.printStackTrace();
     	}
     	
		return result;
	}
	
	public int updateToDo(ToDo lToDoVO) {
		// TODO Auto-generated method stub
		System.out.println("Inside updateToDo method of UserService");
		int result = 0;
		try
     	{
     		 UserDAO userDAO = new  UserDAO ();
     		result = userDAO.updateToDo(lToDoVO);
     	}
     	catch(Exception e)
     	{
     		
     		e.printStackTrace();
     	}
     	
		return result;
	}
	
	public int deleteToDo(ToDo lToDoVO) {
		// TODO Auto-generated method stub
		System.out.println("Inside deleteToDo method of UserService");
		int result = 0;
		try
     	{
     		UserDAO userDAO = new  UserDAO ();
     		result = userDAO.deleteToDo(lToDoVO);
     	}
     	catch(Exception e)
     	{
     		
     		e.printStackTrace();
     	}
     	
		return result;
	}
     
     
}