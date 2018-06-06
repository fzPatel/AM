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

.table_set{

margin-left:200px;
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
            <a class="navbar-brand" href="">
                <img src="https://imgur.com/TIiwKNq.jpg" height="60px" width="200px" alt="LOGO"">
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li><a href="#" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Stats"><i class="fa fa-fw fa-user"></i>
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
                    <a href="retriveAllocatedAssets"><i class="fa fa-fw fa-question-circle"></i>VIEW ALLOCATED ASSET</a>
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

<div class="table_set">
<center>
<%@page import="com.asset_management.beans.UserBean" %>
    <%@page import="java.util.ArrayList" %>

	<%
		ArrayList<UserBean> al=(ArrayList)request.getAttribute("users_arraylist");
		if(al!=null)
		{
			%>
			<center>
			<font color="orange"><h1>All Users</h1></font>
			${user_updated}
				<table border="3">
				<tr>			
					
					<td><font color="orange"> First Name</font></td>
					<td><font color="orange"> Last Name</font></td>
					<td><font color="orange"> Email Id</font></td>
					<td><font color="orange"> Designation</font></td>
					<td><font color="orange"> Manager Id</font></td>
					<td><font color="orange"> Employee Id</font></td>
					<td><font color="orange">Support Id</font></td>				
					
					<td><font color="orange">Mobile </font></td>
					<td><font color="orange">Date Of Joining</font></td>					
					<td><font color="orange">Status</font></td>
					<td><font color="orange">Promotion</font></td>
					<td><font color="orange">Active</font></td>
					<td><font color="orange">Deactive</font></td>
					
				</tr>
				
				
						<%
						
							for(UserBean l:al)
							{
								%>
									<tr>
										<td><%=l.getFirstname()%>&nbsp;</td>
										<td><%=l.getLastname()%>&nbsp;</td>
										<td><%=l.getEmailid()%>&nbsp;</td>
										<td><%=l.getDesignation()%>&nbsp;</td>
										<td><%=l.getManagerid()%>&nbsp;</td>									
										<td><%=l.getEmployeeid()%>&nbsp;</td>
										<td><%=l.getSupportid()%>&nbsp;</td>										
										<td><%=l.getMobile()%>&nbsp;</td>										
										<td><%=l.getDateofjoining()%>&nbsp;</td>
										
																				
										<%-- <td><%=l.getStatus()%>&nbsp;</td> --%>
										<%
											if(l.getStatus().equals("A"))
											{
												%>
													<td><center><font color="blue">Activated</font></center></td>
												<%
											}
											else if(l.getStatus().equals("D"))
											{
												%>
													<td><center><font color="red">Deactivated</font></center></td>
												<%
											}
										%>
									
										
										<% 
											/* if(!l.getDesignation().equals("manager")&&l.getStatus().equals("A")) */
											if(l.getStatus().equals("A"))
											{
										%>
											<td>
											<form action="./promotion">
												<input type="hidden" name="emailid" value="<%=l.getEmailid()%>"/>&nbsp;
												<input type="hidden" name="designation" value="<%=l.getDesignation()%>"/>&nbsp;
												<input type="hidden" name="firstname" value="<%=l.getFirstname()%>"/>&nbsp;
												<input type="hidden" name="lastname" value="<%=l.getLastname()%>"/>&nbsp;
												<input type="hidden" name="managerid" value="<%=l.getManagerid()%>"/>&nbsp;
												<input type="hidden" name="employeeid" value="<%=l.getEmployeeid()%>"/>&nbsp;
												<input type="hidden" name="supportid" value="<%=l.getSupportid()%>"/>&nbsp;
										
											<input type="submit" name="submit" value="Promotion & Demotion"/>&nbsp;	
											</td>											
											</form>
											<%
												}
											else
											{
												%>
													<td><font color="red"><center>Activate person first</center></font></td>
												<%	
											}											
											%>
										<%-- <td>
											<form action="./">
												<input type="hidden" name="hidden3" value="<%=l.getEmailid()%>"/>&nbsp;
												<input type="hidden" name="hidden4" value="<%=l.getAuto()%>"/>&nbsp;
												<input type="submit" name="submit" value="Demotion"/>&nbsp;												
											</form>
										</td>
										 --%>
										<td>
										<center>
											<form action="./activeuser">
											
												<input type="hidden" name="hidden1" value="<%=l.getEmailid()%>"/>&nbsp;												
												<input type="submit" name="submit" value="Active"/>&nbsp;												
											</form>
										</center>
										</td>
										<td>
										<center>
											<form action="./deactiveuser">
												<input type="hidden" name="hidden2" value="<%=l.getEmailid()%>"/>&nbsp;
												
												<input type="submit" name="submit" value="Deactive"/>&nbsp;												
											</form>
										</center>
										</td>
											
										
									</tr>
								<%
							}
						%>
				</table>
				</center>				
	
	<%
		}
	%>
	

</center>

</div>
</body>
</html>
