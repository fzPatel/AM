 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.asset_management.beans.UserBean"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">

body{
background-image:url('https://imgur.com/BPE2EiH.jpg');
background-size:cover;
height:100%;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>

$(document).ready(function()
		{
$("#email").blur(function()
		{
	
	var email = "email="+$("#email").val();

			$.ajax({
				url:'EmailCheckControllerAjax',
				data:email,
				type:'post',
				
				success:function(result)
				{
				
					
					if(result.match('1'))
					{
			
				
				$("#eid").html("<font color='brown'>Email no  already registed</font>");
				
					 $("#other1").hide();
					
					}
				else
					{
				
					$("#eid").hide();
				
					 $("#other1").show();
					}
					
				}
				
			})
	});
		});


$(document).ready(function()
		{
$("#mobile").blur(function()
		{
	
	var mobile = "mobile="+$("#mobile").val();
			
			
			$.ajax({
				url:'MobileCheckControllerAjax',
				data:mobile,
				type:'post',
				success:function(result)
				{
				
					if(result.match(1))
					{
					
				
				$("#mid").html("<font color='orange'>Mobile no  already registed</font>");
				
					 $("#other1").hide();
					
					}
				else
					{
				
					$("#mid").hide();
				
					 $("#other1").show();
					}
					
				}
				
			})
	});
		});
</script>

</head>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
</div>
<div>
<ul class="nav navbar-nav">
<li><a href="./backs" >Home</a></li>
<li><a href="./Empviewmyprofile">Profile</a></li>
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
<font color="red">
<h2>UPDATE YOUR PROFILE</h2>
</font>
<div class="ex" id="form">
<form action="updateprofile" method="post">
				<table>
					<tr>
					<tr id="other">
						<td >
							<input type="hidden" name="id" value="<%=ub.getEmployeeid()%>"/>
								<input type="text" name="fname" pattern="[a-zA-Z][a-zA-Z ]{4,}" required value="<%=ub.getFirstname()%>"/>
						</td>
					</tr>
					<tr>
					<tr id="other">
						<td>
								<input type="text" name="lname" pattern="[a-zA-Z][a-zA-Z ]{5,}" required value="<%=ub.getLastname()%>"/>
						</td>
					</tr>
					<tr>
					<div id="email1">
						<td>
								<input type="email" name="email" id="email" pattern= "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" required value="<%=ub.getEmailid()%>"/>
						</td>
						<tr>	<td id="eid">	</td></tr>
					</tr>
					</div>
					<tr>
			
					<td>
					<div id=" mobile ">	
				<input type="text" name="mobile"  id="mobile" maxlength="10"  pattern="[0-9]{10}" value="<%=ub.getMobile()%>"/>
						</td>
					
					<tr>	<td id="mid">	</td></tr>
					</div>
					</tr>
					<tr id="other1">
						<td>
							<input type="submit" name="update" id="update" value="update"/>
						</td>
					
					</tr>
					 
				</table>
				
				</div>
			</form>
			
    			
			</center>
			<%
		}
		
	%>

</body>

</html>