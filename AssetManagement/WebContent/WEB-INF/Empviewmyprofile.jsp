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

<tr><th>EMPLOYEE_ID</th><th>MANAGER_ID</th><th>Fname<th>Lname</th><th>EMAIL</th><th>PASSWORD</th><th>DESIGNATION</th><th>MOBILE</th><th>DATEOFJOINING</th><th>operation</th></tr>



<%@page import="java.util.List,com.asset_management.beans.*"%>
<%
List<UserBean> ar=(List<UserBean>)request.getAttribute("List");
for(UserBean ab:ar)
{

%>
<tr>
<td><%=ab.getEmployeeid()%></td>
<td><%=ab.getManagerid() %></td>
<td><%=ab.getFirstname()%></td>
<td><%=ab.getLastname()%></td>
<td><%=ab.getEmailid()%></td>
<td><%=ab.getPassword()%></td>
<td><%=ab.getDesignation()%></td>
<td><%=ab.getMobile()%></td>
<td><%=ab.getDateofjoining()%></td>

<form action="./updateprofiletojsp" method ="post">
  <td><input type="hidden" name="id" value="<%=ab.getEmployeeid()%>" />
  <input type="hidden" name="fname" value="<%=ab.getFirstname()%>" />
     <input type="hidden" name="lname" value="<%=ab.getLastname()%>" />
       <input type="hidden" name="email" value="<%=ab.getEmailid()%>" />
          <input type="hidden" name="mobile" value="<%=ab.getMobile()%>" />>
    
 <input type="submit" value="update"  /></td>
</tr>
								


</form>


<% 
}
%>
	
</table>

</center>
<font color="brown">

</font>