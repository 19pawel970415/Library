package org.example.library.service;

import java.util.Scanner;

public class MenuService {
    private Scanner scanner = new Scanner(System.in);

    private static void showLoginRequest() {
        System.out.println("Welcome, enter your login:");
    }

    private static void showPasswordRequest() {
        System.out.println("Enter password:");
    }


    public void showMenu() {
        boolean shouldContinue = true;
        do {
            showLoginRequest();
            String login = scanner.nextLine();
            showPasswordRequest();
            String password = scanner.nextLine();
            if (UserValidator.validateUser(login, password)) {
                System.out.println("Menu:");
                System.out.println("1. Show my rentals");
                System.out.println("2. Rent");
                System.out.println("3. Return");
                System.out.println("4. Exit");
                shouldContinue = false;
            } else {
                System.out.println("No such user");
            }
        } while (shouldContinue);
    }
}
