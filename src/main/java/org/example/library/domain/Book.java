package org.example.library.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Book extends Resource implements Serializable {
    private String author;
    private LocalDateTime yearOfPublication;
    private Genre genre;

    public Book(String id, String author, String title, LocalDateTime yearOfPublication, Genre genre) {
        super(id);
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
    }
}
