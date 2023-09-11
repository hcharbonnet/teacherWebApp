<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
	<ul><!-- nav bar -->
	       	<li><a href="/../teacherWebApp/">Home</a></li>
    </ul>
    <h2>Please enter student's information below.</h2>
	<form action="/teacherWebApp/registration" method="post">
		Student's First Name: <input type="text" name="firstName" required /><br>
		Student's Last Name: <input type="text" name="lastName" required /><br>
		Student ID: <input type="text" name="id" required /><br>
		Studnet's Email: <input type="email" name="email" required /><br>
		Student GPA: <input type="text" name="gpa"/><br>
		
		<br>
		<input type="submit" value="Register!">
		
	</form>
</body>
</html>