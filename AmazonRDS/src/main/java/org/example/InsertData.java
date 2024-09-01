package org.example;
import java.sql.*;

public class InsertData {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://myjavadb.ck6ezrgi722q.us-east-1.rds.amazonaws.com:3307/javadb";
        String masterUsername = "admin";
        String masterUserPassword = "password";

        String firstname = "John";
        String lastname = "Doe";
        String email = "john@gmail.com";

        String insertSQL = "INSERT INTO employees (first_name, last_name, email) VALUES (?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, masterUsername, masterUserPassword);

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                preparedStatement.setString(1, firstname);
                preparedStatement.setString(2, lastname);
                preparedStatement.setString(3, email);

                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected > 0) {
                    System.out.println("Data inserted successfully");
                }else {
                    System.err.println("No rows inserted");
                }
            }catch (SQLException e) {
                System.err.println("No rows inserted : " + e.getMessage());
            }

        }catch (SQLException e) {
            System.err.println("Unabel to connect : " + e.getMessage());
        }


    }

}
