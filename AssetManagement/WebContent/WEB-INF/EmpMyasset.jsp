<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />
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

<tr><th>Requestid</th><th>Managerid<th>Managerapproveddate</th><th>Assetname</th><th>Requestdate</th><th>Status</th></tr>

	

<%@page import="java.util.List,com.asset_management.beans.*"%>
<%
List<RequestBean> ar=(List<RequestBean>)request.getAttribute("LIST");
for(Object o:ar)
{
	RequestBean ab=null;
if(o instanceof RequestBean)
	ab=(RequestBean)o;

%>
<tr>
<td><%=ab.getRequestid()%></td>
<td><%=ab.getManagerid()%></td>
<td><%=ab.getManagerapproveddate()%></td>
<td><%=ab.getAssetname()%></td>
<td><%=ab.getRequestdate()%></td>
<td><%=ab.getStatus()%></td>

<td>

										
</td>
</form>
</tr>
<% 
}
%>
</table>


</center>