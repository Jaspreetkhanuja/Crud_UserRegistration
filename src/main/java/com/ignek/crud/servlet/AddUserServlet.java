package com.ignek.crud.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.crud.constant.UserConstant;
import com.ignek.crud.db.operations.UserServices;
import com.ignek.crud.dto.User;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userIdString = request.getParameter(UserConstant.USER_ID);
			String firstname = request.getParameter(UserConstant.FIRST_NAME);
			String lastname = request.getParameter(UserConstant.LAST_NAME);
			String gender = request.getParameter(UserConstant.GENDER);
			String phonenumber = request.getParameter(UserConstant.PHONE_NUMBER);
			String emailaddress = request.getParameter(UserConstant.EMAIL_ADDRESS);
			String course = request.getParameter(UserConstant.COURSE);

			String[] subjectsArray = request.getParameterValues(UserConstant.SUBJECTS);
			String subjects = String.join(UserConstant.COMMA, subjectsArray);

			int userId = userIdString != null && !userIdString.isEmpty() ? Integer.parseInt(userIdString) : 0;

			User user = new User(userId, firstname, lastname, gender, emailaddress, phonenumber, course, subjects);

			int result = 0;

			if (userId > 0) {
				result = UserServices.updateUser(user);
			} else {
				result = UserServices.insertUser(user);
			}

			if (result > 0) {
				List<User> userList = UserServices.getAllUsers();
				request.setAttribute(UserConstant.USER_LIST, userList);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListsOfUsers.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
