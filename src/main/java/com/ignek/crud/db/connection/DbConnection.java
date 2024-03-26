package com.ignek.crud.db.connection;
import java.sql.*;

	public class DbConnection {
	    
	    public static Connection getConnection() throws SQLException, ClassNotFoundException {
	        Connection con = null;
	        
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_java", "root", "root");
	            
	            if(con.isValid(5)) { 
	                System.out.println("Connection established successfully");
	            } else {
	                System.out.println("Connection is closed or invalid");
	            }
	        } catch(ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            throw e; 
	        }
	        return con;
	    }
	}