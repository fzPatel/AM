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
<h2><a href="./backs">Home</a></h2>
<font color="SaddleBrown">
<h2>${passwordchanged}</h2>
</font>
<form action="./EmpchangePassword" method="post">
<table>
<tr><td>Current Password</td><td><input type="password" name="current" ></td></tr>
<tr><td>New Password</td><td><input type="password" name="New"></td></tr>
<tr><td>Confirm Password</td><td><input type="password" name="confirm"></td></tr>
<tr><td><input type="submit" value="Change Password"></td></tr>
</table> 
</form>

</body>
</html>