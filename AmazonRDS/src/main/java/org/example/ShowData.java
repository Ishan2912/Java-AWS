package org.example;
import java.sql.*;

public class ShowData {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://myjavadb.ck6ezrgi722q.us-east-1.rds.amazonaws.com:3307/javadb";
        String masterUsername = "admin";
        String masterUserPassword = "password";

        String selectSQL = "SELECT * FROM employees";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, masterUsername, masterUserPassword);

            try {
                Statement statement = connection.createStatement();

                try {
                    ResultSet resultSet = statement.executeQuery(selectSQL);
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String firstname = resultSet.getNString("first_name");
                        String lastname = resultSet.getNString("last_name");
                        String email = resultSet.getString("email");

                        System.out.println("ID : " + id);
                        System.out.println("Name : " + firstname);
                        System.out.println("LastName : " + lastname);
                        System.out.println("Email : " + email);



                    }
                }catch (SQLException e) {
                    System.err.println("Error : " + e.getMessage());
                }


            }catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
            }


        }catch (SQLException e) {
            System.err.println("Unabel to connect : " + e.getMessage());
        }


    }

}
