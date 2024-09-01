package org.example;
import java.sql.*;

public class CheckPostCon {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://javadbpostgres.ck6ezrgi722q.us-east-1.rds.amazonaws.com:5432/newdb";
        String username  = "postgres";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection to Postgres was successfull");

            try (Statement statement = connection.createStatement()) {

                String query = "SELECT version()";
                try(ResultSet resultSet = statement.executeQuery(query)) {
                    if (resultSet.next()) {
                        String version = resultSet.getString(1);
                        System.out.println("Postgres Version : " + version);

                    }

                }


            }

        }catch (SQLException e) {
            System.err.println("Error in connection : " + e.getMessage());
        }


    }
}
