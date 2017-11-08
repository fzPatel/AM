<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>



<script type="text/javascript">
	$(document).ready(function()
					  {
		$("#oldpassword").blur(function()
						{
						
							 var data="supportid="+$("#support_session").val();
							 var oldpassword=$("#oldpassword").val();
								$.ajax(
										{
											url:'SupportPasswordExistsOrNot',
												data:data,
													type:'post',
													success:function(result)
													{														
														
														if(result.match(oldpassword))
															{
																$("#newpassword").show();
																$("#conformpassword").show();																
																$("#submit").show();
															}
														else
															{
																$("#newpassword").hide();
																$("#conformpassword").hide();
																$("#submit").hide();
																alert("password doesnot matches!!!!!");
															}
														
														
													}
														
										}
									 ); 
						});
					  });
</script>

















<script type="text/javascript">  
		function matchpass(){  
		var firstpassword=document.f1.password.value;  
		var secondpassword=document.f1.password2.value;  
		  
			if(firstpassword==secondpassword){  
			return true;  
			}  
			else
			{  
			alert("password must be same!");  
			return false;  
			}  
		}  
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
	<table>
		<tr><td><a href="./logout">logout</a></td></tr>
		<tr><td><a href="./supporthome">back</a></td></tr>
	</table>
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
		
		
		
		
		
		
		<form name="f1" action="./supportpasswordchanged" onsubmit="return matchpass()" method="post">
		 <table>	
			<tr id="oldpasswordId">
				<td>Old Password:  <input type="password" id="oldpassword" name="oldpassword" placeholder="Enter Old Password" required/>
				<input type="hidden" name="support_session" id="support_session" value="${support_session}"/>
					<div id="mid"></div>
				</td>
			</tr>
			 	<input type="hidden" name="user_designation" value="${user_designation}"/>
			<tr id="newpassword">
				<td>New Password:<input type="password" name="password" id="newpassword1" placeholder="Enter New Password" required/></td>
			</tr>  
			<tr id="conformpassword">
				<td>Conform Password:<input type="password" name="password2"  id="conformpassword1" placeholder="Conform Password" required/></td>
			</tr>
			
			
			<tr><td></td><td><input type="submit" id="submit" name="submit" value="ok"/></td></tr>
		  </table>
		  	
		</form>		
	</center>
</body>
</html>