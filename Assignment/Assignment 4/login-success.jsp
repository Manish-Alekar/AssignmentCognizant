<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%@page import="com.cts.Login"%>  
      
    <p>You are successfully logged in!</p>  
    <%  
    Login login=(Login)request.getAttribute("login");  
    out.print("Welcome, "+login.getName());  
    %>  
</body>
</html>