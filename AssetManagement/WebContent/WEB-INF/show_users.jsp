<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.asset_management.beans.UserBean" %>
    <%@page import="java.util.ArrayList" %>
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
<a href="./adminlogout">logout</a><br/>
<a href="./adminhome">back</a>
	<font color="blue"><h1>${oh}</h1></font>


<!-- 	<c:forEach items="${show_employees}" var="e">
		<tr>
			<td>${e.FirstName}</td>
			<td>${e.LastName}</td>
			<td>${e.EmailId}</td>
			<td>${e.EmployeeId}</td>
			<td>${e.Designation}</td>
			<td>${e.Mobile}</td>
			<td>${e.DateOfJoining}</td>
			<td>${e.Status}</td>			
		</tr>
	</c:forEach>  -->
	
	
	
	
	<%
		ArrayList<UserBean> al=(ArrayList)request.getAttribute("users_arraylist");
		if(al!=null)
		{
			%>
			<center>
			<font color="orange"><h1>All Users</h1></font>
			${user_updated}
				<table border="3">
				<tr>			
					
					<td><font color="orange"> First Name</font></td>
					<td><font color="orange"> Last Name</font></td>
					<td><font color="orange"> Email Id</font></td>
					<td><font color="orange"> Manager Id</font></td>
					
					<td><font color="orange"> Designation</font></td>
					<td><font color="orange"> Employee Id</font></td>
					<td><font color="orange">Mobile </font></td>
					<td><font color="orange">Date Of Joining</font></td>
					<td><font color="orange">Support Id</font></td>
					<td><font color="orange">Status</font></td>
					<td><font color="orange">Update</font></td>
					<td><font color="orange">Active</font></td>
					<td><font color="orange">Deactive</font></td>
					
				</tr>
				
				
						<%
						
							for(UserBean l:al)
							{
								%>
									<tr>
										<td><%=l.getFirstname()%>&nbsp;</td>
										<td><%=l.getLastname()%>&nbsp;</td>
										<td><%=l.getEmailid()%>&nbsp;</td>
										
										<td><%=l.getManagerid()%>&nbsp;</td>
										
										<td><%=l.getDesignation()%>&nbsp;</td>
										<td><%=l.getEmployeeid()%>&nbsp;</td>										
										<td><%=l.getMobile()%>&nbsp;</td>										
										<td><%=l.getDateofjoining()%>&nbsp;</td>
										<td><%=l.getSupportid()%>&nbsp;</td>										
										<td><%=l.getStatus()%>&nbsp;</td>
									
										<td>
											<form action="./updateuser">
												<input type="hidden" name="hidden3" value="<%=l.getEmailid()%>"/>&nbsp;
												<input type="hidden" name="hidden4" value="<%=l.getAuto()%>"/>&nbsp;
												<input type="submit" name="submit" value="Update"/>&nbsp;												
											</form>
										</td>
										<td>
											<form action="./activeuser">
												<input type="hidden" name="hidden1" value="<%=l.getEmailid()%>"/>&nbsp;
												
												<input type="submit" name="submit" value="Active"/>&nbsp;												
											</form>
										</td>
										<td>
											<form action="./deactiveuser">
												<input type="hidden" name="hidden2" value="<%=l.getEmailid()%>"/>&nbsp;
												
												<input type="submit" name="submit" value="Deactive"/>&nbsp;												
											</form>
										</td>
											
										
									</tr>
								<%
							}
						%>
				</table>
				</center>				
			<%
		}
	%>
	
	
	
</body>
</html>