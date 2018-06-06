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
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">User Support <b class="fa fa-angle-down"></b></a>
                <ul class="dropdown-menu">
                    <li><a href=""><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
                    <li><a href=./changesupportpassword><i class="fa fa-fw fa-cog"></i> Change Password</a></li>
                    <li class="divider"></li>
                    <li><a href="./logout"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
               <li>
                    <a href="#" data-toggle="collapse" data-target=""> </a>
                    
                </li>
                <li>
                    <a href="#" data-toggle="collapse" data-target=""> </a>
                   
                </li>
              
              
                <li>
		      <a href="./viewassetrequest" data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-user-plus"> </i> VIEW ASSET REQUEST </i></a>
                </li>
                <li>
			     <a href="./viewreports" data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-user-plus"> </i> VIEW REPORTS </i></a>
                </li>
                
                <li>
				 <a href="./retrivesupportdetails" data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-user-plus"> </i>UPDATE PROFILE </i></a>
                </li>
                
                <li>
		      <a href="./changesupportpassword" data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-user-plus"> </i> CHANGE PASSWORD</i></a>
                </li>
                 
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>







<!-- 

 <h3>User Designation=<font color="blue">${user_designation}</h3></font>
-->



    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row" id="main" >
                <div class="col-sm-12 col-md-12 well" id="content">
				<h1>Welcome Support</h1>
                <h4>Support ID ${support_session}</h4> 
                                     </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div><!-- /#wrapper -->






<center>

<%@page import="com.asset_management.beans.*" %>
    <%@page import="java.util.ArrayList" %>

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
