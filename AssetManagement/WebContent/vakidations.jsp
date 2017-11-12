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
			$("#emailid").blur(function(){
				alert("hi");
				
			var data="emaili0d="+$("#emailid").val();
			if (data=="") 
			{
				$("emsg").html("Plese enter your id");
			} else {
				alert("not null");

			}
			alert(data);
					$.ajax({
						url:'AdminCheckOldpwd',
						data:data,
						type:'post',
						success:function(result)
						{
							if(result.match(0))
								{

								 $("#printmsg").html("Password does not match");
								 $("#btnSubmit").prop('disabled', true);

								}
							else if(result.match(1))
							{
								 $("#printmsg").html("Password matched please continue");

								 $("#btnSubmit").prop('disabled', false);

							}
						}
						
					})
			});
		
			
			
		}
		
		
		
		);
</script>


</head>
<body>
<form id="formid"name="f1">
<div id="e">
email <input type="email" id="emailid" name="emaili0d" >
</div>
<div id="emsg"></div>
pwd <input type="email" id="p" name="password" >
<div id="pmsg"></div>
<input id="btn" type="Submit" value="Submit">
</form>



</body>
</html>