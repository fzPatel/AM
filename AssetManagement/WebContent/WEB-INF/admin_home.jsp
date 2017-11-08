<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

body{
background-image:url('https://imgur.com/p7L8a5E.jpg');
background-size:cover;
height:100%;
}
</style>

</head>

<body>
<a href="./adminlogout">logout</a>
<font color="blue"><h1>${oh}</h1></font>
${passwordchanged}
<p align="right">
	
</p>

<h3>Admin=<font color="blue">${admin_session}</h3></font>

		<center>
			<font color="orange">
			<h1>${a}</h1>
		</font>			
				<h3><a href="createuser">create new user</a>	</h3>				
				<h3><a href="viewusers">view all users</a></h3>
				<h3><a href="adminchangepassword">change my password</a></h3>
		</center>
</body>
</html>