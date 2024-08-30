package org.example.library.service;

import org.example.library.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserValidator {

    private static final UserService USER_SERVICE = new UserService();

    public static boolean validateUser(String login, String password) {
        List<User> foundUser = USER_SERVICE.readUsers().stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .collect(Collectors.toList());
        if (foundUser.size() != 1) {
            return false;
        } else {
            return true;
        }
    }
}
