<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.lisovitskiy.hw15.model.*"%> 
<%@ page import="java.util.ArrayList" %>
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

<%  
ArrayList<Professor> list = new ArrayList<Professor>();
list = (ArrayList<Professor>) request.getSession().getAttribute("list");
for(Professor p : list) {
    out.println(p.getId());
    out.println(p.getName());
}
%>
<%= (ArrayList<Professor>) request.getAttribute("list") %>
<table>
   <c:forEach items="${list}" var="professors">
        <tr>
            <td>${professors.id}</td>
            <td>${professors.name}</td>
        </tr>
    </c:forEach>
    </table>
 <c:if test="${empty list}">
    <i>The list is empty.</i>
  </c:if>
</body>
</html>