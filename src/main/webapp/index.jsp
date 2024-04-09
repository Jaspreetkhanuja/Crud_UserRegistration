<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style>

<style>
  .form-inline {
    display: inline;
  }

   
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 80vh;
    }

   
    button {
        padding: 0.938rem 1.875rem; 
        font-size: 1.25rem; 
    }
</style>
</head>
<body>
    <form action="GetUserServlet" method="post" class="form-inline">
        <button type="submit">Go to User Management System</button>
    </form>
</body>
</html>
