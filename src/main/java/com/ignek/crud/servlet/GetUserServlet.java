package com.ignek.crud.servlet;

import java.io.IOException;
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

@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<User> userList = UserServices.getAllUsers();
			request.setAttribute(UserConstant.USER_LIST, userList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListsOfUsers.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
