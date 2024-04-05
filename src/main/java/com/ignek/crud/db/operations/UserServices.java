package com.ignek.crud.db.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ignek.crud.constant.UserConstant;
import com.ignek.crud.db.connection.DbConnection;
import com.ignek.crud.dto.User;

public class UserServices {

	// Retrieve all users from the database
	public static List<User> getAllUsers() throws SQLException, ClassNotFoundException {
		List<User> userList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DbConnection.getConnection();
			String query = UserConstant.SELECT_ALL_USERS_QUERY;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = extractUserFromResultSet(resultSet);
				userList.add(user);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		closeResources(resultSet, preparedStatement, connection);
		return userList;
	}

	// Retrieve a specific user by user ID
	public static User getUser(int userId) throws SQLException, ClassNotFoundException {
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DbConnection.getConnection();
			String query = UserConstant.RETRIEVE_USERS_QUERY;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = extractUserFromResultSet(resultSet);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		closeResources(resultSet, preparedStatement, connection);
		return user;
	}

	// Insert a new user into the database
	public static int insertUser(User user) {
		return executeInsertOrUpdateUserQuery(user);
	}

	// Update an existing user in the database
	public static int updateUser(User user) {
		return executeInsertOrUpdateUserQuery(user);
	}

	private static int executeInsertOrUpdateUserQuery(User user) {
		int rowsAffected = 0;
		try (Connection connection = DbConnection.getConnection()) {
			PreparedStatement pstmt;
			if (user.getUserId() != 0) {
				pstmt = connection.prepareStatement(UserConstant.UPDATE_USERS_QUERY);
				pstmt.setInt(8, user.getUserId());
			} else {
				pstmt = connection.prepareStatement(UserConstant.INSERT_USERS_QUERY);
			}

			setCommonUserParameters(pstmt, user);

			rowsAffected = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	private static void setCommonUserParameters(PreparedStatement pstmt, User user) throws SQLException {
		pstmt.setString(1, user.getFirstName());
		pstmt.setString(2, user.getLastName());
		pstmt.setString(3, user.getGender());
		pstmt.setString(5, user.getEmailAddress());
		pstmt.setString(4, user.getPhoneNumber());
		pstmt.setString(6, user.getCourse());
		pstmt.setString(7, String.join(UserConstant.DELIMETER, user.getSubjects()));
	}

	// Delete a user from the database by user ID
	public static boolean deleteUser(int userId) throws ClassNotFoundException, SQLException {
		boolean rowsDeleted = false;
		String query = UserConstant.DELETE_USERS_QUERY;

		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query)) {
			pstmt.setInt(1, userId);
			int rowCount = pstmt.executeUpdate();

			if (rowCount > 0) {
				rowsDeleted = true;
			}
		}
		return rowsDeleted;
	}

	// Extract user data from a ResultSet object
	private static User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setUserId(resultSet.getInt(UserConstant.USER_ID));
		user.setFirstName(resultSet.getString(UserConstant.F_NAME));
		user.setLastName(resultSet.getString(UserConstant.L_NAME));
		user.setGender(resultSet.getString(UserConstant.GENDER));
		user.setEmailAddress(resultSet.getString(UserConstant.EMAIL_ADDRESS));
		user.setPhoneNumber(resultSet.getString(UserConstant.PHONE_NUMBER));
		user.setCourse(resultSet.getString(UserConstant.COURSE));
		user.setSubjects(resultSet.getString(UserConstant.SUBJECTS));

		return user;
	}

	// Close ResultSet, PreparedStatement, and Connection resources
	private static void closeResources(ResultSet resultSet, PreparedStatement preparedStatement,
			Connection connection) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
