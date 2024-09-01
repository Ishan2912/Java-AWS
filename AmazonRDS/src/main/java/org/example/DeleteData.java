package org.example;
import java.sql.*;

public class DeleteData {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://myjavadb.ck6ezrgi722q.us-east-1.rds.amazonaws.com:3307/javadb";
        String masterUsername = "admin";
        String masterUserPassword = "password";

        int employeeId = 1;

        String deleteSQL = "DELETE FROM employees WHERE id = ?";

        try(Connection connection = DriverManager.getConnection(jdbcURL, masterUsername, masterUserPassword)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
                preparedStatement.setInt(1, employeeId);

                int rowAffected = preparedStatement.executeUpdate();

                if( rowAffected > 0) {
                    System.out.println("Data is deleted");
                }else {
                    System.err.println("Data is not deleted");
                }

            }
            
        }catch (SQLException e) {
            System.err.println("Database connection error : " + e.getMessage());
        }


    }
}
