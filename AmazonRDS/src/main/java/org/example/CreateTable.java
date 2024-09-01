package org.example;
import java.sql.*;

public class CreateTable {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://javadbpostgres.ck6ezrgi722q.us-east-1.rds.amazonaws.com:5432/newdb";
        String username  = "postgres";
        String password = "password";

        String createTableSQL = "CREATE TABLE employees (" +
                "id SERIAL PRIMARY KEY," +
                "first_name VARCHAR(50) NOT NULL," +
                "last_name VARCHAR(50) NOT NULL," +
                "email VARCHAR(100) NOT NULL" +
                ")";


        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
                System.out.println("Table employees created");


            }

        }catch (SQLException e) {
            System.err.println("Error in conneciton : " + e.getMessage());
        }


    }
}
