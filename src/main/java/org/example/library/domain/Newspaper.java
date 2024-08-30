package org.example.library.domain;

public class Newspaper extends Resource{
    private String name;
    private String edition;

    public Newspaper(String id, String name, String edition) {
        super(id);
        this.name = name;
        this.edition = edition;
    }
}
