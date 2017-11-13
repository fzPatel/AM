<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />
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
<h1>Cart Details</h1>
<table border="1">

<tr><th>AssetID</th><th>AssetName<th>Emailid </th><th> Transfer From </th><th>Allocation date</th><th>Transfer To </th><th>Action</th></tr>

	

<%@page import="java.util.List,com.asset_management.beans.*"%>
<%
List<UserBean> ar1=(List<UserBean>)request.getAttribute("emplist");
List<AllocatedAssetsBean> ar=(List<AllocatedAssetsBean>)request.getAttribute("LIST");




for(AllocatedAssetsBean ab:ar)
{

%>
<form action="./trasferassetrequest" method="post">
<tr>
<td><input type="text" name="assetid" value="<%=ab.getAssetid()%>"></td>
<td><input type="text" name="assetname" value="<%=ab.getAssetname()%>"></td>
<td><input type="text" name="emailid" value="<%=ab.getEmailid()%>"></td>
<td><input type="text" name="fromempid" value="<%=ab.getUserid()%>"></td>
<td><%=ab.getDateofallocation()%></td>



<td> <select name="toempid">
		<%
		for(UserBean aab:ar1)
		{
		
			int x=aab.getEmployeeid();
		%>
	<option value="<%=x%>"><%=x%></option>
		<%
		}
		%>
</select></td>



<td><input type="submit" value="Transfer"></td>

<td>

										
</td>
</form>
</tr>
<% 
}
%>
</table>

</center>