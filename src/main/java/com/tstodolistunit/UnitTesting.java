package com.tstodolistunit;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.tstodolist.controller.TSToDoListController;
import com.tstodolist.model.LoginVO;
import com.tstodolist.model.ToDo;
import com.tstodolist.service.UserService;

public class UnitTesting {

	@Test
    public void checkIfUserIdBlank() {
         // MyClass is tested
		TSToDoListController contObj = new TSToDoListController();
        // assert statements
        assertEquals(0, contObj.validateUserId("dfvd"), "Blank or null User name");
           
    }
	
	@Test
    public void checkIfPasswordBlank() {
         // MyClass is tested
		TSToDoListController contObj = new TSToDoListController();
        // assert statements
        assertEquals(1, contObj.validatePassword(null), "Blank or null Password");
           
    }
	
	@Test
    public void registerUser() {
         // MyClass is tested
		UserService servObj = new UserService();
		LoginVO lLoginVO = new LoginVO ();
		lLoginVO.setUserid("q");
		lLoginVO.setPassword("v");
        // assert statements
        assertEquals(0, servObj.registerUser(lLoginVO), "Failure");
           
    }
	
	@Test
    public void validateUser() {
         // MyClass is tested
		UserService servObj = new UserService();
		LoginVO lLoginVO = new LoginVO ();
		lLoginVO.setUserid("q");
		lLoginVO.setPassword("v");
        // assert statements
        assertEquals(0, servObj.validateUser(lLoginVO), "Invalid");
           
    }
	
	
	@Test
    public void addToDo() {
         // MyClass is tested
		UserService servObj = new UserService();
		ToDo lToDo = new ToDo ();
		lToDo.setId("1");
		lToDo.setToDoName("Arms Workout");
		lToDo.setToDoType("Personal");
		lToDo.setToDoOn("12/01/2020");
		lToDo.setToDodesc("30 reps  - 2 sets");
        // assert statements
        assertEquals(0, servObj.addToDo(lToDo), "Failed to Add To Do");
           
    }
	
	@Test
    public void updateToDo() {
         // MyClass is tested
		UserService servObj = new UserService();
		ToDo lToDo = new ToDo ();
		lToDo.setId("1");
		lToDo.setToDodesc("30 reps - 6 sets each");
        // assert statements
        assertEquals(0, servObj.updateToDo(lToDo), "Failed to delete To Do");
           
    }
	@Test
    public void doneToDo() {
         // MyClass is tested
		UserService servObj = new UserService();
		ToDo lToDo = new ToDo ();
		lToDo.setId("1");
		
        // assert statements
        assertEquals(0, servObj.doneToDo(lToDo), "Failed to done To Do");
           
    }
	
	
	
	@Test
    public void deleteToDo() {
         // MyClass is tested
		UserService servObj = new UserService();
		ToDo lToDo = new ToDo ();
		lToDo.setId("1");
		
        // assert statements
        assertEquals(0, servObj.deleteToDo(lToDo), "Failed to delete To Do");
           
    }
	
	
	
}
