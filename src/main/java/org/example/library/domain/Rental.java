package org.example.library.domain;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Rental implements Serializable {
    private String usersLogin;
    private Resource resource;
}
