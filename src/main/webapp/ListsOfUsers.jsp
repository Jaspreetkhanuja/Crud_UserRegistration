<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>

<style>
table {
	border-collapse: collapse;
	width: 80%;
	margin: auto;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>

	<h2 style="text-align: center;">User List</h2>

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
					 <td>
                    
                    <form action="UpdateUserServlet" method="post" style="display: inline;">
                        <input type="hidden" name="userId" value="${user.userId}" />
                        <button type="submit">Edit</button>
                    </form>
                    
                    <form action="DeleteUserServlet" method="post" style="display: inline;">
                        <input type="hidden" name="userId" value="${user.userId}" />
                        <button type="submit">Delete</button>
                    </form>
                </td>
			        
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
