package org.example;
import java.sql.*;

public class CreatePostDatabase {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://javadbpostgres.ck6ezrgi722q.us-east-1.rds.amazonaws.com:5432/";
        String username  = "postgres";
        String password = "password";

        String databaseName = "newdb";


        String createDatabaseQuery = "CREATE DATABASE " + databaseName;

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(createDatabaseQuery);
                System.out.println("Database " + databaseName + " created ");

            } catch (SQLException e) {

                System.err.println("Database creating failed : " + e.getMessage());
            }

        }catch (SQLException e) {

            System.err.println("Connection error : " + e.getMessage());
        }

    }
}
