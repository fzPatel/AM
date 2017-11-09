<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.asset_management.beans.UserBean"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
								<input type="text" name="fname" pattern="[a-zA-Z][a-zA-Z ]{4,}" required value="<%=ub.getFirstname()%>"/>
						</td>
					</tr>
					<tr>
					<td>Last Name</td>
						<td>
								<input type="text" name="lname" pattern="[a-zA-Z][a-zA-Z ]{5,}" required value="<%=ub.getLastname()%>"/>
						</td>
					</tr>
					<tr>
					<td>Email Id</td>
						<td>
								<input type="email" name="email" pattern= "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$"    required value="<%=ub.getEmailid()%>"/>
						</td>
					</tr>
					<tr>
					<td>Mobile</td>
						<td>
								<input type="text" name="mobile" maxlength="10"  pattern="[0-9]{10}" value="<%=ub.getMobile()%>"/>
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