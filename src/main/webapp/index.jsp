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
</style>
    
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 80vh;
    }

   
    button {
        padding: 15rem 30rem; 
        font-size: 20rem; 
    }
</style>
</head>
<body>
    <form action="GetUserServlet" method="post" class="form-inline">
        <button type="submit">Go to User Management System</button>
    </form>
</body>
</html>
