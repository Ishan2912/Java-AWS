package org.example;
import java.sql.*;

public class UpdateData {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://myjavadb.ck6ezrgi722q.us-east-1.rds.amazonaws.com:3307/javadb";
        String masterUsername = "admin";
        String masterUserPassword = "password";

        int employeeId = 1;
        String newEmail = "updated@gmail.com";

        String updateSQL = "UPDATE employees SET email = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, masterUsername, masterUserPassword)) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                preparedStatement.setString(1, newEmail);
                preparedStatement.setInt(2, employeeId);

                int rowAffected = preparedStatement.executeUpdate();

                if ( rowAffected > 0) {
                    System.out.println("Data is updated");
                } else {
                    System.out.println("Data is not updated");
                }
            }

        } catch (SQLException e) {
            System.err.println("Database connection error : " + e.getMessage());
        }


    }

}
