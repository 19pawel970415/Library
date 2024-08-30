package org.example.library.db;

import lombok.Getter;
import org.example.library.domain.User;
import org.example.library.domain.UserGenerator;

import java.io.Serializable;
import java.util.List;

@Getter
public class UserRepo implements Serializable {
    private List<User> users = UserGenerator.generateUsers();
}
