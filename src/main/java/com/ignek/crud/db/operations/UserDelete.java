package com.ignek.crud.db.operations;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.ignek.crud.db.connection.DbConnection;

public class UserDelete {
    public static boolean deleteUser(int Id) {

        try {
            String q = "DELETE FROM User WHERE Id = ?";
            PreparedStatement pstmt = DbConnection.getConnection().prepareStatement(q);

            pstmt.setInt(1, Id);
            int rowCount = pstmt.executeUpdate();

            if (rowCount > 0) {
                System.out.println("User with ID " + Id + " deleted successfully");
            } else {
                System.out.println("No user found with ID " + Id);
            }

            pstmt.close();
            DbConnection.getConnection().close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}