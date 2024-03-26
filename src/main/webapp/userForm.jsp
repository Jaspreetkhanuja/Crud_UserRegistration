<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>
</head>
<center>
	<body>
		<form action="GetUserServlet" method="post">
			<input type="submit" value="View All User Details" />
		</form>
		<br />

		<h1>Add New User</h1>
		<form action="AddUserServlet" method="post">
			<label for="firstname">FirstName:</label><br> <input type="text"
				id="firstname" name="firstname" /><br /> <label for="lastname">LastName:</label><br>
			<input type="text" id="lastname" name="lastname" /><br /> <label
				for="phonenumber">PhoneNumber:</label><br> <input type="tel"
				id="phonenumber" name="phonenumber" /><br /> <label for="email">EmailAddress:</label><br>
			<input type="email" id="email" name="email" /><br /> <label>Gender:</label><br>
			<input type="radio" id="male" name="gender" value="male" /><label
				for="male">Male</label><br> <input type="radio" id="female"
				name="gender" value="female" /><label for="female">Female</label><br>

			<label for="course">Course:</label><br> <select id="course"
				name="course" style="width: 155px">
				<option value="B.Tech">B.Tech</option>
				<option value="BBA">BBA</option>
				<option value="BCA">BCA</option>
				<option value="MCA">MCA</option>
				<option value="Other">Other</option>
			</select><br /> <label>Select your subjects:</label><br /> <input
				type="checkbox" id="mathematics" name="subjects" value="Mathematics" /><label
				for="mathematics">Mathematics</label><br> <input
				type="checkbox" id="english" name="subjects" value="English" /><label
				for="english">English</label><br> <input type="checkbox"
				id="physics" name="subjects" value="Physics" /><label for="physics">Physics</label><br>
			<input type="checkbox" id="chemistry" name="subjects"
				value="Chemistry" /><label for="chemistry">Chemistry</label><br>
			<input type="checkbox" id="physical_education" name="subjects"
				value="Physical Education" /><label for="physical_education">Physical
				Education</label><br> 
				<button type="submit" class="btn btn-success">Save</button>
				
		</form>
	</body>
</center>
</html>
