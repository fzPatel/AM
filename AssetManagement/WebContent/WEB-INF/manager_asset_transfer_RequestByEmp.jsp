<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Request </title>
</head>
<body>



<html>

<title>Asset Transfer Request</title>
<head>

<style type="text/css">

body{
background-image:url('https://imgur.com/p7L8a5E.jpg');
background-size:cover;
height:100%;
}
</style>

</head>

<body>


<h4 align="right"><a href="./BackbtnMangerhome" >Home</a>  &nbsp;| &nbsp;<a href="./logout">logout</a></h4> 
	
	




<%UserBean ub1=(UserBean)session.getAttribute("My_Request_To_Id&MyEmail"); 
String Emailid=ub1.getEmailid();
int supportid=ub1.getSupportid();
%>


	<h4 align="left"><font color="blue"> Your ID: ${user_session}</font></h4> 
	<h4 align="left"><font color="blue"> Your EmailID: <%=Emailid %></font></h4> 
	<h4 align="left"><font color="blue"> Your Support ID:<%=supportid %></font></h4> 


<h1>Pending Asset Transfer Request </h1>
</br>
</br>

<%@page import="java.util.ArrayList,com.asset_management.beans.*"%>
<%
ArrayList<RequestBean> ar=(ArrayList<RequestBean>)request.getAttribute("Employee_request");
if(!ar.isEmpty())
{
	
%>	
<table border="1">
<tr><th>RequestID</th><th>EmployeeId</th><th>Asset Name</th><th>Requested Date</th><th>Status</th><th>EmailId</th><th>Action</th></tr>

<%



for(Object o:ar)
{
	RequestBean ub=null;
if(o instanceof RequestBean)
	ub=(RequestBean)o;
%>
<tr>
<td><%=ub.getRequestid()%></td>
<td><%=ub.getEmployeeid()%></td>
<td><%=ub.getAssetname()%></td>
<td><%=ub.getRequestdate()%></td>
<% 
										if(ub.getStatus()==0)
										{
										%>									
											<td><h5> <font color="Orange">Pending by Manager</font></h5></td>
										<%
										}
										else if(ub.getStatus()==1)
										{%>									
											<td><h5> <font color="Green">Approved by Manager</font></h5></td>
										<%}
										else if(ub.getStatus()==2)
										{%>									
											<td><h5><font color="Red">Rejected by Manager</font></h5></td>
										<%}

										else if(ub.getStatus()==4)
										{%>									
											<td><h5> <font color="Green">Dispatched by Support</font></h5></td>
										<%}
										else if(ub.getStatus()==5)
										{%>									
											<td><h5><font color="Red">Rejected by Support</font></h5></td>
										<%}
%>

<td><%=ub.getEmailid()%></td>

<td colspan="2">
				<form action="./aprooveEmprequest">
				<input type="hidden" name="employeeid" value="<%=ub.getEmployeeid()%>"/>
		
				<input type="hidden" name="requestid" value="<%=ub.getRequestid()%>"/>
				<input type="submit" name="submit" value="approve"/>												
					</form>
				</td>
				<td>		
				<form action="./rejectEmprequest">
										<input type="hidden" name="requestid" value="<%=ub.getRequestid()%>"/>
						
						<input type="hidden" name="employeeid" value="<%=ub.getEmployeeid()%>"/>
					<input type="submit" name="submit" value="reject"/>												
				</form>
					</td>	
</tr>
<% 
}
}else
{
	
	%>
	
	
	<h1>No Pending Request By Employee !! </h1>

	<%
	
	
}
%>
</table>

</center>
</body></html>




</body>
</html>