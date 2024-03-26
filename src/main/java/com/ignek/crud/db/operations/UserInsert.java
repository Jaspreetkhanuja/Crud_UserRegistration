package com.ignek.crud.db.operations;

import com.ignek.crud.dto.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ignek.crud.db.connection.DbConnection;

public class UserInsert {

	public static int insertUser(User user) {
		int result = 0;
		try {
			Connection connection = DbConnection.getConnection();
			String q = "insert into User(fName, lName, gender, phoneNumber, emailAddress, course, subjects) values (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(q);

			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getGender());
			pstmt.setString(4, user.getPhoneNumber());
			pstmt.setString(5, user.getEmailAddress());
			pstmt.setString(6, user.getCourse());
			pstmt.setString(7, user.getSubjects());

			result = pstmt.executeUpdate();
			System.out.println("result=====>" + result);
			System.out.println("Data inserted successfully");

			pstmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
