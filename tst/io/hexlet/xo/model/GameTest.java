package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getPlayersTest() throws Exception {
        final Player p1 = new Player("Slava", Figure.X);

        final Player p2 = new Player("Max", Figure.O);

        final Player[] inputValue = {p1, p2};

        final Player[] expectedValue = inputValue;

        final Game<Figure> game = new Game<>(inputValue, null, null);

        final Player[] actualValue = game.getPlayers();

        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    public void getFieldTest() throws Exception {
        final Field inputValue = new Field<>(3);

        final Field expectedValue = inputValue;

        final Game<Figure> game = new Game<>(null, inputValue, null);

        final Field actualValue = game.getField();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getNameTest() throws Exception {
        final String inputValue = "XO game";

        final String expectedValue = inputValue;

        final Game<Figure> game = new Game<>(null, null, inputValue);

        final String actualValue = game.getName();

        assertEquals(expectedValue, actualValue);
    }
}