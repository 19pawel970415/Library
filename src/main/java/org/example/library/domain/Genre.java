package org.example.library.domain;

import java.io.Serializable;

public enum Genre implements Serializable {
    FICTION("Fiction"),
    NON_FICTION("Non-fiction"),
    MYSTERY("Mystery"),
    FANTASY("Fantasy"),
    SCIENCE_FICTION("Science Fiction"),
    ROMANCE("Romance"),
    THRILLER("Thriller"),
    HORROR("Horror"),
    BIOGRAPHY("Biography"),
    AUTOBIOGRAPHY("Autobiography"),
    SELF_HELP("Self-help"),
    HISTORICAL("Historical"),
    CLASSICS("Classics"),
    ADVENTURE("Adventure"),
    DYSTOPIAN("Dystopian"),
    YOUNG_ADULT("Young Adult"),
    CHILDREN("Children"),
    POETRY("Poetry"),
    GRAPHIC_NOVEL("Graphic Novel"),
    TRUE_CRIME("True Crime"),
    RELIGION("Religion");

    private final String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
