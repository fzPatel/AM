<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>



		<!--Ajax code for check Same Name Product if already exist  -->
<%response.setContentType("text/html"); %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#oldpassword").change(function(){
			
			var data = "oldpassword="+$("#manager_id").val();
			var data2=$("#oldpassword").val();
			
			$.ajax({
				
				url:'Getoldpassword',
				data:data,
				type:'Get',
				success:function(mid){{														
					
						if(mid!=null){
						
						$("#submitbtnid").hide();
						}
					
					
				}
				});
			
		});
		
	});

</script>

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
  
<form name="f1" action="./managerchangepwdsubmit" onsubmit="return matchpass()" method="post">

<input size="5px" type="hidden"  value="<%=session.getAttribute("user_session")%>" readonly="readonly"/>
<tr id="oldpasswordId"><td>Old Password:  <input type="password" id="oldpassword" name="oldpassword" title="Please Enter Old Password" placeholder="Enter Old Password" required/>
	<div id="mid"></div>
</td>
</tr>
 
<tr id="newpassword">
<td>New Password:<input type="password" name="password" id="newpassword" title="Please Enter New Password" placeholder="Enter New Password" required/></td></tr>  
<tr><td>Conform Password:<input type="password" name="password2" title="Please conform your Password"  placeholder="Conform Password" required/></td></tr>

<tr><td>
<center>
<input type="reset">
<input id="submitbtnid" type="submit" value="submit" ></center>
</td></tr>

</form> 
</center>
</table>


</body>
</html>