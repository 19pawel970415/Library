package org.example.library.db;

import lombok.Getter;
import org.example.library.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class UserRepo implements Serializable {
    private List<User> users = new ArrayList<>();
}
