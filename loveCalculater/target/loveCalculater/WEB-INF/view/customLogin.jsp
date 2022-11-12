<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form:form>
	<p> Login to App</p>
	<br/>
	User Name : <input type="text" name="username"/>
	<br/>
	Password : <input type="password" name="password"/>
	<br/>
	<input type="submit" value="login"></input>
	
</form:form>
</body>
</html>