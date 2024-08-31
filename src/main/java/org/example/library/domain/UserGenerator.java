package org.example.library.domain;

import org.example.library.db.UserRepo;

import java.time.LocalDateTime;
import java.util.List;

public class UserGenerator {

    public static final UserRepo USER_REPO = new UserRepo();

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

        User user1 = new User("John", "Doe", "john.doe@example.com");

        Rental rental1 = new Rental(user1.getLogin(), book1);
        Rental rental2 = new Rental(user1.getLogin(), boardGame1);
        Rental rental3 = new Rental(user1.getLogin(), newspaper1);

        user1.setRentals(List.of(rental1, rental2, rental3));

        USER_REPO.getUsers().add(user1);

        User user2 = new User("Jane", "Smith", "jane.smith@example.com");

        Rental rental4 = new Rental(user2.getLogin(), book2);
        Rental rental5 = new Rental(user2.getLogin(), boardGame2);
        Rental rental6 = new Rental(user2.getLogin(), newspaper2);

        user2.setRentals(List.of(rental4, rental5, rental6));

        USER_REPO.getUsers().add(user2);

        User user3 = new User("Alice", "Johnson", "alice.johnson@example.com");

        Rental rental7 = new Rental(user3.getLogin(), book3);
        Rental rental8 = new Rental(user3.getLogin(), boardGame3);
        Rental rental9 = new Rental(user3.getLogin(), newspaper3);

        user3.setRentals(List.of(rental7, rental8, rental9));

        USER_REPO.getUsers().add(user3);
    }
}
