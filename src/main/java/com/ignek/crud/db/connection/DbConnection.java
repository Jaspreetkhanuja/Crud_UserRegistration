package com.ignek.crud.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ignek.crud.constant.UserConstant;

public class DbConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;

		Class.forName(UserConstant.JDBC_DRIVER);

		con = DriverManager.getConnection(UserConstant.DB_URL, UserConstant.DB_USERNAME, UserConstant.DB_PASSWORD);

		if (con.isValid(5)) {
			System.out.println("Connection established successfully");
		} else {
			System.out.println("Connection is closed or invalid");
		}

		return con;
	}
}