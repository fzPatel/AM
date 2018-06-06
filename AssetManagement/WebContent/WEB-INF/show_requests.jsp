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

.tableid
{
margin-left:250px;
}


</style>
		
		<!--Ajax code for check Same Name Product if already exist  -->
		
		
		
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script type="text/javascript">





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




<div class="tableid">
<center>

<%@page import="com.asset_management.beans.RequestBean" %>
    <%@page import="java.util.ArrayList" %>


	<%
		ArrayList<RequestBean> al=(ArrayList)request.getAttribute("requests_arraylist");
		if(al!=null)
		{
			%>
			<center>
			<font color="orange"><h1>All Users</h1></font>
			${user_updated}
				<table border="3">
				<tr>			
					
					<td><font color="orange"> Request Id</font></td>
					<td><font color="orange"> Employee id</font></td>
					<td><font color="orange"> Manager id</font></td>
					<!-- <td><font color="orange"> Support id </font></td> -->
					<td><font color="orange"> Request From</font></td>
					
					<td><font color="orange"> Designation</font></td>
					<td><font color="orange"> Asset Name</font></td>
					<td><font color="orange">Request Date </font></td>
					<td><font color="orange">Status</font></td>
					<td><font color="orange">Dispatch</font></td>
					<td><font color="orange">Reject</font></td>
					
					
				</tr>
				
				
						<%
						
							for(RequestBean l:al)
							{
								%>
									<tr>
										<td><%=l.getRequestid()%>&nbsp;</td>
										<td><%=l.getEmployeeid()%>&nbsp;</td>
										<td><%=l.getManagerid()%>&nbsp;</td>
										<%-- <td>${support_session}&nbsp;</td> --%>
										<td><%=l.getEmailid()%>&nbsp;</td>
										
										<td><%=l.getDesignation()%>&nbsp;</td>
										<td><%=l.getAssetname()%>&nbsp;</td>										
										<td><%=l.getRequestdate()%>&nbsp;</td>										
										<%
											if(l.getStatus()==1)
										{%>									
											<td><h6><font color="Green">Approved by manager</font></h6></td>
										
										<% 
										}
											else	if(l.getStatus()==0)
											{%>									
												<td><h6><font color="Red">Pending by manager</font></h6></td>
											
											<% 
											}
										
										else	if(l.getStatus()==2)
										{%>									
											<td><h6><font color="Red">Rejected by manager</font></h6></td>
										
										<% 
										}
										else if(l.getStatus()==3)
										{
										%>									
											<td><h6><font color="Orange">Pending by Support</font></h6></td>
										<%
										}
										else if(l.getStatus()==4)
										{%>									
											<td><h6><font color="green">Dispatched by Support</font></h6></td>
										<%
										}else if(l.getStatus()==5)

										{
											%>									
											<td><h6><font color="red">Rejected by Support</font></h6></td>
										<%
											
										}
										
										if((l.getDesignation().equals("manager"))||(l.getDesignation().equals("employee"))&&(l.getStatus()!=2)&&(l.getStatus()!=0))
										{
										%>
									
										<td>
											<form action="./approveandinsert" method="post">
												<input type="hidden" name="supportid" value="${support_session}"/>
												<input type="hidden" name="assetname" value="<%=l.getAssetname()%>"/>
												<input type="hidden" name="dateofallocation" value="<%=l.getManagerapproveddate()%>"/>
												<input type="hidden" name="emailid" value="<%=l.getEmailid()%>"/>
												<input type="hidden" name="employeeid" value="<%=l.getEmployeeid()%>"/>
												<input type="hidden" name="requestid" value="<%=l.getRequestid()%>"/>
												<input type="submit" name="submit" value="Dispatch"/>									
											</form>
										</td>
										<td>
											<form action="./cancelrequest" method="post">
												<input type="hidden" name="supportid" value="${support_session}"/>
												<input type="hidden" name="employeeid" value="<%=l.getEmployeeid()%>"/>
												<input type="hidden" name="requestid" value="<%=l.getRequestid()%>"/>
												<input type="submit" name="submit" value="Reject"/>
											</form>
										</td>
										
											<%
										}
											
										else {
											
											%>
											<td>	No operation performed by manager</td>
											<%
											
										}
											%>
										
									</tr>
								<%
							}
						%>
				</table>
				</center>				
			<%
		}else
		{
			
			%><center><h1> <font color="Red">No Pending Orders</font></h1></center><%
			
		}
	%>
	





</center>


</div>

</body>
</html>
