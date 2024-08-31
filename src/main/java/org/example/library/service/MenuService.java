package org.example.library.service;

import org.example.library.domain.User;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class MenuService implements MenuServiceInterface {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserServiceInterface USER_SERVICE = new UserService();
    private static final User USER = new User();
    private static final UserValidatorInterface USER_VALIDATOR = new UserValidator();

    private static void showLoginRequest() {
        System.out.println("Welcome, enter your login:");
    }

    private static void showPasswordRequest() {
        System.out.println("Enter password:");
    }

    @Override
    public void showMenu() {
        boolean shouldContinue = true;
        do {
            showLoginRequest();
            String login = SCANNER.nextLine();
            showPasswordRequest();
            String password = SCANNER.nextLine();
            if (USER_VALIDATOR.validateUser(login, password)) {
                Optional<User> loggedInUser = USER_SERVICE.readUsers().stream()
                        .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                        .findFirst();
                if (loggedInUser.isPresent()) {
                    USER.setName(loggedInUser.get().getName());
                    USER.setSurname(loggedInUser.get().getSurname());
                    USER.setEmail(loggedInUser.get().getEmail());
                    USER.setLogin(loggedInUser.get().getLogin());
                    USER.setPassword(loggedInUser.get().getPassword());
                    USER.setRentals(loggedInUser.get().getRentals());
                    System.out.println("Menu:");
                    System.out.println("1. Show my rentals");
                    System.out.println("2. Rent");
                    System.out.println("3. Return");
                    System.out.println("4. Exit");
                } else {
                    System.out.println("Something went wrong, come back later :(");
                }
                shouldContinue = false;
            } else {
                System.out.println("No such user");
            }
        } while (shouldContinue);
        try {
            Integer option = SCANNER.nextInt();
            switch (option) {
                case 1 -> USER.getRentals().stream().forEach(r -> System.out.println(r.getResource().getId()));
            }
        } catch (InputMismatchException ime) {
            System.err.println("You did not enter a number, you've been logged out. Log in and try again later with numbers");
        }
    }
}
