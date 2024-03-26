package com.ignek.crud.db.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ignek.crud.db.connection.*;
import com.ignek.crud.dto.*;


public class UserGet {

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> userList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            
            Connection connection1 = DbConnection.getConnection();

            String query = "SELECT * FROM User";
            preparedStatement = connection1.prepareStatement(query);

           
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String firstName = resultSet.getString("fName");
                String lastName = resultSet.getString("lName");
                String gender = resultSet.getString("gender");
                String emailAddress = resultSet.getString("emailAddress");
                String phoneNumber = resultSet.getString("phoneNumber");
                String course = resultSet.getString("course");
                String subjects = resultSet.getString("subjects");

               
                User user = new User();
                
                user.setUserId(userId);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setGender(gender);
                user.setEmailAddress(emailAddress);
                user.setPhoneNumber(phoneNumber);
                user.setCourse(course);
                user.setSubjects(subjects);
                
                userList.add(user);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return userList;
    }
}

