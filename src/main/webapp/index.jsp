<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style>
    
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 80vh;
    }

   
    button {
        padding: 15px 30px; 
        font-size: 20px; 
    }
</style>
</head>
<body>
    <form action="GetUserServlet" method="post" style="display: inline;">
        <button type="submit">Go to User Management System</button>
    </form>
</body>
</html>
