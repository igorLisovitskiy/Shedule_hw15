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
      <form action = "schedule" method = "GET">
       <h4>Number of:</h4>
         Days <input type = "text" name = "days">
         <br/>
         Subjects <input type = "text" name = "subjects" />
         <br/>
         Audiences <input type = "text" name = "audiences" />
         <br/>
         <input type = "submit" value = "Submit" />
          <br/>
      </form>
       <br/>
       <button type="button" onclick="location.href = 'schedule?select=all'" id="select-all">Select all</button>
       <br/>
	<%=request.getAttribute("data")%>
</body>
</html>