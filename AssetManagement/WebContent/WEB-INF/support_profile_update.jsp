<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.asset_management.beans.UserBean" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function()
		{
	$("#printmsg").hide();
	$("#printmobile").hide();
			$("#emailid").blur(function(){
				
			var emailid="emailid="+$("#emailid").val()+"&supportid="+$("#supportid").val();
			var user_session="user_session="+$("#user_session").val();
			var managerid="supportid="+$("#supportid").val();		
					
					
			
				
					
					$.ajax({
						url:'checkemailifexistsupport',
						data:emailid,
						type:'post',
						success:function(result)
						{
							if(result.match(1))
								{
								
								$("#printmsg").show();
								 $("#btnSubmit").prop('disabled', true);

								}
							else
								{
								$("#printmsg").hide();
								}
						}
						
					})
			});
		
		//Ajax for mobile if exist check-------//	
			$("#mobile").blur(function(){
				
				var mobile="mobile="+$("#mobile").val()+"&supportid="+$("#supportid").val();
						
						
						$.ajax({
							url:'checkemobileifexistsupport',
							data:mobile,
							type:'post',
							success:function(result)
							{
								if(result.match(1))
								{
								
								$("#printmobile").show();
								 $("#btnSubmit").prop('disabled', true);

								}
							else
								{
								$("#printmobile").hide();
								}
							}
							
						})
				});
			
			
		}
		
		
		
		);
</script>
</head>
<body>
	<table>
		<tr><td><a href="./logout">logout</a></td></tr>
		<tr><td><a href="./supporthome">back</a></td></tr>
	</table>
						
<%
ArrayList<UserBean> al=(ArrayList<UserBean>)request.getAttribute("supportdetails");
%>
<center>
				<h1><font color="blue">Update My Profile</font></h1>
				<h1><font color="green">${supportdetailsupdated}</font></h1>
				<h1><font color="red">${supportdetailsnotupdated}</font></h1>
				
				
<table>
							<%
						
							for(UserBean l:al)
							{
								%>
								<form action="./updatesupportprofile" method="post">
									
										<tr><td><font color="orange"> Support Id</font></td><td><input type="text" name="supportid" id="supportid" value="<%=l.getSupportid()%>" readonly/>&nbsp;</td></tr>
										<tr><td><font color="orange"> First Name</font></td><td><input type="text" name="firstname" id="firstname" value="<%=l.getFirstname()%>"/>&nbsp;</td></tr>
										<tr><td><font color="orange"> Last Name</font></td><td><input type="text" name="lastname" id="lastname" value="<%=l.getLastname()%>"/>&nbsp;</td></tr>
										<tr><td><font color="orange"> Email id</font></td><td><input type="text" name="emailid" id="emailid" value="<%=l.getEmailid()%>"/>&nbsp;</td></tr>
										<tr id="printmsg"><td><input type="text" placeholder="Email id already exists!!!!" readonly/></td></tr>
										<tr><td><font color="orange"> Mobile Number</font></td><td><input type="text" name="mobile" maxlength="10"  pattern="[0-9]{10}" id="mobile" value="<%=l.getMobile()%>"/>&nbsp;</td></tr>
										<tr id="printmobile"><td><input type="text" placeholder="Mobile number already exists!!!!" readonly/></td></tr>		
										<tr><td><font color="orange"> Password</font></td><td><input type="text" name="password" id="password" value="<%=l.getPassword()%>"/>&nbsp;</td></tr>
										<tr><td><font color="orange"> Designation </font></td><td><input type="text" name="designation" id="designation" value="<%=l.getDesignation()%>" readonly/>&nbsp;</td></tr>										
										<tr><td><font color="orange">Date Of Joining</font></td><td><input type="text" name="dateofjoining" id="dateofjoining" value="<%=l.getDateofjoining()%>" readonly/>&nbsp;</td></tr>										
										
									
										
											
										<tr><td></td><td><input type="submit" name="submit" value="Update"/></td></tr>									
								</form>
										
									
											
										
									
								<%
							}
						%>
</table>
</center>
</body>
</html>