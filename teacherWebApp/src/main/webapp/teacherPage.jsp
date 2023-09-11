<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher View</title>
</head>
<body>
	<ul><!-- nav bar -->
	       	<li><a href="/../teacherWebApp/">Home</a></li>
    </ul>
    <h2>Get a list of all students in your class</h2>

    <h2>Find a student in your class</h2>
    	<p>Please provide the ID of the student you are looking for:</p>
        <form action="/teacherWebApp/student/" method="get">
			Student ID: <input type="text" name="id" required /><br>
			<br>
			<input type="submit" value="Find Student">
		</form>
	
    <h2>Add a student to your class</h2>
    <h2>Update a student's information</h2>
   	<h2>Remove a student from your class</h2>
   	<h2>Remove all students from your class</h2>

</body>
</html>