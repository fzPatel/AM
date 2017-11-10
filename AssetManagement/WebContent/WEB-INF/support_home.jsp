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


<a href="./logout">logout</a>

<h3>User Id=<font color="blue">${support_session}</h3></font>
<h3>User Designation=<font color="blue">${user_designation}</h3></font>




	<center>
	<font color="orange"><h1>Support home</h1></font><br/>
	<table>
	<h3><font color="blue">${passwordchanged}</h3></font>
	<tr>
		<td>
			<form action="./viewassetrequest" method="post">
				<input type="hidden" name="usersession" value="${user_session}"/>
				
				<input type="submit"  name="viewassetrequest" value="view asset request"/>
			</form>
		</td>
	</tr>
	<tr>
		<td>
			<form action="./viewreports" method="post">
				<input type="hidden" name="hidden2" value="${user_session}"/>
				<input type="submit"  name="viewreports" value="View Reports"/>
			</form>
		</td>
	</tr>
	<tr>
		<td>
			<form action="./changesupportpassword" method="post">
				<input type="hidden" name="hidden3" value="${user_session}"/>
			
				<input type="submit"  name="" value="change Password"/>
			</form>
		</td>
	</tr>	
	</table>
	</center>
</body>
</html>