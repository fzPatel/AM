<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

body{
     background-image:url(https://imgur.com/uILsCFL.jpg);
background-size:cover;
height:100%;
}
</style>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script type="text/javascript">

$(document).ready(function()
		{
	$("#printmsg").hide();
	$("#printmobile").hide();
			$("#emailid").blur(function(){
				
			var emailid="emailid="+$("#emailid").val()+"&managerid="+$("#managerid").val();
			var user_session="user_session="+$("#user_session").val();
			var managerid="managerid="+$("#managerid").val();		
					
					

					$.ajax({
						url:'forgetpasswordUserAlreadyExistsOrNot',
						data:emailid,
						type:'post',
						success:function(result)
						{
							
							if(result.match(1))
								
							
							{
								
								$("#printmsg").hide();
								 $("#btnSubmit").prop('disabled', false);

								}
							else
								{

								$("#printmsg").show();
								 $("#btnSubmit").prop('disabled', true);

								}
						}
						
					})
			});
		
			
		}
		
		);
</script>
</head>
 <body >
<center>
		<table></br></br></br></br></br>
		
		
		${mailmsg}
		
		<font color="blue"><h1> <font color="red">Welcome To Asset Management</font></h1>				
				<h2>Enter Your E-mail Address</h2></br>
				
				
				
				<form action="./forgetpwdSubmit" method="post">
				
                 <input type="email" name="emailid" id=emailid class="form-control" id="exampleInputEmail2"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Enter Valid Emailid" placeholder="Email address" required>
				<tr id="printmsg"><td><input type="text" placeholder="E-mail Id not Valid!!!!" readonly/></td></tr>
				
				<input type="submit" id="btnSubmit" value="submit">
				</form>
				
				</font>
		</table></br>
						<font color="blue"><font color="red">(Your Password will send to your E-mail)</font>
				       </br>   <a href="./backtoindex"><font >Click here to login</font> </a>
			
	</center>
						
</body>
</html>