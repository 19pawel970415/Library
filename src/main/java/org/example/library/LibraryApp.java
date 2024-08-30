package org.example.library;

import org.example.library.service.MenuService;
import org.example.library.service.UserService;

public class LibraryApp {

    private static final UserService USER_SERVICE = new UserService();
    private static final MenuService MENU_SERVICE = new MenuService();

    public static void main(String[] args) {
        USER_SERVICE.writeUsers();
        MENU_SERVICE.showMenu();
    }
}