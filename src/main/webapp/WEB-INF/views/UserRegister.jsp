<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to User Register page</h3>

<form:form action="save" method="POST" modelAttribute="user">
<pre>
NAME : <form:input path="userName"/>
EMAIL: <form:input path="userEmail"/>
PWD  : <form:password path="userPwd"/>
ROLES:
  <form:checkbox path="roles" value="ADMIN"/> ADMIN
  <form:checkbox path="roles" value="MANAGER"/> MANAGER
  <input type="submit" value="Register"/>
</pre>
</form:form>
${message}
</body>
</html>