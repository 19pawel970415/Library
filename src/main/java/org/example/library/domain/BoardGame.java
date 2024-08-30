package org.example.library.domain;

public class BoardGame extends Resource {
    private String name;
    private String numberOfPlayers;

    public BoardGame(String id, String name, String numberOfPlayers) {
        super(id);
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
    }
}
