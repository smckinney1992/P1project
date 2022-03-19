<%@page import="java.util.Iterator"%>
<%@page import="com.training.ers.model.Users"%>
<%@page import="java.util.List"%>
<%@page import="com.training.jwa.dao.LoginDAOImpl"%>
<%@page import="com.training.jwa.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User's</title>
<link type="text/css" rel="stylesheet" href="styles.css">
</head>
<%
String username = (String) session.getAttribute("username");
%>
<h2>
	You are logged in as :
	<%=username%>
	and the message is :
	<%=session.getAttribute("message")%></h2>
<body>

	<%
	LoginDAO loginDAO = new LoginDAOImpl();
	List<Users> users = loginDAO.getUsers();
	Iterator<Users> iterator = users.iterator();
	%>
	<h1>List of all the users</h1>
	<table border="2" cellspacing="10" cellpadding="10">
		<th>User Id</th>
		<th>User Name</th>
		<th>Password</th>
		<th>Gender</th>
		<th>Notifications</th>
		<th>Qualifications</th>
		<%
		while (iterator.hasNext()) {
			Users user = iterator.next();
		%>
		<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=user.getGender()%></td>
			<td><%=user.getNotification()%></td>
			<td><%=user.getQualification()%></td>
		</tr>
		<%
		}
		%>

	</table>
	<br/>
	<br/>
	<br/>
	<br/>
	<a href="index.jsp">Logout</a>
</body>
</html>