<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>
<style>
body {
	text-align: center;
}

.form-group {
	margin-bottom: 0.625rem;
	align-items: center;
}

.form-group label {
	width: 6.25rem;
	text-align: right;
	margin-right: 0.625rem;
}

.form-group input[type="text"], .form-group input[type="tel"],
	.form-group input[type="email"], .form-group select {
	flex: 1;
	width: 12.5rem;
}

.form-group input[type="radio"], .form-group input[type="checkbox"] {
	flex: unset;
}

.required::after {
	content: "*";
	color: red;
}
</style>
</head>
<body>
	<center>
		<form action="AddUserServlet" method="post">
			<input type="hidden" name="userId" value="${existingUser.userId}" />
			<h2>
				<c:choose>
					<c:when test="${existingUser != null}">
                    Edit User
                </c:when>
					<c:otherwise>
                    Add New User
                </c:otherwise>
				</c:choose>
			</h2>

			<div class="form-group">
				<label for="firstName" class="required">First Name:</label> <input
					type="text" id="firstName" name="firstName"
					value="${existingUser.firstName}" required />
			</div>

			<div class="form-group">
				<label for="lastName" class="required">Last Name:</label> <input
					type="text" id="lastName" name="lastName"
					value="${existingUser.lastName}" required />
			</div>

			<div class="form-group">
				<label for="phoneNumber" class="required">Phone Number:</label> <input
					type="tel" id="phoneNumber" name="phoneNumber"
					value="${existingUser.phoneNumber}" required />
			</div>

			<div class="form-group">
				<label for="email" class="required">Email Address:</label> <input
					type="email" id="email" name="emailAddress"
					value="${existingUser.emailAddress}" required />
			</div>

			<div class="form-group">
				<label class="required">Gender:</label> <input type="radio"
					id="male" name="gender" value="male"
					${existingUser.gender == 'male' ? 'checked' : ''} required /> <label
					for="male">Male</label> <input type="radio" id="female"
					name="gender" value="female"
					${existingUser.gender == 'female' ? 'checked' : ''} required /> <label
					for="female">Female</label>
			</div>

			<div class="form-group">
				<label for="course" class="required">Course:</label> <select
					id="course" name="course" required>
					<option value="B.Tech"
						${existingUser.course == 'B.Tech' ? 'selected' : ''}>B.Tech</option>
					<option value="BBA"
						${existingUser.course == 'BBA' ? 'selected' : ''}>BBA</option>
					<option value="BCA"
						${existingUser.course == 'BCA' ? 'selected' : ''}>BCA</option>
					<option value="MCA"
						${existingUser.course == 'MCA' ? 'selected' : ''}>MCA</option>
					<option value="Other"
						${existingUser.course == 'Other' ? 'selected' : ''}>Other</option>
				</select>
			</div>

			<div class="form-group">
				<label class="required">Select your subjects:</label><br> 
				<input
					type="checkbox" id="mathematics" name="subjects"
					value="Mathematics"
					${existingUser.subjects.contains('Mathematics') ? 'checked' : ''} />

				<label for="mathematics">Mathematics</label><br> 
				<input
					type="checkbox" id="english" name="subjects" value="English"
					${existingUser.subjects.contains('English') ? 'checked' : ''} /> 
					
				<label for="english">English</label><br> 
				<input type="checkbox"
					id="physics" name="subjects" value="Physics"
					${existingUser.subjects.contains('Physics') ? 'checked' : ''} /> 
					
				<label for="physics">Physics</label><br> 
				<input type="checkbox"
					id="chemistry" name="subjects" value="Chemistry"
					${existingUser.subjects.contains('Chemistry') ? 'checked' : ''} />

				<label for="chemistry">Chemistry</label><br> 
				<input
					type="checkbox" id="physical_education" name="subjects"
					value="Physical Education"
					${existingUser.subjects.contains('Physical Education') ? 'checked' : ''} />

				<label for="physical_education">Physical Education</label><br>
			</div>

			<button type="submit" id="submit" class="btn btn-success">Save</button>
			<input type="reset" value="Reset" />

		</form>
		</form>
	</center>
</body>
</html>