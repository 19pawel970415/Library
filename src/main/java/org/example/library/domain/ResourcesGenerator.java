package org.example.library.domain;

import org.example.library.db.ResourceRepo;

import java.time.LocalDateTime;

public class ResourcesGenerator {

    public static final ResourceRepo RESOURCE_REPO = new ResourceRepo();

    public static void generateResources() {

        Book book1 = new Book("To Kill a Mockingbird", "10", "Harper Lee", LocalDateTime.of(1960, 7, 11, 0, 0), Genre.CLASSIC);
        Book book2 = new Book("Pride and Prejudice", "11", "Jane Austen", LocalDateTime.of(1813, 1, 28, 0, 0), Genre.ROMANCE);
        Book book3 = new Book("The Catcher in the Rye", "12", "J.D. Salinger", LocalDateTime.of(1951, 7, 16, 0, 0), Genre.CLASSIC);
        Book book4 = new Book("The Great Gatsby", "13", "F. Scott Fitzgerald", LocalDateTime.of(1925, 4, 10, 0, 0), Genre.CLASSIC);
        Book book5 = new Book("Moby Dick", "14", "Herman Melville", LocalDateTime.of(1851, 10, 18, 0, 0), Genre.CLASSIC);
        Book book6 = new Book("War and Peace", "15", "Leo Tolstoy", LocalDateTime.of(1869, 1, 1, 0, 0), Genre.HISTORICAL);
        Book book7 = new Book("The Odyssey", "16", "Homer", LocalDateTime.of(-800, 1, 1, 0, 0), Genre.CLASSIC);

        BoardGame boardGame1 = new BoardGame("Monopoly", "17", "2-6");
        BoardGame boardGame2 = new BoardGame("Chess", "18", "2");
        BoardGame boardGame3 = new BoardGame("Scrabble", "19", "2-4");
        BoardGame boardGame4 = new BoardGame("Risk", "20", "2-6");
        BoardGame boardGame5 = new BoardGame("Pandemic", "21", "2-4");
        BoardGame boardGame6 = new BoardGame("Clue", "22", "2-6");


        Newspaper newspaper1 = new Newspaper("Le Monde", "23", "Evening Edition");
        Newspaper newspaper2 = new Newspaper("The Washington Post", "24", "Morning Edition");
        Newspaper newspaper3 = new Newspaper("El País", "25", "Daily Edition");
        Newspaper newspaper4 = new Newspaper("La Repubblica", "26", "Weekend Edition");

        RESOURCE_REPO.getResources().add(book1);
        RESOURCE_REPO.getResources().add(book2);
        RESOURCE_REPO.getResources().add(book3);
        RESOURCE_REPO.getResources().add(book4);
        RESOURCE_REPO.getResources().add(book5);
        RESOURCE_REPO.getResources().add(book6);
        RESOURCE_REPO.getResources().add(book7);

        RESOURCE_REPO.getResources().add(boardGame1);
        RESOURCE_REPO.getResources().add(boardGame2);
        RESOURCE_REPO.getResources().add(boardGame3);
        RESOURCE_REPO.getResources().add(boardGame4);
        RESOURCE_REPO.getResources().add(boardGame5);
        RESOURCE_REPO.getResources().add(boardGame6);

        RESOURCE_REPO.getResources().add(newspaper1);
        RESOURCE_REPO.getResources().add(newspaper2);
        RESOURCE_REPO.getResources().add(newspaper3);
        RESOURCE_REPO.getResources().add(newspaper4);
    }
}
