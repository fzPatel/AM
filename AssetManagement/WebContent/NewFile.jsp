<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user registration form validation using javascript with example</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<style type="text/css">

body{
background-image:url('https://imgur.com/p7L8a5E.jpg');
background-size:cover;
height:100%;
}
</style>
		
<style>

@import url('https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css');
@media(min-width:768px) {
    body {
        margin-top: 50px;
    }
    /*html, body, #wrapper, #page-wrapper {height: 100%; overflow: hidden;}*/
}

#wrapper {
    padding-left: 0;    
}

#page-wrapper {
    width: 100%;        
    padding: 0;
    background-color: #fff;
}

@media(min-width:768px) {
    #wrapper {
        padding-left: 225px;
    }

    #page-wrapper {
        padding: 22px 10px;
    }
}

/* Top Navigation */

.top-nav {
    padding: 0 15px;
}

.top-nav>li {
    display: inline-block;
    float: left;
}

.top-nav>li>a {
    padding-top: 20px;
    padding-bottom: 20px;
    line-height: 20px;
    color: #fff;
}

.top-nav>li>a:hover,
.top-nav>li>a:focus,
.top-nav>.open>a,
.top-nav>.open>a:hover,
.top-nav>.open>a:focus {
    color: #fff;
    background-color: #1a242f;
}

.top-nav>.open>.dropdown-menu {
    float: left;
    position: absolute;
    margin-top: 0;
    /*border: 1px solid rgba(0,0,0,.15);*/
    border-top-left-radius: 0;
    border-top-right-radius: 0;
    background-color: #fff;
    -webkit-box-shadow: 0 6px 12px rgba(0,0,0,.175);
    box-shadow: 0 6px 12px rgba(0,0,0,.175);
}

.top-nav>.open>.dropdown-menu>li>a {
    white-space: normal;
}

/* Side Navigation */

@media(min-width:768px) {
    .side-nav {
        position: fixed;
        top: 60px;
        left: 225px;
        width: 225px;
        margin-left: -225px;
        border: none;
        border-radius: 0;
        border-top: 1px rgba(0,0,0,.5) solid;
        overflow-y: auto;
        background-color: #222;
        /*background-color: #5A6B7D;*/
        bottom: 0;
        overflow-x: hidden;
        padding-bottom: 40px;
    }

    .side-nav>li>a {
        width: 225px;
        border-bottom: 1px rgba(0,0,0,.3) solid;
    }

    .side-nav li a:hover,
    .side-nav li a:focus {
        outline: none;
        background-color: #1a242f !important;
    }
}

.side-nav>li>ul {
    padding: 0;
    border-bottom: 1px rgba(0,0,0,.3) solid;
}

.side-nav>li>ul>li>a {
    display: block;
    padding: 10px 15px 10px 38px;
    text-decoration: none;
    /*color: #999;*/
    color: #fff;    
}

.side-nav>li>ul>li>a:hover {
    color: #fff;
}

.navbar .nav > li > a > .label {
  -webkit-border-radius: 50%;
  -moz-border-radius: 50%;
  border-radius: 50%;
  position: absolute;
  top: 14px;
  right: 6px;
  font-size: 10px;
  font-weight: normal;
  min-width: 15px;
  min-height: 15px;
  line-height: 1.0em;
  text-align: center;
  padding: 2px;
}

.navbar .nav > li > a:hover > .label {
  top: 10px;
}

.navbar-brand {
    padding: 5px 15px;
}
</style>
		
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






/* 

$(document).ready(function()
{
	$("#mobile").blur(function()
	{
		var data="mobile="+$("#mobile").val();
		$.ajax(
				{
					url:'./UserMobileAlreadyExistsOrNot',
					data:data,
					type:'post',
					success:function(result)
					{
						if(result.match('1'))
							{
							$("#dateofjoiningrow").hide();															
							$("#submitrow").hide();
							}
						else
							{
							$("#dateofjoiningrow").show();															
							$("#submitrow").show();
							}
					}
				}
				);
	});
	
});


 */














$(document).ready(function()
{
		$("#emailid").blur(function()
		{

			$("#mid").hide();
			  $("#sid").hide();
			  $("#feedmanagerid").hide();
			  $("#feedsupportid").hide();
			  $("#its").hide();
			
			
			var data="emailid="+$("#emailid").val();
		
			
			$.ajax(
					{
						url:'./UserAlreadyExistsOrNot',
						data:data,
						type:'post',
						success:function(result)
						{
							if(result.match('1'))
							{
								$("#passwordrow").hide();
								$("#designationrow").hide();
								$("#feedmanagerid").hide();
								$("#feedsupportid").hide();
								$("#its").hide();
								$("#mid").hide();
								$("#sid").hide();
								$("#mobilerow").hide();
								$("#dateofjoiningrow").hide();															
								$("#submitrow").hide();
								
								alert("you are already registered!!!!!");
							}
						else
							{
								$("#passwordrow").show();
								$("#designationrow").show();
							/* 	$("#feedmanagerid").show();
								$("#feedsupportid").show();
								$("#its").show();
								$("#mid").show();
								$("#sid").show(); */
								$("#mobilerow").show();
								$("#dateofjoiningrow").show();															
								$("#submitrow").show();
							}
						}
					}
					);
		});



});
</script>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js">
var NotBeforeToday = function(date) {
		var now = new Date(); //this gets the current date and time
		if (date.getFullYear() == now.getFullYear() && date.getMonth() == now.getMonth() && date.getDate() >= now.getDate() && (date.getDay() > 0 && date.getDay() < 6) )
			return [true,""];
		if (date.getFullYear() >= now.getFullYear() && date.getMonth() > now.getMonth() && (date.getDay() > 0 && date.getDay() < 6))
			return [true,""];
		if (date.getFullYear() > now.getFullYear() && (date.getDay() > 0 && date.getDay() < 6))
			return [true,""];
		return [false,""];
	}


jQuery("#datepicker").datepicker({
		beforeShowDay: NotBeforeToday
    });



  </script>








<script type="text/javascript">
$(document).ready(function(){
	$("#mid").hide();

	

	$("#designation").change(function(){
		var data=$("#designation").val();
		if(data.match('developer'))
			{
			$("#mid").show();
			$.ajax({
				url:'FetchManager',						
				type:'post',									
					success:function(result){
						alert(result);
						$("#managerid").empty().append(result);
					}

					});
			}
		else{
			$("#mid").hide();
			$("#managerid").empty();
		}
			});
	
/* 

$("#email").change(function(){
		var data="email="+$("#email").val();
		var data1=$("#email").val();
		//alert(data);
		$.ajax({
			url:'./checkEmailExist',
			data:data,
			type:'post',
			success:function(result){
				if(result.match("1")){
					$("#email").val('');
					$("#emailexist").html(data1+" already exist");
				}
				else{
					$("#emailexist").html("");
				}
			}
		});
	});

*/
	
	 $("#doj").change(function(){
		var d=new Date($("#doj").val());
		//alert(d)
		if(d.getFullYear()<1980){
			alert("your company didn't existed at that time");
			$("#doj").val('');
		
		
		}
		
	}); 
	 
	  $("#mobile").change(function (){
		 
	    	var mo=$("#mobile").val();
	    	var mo1="mobile="+$("#mobile").val();
	    	var patter=/[789][0-9]{9}/;
		    //alert(mo.match(patter));
		    if(!mo.match(patter))
		    	{
		    	$("#mobile").val('');
		    	$("#mobile1").html("Enter valid mobile number");
		    	  
		    	}
		    else
		    	{
		    	$("#mobile1").hide();

		    	alert("inside else");
		    	
		    	$("#mobile").blur(function()
		    			{
		    				var data="mobile="+$("#mobile").val();
		    				$.ajax(
		    						{
		    							url:'./UserMobileAlreadyExistsOrNot',
		    							data:data,
		    							type:'post',
		    							success:function(result)
		    							{
		    								if(result.match('1'))
		    									{
		    									$("#dateofjoiningrow").hide();															
		    									$("#submitrow").hide();
		    									}
		    								else
		    									{
		    									$("#dateofjoiningrow").show();															
		    									$("#submitrow").show();
		    							    	$("#mobile1").hide();
		    									}
		    							}
		    						}
		    						);
		    			});
		    	}
	 });
	  
	  
	  $("#firstname").change(function(){
		  
	  
	  var name=$("#firstname").val();
	  var name_pattern=/[a-zA-Z]+/;
	  
	  if(!name.match(name_pattern))
		   {
		  $("#firstname").val('');
			$("#name1").html("First Name should be alphabets only");
		    
		  }
	  else{
		  $("#name1").html("");
	  }
	  
	  
	  
	  
	  
	  });
	  
	  
	  
	  $("#lastname").change(function(){
		  
		  
		  var name=$("#lastname").val();
		  var name_pattern=/[a-zA-Z]+/;
		  
		  if(!name.match(name_pattern))
			   {
			  $("#lastname").val('');
				$("#name2").html("Last Name should be alphabets only");
			    
			  }
		  else{
			  $("#name2").html("");
		  }
		  
		  
		  
		  
		  
		  });
	  
	  
});
</script>







</head>

<body>
<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://cijulenlinea.ucr.ac.cr/dev-users/">
                <img src="https://imgur.com/TIiwKNq.jpg" height="60px" width="200px" alt="LOGO"">
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li><a href="#" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Stats"><i class="fa fa-bar-chart-o"></i>
                </a>
            </li>            
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin User <b class="fa fa-angle-down"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
                    <li><a href="adminchangepassword"><i class="fa fa-fw fa-cog"></i> Change Password</a></li>
                    <li class="divider"></li>
                    <li><a href="./adminlogout"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li>
                    <a href="#" data-toggle="collapse" data-target="#submenu-1"> </a>
                    
                </li>
                <li>
                    <a href="createuser" data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-user-plus"> </i> CREATE NEW USER </i></a>
                   
                </li>
                <li>
                    <a href="viewusers"><i class="fa fa-fw fa-user"></i> VIEW USERS</a>
                </li>
                <li>
                    <a href="sugerencias"><i class="fa fa-fw fa-question-circle"></i>VIEW ALLOCATED ASSET</a>
                </li>
                <li>
                    <a href="faq"><i class="fa fa-fw fa fa-question-circle"></i> MENU 5</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row" id="main" >
                <div class="col-sm-12 col-md-12 well" id="content">
                    	 <h2>Welcome Admin!</h2>
                    <h4>UserId: ${admin_session}</h4> 
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div><!-- /#wrapper -->









	<h1><font color="green">${user_inserted}</font></h1>

<center>
	<h1><font color="green">${user_inserted}</font></h1>
	<h1><font color="orange">Feed User Form</font></h1>
		
		<table>
		<form action="./insertuser" id="form1" method="post">	
			
			<tr><td>First Name :</td><td><input type="text" name="firstname" id="firstname" placeholder="Enter Name" required/></td></tr>
			
			<tr><td><font color="red" size="4"><div id="name1"></div></font></td><tr>
			
			<tr><td>Last Name :</td><td><input type="text" name="lastname" id="lastname" required/></td></tr>
			
			<tr><td><font color="red" size="4"><div id="name2"></div></font></td><tr>
			
			
			<tr><td>E-mail :</td><td><input type="email" name="emailid" id="emailid" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Enter emailid" id="i1" required/></td></tr>
			<tr id="passwordrow"><td>Password :</td><td><input type="text" id="i2" name="password" title="Enter your password" required/></td></tr>
		
		<tr id="designationrow">
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
			<td><input type="text"  id="id1" value="0"  maxlength="3" name="newemployeeid" placeholder="select employee id" required/></td>
		</tr>
			
		<tr id="feedsupportid">
			<td>New Manager Id:</td>
			<td><input type="text"  id="id2" value="0"  maxlength="3" name="newmanagerid" placeholder="select manager id" required /></td>
		</tr>	
		<tr id="its">
			<td>New Support Id:</td>
			<td><input type="text"  id="id3" value="0"  maxlength="3" name="newsupportid" placeholder="select support id" required/></td>
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
									
			<tr id="mobilerow"><td>Mobile :</td><td><input type="text" name="mobile" id="mobile"  required/></td></tr>
			
			<font color="red" size="4"><div id="mobile1"></div></font>
			
			<tr id="dateofjoiningrow"><td>Date Of Joining :</td><td><input type="date" id="datepicker" name="dateofjoining" required/></td></tr>
			<tr id="submitrow"><td><input type="submit" value="submit"/></td></tr>
		</form>
		</table>

		
		
		
		
	</center>
</body>
</html>
