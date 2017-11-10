<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

body{
background-image:url('https://imgur.com/p7L8a5E.jpg');
background-size:cover;
height:100%;
}
</style>

</head>

<body>

<a href="./backtoindex">back</a>
	<center>
		
	<%-- 	<%
		if(admin_session!=null)
		{
			%><%
		}
		% --%>
		
		<font color="Red"><h3>${errormag}</font></h3>
			
		<form action="./adminlogincheck" method="post" id="the-form">
					<font color="orange"><h1>Admin Login</h1></font>
				<table>
					<tr>
						<td>E-mail</td>
						<td><input type="text" name="emailid" id="emailid" data-validation="email" data-validation-help="as-abc@gmail.com..." required/></td>
					
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" id="password" required/></td>
					</tr>
					<tr>
						<td><input type="submit" name="submit" value="login"/></td>
						<td><input type="reset" name="reset" value="reset"/></td>
					</tr>
				</table>
			</form>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
<script>
  $.validate();
  $('#my-textarea').restrictLength( $('#max-length-element') );
</script>
	</center>

</body>
</html>