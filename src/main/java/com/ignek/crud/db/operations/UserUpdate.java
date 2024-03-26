package com.ignek.crud.db.operations;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ignek.crud.db.connection.DbConnection;
import com.ignek.crud.dto.*;

public class UserUpdate {

    public boolean updateUser(User user) {
        try {
            String q = "UPDATE User SET emailAddress=?, firstName=?, lastName=?, phoneNumber=?, course=?, subjects=? WHERE Id=?";
            PreparedStatement pstmt = DbConnection.getConnection().prepareStatement(q);

            
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getPhoneNumber());
            pstmt.setString(1, user.getEmailAddress());
            pstmt.setString(5, user.getCourse());
            pstmt.setString(6, user.getSubjects());

            int rowsUpdated = pstmt.executeUpdate();
            pstmt.close();
            DbConnection.getConnection().close();

          
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
