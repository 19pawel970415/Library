package org.example.library.domain;

import java.io.Serializable;

public class BoardGame extends Resource implements Serializable {
    private String numberOfPlayers;

    public BoardGame(String name, String id, String numberOfPlayers) {
        super(name, id);
        this.numberOfPlayers = numberOfPlayers;
    }
}
