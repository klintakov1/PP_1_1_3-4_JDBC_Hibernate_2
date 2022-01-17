package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASS = "root";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
            Statement statement = connection.createStatement();
            System.out.println(connection.isClosed());
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }
            connection.isClosed();
            if (!connection.isClosed()) {
                System.out.println("Соединение c БД закрыто");
            }

        } catch (SQLException e) {
            System.err.println("Не удалось соедениться с БД");
            ;
        } // реализуйте настройку соеденения с БД
        return connection;
    }
}
