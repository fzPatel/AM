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

<a href="backtoindex">back</a>


${loginFailedmsg}
<%-- <%
	String user_designation=(String)session.getAttribute("user_designation");
	if(user_designation.equals("employee"))
	{
		response.sendRedirect("employee_home.jsp");
	}
	else if(user_designation.equals("manager"))
	{
		response.sendRedirect("manager_home.jsp");
	}
	else if(user_designation.equals("support"))
	{
		response.sendRedirect("support_home.jsp");
	}
	else if(user_designation==null)
	{
%> --%>
	<center>
		<font color="orange"><h1>User Login</h1></font>
			<table><form action="./userlogin" method="post">
				
					<!-- <tr>
						<td>
							<select name="designation" id="designation">
								<option value="manager" >manager</option>
								<option value="employee">employee</option>
								<option value="support">support</option>
							</select>
						</td>
					</tr>   -->
					
					<tr><td>User Id</td><td><input type="text" name="userid" required/></td></tr>
					<tr><td>Password</td><td><input type="password" name="password" required/></td></tr>
					<td><input type="submit" name="submit" value="submit"/></td>
					<td><input type="reset" name="reset" value="reset"/></td>
				
			</form></table>
			
	</center>
<%-- <%
	}
%> --%>
</body>
</html>