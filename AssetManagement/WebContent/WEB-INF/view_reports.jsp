<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.asset_management.beans.AllocatedAssetsBean" %>
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
		ArrayList<AllocatedAssetsBean> al=(ArrayList<AllocatedAssetsBean>)request.getAttribute("reports_arraylist");
		if(al!=null)
		{
			%>
			<center>
			<font color="orange"><h1>Reports</h1></font>
			${user_updated}
				<table border="3">
				<tr>			
					
					
					<td><font color="orange"> Asset Id</font></td>
					<td><font color="orange"> User Id</font></td>					
					<td><font color="orange"> Asset Name</font></td>
					<td><font color="orange"> Date Of Allocation</font></td>
					<td><font color="orange"> Email Id</font></td>
					
				</tr>
				
				
						<%
						
							for(AllocatedAssetsBean l:al)
							{
								%>
									<tr>
										<td><%=l.getAssetid()%>&nbsp;</td>
										<td><%=l.getUserid()%>&nbsp;</td>
										<td><%=l.getAssetname()%>&nbsp;</td>										
										<td><%=l.getDateofallocation()%>&nbsp;</td>
										<td><%=l.getEmailid()%>&nbsp;</td>
							
										
						<!-- 				<td>
											<form action="./update_user">
												<input type="hidden" name="hidden3" value=""/>&nbsp;
												<input type="submit" name="submit" value="Update"/>&nbsp;												
											</form>
										</td>
										<td>
											<form action="./active_user">
												<input type="hidden" name="hidden1" value=""/>&nbsp;
												<input type="submit" name="submit" value="Active"/>&nbsp;												
											</form>
										</td>
										<td>
											<form action="./deactive_user">
												<input type="hidden" name="hidden2" value=""/>&nbsp;
												<input type="submit" name="submit" value="Deactive"/>&nbsp;												
											</form>
										</td>
											 -->
										
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