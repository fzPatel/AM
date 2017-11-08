
<h2><a href="./backs"> Home</a></h2>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<font color="orange">
	<h2>${msg}</h2>
	</font>

<form action="./requestcreatetomanagerbyemp" method="post">

Emp Id        <input type="text" value="<%=session.getAttribute("user_session")%>" name="employeeid">
Manager Id    <input type="text" value="<%=session.getAttribute("My_Request_To_Id")%>" name="managerid">

Asset Name  <select name="assetname">
            <option>Laptop</option>
            <option>Mouse</option>
            <option>Hard disk</option>
            <option>Headphones</option>
            <option>Pen drive</option>
            </select>
Designation       <input type="text" value="<%=session.getAttribute("user_designation")%>" name="designation">
Email               <input type="text" value="<%=session.getAttribute("Emailid")%>" name="emailid">
            
<input type="submit"name="submit"/>
</form>




<h2><a href="./logout">logout </a>	</h2>



 
</body>
</html>