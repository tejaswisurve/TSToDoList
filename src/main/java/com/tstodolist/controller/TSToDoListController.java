package com.tstodolist.controller;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tstodolist.dao.UserDAO;
import com.tstodolist.model.LoginVO;
import com.tstodolist.model.OutputVO;
import com.tstodolist.model.ToDo;
import com.tstodolist.service.UserService;



/*
@RestController*/
@CrossOrigin
@Component
@Controller
@Scope("session")
public class TSToDoListController {
	
	 @Autowired
	 UserService userService;
	
	 
	 @RequestMapping(value = "/signup",method = RequestMethod.GET)  
	
		 public String signup()
		 {  
		    System.out.println("Inside signup method of TSToDoListController");
		    System.out.println("Redirecting login page to Sign up page.!!");
	        return "signup";  
	     }  
	 
	 @RequestMapping(value = "/login",method = RequestMethod.GET)  
		
	 public String home()
	 {  
	   
        return "index";  
     }  
 
	 
	 @RequestMapping(value = "/logout",method = RequestMethod.GET)  
		
	 public String logout(HttpServletRequest request)
	 {  
	    System.out.println("Inside logout method of TSToDoListController");
	    System.out.println("Redirecting to login page !!");
	      request.getSession().setAttribute("userId","0");
	    //request.getSession().removeAttribute("userId");
        return "index";  
     }  
	 
	 @RequestMapping(value = "/home",method = RequestMethod.GET)  
		
	 public String goToHome(HttpServletRequest request)
	 {  
		 System.out.println("Inside goToHome method of TSToDoListController");
	    try
	    {
		if(request.getSession().getAttribute("userId")!="0" && request.getSession().getAttribute("userId")!="" )
		{
		
	    System.out.println("Redirecting to home page !!");
	   
        return "home"; 
		}
	    
		return "401";
	    }
	    catch(Exception e)
	    {
	    	return "401";
	    }
     }  
	 
	 @RequestMapping(value = "/401",method = RequestMethod.GET)  
		
	 public String goTo401(HttpServletRequest request)
	 {  
	    
		
		return "401";
     }  
	 
	 public int validateUserId(String userid)
	 {
		 if(userid==null || userid.equals(""))
		 {
			 return 1;
		 }
		 return 0;
	 }
	 
	 public int validatePassword(String pass)
	 {
		 if(pass==null || pass.equals(""))
		 {
			 return 1;
		 }
		 return 0;
	 }
	 
	 @RequestMapping(value = "/register", method = { RequestMethod.GET, RequestMethod.POST })  
     @ResponseBody
	 public OutputVO register(@RequestBody LoginVO  lLoginVO,HttpServletRequest request)
	 {
		 System.out.println("Inside register method of TSToDoListController");
        UserService user= new UserService();
        OutputVO lOutputVO = new OutputVO();
        try
        {
        String userId=lLoginVO.getUserid();
        String password = lLoginVO.getPassword();
        
        if(validatePassword(password)!=1 && validateUserId(userId)!=1)
        {
        int result = user.registerUser(lLoginVO);
        System.out.println(result);
        
        
        if (result==0)
        {
        	lOutputVO.setStatus("Success creating new User.!!");
        	lOutputVO.setStatusCode("0");
        }
        else
        {
        	lOutputVO.setStatus("User Name Already Exists/ Failure Creating User");
        	lOutputVO.setStatusCode("1");
        	
        }
        }
        }
        catch(Exception e)
        {
        	lOutputVO.setStatus("Failure Creating User");
        	lOutputVO.setStatusCode("1");
        }
        return lOutputVO; 
         
    }  
	 
	 @RequestMapping(value = "/getUser", method = { RequestMethod.GET, RequestMethod.POST })  
		
	 public String getUser(HttpServletRequest request)
	 {
		 System.out.println("Inside getUser method of TSToDoListController");
        UserService user= new UserService();
        UserDAO ud= new UserDAO();
        int result = ud.getUser();
        System.out.println(result);
        return "signup";  
    }  
	 
	 @RequestMapping(value = "/validateUser", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)  
	 
     @ResponseBody
	 public OutputVO validateUser(@RequestBody LoginVO  lLoginVO,HttpServletRequest request)
	 {
		 System.out.println("Inside validateUser method of TSToDoListController");
		 
        UserService user= new UserService();
        UserDAO ud= new UserDAO();
        OutputVO lOutputVO = new OutputVO();
        try {
        String userId=lLoginVO.getUserid();
        String password = lLoginVO.getPassword();
        
        if(validatePassword(password)!=1 && validateUserId(userId)!=1)
        {
        int result = user.validateUser(lLoginVO);
        System.out.println(result);
       
        if (result==0)
        {
        	lOutputVO.setStatus("Success.!!");
        	lOutputVO.setStatusCode("0");
        	int id = 0;
        	id= (int)ud.getUserId(lLoginVO);
        	request.getSession().setAttribute("userId", id);
        	System.out.println("Actual user id is :"+id);
        }
        else
        {
        	lOutputVO.setStatus("Invalid Credentials.!!");
        	lOutputVO.setStatusCode("1");
        	
        }
        }
        }
        catch(Exception e)
        {
        	lOutputVO.setStatus("Error Logging In");
        	lOutputVO.setStatusCode("1");
        }
        return lOutputVO; 
    }  
	 
	 @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })  
     @ResponseBody
	 public OutputVO add(@RequestBody ToDo  todo,HttpServletRequest request)
	 {
		System.out.println("Inside add method of TSToDoListController");
		OutputVO lOutputVO = new OutputVO();
		int i = (Integer) request.getSession().getAttribute("userId");
		todo.setId(i+"");
        UserService user= new UserService();
        List<ToDo> todolist= new ArrayList<ToDo>();
        int result = 0;
        result = user.addToDo(todo);
        System.out.println(result);
        
        if(result==0)
        {
        	lOutputVO.setStatus("To Do Item Added Successfully!!");
        	lOutputVO.setStatusCode("0");
        	todolist = user.getToDoAfterUpdation(todo);
        	lOutputVO.setTodolist(todolist);
        }
        else
        {
        	lOutputVO.setStatus("To Do Item Not Added !");
        	lOutputVO.setStatusCode("1");
        	
        }
       
        return lOutputVO;  
    }   
	 
 @RequestMapping(value = "/getToDo", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)  
	 
     @ResponseBody
	 public OutputVO getToDo(HttpServletRequest request)
	 {  
	 
	    System.out.println("Inside getToDo method of TSToDoListController");
	    OutputVO lOutputVO = new OutputVO();
	    try
        {
	    if(request.getSession().getAttribute("userId")!="0" && request.getSession().getAttribute("userId")!="" )
		{
       
        List <ToDo> todolist = null;
        UserService user= new UserService();
        LoginVO lLoginVO = new LoginVO();
        String id=  request.getSession().getAttribute("userId")+"";
        lLoginVO.setUserid(id);
       
        todolist = user.getToDo(lLoginVO);
        int sizeOfTDL= todolist.size();
        System.out.println(sizeOfTDL);
       
        if(sizeOfTDL==0)
        {
        	lOutputVO.setStatus("New User.!!");
        	lOutputVO.setStatusCode("0");
        }
        else if(sizeOfTDL>0)
        {
        	lOutputVO.setStatus("Existing User.!!");
        	lOutputVO.setStatusCode("0");
        	lOutputVO.setTodolist(todolist);
        }
		}
	    else
	    {
            lOutputVO.setStatus("Failed");
        	
        	lOutputVO.setStatusCode("401");
	    }
        }
        catch(Exception e)
        {
            lOutputVO.setStatus("Failed");
        	
        	lOutputVO.setStatusCode("1");
        	
        }
        return lOutputVO; 
    }  
	 
 
 @RequestMapping(value = "/getToDoByType", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)  
 
 @ResponseBody
 public OutputVO getToDoByType(@RequestBody ToDo  lToDo,HttpServletRequest request)
 {
    System.out.println("Inside getToDoByType method of TSToDoListController");
    OutputVO lOutputVO = new OutputVO();
    List <ToDo> todolist = null;
    UserService user= new UserService();
    try
    {
    todolist = user.getToDoByType(lToDo);
    int sizeOfTDL= todolist.size();
    System.out.println(sizeOfTDL);
   
    if(sizeOfTDL==0)
    {
    	lOutputVO.setStatus("No to do list found..");
    	lOutputVO.setStatusCode("0");
    }
    else if(sizeOfTDL>0)
    {
    	lOutputVO.setStatus("To do list fetched.!!");
    	lOutputVO.setStatusCode("0");
    	lOutputVO.setTodolist(todolist);
    }
    
    }
    catch(Exception e)
    {
        lOutputVO.setStatus("Failed");
    	
    	lOutputVO.setStatusCode("1");
    	todolist = user.getToDoAfterUpdation(lToDo);
    	lOutputVO.setTodolist(todolist);

    	
    }
    return lOutputVO; 
}  
 
 @RequestMapping(value = "/doneToDo", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)  
 
 @ResponseBody
 public OutputVO doneToDo(@RequestBody ToDo  lToDoVO,HttpServletRequest request)
 {
   System.out.println("Inside doneToDo method of TSToDoListController");
   OutputVO lOutputVO = new OutputVO();
   List <ToDo> todolist = null;
   int result = 0;   
    UserService user= new UserService();
    try
    {
    	result = user.doneToDo(lToDoVO);
   
   
    if(result==0)
    {
    	lOutputVO.setStatus("Success completing to Do.!!");
    	lOutputVO.setStatusCode("0");
    	todolist = user.getToDoAfterUpdation(lToDoVO);
    	lOutputVO.setTodolist(todolist);

    }
    else {
    	lOutputVO.setStatus("Failure completing to Do.!!");
    	lOutputVO.setStatusCode("1");
    	todolist = user.getToDoAfterUpdation(lToDoVO);
    	lOutputVO.setTodolist(todolist);

    }
    }
    catch(Exception e)
    {
        lOutputVO.setStatus("Failed");
    	
    	lOutputVO.setStatusCode("1");
    	todolist = user.getToDoAfterUpdation(lToDoVO);
    	lOutputVO.setTodolist(todolist);

    	
    }
    return lOutputVO; 
}  
 
@RequestMapping(value = "/updateToDo", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)  
 
 @ResponseBody
 public OutputVO updateToDo(@RequestBody ToDo  lToDoVO,HttpServletRequest request)
 {
	 System.out.println("Inside updateToDo method of TSToDoListController");
	 List <ToDo> todolist = null;
    OutputVO lOutputVO = new OutputVO();
   int result = 0;   
    UserService user= new UserService();
    try
    {
    	result = user.updateToDo(lToDoVO);
   
   
    if(result==1)
    {
    	lOutputVO.setStatus("Success updating to Do.!!");
    	lOutputVO.setStatusCode("0");
    	todolist = user.getToDoAfterUpdation(lToDoVO);
    	lOutputVO.setTodolist(todolist);
    }
    else {
    	lOutputVO.setStatus("Failure updating to Do.!!");
    	lOutputVO.setStatusCode("1");
    	todolist = user.getToDoAfterUpdation(lToDoVO);
    	lOutputVO.setTodolist(todolist);
    }
    }
    catch(Exception e)
    {
        lOutputVO.setStatus("Failed");
    	
    	lOutputVO.setStatusCode("1");
    	todolist = user.getToDoAfterUpdation(lToDoVO);
    	lOutputVO.setTodolist(todolist);

    	
    }
    return lOutputVO; 
}  

@RequestMapping(value = "/deleteToDo", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)  

@ResponseBody
public OutputVO deleteToDo(@RequestBody ToDo  lToDoVO,HttpServletRequest request)
{
	 System.out.println("Inside deleteToDo method of TSToDoListController");
	 List <ToDo> todolist = null;
   OutputVO lOutputVO = new OutputVO();
  int result = 0;   
   UserService user= new UserService();
   
   try
   {
   	result = user.deleteToDo(lToDoVO);
  
   if(result==1)
   {
   	lOutputVO.setStatus("Success deleting to Do.!!");
   	
   	
   	lOutputVO.setStatusCode("0");
   	todolist = user.getToDoAfterUpdation(lToDoVO);
	lOutputVO.setTodolist(todolist);

   }
   else {
   	lOutputVO.setStatus("Failure deleting to Do.!!");
   	lOutputVO.setStatusCode("1");
   	todolist = user.getToDoAfterUpdation(lToDoVO);
	lOutputVO.setTodolist(todolist);

   }
   }
   catch(Exception e)
   {
       lOutputVO.setStatus("Failed");
   	
   	lOutputVO.setStatusCode("1");
   	todolist = user.getToDoAfterUpdation(lToDoVO);
	lOutputVO.setTodolist(todolist);

   	
   }
   return lOutputVO; 
}  
	 
	 
	 
}
