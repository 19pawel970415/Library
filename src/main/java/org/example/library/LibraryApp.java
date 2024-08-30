package org.example.library;

import org.example.library.service.UserService;

public class LibraryApp {

    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        userService.writeUsers();
    }
}