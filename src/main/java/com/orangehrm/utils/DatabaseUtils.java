package com.orangehrm.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/orangehrm";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Reset@1234";

    public static ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Create statement
            Statement statement = connection.createStatement();

            // Execute query
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
	
}
