package com.ignek.crud.constant;

public class UserConstant {

	public static final String USER_ID = "userId";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String GENDER = "gender";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String COURSE = "course";
	public static final String SUBJECTS = "subjects";

	public static final String F_NAME = "fName";
	public static final String L_NAME = "lName";

	public static final String SELECT_ALL_USERS_QUERY = "SELECT * FROM User";
	public static final String RETRIEVE_USERS_QUERY = "SELECT * FROM User WHERE userId = ?";
	public static final String INSERT_USERS_QUERY = "INSERT INTO User(fName, lName, gender, phoneNumber, emailAddress, course, subjects) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_USERS_QUERY = "UPDATE User SET fName=?, lName=?, gender=?, emailAddress=?, phoneNumber=?, course=?, subjects=? WHERE userId=?";
	public static final String DELETE_USERS_QUERY = "DELETE FROM User WHERE userId = ?";

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/crud_java";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "root";

	public static final String EDIT_USER_ID = "editUserId";
	public static final String DELETE_USER_ID = "deleteUserId";

	public static final String EXISTING_USER = "existingUser";
	public static final String USER_LIST = "userList";

	public static final String DELIMETER = ";";
	public static final String COMMA = ",";

}
