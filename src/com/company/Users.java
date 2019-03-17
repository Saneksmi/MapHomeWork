package com.company;

import java.util.Scanner;
import java.util.HashMap;

/**
 * Класс реализует 2 метода:
 * для считываения логина и пароля из консоли с помощью Scanner
 * и получения пароля по логину.
 */
public final class Users {

    private HashMap<String, String> users;

    public Users() {
        this.users = new HashMap<>();
    }

    //Метод для чтения логинов и паролей из консоли
    public void addUserFromConsole() {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        //Устанавливаем делимитер на символ перехода на новую строку
        scanner.useDelimiter("\\n");

        String login = null;
        String password = null;
        System.out.println("Имя пользователя:");

        //Считываем строку вместе пробелами исключая пустые строки
        if (scanner.hasNext()) {
            login = scanner.next();

            //Проверка на пустой ввод
            while (login.isEmpty()) {
                login = scanner.next();
            }

            //Проверка на уникальность логина
            while (users.containsKey(login)) {
                System.out.println("Это имя уже занято, придумайте другое:");
                login = scanner.next();
                while (login.isEmpty()) {
                    login = scanner.next();
                }
            }
        }
        System.out.println("Пароль:");

        if (scanner.hasNext()) {
            password = scanner.next();
            while (password.isEmpty()) {
                password = scanner.next();
            }
        }
        users.put(login, password);
    }

    //метод для получения пароля по логину
    public String getPassword() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Имя пользователя:");
        String login = null;
        if (scanner.hasNext()) {
            login = scanner.nextLine();
            while (login.isEmpty()) {
                login = scanner.next();
            }
        }
        while (!(users.containsKey(login))) {
            System.out.println("Такого имени нет, "
                    + "попробуйте ещё раз (для выхода введите -1)");
            login = scanner.nextLine();

            //Если надоело вводить неправильный логин
            if (login.equals("-1")) {
                return "0";
            }
        }
        return users.get(login);
    }
}
