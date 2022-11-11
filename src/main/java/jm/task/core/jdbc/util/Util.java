package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;

public class Util {
    // Настройки гибернации эквивалентны hibernate.cfg.xml свойства
    private static SessionFactory sessionFactory;
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASS = "root";
    private static final Connection connection = null;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();//Конфигурация
                configuration.setProperty("hibernate.current_session_context_class", "thread");//ссесия привязана к потоку
                configuration.setProperty(Environment.URL, URL);
                configuration.setProperty(Environment.USER, USERNAME); // setProperty Связывает значение с ключом. Возвращает предыдущее значение
                configuration.setProperty(Environment.PASS, PASS);
                configuration.setProperty("hibernate.connection.release_mode", "auto");
                configuration.setProperty("hibernate.show_sql", "true");//sql запросы
                configuration.addAnnotatedClass(User.class);//передаем конфигурации класс который является сущностью

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException hibernateException) {
                hibernateException.getStackTrace();
                throw new RuntimeException();
            }
        } return sessionFactory;
    }


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection;
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME, PASS);

        return connection;
    }
}
