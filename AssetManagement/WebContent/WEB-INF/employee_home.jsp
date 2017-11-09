<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
   
        </div>
    <div>
      <ul class="nav navbar-nav">
	<li><a href="./backs" >Home</a></li>
	<li> <a href="./Empviewmyprofile">Profile</a></li>
<li><a href="./createrequestbyemp"> Create Request</a></li>
<li><a href="./EmpViewmyrequest">view My request</a></li>
<li><a href="./Myasset"> My assets</a></li>
<li><a href="./Assettranfer"> Asset Transfer</a></li>
<li><a href="./change_password"> Change your password</a></li>
  <li><a href="./logout">Logout</a></li>
      </ul>  
    </div>
  </div>
</nav>

<font color="blue"><h1>${oh}</h1>
<center>

<h3 align="center"><font color="darkblue"> <h2>Welcome Employee${adminsession}<h2>   
<h3 align="center"><font color="darkblue"> Your ID: ${user_session}</font></h3>
<h3 align="center"><font color="darkblue">Manager-id:<%=session.getAttribute("My_Request_To_Id")%></font></h3>
	<h3 align="center"><font color="blue"><%=session.getAttribute("Emailid")%> </font></h3>

</center>
</font></h2>


<center>


</body>
</html>