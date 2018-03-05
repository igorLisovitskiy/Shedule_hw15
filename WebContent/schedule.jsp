<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.lisovitskiy.hw15.model.*"%> 
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
  <jsp:include page="styles.css"/>
</style>
<title>Schedule app</title>
</head>
	<body>
		<h1>Schedule</h1>
	<c:out value="${'Welcome!'}"/>
	<br>
	<table border="1">
  		<thead>
		    <th>ID</th>
		    <th>Name</th>
  		</thead>
 		 <tbody>
		     <c:forEach items="${list}" var="professor">
		       <tr>
		         <td>${professor.id}</td>
		         <td>${professor.name}</td>
		       </tr>
   			 </c:forEach>
 		 </tbody>
 	 </table>
	</body>
</html>