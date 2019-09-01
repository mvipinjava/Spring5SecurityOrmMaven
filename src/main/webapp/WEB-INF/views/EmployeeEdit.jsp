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
<a href="../logout">Logout</a>
<h3>Welcome to Employee Edit Page</h3>
<form:form action="update" method="POST" modelAttribute="employee">
<pre>
ID    : <form:input path="empId" readonly="true"/>
NAME  : <form:input path="empName"/>
SAL   : <form:input path="empSal"/>
DEPT  : <form:select path="empDept">
			<form:option value="">-SELECT-</form:option>
			<form:option value="DEV">DEV</form:option>
			<form:option value="QA">QA</form:option>
			<form:option value="BA">BA</form:option>
		</form:select> 
GENDER: 
      <form:radiobutton path="empGen" value="Male"/> Male
      <form:radiobutton path="empGen" value="Female"/> Female
ADDRESS:
   <form:textarea path="empAddr"/>      
	<input type="submit" value="Update"/>
</pre>
</form:form>
</body>
</html>