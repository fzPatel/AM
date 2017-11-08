<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.asset_management.beans.RequestBean" %>
    <%@page import="java.util.ArrayList" %>
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

	<font color="blue"><h1>${oh}</h1></font>
	<table>
		<tr><td><a href="./logout">logout</a></td></tr>
		<tr><td><a href="./supporthome">back</a></td></tr>
	</table>
		
	

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
										
										if((l.getDesignation().equals("manager"))||(l.getDesignation().equals("employee"))&&(l.getStatus()!=2))
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
											%>
										
									</tr>
								<%
							}
						%>
				</table>
				</center>				
			<%
		}
	%>
	
	
	
</body>
</html>