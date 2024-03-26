package com.ignek.crud.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.crud.db.operations.UserUpdate;
import com.ignek.crud.dto.User;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("userId"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String phoneNumber = request.getParameter("phoneNumber");
            String emailAddress = request.getParameter("emailAddress");
            String course = request.getParameter("course");
            String subjects = request.getParameter("subjects");
            
            User updatedUser = new User(userId, firstName, lastName, gender, phoneNumber, emailAddress, course, subjects);
            
             boolean updated = UserUpdate.updateUser(updatedUser);
            
            if (updated) {
                // Redirect to success page if update is successful
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                // Redirect to error page if update fails
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (NumberFormatException | IOException e) {
            // Handle number format exception or IO exception
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
