<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


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
</head>
<body>

<a href="./adminlogout">logout</a><br/>
<a href="./adminhome">back</a>
		<center>
	<%-- 	<form action="./adminpasswordchanged" method="post">
		<table>
			<tr><td><input type="hidden" name="admin_session" value="${admin_session}" /></td></tr>
			<tr><td>Old Password</td><td><input type="text" name="oldpassword" /></td></tr>
			<tr><td>New Password</td><td><input type="text" name="newpassword" /></td></tr>
			<tr><td>Confirm Password</td><td><input type="text" name="confirmpassword" /></td></tr>
			<tr>
					<td><input type="hidden" name="adminsession" value="${admin_session}"/></td>			
					<td></td><td><input type="submit" name="submit" value="ok"/></td>
			</tr>
			</table>
		</form> --%>
		
		
		
		
		
		
		<form name="f1" action="./adminpasswordchanged" onsubmit="return matchpass()" method="post">
		 <table>	
			<tr id="oldpasswordId">
				<td>Old Password:  <input type="password" id="oldpassword" name="oldpassword" placeholder="Enter Old Password" required/>
					<div id="mid"></div>
				</td>
			</tr>
			 
			<tr id="newpassword">
				<td>New Password:<input type="password" name="password" id="newpassword" placeholder="Enter New Password" required/></td>
			</tr>  
			<tr>
				<td>Conform Password:<input type="password" name="password2"  placeholder="Conform Password" required/></td>
			</tr>
			
			
			<tr><td></td><td><input type="submit" name="submit" value="ok"/></td></tr>
		  </table>
		  	
		</form>		
	</center>
</body>
</html>