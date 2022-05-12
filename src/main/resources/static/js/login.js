function redirectToSignUpPage()
{
	  
	
	  $.ajax(
       {
        url  : "./signup",
        contentType: "application/json",
        type:"GET",
       
        contentType: false,
        cache: false,
        processData: false,
        success: function(response){
	         
             window.location.replace("./signup");
	     }
});

}
function registerUser()
{


 var pass = document.getElementById("pass").value;
 var username = document.getElementById("username").value;
      var registerData = {
			"userid": username, 
	        "password": pass
		   }
     $.ajax(
       {
        url  : "./register",
       headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        type:"POST",
        data : JSON.stringify(registerData),
        contentType: 'application/json',
        cache: false,
        processData: false,
        success: function(response){
	         if(response.statusCode == "0")
	        { 
		      document.getElementById("registerError").value="";
			 alert("Successfully registered. Please Sign In now.");
             console.log(response);
			 window.location.replace("./login");
             }
            else if(response.statusCode == "1")
            {
	         alert("User Name Already Exists.!!");
	         document.getElementById("registerError").value="User Name already Exists.";
            }
            else 
            {
	          document.getElementById("registerError").value="Please try again later";
            }
	     }
});
}

function login()
{


 var pass = document.getElementById("pass").value;
 var username = document.getElementById("username").value;
      var data = {
			"userid": username, 
	        "password": pass
		   }
     $.ajax(
       {
        url  : "./validateUser",
       headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        type:"POST",
        data : JSON.stringify(data),
        contentType: 'application/json',
        cache: false,
        processData: false,
        success: function(response){
	         if(response.statusCode == "0")
	        { 
		     //document.getElementById("registerError").value="";
			 alert("Successfully logged in ");
             console.log(response);
			 window.location.replace("./home");
             }
            else if(response.statusCode == "1")
            {
	         alert("Invalid Credentials");
	         //document.getElementById("registerError").value="User Name already Exists.";
            }
            else 
            {
	          //document.getElementById("registerError").value="Please try again later";
            }
	     }
});
}




 