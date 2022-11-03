package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASS = "root";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME, PASS);
        Statement statement = connection.createStatement();

        return connection;
    }
}
