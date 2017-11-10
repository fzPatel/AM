<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Profile Update</title>
 <%@page import="com.asset_management.beans.UserBean" %>
    <%@page import="java.util.ArrayList" %>


<style type="text/css">

body{
background-image:url('https://imgur.com/p7L8a5E.jpg');
background-size:cover;
height:100%;
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script type="text/javascript">

$(document).ready(function()
		{
	
			$("#emailid").blur(function(){
				
			var emailid="emailid="+$("#emailid").val();
					alert("emailid"+emailid);
					
					$.ajax({
						url:'checkemailifexist',
						data:emailid,
						type:'post',
						success:function(result)
						{
							if(result.match(1))
								{
								
								$("#printmsg").html("Email id Already exist");
								 $("#btnSubmit").prop('disabled', true);

								}
						}
						
					})
			});
		
		//Ajax for mobile if exist check-------//	
			$("#mobile").blur(function(){
				
				var mobile="mobile="+$("#mobile").val();
						alert("mobile"+mobile);
						
						$.ajax({
							url:'checkemobileifexist',
							data:mobile,
							type:'post',
							success:function(result)
							{
								if(result.match(1))
									{
									
									$("#printmobile").html("mobile number Already registered");
									 $("#btnSubmit").prop('disabled', true);

									}
							}
							
						})
				});
			
			
		}
		
		
		
		);
</script>

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



<%UserBean ub1=(UserBean)session.getAttribute("My_Request_To_Id&MyEmail"); 
String Emailid=ub1.getEmailid();
int supportid=ub1.getSupportid();
%>

<center>
	<h4 align="left"><font color="blue"> Your ID: ${user_session}</font></h4> 
	<h4 align="left"><font color="blue"> Your EmailID: <%=Emailid %></font></h4> 
	<h4 align="left"><font color="blue"> Your Support ID:<%=supportid %></font></h4> 
</center>

	<%
	UserBean eb=(UserBean)request.getAttribute("Profile");
		if(eb!=null)
		{
			%>
			<center>
			<font color="orange"><h1>Update Profile</h1></font>
			<form action="./managerprofileUpdate" method="Post">
			
				<table border="1">
							
					
					<tr><td><font color="orange"> First Name</font></td><td><input type="text" name="firstname" pattern="[A-Za-z- ]+" title="only alphabet" value="<%=eb.getFirstname()%>"required/>&nbsp;</td></tr>
					<tr><td><font color="orange"> Last Name</font></td><td><input type="text" name="lastname" pattern="[A-Za-z- ]+" title="only alphabet" value="<%=eb.getLastname()%>"required/>&nbsp;</td></tr>
					<tr><td><font color="orange"> Email Id</font></td><td><input id=emailid type="email" name="emailid" title="Example - abc@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" value="<%=eb.getEmailid()%>" required />&nbsp;</td></tr>
					<tr><td id="printmsg"></td></tr>
					<tr><td><font color="orange"> Manager Id</font></td><td><input type="text" name="managerid" value="<%=eb.getManagerid()%>" readonly/>&nbsp;</td></tr>
					<tr><td><font color="orange"> Designation</font></td><td><input type="text" name="designation" value="<%=eb.getDesignation()%>"readonly/>&nbsp;</td></tr>
					<tr><td><font color="orange">Mobile </font></td><td><input type="Number" id="mobile" name="mobile" maxlength="10" title="Enter Mobile Number" pattern="[0-9]{10}" value="<%=eb.getMobile()%>"required/>&nbsp;</td></tr>
					<tr><td id="printmobile"></td></tr>
					<tr><td><font color="orange">Date Of Joining</font></td><td><input type="date" name="dateofjoining" value="<%=eb.getDateofjoining()%>"readonly/>&nbsp;</td></tr>
					<tr><td><font color="orange"> Status</font></td><td><input type="text" name="status" value="<%=eb.getStatus()%>" readonly/>&nbsp;</td></tr>
					<tr><td><input type="hidden" name="hidden" value="<%=eb.getEmailid()%>"/>&nbsp;</td></tr>
					<tr><td><input type="submit" id="btnSubmit" name="submit" value="update now" /></td></tr>
				</table>
				</form>
				</center>				
			<%
		}
	%>




</body>
</html>