<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Your Personal Info</h1>

<%
ArrayList<String> arrayInfo=(ArrayList<String>)session.getAttribute("personalInfo");
out.println("Id:"+arrayInfo.get(0));
out.println("<br>");
out.println("First name:"+arrayInfo.get(1));
out.println("<br>");
out.println("Second name:"+arrayInfo.get(2));
out.println("<br>");
out.println("User name:"+arrayInfo.get(3));
out.println("<br>");
out.println("Gender:"+arrayInfo.get(4));
out.println("<br>");
out.println("Email:"+arrayInfo.get(5));
out.println("<br>");
out.println("Locale:"+arrayInfo.get(6));
%>
 
</body>
</html>