package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Рома", "Клинтаков", (byte) 28);
        userService.saveUser("Лиза", "Тюлюбаева", (byte) 26);
        userService.saveUser("Иван", "Сиднев", (byte) 29);
        userService.saveUser("Зоя", "Донченко", (byte) 55);
        userService.removeUserById(2);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}