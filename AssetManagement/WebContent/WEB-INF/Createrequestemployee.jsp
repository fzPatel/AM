
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<title>Insert title here</title>
</head>

<body>
	<font color="orange">
	<h2>${msg}</h2>
	</font>
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
<form action="./requestcreatetomanagerbyemp" method="post">

Emp Id        <input type="text" value="<%=session.getAttribute("user_session")%>" readonly name="employeeid">
Manager Id    <input type="text" value="<%=session.getAttribute("My_Request_To_Id")%>" readonly name="managerid">

Asset Name  <select name="assetname">
            <option>Laptop</option>
            <option>Mouse</option>
            <option>Hard disk</option>
            <option>Headphones</option>
            <option>Pen drive</option>
            </select>
Designation       <input type="text" value="<%=session.getAttribute("user_designation")%>" readonly name="designation">
Email               <input type="text" value="<%=session.getAttribute("Emailid")%>" readonly name="emailid">
            
<input type="submit"name="submit"/>
</form>




 
</body>
</html>