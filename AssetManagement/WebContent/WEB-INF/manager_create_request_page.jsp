<html>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Create Request</title>

<style type="text/css">

body{
background-image:url('https://imgur.com/p7L8a5E.jpg');
background-size:cover;
height:100%;
}
</style>

</head>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
   <a href="./BackbtnMangerhome"><img src="assetManagement.png"   width="110px" height="70px" alt="logo" /></a>
        </div>
    <div>
      <ul class="nav navbar-nav">
	<li><a href="./BackbtnMangerhome" >Home</a></li>
	   <li><a href="./logout">logout</a></li>
      </ul>  
    </div>
  </div>
</nav>




<%@page import="org.springframework.web.bind.annotation.SessionAttributes"%>

<center>
<h1><font color="Green"> ${oh}</font></h1> 
	<h2><font color="blue"> Welcome: Manager</font></h2> 
	<h3><font color="blue"> Your ID: ${user_session}</font></h3> 
	
		
		
		<h3><font color="green">${msg}</font></h3> 
	<table>
		   <h2>Select Asset </h2>
            <form action="./submitManagerRequest" method="post">
            	
         Select Asset   <select name="assetname" id="select1">
						<option value="laptop" >Laptop</option>
						<option value="simcard">SimCard</option>
						<option value="pendrive" >Pendrive</option>
						<option value="desk">Desk</option>
		</select>
		
<%@page import="java.util.ArrayList,com.asset_management.beans.*"%>
<%UserBean ub=(UserBean)session.getAttribute("My_Request_To_Id&MyEmail"); 
String emailid=ub.getEmailid();
int sid=ub.getSupportid();
	%>	
		
<input type="hidden" name="managerid" value="<%=session.getAttribute("user_session")%>"/>&nbsp;
       <input type="Hidden" name="emailid" value="<%=emailid%>"/>&nbsp;
        <input type="text" name="supportid" size="5px" value="<%=sid%> "readonly/>&nbsp;
           
			 <br/><input type="submit" value="Submit" Onclick="return confirm('Are you sure You want to Create Request')">
				
         </table>
         </form>
        
</center>


</body>

</html>


