package org.example;
import java.sql.*;

public class DeletePostData {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://javadbpostgres.ck6ezrgi722q.us-east-1.rds.amazonaws.com:5432/newdb";
        String username  = "postgres";
        String password = "password";

        int employeeId = 1;

        String deleteQuery = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)){
                preparedStatement.setInt(1, employeeId);

                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected > 0) {
                    System.out.println("Data deleted");
                }else {
                    System.err.println("Data not deleted");
                }

            }

        }catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }

}
