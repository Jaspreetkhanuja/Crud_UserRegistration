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
import com.ignek.crud.db.operations.UserOperations;
import com.ignek.crud.dto.User;

@WebServlet("/userOperation")
public class UpdateAndDeleteUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String editUserId = request.getParameter(UserConstant.EDIT_USER_ID);
		String deleteUserId = request.getParameter(UserConstant.DELETE_USER_ID);

		if (editUserId != null && !editUserId.isEmpty()) {
			getUserByUserId(request, response, Integer.parseInt(editUserId));
		}
		if (deleteUserId != null && !deleteUserId.isEmpty()) {
			deleteUser(request, response, Integer.parseInt(deleteUserId));
		}
	}

	private void getUserByUserId(HttpServletRequest request, HttpServletResponse response, int userId)
			throws ServletException, IOException {
		try {
			User existingUser = UserOperations.getUser(userId);
			request.setAttribute(UserConstant.EXISTING_USER, existingUser);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userForm.jsp");
			requestDispatcher.forward(request, response);
		} catch (NumberFormatException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response, int userId)
			throws ServletException, IOException {
		try {
			boolean deleted = UserOperations.deleteUser(userId);
			if (deleted) {
				List<User> userList = UserOperations.getAllUsers();
				request.setAttribute(UserConstant.USER_LIST, userList);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListsOfUsers.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
