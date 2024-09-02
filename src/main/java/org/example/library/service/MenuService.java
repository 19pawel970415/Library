package org.example.library.service;

import org.example.library.domain.User;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuService implements MenuServiceInterface {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserServiceInterface USER_SERVICE = new UserService();
    private static final User USER = new User();
    private static final UserValidatorInterface USER_VALIDATOR = new UserValidator();
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @Override
    public void showMenu() {
        boolean shouldContinue = true;
        do {
            showRegisterOrLoginRequest();
            Integer logSingInOption = Integer.parseInt(SCANNER.nextLine());
            switch (logSingInOption) {
                case 1:
                    register();
                case 2:
                    showLoginRequest();
                    String login = SCANNER.nextLine();
                    showPasswordRequest();
                    String password = SCANNER.nextLine();
                    if (USER_VALIDATOR.validateUser(login, password)) {
                        Optional<User> loggingInUser = findLoggingInUser(login, password);
                        if (loggingInUser.isPresent()) {
                            setUser(loggingInUser);
                            getTheChoiceFromUser();
                        } else {
                            System.out.println("Something went wrong, come back later :(");
                        }
                    } else {
                        System.out.println("No such user");
                    }
                    break;
            }
        } while (true);
    }

    private static void showRegisterOrLoginRequest() {
        System.out.println("Hello! Chose: ");
        System.out.println("1. To register");
        System.out.println("2. To log in");
    }

    private static void register() {
        List<String> nameSurnameEmail = getNameSurnameEmail();
        User user = new User(nameSurnameEmail.get(0), nameSurnameEmail.get(1), nameSurnameEmail.get(2));
        List<User> users = USER_SERVICE.readUsers();
        users.add(user);
        USER_SERVICE.writeNewUsers(users);
    }

    private static List<String> getNameSurnameEmail() {
        boolean shouldEnd = false;
        List<String> newUsersData = new ArrayList<>();
        do {
            System.out.println("Enter your name: ");
            String name = SCANNER.nextLine();

            System.out.println("Enter your surname: ");
            String surname = SCANNER.nextLine();

            System.out.println("Enter your email: ");
            String email = SCANNER.nextLine();
            Matcher matcher = EMAIL_PATTERN.matcher(email);
            if (matcher.matches()) {
                newUsersData.add(name);
                newUsersData.add(surname);
                newUsersData.add(email);
                shouldEnd = true;
                System.out.println("You registered successfully! Now check your account.");
            } else {
                System.out.println("Enter a correct email!!!");
            }
        } while (!shouldEnd);
        return newUsersData;
    }

    private static void showLoginRequest() {
        System.out.println("Enter your login:");
    }

    private static void showPasswordRequest() {
        System.out.println("Enter password:");
    }

    private static Optional<User> findLoggingInUser(String login, String password) {
        return USER_SERVICE.readUsers().stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .findFirst();
    }

    private static void setUser(Optional<User> loggingInUser) {
        USER.setName(loggingInUser.get().getName());
        USER.setSurname(loggingInUser.get().getSurname());
        USER.setEmail(loggingInUser.get().getEmail());
        USER.setLogin(loggingInUser.get().getLogin());
        USER.setPassword(loggingInUser.get().getPassword());
        USER.setRentals(loggingInUser.get().getRentals());
    }

    private static void showLoggedInUserMenu() {
        System.out.println("Menu:");
        System.out.println("1. Show my rentals");
        System.out.println("2. Rent");
        System.out.println("3. Return");
        System.out.println("4. Exit");
    }

    private static void getTheChoiceFromUser() {
        while (true) {
            showLoggedInUserMenu();
            try {
                Integer option = Integer.parseInt(SCANNER.nextLine());
                switch (option) {
                    case 1 ->
                            USER.getRentals().stream().forEach(r -> System.out.println(r.getResource().getName()));

                    case 4 -> sayGoodbyeAndCloeTheApp();
                }
            } catch (InputMismatchException ime) {
                System.err.println("You did not enter a number, you've been logged out. Log in and try again later with numbers");
            }
        }
    }

    private static void sayGoodbyeAndCloeTheApp() {
        System.out.println("See you soon");
        System.exit(0);
    }
}
