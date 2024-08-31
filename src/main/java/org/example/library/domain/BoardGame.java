package org.example.library.domain;

import java.io.Serializable;

public class BoardGame extends Resource implements Serializable {
    private String numberOfPlayers;

    public BoardGame(String id, String name, String numberOfPlayers) {
        super(id);
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
    }
}
