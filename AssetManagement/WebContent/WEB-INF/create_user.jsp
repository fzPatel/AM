<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
<head>


<style type="text/css">

body{
background-image:url('https://imgur.com/p7L8a5E.jpg');
background-size:cover;
height:100%;
}
</style>

</head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	
	
	

	<script type="text/javascript">
			function abc()
			{
				var v1=document.getElementById("i1").value;
				document.getElementById("i2").value=v1;
			}
			
			$(document).ready(function()
							{
								  $("#mid").hide();
								  $("#sid").hide();
								  $("#feedmanagerid").hide();
								  $("#feedsupportid").hide();
								  $("#its").hide();
								  
							    $("#designation").change(function () {
							         var data=$("#designation").val();
							     //    var data1="designation="+$("#designation").val();
								    	 if(data.match('employee'))
								    		 {
								    		 $("#mid").show();
								    		 	$("#sid").hide();
								    		 	$("#feedmanagerid").show();
								    		 	$("#feedsupportid").hide();
								    		 	$("#its").hide();
								    			
								    		 	
								    		 }
								    		  
								    	 else if(data.match('manager'))
								    		 {
								    		 	$("#sid").show();
								    		 	$("#mid").hide();
								    		 	$("#feedmanagerid").hide();
								    		 	$("#feedsupportid").show();
								    		 	$("#its").hide();
								    			
									    		
								    		 }
								    	 else if(data.match('support'))
								    		 {
								    		 	$("#sid").hide();
								    		 	$("#mid").hide();
								    		 	$("#feedmanagerid").hide();
								    		 	$("#feedsupportid").hide();
								    		 	$("#its").show();
								    			
								    		 }
								    	 
							    });
							
			     });
				
			$(document).ready(function()
							  {				
								$("#id1").blur(
											      function()
											      {				
													$.ajax(
															{
																	url:'retrivemanagerids',
																	
																	type:'get',
																	success:function(result)
																	{												
																		$("#mm").empty().append(result);
																	}
							
															}
														  ); 
						
												  }
										      );
								
								$("#id2").blur(
									      function()
									      {				
											$.ajax(
													{
															url:'retrivesupportids',
															
															type:'get',
															success:function(result)
															{												
																$("#ss").empty().append(result);
															}
					
													}
												  ); 
				
										  }
								      );
		
				
								}
							);

			
			
			
	</script>
	
	
	
	  <script>
         $(function() {
            
			  $( "#datepicker-12" ).datepicker(
			  {
   
	minDate: new Date(),
    //selectOtherMonths: true,
   // changeMonth: true,
//changeYear: true,
  //  showButtonPanel: true,
    dateFormat: 'dd-mm-yy'
}
			  
			  );
       
			
         });
      </script>
	
	
</head>

<body>
<a href="./adminlogout">logout</a><br/>
<a href="./adminhome">back</a>
<font color="blue"><h1>${oh}</h1></font>

	
</p>

	<center>
	<h1><font color="green">${user_inserted}</font></h1>
	<h1><font color="orange">Feed User Form</font></h1>
		
		<table>
		<form action="./insertuser" id="form1" method="post">	
			
			<tr><td>First Name :</td><td><input type="text" name="firstname"  pattern="[A-Za-z-]+" title="only alphabet" required/></td></tr>
			<tr><td>Last Name :</td><td><input type="text" name="lastname" pattern="[A-Za-z-]+" title="only alphabet" required/></td></tr>
			<tr><td>E-mail :</td><td><input type="email" name="emailid"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Enter emailid" id="i1" required/></td></tr>
			<tr><td>Password :</td><td><input type="text" id="i2" name="password" title="Enter your password" required/></td></tr>
		
		<tr>
				<td>Designation :</td>
				<td>
					<select name="designation" id="designation" required>
					
						<option value="manager">manager</option>
						<option value="employee">employee</option>
						<option value="support">support</option>
					</select>
				</td>
			</tr> 
		<tr id="feedmanagerid">
			<td>New Employee Id:</td>
			<td><input type="text"  id="id1" value="0"  name="newemployeeid" placeholder="select employee id" required/></td>
		</tr>
			
		<tr id="feedsupportid">
			<td>New Manager Id:</td>
			<td><input type="text"  id="id2" value="0" name="newmanagerid" placeholder="select manager id" required /></td>
		</tr>	
		<tr id="its">
			<td>New Support Id:</td>
			<td><input type="text"  id="id3" value="0" name="newsupportid" placeholder="select support id" required/></td>
		</tr>
			
			
					<tr id="mid">					
						<td>Manager Id</td>	
						<td>
							<select name="managerid" id="mm">
								
							</select>
						</td>		
					 		 					
					</tr>
					
					<tr id="sid">					
						<td>Support Id</td>
						<td>
							<select name="supportid" id="ss">
								
							</select>
						</td>
					</tr>
									
			<tr><td>Mobile :</td><td><input type="text" name="mobile" maxlength="10" title="Enter Mobile Number" pattern="[0-9]{10}" required/></td></tr>
			<tr><td>Date Of Joining :</td><td><input type="date" id="datepicker-12" name="dateofjoining" required/></td></tr>
			<tr><td><input type="submit" value="submit"/></td></tr>
		</form>
		</table>

		
		
		
		
	</center>
</body>
</html>