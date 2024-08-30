package org.example.library.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class User implements Serializable {
    private final String name;
    private final String surname;
    private final String email;
    private final String login;
    private final String password;
    private List<Rental> rentals;

    private transient  Function<List<String>, String> loginCreator = userData -> String.join("", userData) + userData.size();
    private transient  Function<String, String> passwordCreator = email -> email.chars()
            .filter(c -> Character.isLetterOrDigit(c))
            .mapToObj(Integer::toString)
            .limit(10)
            .collect(Collectors.joining(""));

    public User(String name, String surname, String email, List<Rental> rentals) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = loginCreator.apply(List.of(name, surname));
        this.password = passwordCreator.apply(email);
        this.rentals = rentals;
    }
}
