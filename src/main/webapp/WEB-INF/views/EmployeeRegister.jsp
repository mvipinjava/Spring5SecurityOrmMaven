<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err{
	color: red;
}
</style>
</head>
<body>
<a href="../logout">Logout</a>
<h3>Welcome to Employee Register Page</h3>
<form:form action="save" method="POST" modelAttribute="employee">
<pre>
NAME  : <form:input path="empName"/>
 <form:errors path="empName" cssClass="err"/>
SAL   : <form:input path="empSal"/>
 <form:errors path="empSal" cssClass="err"/>
DEPT  : <form:select path="empDept">
			<form:option value="">-SELECT-</form:option>
			<form:option value="DEV">DEV</form:option>
			<form:option value="QA">QA</form:option>
			<form:option value="BA">BA</form:option>
		</form:select> 
 <form:errors path="empDept" cssClass="err"/>
GENDER: 
      <form:radiobutton path="empGen" value="Male"/> Male
      <form:radiobutton path="empGen" value="Female"/> Female
 <form:errors path="empGen" cssClass="err"/>
ADDRESS:
   <form:textarea path="empAddr"/>      
   <form:errors path="empAddr" cssClass="err"/>
	<input type="submit" value="Register"/>
</pre>
</form:form>
${message}
</body>
</html>