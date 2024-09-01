package org.example;
import java.sql.*;

public class InsertPostData {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://javadbpostgres.ck6ezrgi722q.us-east-1.rds.amazonaws.com:5432/newdb";
        String username  = "postgres";
        String password = "password";


        String firstname = "John";
        String lastname = "Doe";
        String email = "john@gmail.com";

        String insertQuery = "INSERT INTO employees (first_name, last_name, email) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, firstname);
                preparedStatement.setString(2, lastname);
                preparedStatement.setString(3, email);

                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected > 0) {
                    System.out.println("Data inserted ");
                }else {
                    System.err.println("Now rows affected");
                }

            }

        }catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
}
