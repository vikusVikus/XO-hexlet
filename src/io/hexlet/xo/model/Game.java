package io.hexlet.xo.model;

public class Game<F> {
    private final Player[] players;

    private final Field<F> field;

    private final String name;

    public Game(Player[] players,
                Field<F> field,
                String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field<F> getField() {
        return field;
    }

    public String getName() {
        return name;
    }
}
