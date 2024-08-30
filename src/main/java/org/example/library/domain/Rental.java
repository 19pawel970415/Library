package org.example.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class Rental implements Serializable {
    private String usersLogin;
    private Resource resource;
}
