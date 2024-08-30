package org.example.library.domain;

import lombok.Getter;
import org.example.library.db.UserRepo;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class UserGenerator {

    private static UserRepo userRepo = new UserRepo();

    public static void generateUsers() {
        Book book1 = new Book("1", "J.K. Rowling", "Harry Potter and the Philosopher's Stone", LocalDateTime.of(1997, 6, 26, 0, 0), Genre.FANTASY);
        Book book2 = new Book("2", "George Orwell", "1984", LocalDateTime.of(1949, 6, 8, 0, 0), Genre.DYSTOPIAN);
        Book book3 = new Book("3", "J.R.R. Tolkien", "The Hobbit", LocalDateTime.of(1937, 9, 21, 0, 0), Genre.FANTASY);

        BoardGame boardGame1 = new BoardGame("4", "Catan", "3-4");
        BoardGame boardGame2 = new BoardGame("5", "Ticket to Ride", "2-5");
        BoardGame boardGame3 = new BoardGame("6", "Carcassonne", "2-5");

        Newspaper newspaper1 = new Newspaper("7", "The Times", "Daily Edition");
        Newspaper newspaper2 = new Newspaper("8", "The Guardian", "Weekend Edition");
        Newspaper newspaper3 = new Newspaper("9", "The New York Times", "Sunday Edition");

        userRepo.getUsers().add(new User("John", "Doe", "john.doe@example.com", List.of(
                new Rental("john.doe", book1),
                new Rental("john.doe", boardGame1),
                new Rental("john.doe", newspaper1)
        )));

        userRepo.getUsers().add(new User("Jane", "Smith", "jane.smith@example.com", List.of(
                new Rental("jane.smith", book2),
                new Rental("jane.smith", boardGame2),
                new Rental("jane.smith", newspaper2)
        )));

        userRepo.getUsers().add(new User("Alice", "Johnson", "alice.johnson@example.com", List.of(
                new Rental("alice.johnson", book3),
                new Rental("alice.johnson", boardGame3),
                new Rental("alice.johnson", newspaper3)
        )));

        userRepo.getUsers().add(new User("Bob", "Brown", "bob.brown@example.com", List.of(
                new Rental("bob.brown", book1),
                new Rental("bob.brown", boardGame2),
                new Rental("bob.brown", newspaper3)
        )));

        userRepo.getUsers().add(new User("Charlie", "Davis", "charlie.davis@example.com", List.of(
                new Rental("charlie.davis", book2),
                new Rental("charlie.davis", boardGame1),
                new Rental("charlie.davis", newspaper1)
        )));
    }
}
