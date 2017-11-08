<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.asset_management.beans.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h2><a href="./backs">Home</a></h2>
<body>
	<%
		UserBean ub=(UserBean)request.getAttribute("forupdate");
	
		if(ub!=null)
		{
			%>
			<center>
			<form action="updateprofile" method="post">
				<table>
					<tr>
					<td>First Name</td>
						<td>
							<input type="hidden" name="id" value="<%=ub.getEmployeeid()%>"/>
								<input type="text" name="fname" value="<%=ub.getFirstname()%>"/>
						</td>
					</tr>
					<tr>
					<td>Last Name</td>
						<td>
								<input type="text" name="lname" value="<%=ub.getLastname()%>"/>
						</td>
					</tr>
					<tr>
					<td>Email Id</td>
						<td>
								<input type="text" name="email" value="<%=ub.getEmailid()%>"/>
						</td>
					</tr>
					<tr>
					<td>Mobile</td>
						<td>
								<input type="text" name="mobile" value="<%=ub.getMobile()%>"/>
						</td>
					</tr>
					<tr>
						<td>
									<input type="submit" name="update" value="update"/>
						</td>
					</tr>
				</table>
			</form>
			</center>
			<%
		}
		
	%>
</body>
</html>