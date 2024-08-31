package org.example.library.service;

import org.example.library.domain.User;

import java.util.List;

public interface UserServiceInterface {
    void writeUsers();
    List<User> readUsers();
}
