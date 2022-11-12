<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Hi ${userDetails.userName}</h3>
<div align="center">
<form:form action="/loveCalculater/send-mail" modelAttribute="emailDetails">
<label for="email">Email : </label>
<form:input path="email" id="email" /> 
<br/>
<br/>
<form:button type="submit">Submit</form:button>
</form:form>

</div>
</body>
</html>