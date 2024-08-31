package org.example.library.domain;

import java.io.Serializable;

public class Newspaper extends Resource implements Serializable {
    private String edition;

    public Newspaper(String id, String name, String edition) {
        super(id);
        this.name = name;
        this.edition = edition;
    }
}
