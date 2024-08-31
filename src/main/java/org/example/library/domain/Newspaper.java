package org.example.library.domain;

import java.io.Serializable;

public class Newspaper extends Resource implements Serializable {
    private String edition;

    public Newspaper(String name, String id, String edition) {
        super(name,id);
        this.edition = edition;
    }
}
