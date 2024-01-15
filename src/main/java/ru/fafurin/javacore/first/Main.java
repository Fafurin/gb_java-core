package ru.fafurin.javacore.first;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин: ");
        String login = scanner.nextLine();

        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        System.out.println("Подтвердите пароль: ");
        String confirmPassword = scanner.nextLine();

        try {
            System.out.println(verification(login, password, confirmPassword));
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
    private static boolean verification(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean res = false;
        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше 20 символов");
        } else if (password.length() > 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают или длина превышает 20 символов");
        } else res = true;

        return res;
    }
}