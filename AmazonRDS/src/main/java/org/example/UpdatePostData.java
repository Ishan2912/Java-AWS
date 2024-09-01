package org.example;
import java.sql.*;

public class UpdatePostData {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://javadbpostgres.ck6ezrgi722q.us-east-1.rds.amazonaws.com:5432/newdb";
        String username  = "postgres";
        String password = "password";

        int employeeId = 1;
        String newEmail = "updated@gmail.com";

        String updateQuery = "Update employees SET email = ?  WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)){
                preparedStatement.setString(1, newEmail);
                preparedStatement.setInt(2, employeeId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data updated");
                }else {
                    System.err.println("Data not updated");
                }

            }

        }catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
}
