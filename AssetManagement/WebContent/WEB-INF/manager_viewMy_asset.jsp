<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>My Assets</title>

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
   <a href="./BackbtnMangerhome"><img src="assetManagement.png"   width="110px" height="70px" alt="logo" /></a>
        </div>
    <div>
      <ul class="nav navbar-nav">
	<li><a href="./BackbtnMangerhome" >Home</a></li>
	   <li><a href="./logout">logout</a></li>
      </ul>  
    </div>
  </div>
</nav>



<center>
<h1>My Asset </h1>
</center>


<%UserBean ub1=(UserBean)session.getAttribute("My_Request_To_Id&MyEmail"); 
String Emailid=ub1.getEmailid();
int supportid=ub1.getSupportid();
%>


	<h4 align="left"><font color="blue"> Your ID: ${user_session}</font></h4> 
	<h4 align="left"><font color="blue"> Your EmailID: <%=Emailid %></font></h4> 
	<h4 align="left"><font color="blue"> Your Support ID:<%=supportid %></font></h4> 


</br>
<%@page import="java.util.ArrayList,com.asset_management.beans.*"%>
<%
ArrayList<RequestBean> ar=(ArrayList<RequestBean>)request.getAttribute("Manager_request");

if(!ar.isEmpty())
{
	
%>	
	<table border="1">
	<tr><th>RequestID</th><th>ManagerId</th><th>Asset Name</th><th>Requested Date</th></tr>

<%


for(Object o:ar)
{
	RequestBean ub=null;
if(o instanceof RequestBean)
	ub=(RequestBean)o;
%>
<tr>
<td><%=ub.getRequestid()%></td>
<td><%=ub.getManagerid()%></td>
<td><%=ub.getAssetname()%></td>
<td><%=ub.getRequestdate()%></td>
</tr>
<% 
}
}else
{
	
	%>
	
	
	<h1>You Have No Asset !! </h1>

	<%
	
	
}
%>
</table>

</center>
</body>
</html>