package com.company;

import java.util.Scanner;

/**
 * Программа считывает с консоли количество пользователей,
 * считывает логин и пароль для каждого,
 * ожидает ввода логина и выдаёт пароль от введённого логина.
 */
public final class Main {
    private Main() {
    }
    public static void main(final String[] args) {

        int num = 0;
        Users users = new Users();

        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Введите количество пользователей");
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        }
        System.out.println(" ");

        for (int i = 1; i <= num; i++) {
            System.out.println("Придумайте имя пользователя и пароль для "
                    + i + "-го пользователя.");
            users.addUserFromConsole();
        }
        System.out.println("Получение пароля по имени пользователя.");
        System.out.println(users.getPassword());
    }
}
