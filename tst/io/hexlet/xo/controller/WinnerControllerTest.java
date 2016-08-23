package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerWithEmptyFieldTest() throws Exception {
        final Field field = new Field(5);

        final WinnerController wc = new WinnerController();

        final Figure actualValue = wc.getWinner(field);

        assertNull(actualValue);
    }

    @Test
    public void getWinnerWithSeveralRandomFiguresTest() throws Exception {
        final Field field = new Field(5);

        final WinnerController wc = new WinnerController();

        final MoveController mv = new MoveController();

        mv.applyFigure(field, new Point(3,4), Figure.X);
        mv.applyFigure(field, new Point(3,0), Figure.X);
        mv.applyFigure(field, new Point(1,4), Figure.O);
        mv.applyFigure(field, new Point(3,2), Figure.X);
        mv.applyFigure(field, new Point(0,1), Figure.O);
        mv.applyFigure(field, new Point(1,2), Figure.X);

        final Figure actualValue = wc.getWinner(field);

        assertNull(actualValue);
    }

    @Test
    public void getWinnerWithRowFilledTest() throws Exception {
        final Field field = new Field(5);

        final WinnerController wc = new WinnerController();

        final MoveController mv = new MoveController();

        final Figure expectedValue = Figure.X;

        mv.applyFigure(field, new Point(4,4), Figure.X);
        mv.applyFigure(field, new Point(1,4), Figure.O);
        mv.applyFigure(field, new Point(4,2), Figure.X);
        mv.applyFigure(field, new Point(4,1), Figure.X);
        mv.applyFigure(field, new Point(0,0), Figure.O);
        mv.applyFigure(field, new Point(0,1), Figure.O);
        mv.applyFigure(field, new Point(4,0), Figure.X);
        mv.applyFigure(field, new Point(3,3), Figure.O);
        mv.applyFigure(field, new Point(4,3), Figure.X);

        final Figure actualValue = wc.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerWithColumnFilledTest() throws Exception {
        final Field field = new Field(5);

        final WinnerController wc = new WinnerController();

        final MoveController mv = new MoveController();

        final Figure expectedValue = Figure.O;

        mv.applyFigure(field, new Point(3,3), Figure.X);
        mv.applyFigure(field, new Point(0,4), Figure.O);
        mv.applyFigure(field, new Point(4,2), Figure.X);
        mv.applyFigure(field, new Point(1,4), Figure.O);
        mv.applyFigure(field, new Point(0,0), Figure.X);
        mv.applyFigure(field, new Point(2,4), Figure.O);
        mv.applyFigure(field, new Point(1,0), Figure.X);
        mv.applyFigure(field, new Point(3,4), Figure.O);
        mv.applyFigure(field, new Point(4,3), Figure.X);
        mv.applyFigure(field, new Point(4,4), Figure.O);

        final Figure actualValue = wc.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerWithFirstDiagonalFilledTest() throws Exception {
        final Field field = new Field(5);

        final WinnerController wc = new WinnerController();

        final MoveController mv = new MoveController();

        final Figure expectedValue = Figure.O;

        mv.applyFigure(field, new Point(3,0), Figure.X);
        mv.applyFigure(field, new Point(0,0), Figure.O);
        mv.applyFigure(field, new Point(4,2), Figure.X);
        mv.applyFigure(field, new Point(1,1), Figure.O);
        mv.applyFigure(field, new Point(0,1), Figure.X);
        mv.applyFigure(field, new Point(2,2), Figure.O);
        mv.applyFigure(field, new Point(1,0), Figure.X);
        mv.applyFigure(field, new Point(3,3), Figure.O);
        mv.applyFigure(field, new Point(4,3), Figure.X);
        mv.applyFigure(field, new Point(4,4), Figure.O);

        final Figure actualValue = wc.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerWithSecondDiagonalFilledTest() throws Exception {
        final Field field = new Field(5);

        final WinnerController wc = new WinnerController();

        final MoveController mv = new MoveController();

        final Figure expectedValue = Figure.X;

        mv.applyFigure(field, new Point(0,4), Figure.X);
        mv.applyFigure(field, new Point(0,0), Figure.O);
        mv.applyFigure(field, new Point(1,0), Figure.O);
        mv.applyFigure(field, new Point(1,3), Figure.X);
        mv.applyFigure(field, new Point(2,2), Figure.X);
        mv.applyFigure(field, new Point(2,0), Figure.O);
        mv.applyFigure(field, new Point(3,1), Figure.X);
        mv.applyFigure(field, new Point(3,4), Figure.O);
        mv.applyFigure(field, new Point(4,0), Figure.X);
        mv.applyFigure(field, new Point(4,2), Figure.O);

        final Figure actualValue = wc.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }
}