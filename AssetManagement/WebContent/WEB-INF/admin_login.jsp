<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function Submit(){
	var emailRegex = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;

	var	femail = document.form.emailid.value,
		fpassword = document.form.password.value;
		
   if (femail == "" )
	{
		document.form.emailid.focus();
		document.getElementById("errorBox").innerHTML = "enter the email";
		return false;
	 }else if(!emailRegex.test(femail)){
		document.form.emailid.focus();
		document.getElementById("errorBox").innerHTML = "enter the valid email";
		return false;
	 }

	if(fpassword == "")
	 {
		 document.form.password.focus();
		 document.getElementById("errorBox").innerHTML = "enter the password";
		 return false;
	 }
	 
		  
}



</script>


<style type="text/css">

body{
background-image:url('https://imgur.com/p7L8a5E.jpg');
background-size:cover;
height:100%;
}
</style>
		<font color="Red"><h3>${errormag}</font></h3>

</head>

<body>
<a href="./backtoindex">back</a>

<center>

       <div id="errorBox"></div>

<font color="orange"><h1>Admin Login</h1></font>

       <form name="form" action="./adminlogincheck" method="post" >
     
      <div id="email_form">
        <input type="text" name="emailid" value="" onClick="Tab()"  placeholder="Your Email" class="input_email">
      </div>
      
      <div id="password_form">
        <input type="password" name="password" value=""  placeholder="New password" class="input_password">
      </div>
   
       <div>
       
       	<td><input type="submit" onClick="Submit()" name="submit" value="submit"/></td>
       
        <p id="sign_user" onClick="Submit()">Submit </p>
      </div>
     </form>
     </center>
    
</body>
</html>
