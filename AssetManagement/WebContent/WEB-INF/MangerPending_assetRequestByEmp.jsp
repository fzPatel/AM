<html>


<title>Pending Request</title>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
   <a href="./BackbtnMangerhome"><img src="https://imgur.com/tzbW2jt.png"   width="110px" height="70px" alt="logo" /></a>
        </div>
    <div>
      <ul class="nav navbar-nav">
	<li><a href="./BackbtnMangerhome" >Home</a></li>
	   <li><a href="./logout">logout</a></li>
      </ul>  
    </div>
  </div>
</nav>



<h1>Pending Asset Requested </h1>


<%UserBean ub1=(UserBean)session.getAttribute("My_Request_To_Id&MyEmail"); 
String Emailid=ub1.getEmailid();
int supportid=ub1.getSupportid();
%>


	<h4 align="left"><font color="blue"> Your ID: ${user_session}</font></h4> 
	<h4 align="left"><font color="blue"> Your EmailID: <%=Emailid %></font></h4> 
	<h4 align="left"><font color="blue"> Your Support ID:<%=supportid %></font></h4> 


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