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

<font color="blue"><h1>${oh}</h1>
<center>
<h2> EMPLOYEE HOME</h2>
</center>

<h2>   
<center>
<font color="Green"> Welcome ${adminsession}
</center>
</font></h2>



<h3><a href="./Empviewmyprofile"> Profile</a></h3>
<h3><a href="./createrequestbyemp"> Create Request</a></h3>
<h3><a href="./EmpViewmyrequest">view My request</a></h3>
<h3><a href="./Myasset"> My assets</a></h3>
<h3><a href="./Assettranfer"> Asset Transfer</a></h3>
<h3> <a href="./ change_password"> Change your password</a></h3>

<h3><a href="./logout"> <h2>LOGOUT</h2> </a></h3>
</form>
</body>
</html>