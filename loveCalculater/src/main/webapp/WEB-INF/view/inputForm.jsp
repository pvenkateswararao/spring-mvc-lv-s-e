<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
	.cssErrors{
	padding-left:30px;
		color:red;
		position: fixed;
	}
	
	</style>
</head>
<body>

<H1 align="center"> Love Calculater</H1>

<h3>Hi ${userDetails.userName}</h3>
<div align = "center">
<hr/>
<form:form action="calculate-love" modelAttribute="userDetails" >
	<label for ="userName">User Name : </label>
	<form:input id="userName" name="userName" path="userName"></form:input>
	<form:errors  class="cssErrors" path="userName"></form:errors>
	<br/>
	<br/>
	<label for ="crushName">Crush Name : </label>
	<form:input id="crushName" name="crushName" path="crushName"></form:input>
	<form:errors  class="cssErrors" path="crushName"></form:errors>
	<br/>
	<br/>
	<label for ="fullName">Full Name : </label>
	<form:input id="fullName" name="fullName" path="fullName"></form:input>
	<form:errors  class="cssErrors" path="fullName"></form:errors>
	<br/>
	<br/>
	<br/>
	<form:button type="submit">Calculate</form:button>
	
</form:form>
Logout
<form:form action="logout" method="POST">
<input type="submit" value = "logout"/>
</form:form>
</div>
</body>
</html>