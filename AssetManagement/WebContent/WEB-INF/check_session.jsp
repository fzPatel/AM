<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />



<head>
<%  
 HttpSession customss=request.getSession();
int customersession=(int)customss.getAttribute("user_session");
 
if(customersession!=0)
		{	
			out.println(customersession);
			response.sendRedirect("manager.jsp");
		}
else if(customersession==0){
			RequestDispatcher rd=request.getRequestDispatcher("user_login.jsp");
			request.setAttribute("loginfirst","Please login First");
			rd.forward(request, response);
}%>

 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AssetManagemet</title>
    </head>
  
 
    
</html>
 