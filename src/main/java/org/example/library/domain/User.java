package org.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private List<Rental> rentals = new ArrayList<>();

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
        this.rentals = new ArrayList<>(rentals);
    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = loginCreator.apply(List.of(name, surname));
        this.password = passwordCreator.apply(email);
        this.rentals = new ArrayList<>();
    }
}
