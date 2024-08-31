package org.example.library;

import org.example.library.service.*;

public class LibraryApp {

    private static final UserService USER_SERVICE = new UserService();
    private static final ResourceServiceInterface RESOURCE_SERVICE = new ResourceService();
    private static final MenuServiceInterface MENU_SERVICE = new MenuService();

    public static void main(String[] args) {
        USER_SERVICE.writeUsers();
        RESOURCE_SERVICE.writeResources();
        MENU_SERVICE.showMenu();
    }
}