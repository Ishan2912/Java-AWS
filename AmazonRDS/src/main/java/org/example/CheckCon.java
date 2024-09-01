package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CheckCon {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://myjavadb.ck6ezrgi722q.us-east-1.rds.amazonaws.com:3307/javadb";
        String masterUsername = "admin";
        String masterUserPassword = "password";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, masterUsername, masterUserPassword);

            if (connection!= null) {
                System.out.println("Database connection was successfull");
                connection.close();
            }else {
                System.err.println("Database connection failed");
            }


        }catch (SQLException e) {
            System.err.println("Database connection error : " + e.getMessage());
        }

    }
}
