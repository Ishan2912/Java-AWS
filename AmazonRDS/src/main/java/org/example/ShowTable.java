package org.example;
import java.sql.*;

public class ShowTable {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://myjavadb.ck6ezrgi722q.us-east-1.rds.amazonaws.com:3307/javadb";
        String masterUsername = "admin";
        String masterUserPassword = "password";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, masterUsername, masterUserPassword);
            DatabaseMetaData metaData = connection.getMetaData();

            try {
                ResultSet tables = metaData.getTables(null, null, null, new String[] {"TABLE"});
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    System.out.println("Table Name : " + tableName);
                }

            }catch (SQLException e) {
                System.err.println("Error in getting tables" + e.getMessage());
            }

        }catch (SQLException e) {
            System.err.println("Error in creating connection" + e.getMessage());


        }

    }
}
