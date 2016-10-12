package io.hexlet.xo.model;

import java.util.Iterator;

public class Game<F> implements Iterable<Player> {
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

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < Game.this.players.length;
        }

        @Override
        public Player next() {
            return Game.this.players[cursor++];
        }
    }
}
