package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://myjavadb.ck6ezrgi722q.us-east-1.rds.amazonaws.com:3307/javadb";
        String masterUsername = "admin";
        String masterUserPassword = "password";

        String createTableSQL = "CREATE TABLE employees (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "first_name VARCHAR(50) NOT NULL," +
                "last_name VARCHAR(50) NOT NULL," +
                "email VARCHAR(100) NOT NULL UNIQUE" +
                ")";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, masterUsername, masterUserPassword);

            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(createTableSQL);
                System.out.println("Table employees created ");

            }catch (SQLException e) {
                System.err.println("Error Creating Table " + e.getMessage());
            }

        }catch (SQLException e) {
            System.err.println("Error connection " + e.getMessage());
        }

    }

}
