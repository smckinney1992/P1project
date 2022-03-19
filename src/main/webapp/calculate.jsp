<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="styles.css">
</head>
<script type="text/javascript">
	
	function Add() {
		result=num1+num2
	}
	function Sub(){
		result=num1-num2
	}
	function Mul(){
		result=num1*num2
	}
	function Div(){
		result=num1/num2
	}
<%!
int num1;
int num2; 
public int addNums(int num1, int num2){
	return num1 + num2;
}
public int subNums(int num1, int num2){
	return num1 - num2;
}
public int mulNums(int num1, int num2){
	return num1 * num2;
}
public int divNums(int num1, int num2){
	return num1 / num2;
}%>
	<%
	num1 = Integer.parseInt(request.getParameter("number1"));
    num2 = Integer.parseInt(request.getParameter("number2"));
    %>
    <% 
    if(request.getParameter("operation").equals("Add")){%>
    <h1><%=addNums(num1, num2)%></h1>
    <% } else if (request.getParameter("operation").equals("Sub")) {%>
        <h1><%=subNums(num1, num2)%></h1><%
    } else if (request.getParameter("operation").equals("Mul")) {%>
        <h1><%=mulNums(num1, num2)%></h1><%
    } else {%>
        <h1><%=divNums(num1, num2)%></h1><%
    }%>

	
	
<body>

</body>
</html>