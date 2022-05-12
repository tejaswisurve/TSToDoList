var toDoNewList =[];
function populateToDo()
{
	getAllToDo();
	document.getElementById("msgAllTodo").innerHTML="";
	document.getElementById("msgActiveTodo").innerHTML="";
}
function logout()
{
	
	 $.ajax(
       {
        url  : "./login",
        contentType: "application/json",
        type:"GET",
       
        contentType: false,
        cache: false,
        processData: false,
        success: function(response){
	         
             window.location.replace("./login");
	     }
});
}

function getAllToDo()
{
	
 
	 $.ajax(
       {
        url  : "./getToDo",
        contentType: "application/json",
        type:"GET",
        
       
        contentType: false,
        cache: false,
        processData: false,
        success: function(response){
	          if(response.statusCode == "401")
              {
	             
	              window.location.replace("./401");
               }
               else
              {
	          document.getElementById("msgAllTodo").innerHTML="";
              document.getElementById("msgActiveTodo").innerHTML="";
              toDoNewList = response.todolist;
              if(toDoNewList==null)
				{
					document.getElementById("msgAllTodo").innerHTML="No To Do Present";
					document.getElementById("msgActiveTodo").innerHTML="";
				}
				}
			  
	     }
});
	
	
}

function displayToDoForm()
{
	
	 document.getElementById("myForm").style.display = "block";
	   const div1 = document.getElementById("viewAllToDo");
    div1.innerHTML = '';
    const div2 = document.getElementById("viewActiveToDo");
    div2.innerHTML = '';
}

function closeForm()
{
	 document.getElementById("myForm").style.display = "none";
     document.getElementById("toDoName").value = "";
     document.getElementById("toDodesc").value ="";
     document.getElementById("toDoType").value ="";
     document.getElementById("toDoOn").value="";
}

function submitToDo()
{
	 
    	 var toDoName = document.getElementById("toDoName").value;
     	var toDodesc = document.getElementById("toDodesc").value;
		var toDoType = document.getElementById("toDoType").value;
		var toDoOn = document.getElementById("toDoOn").value;
		
      var registerData = {
			"toDoName": toDoName, 
	        "toDodesc": toDodesc,
            "toDoType": toDoType, 
	        "toDoOn": toDoOn,
            "toDoStatus":"OPEN"
		   }
     
	 $.ajax(
       {
        url  : "./add",
        contentType: "application/json",
        type:"POST",
 headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        data : JSON.stringify(registerData),
        contentType: false,
        cache: false,
        processData: false,
        success: function(response){
	         toDoNewList = response.todolist;

           console.log(toDoNewList);
           closeForm();
	     }

});
	
	
	
}

function viewAllToDo()
{
	document.getElementById("viewActiveToDo").style.display = "";
	const div1 = document.getElementById("viewAllToDo");
    div1.innerHTML = '';
    const div2 = document.getElementById("viewActiveToDo");
    div2.innerHTML = '';
	document.getElementById("viewAllToDo").style.display = "block";
	getAllToDo();
	var delayInMilliseconds = 2000; //1 second

	setTimeout(function() {
	  //your code to be executed after 1 second
	}, delayInMilliseconds);
	console.log(toDoNewList);
	
	
	for (var i =0;i<toDoNewList.length;i++)
	{
		var v = document.createElement('div');
       
         v.className = "card";
         v.value ="yes";
         
         var p = document.createElement('p'); 
         p.className = "price";
         p.innerHTML = "Name of Task - "+ toDoNewList[i].toDoName;
         var p1 = document.createElement('p'); 
         p1.className = "price";
         p1.innerHTML = "Desc Task - "+ toDoNewList[i].toDodesc;
         var p2 = document.createElement('p'); 
         p2.className = "price";
         p2.innerHTML = "Task Status - "+ toDoNewList[i].toDoStatus;
         var p3 = document.createElement('p'); 
         p3.className = "price";
         p3.innerHTML = "Created on - "+ toDoNewList[i].toDoCreatedDate;
         var p4 = document.createElement('p'); 
         p4.className = "price";
         p4.innerHTML = "Modified on  - "+ toDoNewList[i].toDoModifedDate;
          var p5 = document.createElement('p'); 
         p5.className = "price";
         p5.innerHTML = "To do for  - "+ toDoNewList[i].toDoOn;
         document.getElementById('viewAllToDo').appendChild(v).appendChild(p).appendChild(p1).appendChild(p2).appendChild(p3).appendChild(p4).appendChild(p5);
         
        
	
	}
}

function viewActiveToDo()
{
	 var newlist= [];
	 document.getElementById("viewActiveToDo").style.display = "block";
     document.getElementById("viewAllToDo").style.display = "";
     const div1 = document.getElementById("viewAllToDo");
    div1.innerHTML = '';
    const div2 = document.getElementById("viewActiveToDo");
    div2.innerHTML = '';
    if(toDoNewList== null)
    {
	document.getElementById("msgActiveTodo").innerHTML="";
    document.getElementById("msgActiveTodo").innerHTML="No active to do";
    document.getElementById("msgAllTodo").innerHTML="";
      }
    var flag = 0;
	for(var i =0;i<toDoNewList.length;i++)
	{
		if(toDoNewList[i].toDoStatus=="OPEN")
		{
		 flag=1;
		 var v = document.createElement('div');
       
         v.className = "card";
         v.value ="yes";
         
         
         var p = document.createElement('p'); 
         p.className = "price";
         p.innerHTML = "Name of Task - "+ toDoNewList[i].toDoName;
         var p1 = document.createElement('p'); 
         p1.className = "price";
         p1.innerHTML = "Desc Task - "+ toDoNewList[i].toDodesc;
        
         var p3 = document.createElement('p'); 
         p3.className = "price";

         var date = new Date(toDoNewList[i].toDoCreatedDate),
         datevalue = [
            date.getFullYear(),
            date.getMonth()+1,
              date.getDate(),
             date.getHours(),
			   date.getMinutes(),
			   date.getSeconds(),
			];
         p3.innerHTML = "Created on - "+datevalue[2]+"/"+datevalue[1]+"/"+datevalue[0]+"- "+datevalue[3]+":"+datevalue[4]+":"+datevalue[5] ;
         var p4 = document.createElement('p'); 
         p4.className = "price";
         var date1 = new Date(toDoNewList[i].toDoCreatedDate),
         datevalue2 = [
            date1.getFullYear(),
            date1.getMonth()+1,
              date1.getDate(),
             date1.getHours(),
			   date1.getMinutes(),
			   date1.getSeconds(),
			];
         p4.innerHTML = "Modified on  - "+datevalue2[2]+"/"+datevalue2[1]+"/"+datevalue2[0]+"- "+datevalue2[3]+":"+datevalue2[4]+":"+datevalue2[5] ;
         var p5 = document.createElement('p'); 
         p5.className = "price";
         p5.innerHTML = "To do for  - "+ toDoNewList[i].toDoOn;
         var b1 = document.createElement('button');
         b1.innerHTML = "Done";
         b1.id = toDoNewList[i].todoid+"";
         b1.className="done";
        
         
         var b2 = document.createElement('button');
         b2.innerHTML = "Delete";
          b2.className="delete";
         b2.value = toDoNewList[i].todoid;
         b2.id = toDoNewList[i].todoid+"";
         v.innerHTML+= p.outerHTML + p1.outerHTML  + p3.outerHTML +p4.outerHTML+ b1.outerHTML+ b2.outerHTML;
        
         //document.getElementById('viewActiveToDo').appendChild(v).appendChild(p).appendChild(p1).appendChild(p3).appendChild(p4).appendChild(p5);
         document.getElementById('viewActiveToDo').appendChild(v);
         var br = document.createElement("br");
         document.getElementById('viewActiveToDo').appendChild(br);
		}
	}
	if(flag==0)
	{
		document.getElementById("msgActiveTodo").innerHTML="";
    document.getElementById("msgActiveTodo").innerHTML="No active to do";
    document.getElementById("msgAllTodo").innerHTML="";
	}
	
	
	console.log(toDoNewList);
	
}

$(document).on('click', '.done', function(){
 
var id =  event.target.id;
   
     var registerData = {
			"todoid": id
	        
		   }
     
	 $.ajax(
       {
        url  : "./doneToDo",
        contentType: "application/json",
        type:"POST",
 headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        data : JSON.stringify(registerData),
        contentType: false,
        cache: false,
        processData: false,
        success: function(response){
	         toDoNewList = response.todolist;
            alert("To Do Status Changed.");
           console.log(toDoNewList);
          
	     }

});

});

$(document).on('click', '.delete', function(){
 
   var id =  event.target.id;
   
     var registerData = {
			"todoid": id
	        
		   }
     
	 $.ajax(
       {
        url  : "./deleteToDo",
        contentType: "application/json",
        type:"POST",
 headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        data : JSON.stringify(registerData),
        contentType: false,
        cache: false,
        processData: false,
        success: function(response){
	         toDoNewList = response.todolist;
             alert("To Do Deleted");
           console.log(toDoNewList);
          
	     }

});

});


