<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-2.2.0.min.js"
		type="text/javascript"></script>
<title>TS To Do List</title>

<!-- css  -->


<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>">
    <script src="<c:url value="/resources/js/todo.js"/>"></script>
</head>
<body onLoad="populateToDo()">
<!-- banner  -->
	<div class="logo-banner">
		<img src="<c:url value="/resources/img/todoicon.png"/>"> <span class="logo-name">TS To Do List</span>
	</div>
    <div class="menu-bar-div">
	<nav class="menu-bar">

		<ul>
			
			<li><a href="#" id="featuredCars" onClick="displayToDoForm()">Add Todo</a></li>
			<li><a href="#" onClick="viewActiveToDo()" >View Active</a></li>
			<li><a href="#" onClick="viewAllToDo()" >All Todo</a></li>
			<li><a href="#" onClick="logout()" >Log Out</a></li>
		</ul>
	</nav>
	</div>
	
	<!-- Add to do form -->
	<div class="form-popup" id="myForm">
			<form action="submitForm()" class="form-container">
				<h1>Add to do Details</h1>

				<label for="taskname"><b>Task Name</b></label> <input type="text"
					placeholder="Enter task name" name="email" id="toDoName"
					 maxlength="20" required>
				<div id="emailerror" class="errormsg"></div>

				<label for="desc"><b>Description</b></label> <input type="text"
					placeholder="Enter Desciption" name="name" id="toDodesc"
					
					
					maxlength="50" required>
				<div id="descerror" class="errormsg"></div>

				<label for="type"><b>Task Type</b></label> <input type="text"
					placeholder="Enter type" name="carmodel" id="toDoType"
					required>
				<div id="toDoTypeerror" class="errormsg"></div>

				<label for="todoon"><b>Task on</b></label> <input
					type="text" placeholder="Enter task date" name="contactnumber"
					id="toDoOn"
					
					maxlength="10" size="10" required>
				<div id="toDoOnerror" class="errormsg"></div>

				<button type="button" onclick="submitToDo()" class="btn" id="submit">Add</button>
				<button type="button" onclick="closeForm()" class="btn1" id="close">Close</button>
			</form>
		</div>
	<br>
	<!-- View All To Do -->
	<div class="cardList" id="viewAllToDo">
	  
	 
           
    </div>
    <center>
     <span id="msgAllTodo"></span>
     <center>
       <br>
       
       
   <!-- View Active To Do -->    
       <div class="cardList" id="viewActiveToDo">
	
        
    </div>
    <span id="msgActiveTodo"></span>
    <br>
   
<!-- about us section-->	
	<div class="index-about-us" id="about-us">
	<!--	<hr class="ihorizontal-line-start"> -->
		
		<h2 class="featured-car-heading">ABOUT US</h2>
	<!--	<hr class="ihorizontal-line-end">  -->

		<div class="about-us-content" id="about-us-content">
			<p>Founded by Tejaswi Surve, TSToDo List is a website which helps you to keep track of all the 
				to do list as per the various types and completion status</p>
			<br>
			<p>TS ToDoList is a pet project to demonstrate the learnings from the founders's educational as well as work experience</p>
			<br>
			<p>Technology used: JAVA8, Spring 5, Hibernate 5, HSQL etc.</p>
		</div>
	</div>
<!-- contact us section-->	
	<div class="index-contact-us" id="contact-us">
	<!--	<hr class="horizontal-line-start"> -->
		<h2 class="featured-car-heading">CONTACT US</h2> 
	<!--	<hr class="horizontal-line-end">  -->
	</div>

	<div class="contact-us-content" id="contact-us-content">

		<div class="address">
			<h3>ADDRESS</h3>
			<p>
				NO. 3-4,<br> PORTLAND STREET NORTH, <br> DUBLIN 01.<br>
				D-01
			</p>

		</div>

		<div id="contact-numbers" class="contact-numbers">
			<h3>CONTACT NUMBERS</h3>
			<p>
				+353 33 333 3333 <br> <br> <br> <br>

			</p>
		</div>

		<div class="opening-hrs">
			<h3>OPENING HOURS</h3>

			<p>
				Mon-Thu : 09:00 - 17:30 <br> Fri : 09:00 - 17:00 <br> Sat
				: 10:00 - 15:00 <br> Sun : CLOSED
			</p>
		</div>
		<div class="email">
			<h3>EMAIL</h3>
			<p>tstodolist@sales.ie</p>
			<br> <br> <br>

		</div>
	</div>
	<!-- footer section-->	
	<div class="footer">
		<p>Powered by TS &copy; 2021</p>
	</div>
	
	<!-- scripts -->	
	
	
	
</body>
</html>
