package com.ignek.crud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.crud.db.operations.UserInsert;
import com.ignek.crud.dto.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname"); 
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String phonenumber = request.getParameter("phonenumber");
        String emailaddress = request.getParameter("emailaddress");
        String course = request.getParameter("course");
        String subjects = request.getParameter("subjects");
        
        
        System.out.println("firstname=====>" + firstname);
        System.out.println("lastname=====>" + lastname);
        System.out.println("gender=====>" + gender);
        System.out.println("phonenumber=====>" + phonenumber);
        System.out.println("emailaddress=====>" + emailaddress);
        System.out.println("course=====>" + course);
        System.out.println("subjects=====>" + subjects);
        
        
        User user = new User();
        
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setGender(gender);
        user.setPhoneNumber(phonenumber);
        user.setEmailAddress(emailaddress);
        user.setCourse(course);
        user.setSubjects(subjects);
        
       int result =  UserInsert.insertUser(user);
		if (result > 0) {
			System.out.println("Successfully done");
		}
		
	}

}
