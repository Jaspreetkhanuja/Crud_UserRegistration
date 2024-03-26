package com.ignek.crud.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.crud.db.operations.UserGet;
import com.ignek.crud.dto.User;

@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
           
            UserGet userGet = new UserGet();
            List<User> userList = userGet.getAllUsers();
            
            System.out.println(userList.get(0).getFirstName());
            request.setAttribute("userList", userList);
            
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListsOfUsers.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
           
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
