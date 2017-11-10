<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.asset_management.beans.UserBean" %>
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
<a href="./backtoviewusers">back</a>
<font color="blue"><h1>${oh}</h1></font>


	<%
	UserBean eb=(UserBean)request.getAttribute("single_user");
		if(eb!=null)
		{
			%>
			<center>
			<font color="orange"><h1>Single User</h1></font>
			<form action="./updatesingleuser">
			
				<table border="1">
							
					
					<tr><td><font color="orange"> First Name</font></td><td><input type="text" name="firstname" pattern="[A-Za-z-]+" title="only alphabet" value="<%=eb.getFirstname()%>"readonly/>&nbsp;</td></tr>
					<tr><td><font color="orange"> Last Name</font></td><td><input type="text" name="lastname" pattern="[A-Za-z-]+" title="only alphabet" value="<%=eb.getLastname()%>"readonly/>&nbsp;</td></tr>
					<tr><td><font color="orange"> Email Id</font></td><td><input type="email" name="emailid" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" value="<%=eb.getEmailid()%>" readonly/>&nbsp;</td></tr>
				
					
					<!-- <tr><td><font color="orange"> Designation</font></td><td><input type="text" name="designation" value="<%=eb.getDesignation()%>" required/>&nbsp;</td></tr> -->
					
					<tr>
						<td>Designation :</td>
						<td>
							<select name="designation" id="designation" required>
							<%
							if(eb.getDesignation().equals("employee"))
							{
							%>
								<option value="<%=eb.getDesignation()%>"><%=eb.getDesignation()%></option>
								<option value="manager">manager</option>
								<option value="support">support</option>
							<%
							}
							else if(eb.getDesignation().equals("manager"))
							{
							%>
								<option value="<%=eb.getDesignation()%>"><%=eb.getDesignation()%></option>
								<option value="employee">employee</option>
								<option value="support">support</option>
							<%
							}
							else if(eb.getDesignation().equals("support"))
							{
							%>
								<option value="<%=eb.getDesignation()%>"><%=eb.getDesignation()%></option>
								<option value="manager">manager</option>
								<option value="employee">employee</option>
							<%
							}
							%>	
							</select>
						</td>
					</tr> 
					<%if(eb.getDesignation().equals("support"))
					{
						%>
						<tr><td><font color="orange"> Support Id</font></td><td><input type="text" name="supportid" value="<%=eb.getSupportid()%>" required/>&nbsp;</td></tr>
						<%
					}
					else if(eb.getDesignation().equals("manager"))
					{
						%>
							
							<tr><td><font color="orange"> Manager Id</font></td><td><input type="text" name="managerid" value="<%=eb.getManagerid()%>" required/>&nbsp;</td></tr>
							<tr><td><font color="orange"> Support Id</font></td><td><input type="text" name="supportid" value="<%=eb.getSupportid()%>" required/>&nbsp;</td></tr>
					
						<%
					}
					else if(eb.getDesignation().equals("employee"))
					{
						%>
						<tr><td><font color="orange"> Employee Id</font></td><td><input type="text" name="employeeid" value="<%=eb.getEmployeeid()%>" required/>&nbsp;</td></tr>
					
							<tr><td><font color="orange"> Manager Id</font></td><td><input type="text" name="managerid" value="<%=eb.getManagerid()%>" required/>&nbsp;</td></tr>
							
						<%
					}
					%>
					
					<tr><td><font color="orange">Mobile </font></td><td><input type="text" name="mobile" value="<%=eb.getMobile()%>" readonly/>&nbsp;</td></tr>
					<tr><td><font color="orange">Date Of Joining</font></td><td><input type="date" name="dateofjoining" value="<%=eb.getDateofjoining()%>" readonly/>&nbsp;</td></tr>
					<tr><td><font color="orange"> Status</font></td><td><input type="text" name="status" value="<%=eb.getStatus()%>"readonly/>&nbsp;</td></tr>
					<tr><td><font color="orange"> Auto Incremented Id</font></td><td><input type="text" name="auto" value="<%=eb.getAuto()%>" readonly/>&nbsp;</td></tr>
					
			
					<tr><td><input type="hidden" name="hidden" value="<%=eb.getEmailid()%>"/>&nbsp;</td></tr>
					<tr><td><input type="submit" name="submit" value="update now"/></td></tr>
				</table>
				</form>
				</center>				
			<%
		}
	%>
</body>
</html>