package org.example.library.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Book extends Resource implements Serializable {
    private String author;
    private LocalDateTime yearOfPublication;
    private Genre genre;

    public Book(String name, String id, String author, LocalDateTime yearOfPublication, Genre genre) {
        super(name, id);
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
    }
}
