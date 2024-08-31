package org.example.library.service;

import org.example.library.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserValidator implements UserValidatorInterface {

    private static final UserService USER_SERVICE = new UserService();


    @Override
    public boolean validateUser(String login, String password) {
        List<User> foundUser = USER_SERVICE.readUsers().stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .toList();
        if (foundUser.size() != 1) {
            return false;
        } else {
            return true;
        }
    }
}
