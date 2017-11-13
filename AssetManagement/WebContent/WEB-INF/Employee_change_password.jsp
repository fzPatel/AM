<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">

body{
background-image:url('https://imgur.com/BPE2EiH.jpg');
background-size:cover;
height:100%;
}
</style>
<title>Change Password</title>



		<!--Ajax code for check Same Name Product if already exist  -->
<%response.setContentType("text/html"); %>


<script type="text/javascript">
	$(document).ready(function(){
		$("#resetdiv2").hide();
		$("#oldpassword").blur(function(){
			
			var oldpassword = $("#oldpassword").val();
			var data = "employeeid="+$("#employeeid").val();
			var newpassword = $("#newpassword").val();
			var data2=$("#oldpassword").val();
		
			
			$.ajax({
				
				url:'Getoldpasswordemp',
				data:data,
				type:'Get',
				success:function(result)
				{														
					
					if(result.match(oldpassword))
						{
						$("#form").show();
						$("#resetdiv2").hide();
						$("#newpasswordId").show();
						$("#conformpasswordId").show();																
						$("#submitbuttonId").show();
						}
					else 
						{
						alert("password doesn't match");
						$("#form").show();
						$("#resetdiv2").show();
						$("#newpasswordId").hide();
						$("#conformpasswordId").hide();																
						$("#submitbuttonId").hide(); 
						}}	
			});
			
		});
		
	});

</script>


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



<center>
	<h3><font color="blue"> Your ID: ${user_session}</font></h3> 
</center>
${passwordchanged}


 <center>

<table cellpadding="2" width="30%" align="center"
cellspacing="2" border="1">

${ChnagepwdMsgSucces}

<script type="text/javascript">  
function matchpass(){  
var firstpassword=document.f1.password.value;  
var secondpassword=document.f1.password2.value;  
  
if(firstpassword==secondpassword){  
return true;  
}  
else{  
alert("password must be same!");  
return false;  
}  
}  
</script>  
  	<div class="ex" id="form">
<form name="f1" action="./Employeechangepwdsubmit" onsubmit="return matchpass()" method="post">

<input size="5px" id="employeeid" type="hidden"  value="<%=session.getAttribute("user_session")%>" readonly="readonly"/>
<tr id="oldpasswordId">
<td>Old Password:      <input type="password" id="oldpassword" name="oldpassword" placeholder="Enter Old Password" required/>
	<div id="mid"></div>
</td>
</tr>
 
<tr id="newpasswordId">
<td>New Password:      <input type="password" name="password" id="newpassword" placeholder="Enter New Password" required/></td></tr>  
<tr id="conformpasswordId">
<td>Conform Password:  <input type="password" name="password2"  placeholder="Conform Password" required/></td></tr>
<tr>
<td>
<center>
<input id="submitbuttonId" type="submit" value="submit" ></center>
<div id="resetdiv2">
    			<input type="reset" value="ResetToForm" id="reset1"/>
</div>	
</td>
</tr>

</form> 
</div>


</center>
</table>


</body>
</html>