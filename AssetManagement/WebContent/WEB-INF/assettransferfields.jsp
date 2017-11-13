<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.List,com.asset_management.beans.AllocatedAssetsBean,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<title>Insert title here</title>




		<style type="text/css">

body{
background-image:url('https://imgur.com/BPE2EiH.jpg');
background-size:cover;
height:100%;
}
</style>
		
</head>




<body>
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

<%
	List<AllocatedAssetsBean> ll=(List<AllocatedAssetsBean>)request.getAttribute("List");
%>
<tr>
<form method="post">

From Emp Id <tr><td> <input type="text" value="<%=session.getAttribute("user_session")%>"  name="employeeid"></td></tr>
Manager Id   <tr><td> <input type="text" value="<%=session.getAttribute("My_Request_To_Id")%>" name="managerid"></td></tr>
To Emp Id   <tr><td> <input type="text" name="toempid"/></td></tr>
Asset Name <tr><td><select name="assetname">
		<%
		for(AllocatedAssetsBean aab:ll)
		{
			String x=aab.getAssetname();
			int y=aab.getAssetid();
		%>
	<option value="<%=x%>"><%=x%> Asset ID <%=y%> </option>
		<%
		}
		%>
</select></td></tr>
Asset ID<tr><td> <select name="assetid">
		<%
		for(AllocatedAssetsBean aab:ll)
		{
		
			int x=aab.getAssetid();
		%>
	<option value="<%=x%>"><%=x%></option>
		<%
		}
		%>
</select></td></tr>
<input type="submit"   value="TransferAssets" name="submit"/>


</form>


</body>
</html>