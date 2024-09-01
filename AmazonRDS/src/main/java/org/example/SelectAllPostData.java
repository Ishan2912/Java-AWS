package org.example;
import java.sql.*;

public class SelectAllPostData {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://javadbpostgres.ck6ezrgi722q.us-east-1.rds.amazonaws.com:5432/newdb";
        String username  = "postgres";
        String password = "password";

        String selectQuery = "SELECT * from employees";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            try (Statement statement = connection.createStatement()){
                try (ResultSet resultSet = statement.executeQuery(selectQuery)){
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String firstname = resultSet.getString("first_name");
                        String lastname = resultSet.getString("last_name");
                        String email = resultSet.getString("email");

                        System.out.println("ID : " + id);
                        System.out.println("Name : " + firstname);
                        System.out.println("Last Name : " + lastname);
                        System.out.println("Email : " + email);
                        System.out.println(" ------------------------- ");

                    }

                }

            }

        }catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
}
