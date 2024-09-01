package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMySQLDB {

    public static void main(String[] args) {

        String dbInstanceEndpoint = "myjavadb.ck6ezrgi722q.us-east-1.rds.amazonaws.com";
        String masterUsername = "admin";
        String masterUserPassword = "password";
        String databaseName = "javadb";

        String jdbcUrl = "jdbc:mysql://" + dbInstanceEndpoint + ":3307/";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, masterUsername, masterUserPassword)) {
            String createDatabaseSQL = "CREATE DATABASE " + databaseName;

            try (Statement statement = connection.createStatement()){
                statement.executeUpdate(createDatabaseSQL);
                System.out.println("Database " + databaseName + "Created Successfully");
            }catch (SQLException e) {
                System.err.println("Error creating the table" + e.getMessage());
            }

        }catch (SQLException e) {
            System.err.println("Connection error : " + e.getMessage());
        }





    }


}
