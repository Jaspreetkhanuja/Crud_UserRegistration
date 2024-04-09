<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management System</title>

<style>
  .inline-form {
    display: inline;
  }
  
table {
	border-collapse: collapse;
	width: 80%;
	margin: auto;
}

th, td {
	border: 1px solid black;
	padding: 0.5rem;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
<script>
	function confirmDelete(userId) {
		var result = confirm("Are you sure you want to delete this user?");
		if (result) {
			document.getElementById("deleteForm_" + userId).submit();
		}
	}
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/userForm.jsp" method="get"
		class="inline-form">
		<button type="submit" class="btn btn-success">Add New User</button>
	</form>

	<h2 style="text-align: center;">Lists of Users</h2>

	<table>
		<thead>
			<tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Phone Number</th>
				<th>Email Address</th>
				<th>Course</th>
				<th>Subjects</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.gender}" /></td>
					<td><c:out value="${user.phoneNumber}" /></td>
					<td><c:out value="${user.emailAddress}" /></td>
					<td><c:out value="${user.course}" /></td>
					<td><c:out value="${user.subjects}" /></td>
					<td><a
						href="${request.getContextPath()}userOperation?editUserId=${user.userId}"
						class="button">Edit</a> <a
						href="${request.getContextPath()}userOperation?deleteUserId=${user.userId}"
						class="button"
						onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
