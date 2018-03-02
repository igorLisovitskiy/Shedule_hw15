<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<br/>
<%= (String)request.getAttribute("data") %>
<table>
    <c:forEach items="${data}" var="professors"> 
      <tr>
         <td><c:out value="${professors.getId}"/></td>
         <td><c:out value="${professors.getName}"/></td>
      </tr>
    </c:forEach>>
    </table>
</body>
</html>