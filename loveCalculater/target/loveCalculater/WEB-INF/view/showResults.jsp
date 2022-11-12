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
<hr/>
<br/>
Full Name: ${userDetails.fullName.firstName} ${userDetails.fullName.lastName}
<br/>
<br/>
User Name: ${userDetails.userName}
<br/>
<br/>
Crush Name: ${userDetails.crushName}
<br/>

results : ${results}
<br/>
<br/>
<a href="/loveCalculater/send-mail-input">SendMail</a>
</body>
</html>