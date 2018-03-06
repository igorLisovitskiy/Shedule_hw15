<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.lisovitskiy.hw15.model.*"%> 
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "ex" uri = "WEB-INF/PrintList.tld"%>
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
  <jsp:include page="styles.css"/>
</style>
<title>Schedule app</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	  $("select.main").on("change", function(){
	    $("input.values.active").removeClass("active");
	    var subVal = $("input.values." + $(this).val());
	    if (subVal.length){
	      subVal.addClass("active");
	    }
	  });
});

$('#form').on('submit', function(e) {
    e.preventDefault();
    $.ajax({
    url : "schedule",
    type: "GET",
    data: $('#form').serialize(),
    success: function (data) {
       $("#schedule").html(data);
       },
        error: function (jXHR, textStatus, errorThrown) {
         alert(errorThrown);
         }
     });
});

</script>
</head>
	<body>
		<h3>Welcome to the Schedule App</h3>
		<div>
			<form id=form>
				<select class='main' name="action">
					<option value='0'> Show all</option>
			   		<option value='1'> Show all professors</option>
			  		<option value='2'> Show professors not working on the day</option>
			  		<option value='3'> Show professors working on day and in the audience </option>
			    	<option value='4'> Show days with the number of occupied audiences </option>
				  	<option value='5'> Show days by number of lessons </option>
				</select>
					<input class='values 2' id="day-2" name="day-2" placeholder="Day..."></input>
					<input class='values 3' id="day-3" name="day-3" placeholder="Day..."></input>
					<input class='values 3' id="audience-3" name="audience-3" placeholder="Audience..."></input>
					<input class='values 4' id="audience-4" name="audience-4" placeholder="Number of audiences..."></input>
					<input class='values 5' id="lessons-5" name="lessons-5" placeholder="Number of lessons..."></input>
			<button type="submit" class="submit btn" formaction="schedule">Submit</button>
			</form>
		</div>
		<div id="schedule">
			<br>
		 	<table border="1" >
		 		 <tbody>
					<c:if test="${not empty profListAll}">
		    			<ex:printProfList list = "${profListAll}"/>
					</c:if>
						<c:if test="${not empty profListNotworkingOn}">
		    			<ex:printProfList list = "${profListNotworkingOn}"/>
					</c:if>
						<c:if test="${not empty profListOnDayInAudience}">
		    			<ex:printProfList list = "${profListOnDayInAudience}"/>
					</c:if>
					
					<c:if test="${not empty daysByAudiences}">
		    			<ex:printDayList list = "${daysByAudiences}"/>
					</c:if>
					<c:if test="${not empty daysByLessons}">
		    			<ex:printDayList list = "${daysByLessons}"/>
					</c:if>
					
		 	 	 </tbody>
		 	 </table>
		 </div>
	</body>
</html>