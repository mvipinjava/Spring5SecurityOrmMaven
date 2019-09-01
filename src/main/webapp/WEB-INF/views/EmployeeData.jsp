<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="../logout">Logout</a>
<h3>Welcome to Employee Page</h3>
<table border="1">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>SAL</th>
		<th>DEPT</th>
		<th>GEN</th>
		<th>ADDR</th>
		<th colspan="2">OPERATIONS</th>
		
	</tr>
	
	<c:forEach items="${list}" var="ob"> 
		<tr>
			<td><c:out value="${ob.empId}"/> </td>
			<td><c:out value="${ob.empName}"/> </td>
			<td><c:out value="${ob.empSal}"/> </td>
			<td><c:out value="${ob.empDept}"/> </td>
			<td><c:out value="${ob.empGen}"/> </td>
			<td><c:out value="${ob.empAddr}"/> </td>
			<td>
				<a href="delete?id=${ob.empId}">DELETE</a>
			</td>
			<td>				
				<a href="edit?id=${ob.empId}">EDIT</a>
			</td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>