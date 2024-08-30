package org.example.library.db;

import org.example.library.domain.User;
import org.example.library.domain.UserGenerator;

import java.io.Serializable;
import java.util.List;

public class UserRepo implements Serializable {
    private List<User> users = UserGenerator.generateUsers();
}
