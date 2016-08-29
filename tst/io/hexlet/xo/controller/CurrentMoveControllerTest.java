package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {
    @Test
    public void currentMoveWithEmptyFieldTest() throws Exception {
        final Field field = new Field(3);

        final CurrentMoveController cmc = new CurrentMoveController();

        final Figure expectedValue = Figure.X;

        final Figure actualValue = cmc.currentMove(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void currentMoveWithOneFieldTest() throws Exception {
        final Field field = new Field(3);

        final CurrentMoveController cmc = new CurrentMoveController();

        final MoveController mc = new MoveController();

        final Figure expectedValue = Figure.O;

        mc.applyFigure(field, new Point(1,2), Figure.X);

        final Figure actualValue = cmc.currentMove(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void currentMoveWithTwoFieldTest() throws Exception {
        final Field field = new Field(3);

        final CurrentMoveController cmc = new CurrentMoveController();

        final MoveController mc = new MoveController();

        final Figure expectedValue = Figure.X;

        mc.applyFigure(field, new Point(1,2), Figure.X);
        mc.applyFigure(field, new Point(2,2), Figure.O);

        final Figure actualValue = cmc.currentMove(field);

        assertEquals(expectedValue, actualValue);
    }


    @Test
    public void currentMoveWithFiveFieldTest() throws Exception {
        final Field field = new Field(3);

        final CurrentMoveController cmc = new CurrentMoveController();

        final MoveController mc = new MoveController();

        final Figure expectedValue = Figure.O;

        mc.applyFigure(field, new Point(1,2), Figure.X);
        mc.applyFigure(field, new Point(2,2), Figure.O);
        mc.applyFigure(field, new Point(2,0), Figure.X);
        mc.applyFigure(field, new Point(0,2), Figure.O);
        mc.applyFigure(field, new Point(1,1), Figure.X);

        final Figure actualValue = cmc.currentMove(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void currentMoveWithFilledFieldTest() throws Exception {
        final Field field = new Field(4);

        final CurrentMoveController cmc = new CurrentMoveController();

        final MoveController mc = new MoveController();

        mc.applyFigure(field, new Point(0,0), Figure.X);
        mc.applyFigure(field, new Point(0,1), Figure.O);
        mc.applyFigure(field, new Point(0,2), Figure.X);
        mc.applyFigure(field, new Point(0,3), Figure.O);
        mc.applyFigure(field, new Point(1,0), Figure.X);
        mc.applyFigure(field, new Point(1,1), Figure.O);
        mc.applyFigure(field, new Point(1,2), Figure.X);
        mc.applyFigure(field, new Point(1,3), Figure.O);
        mc.applyFigure(field, new Point(2,0), Figure.X);
        mc.applyFigure(field, new Point(2,1), Figure.O);
        mc.applyFigure(field, new Point(2,2), Figure.X);
        mc.applyFigure(field, new Point(2,3), Figure.O);
        mc.applyFigure(field, new Point(3,0), Figure.X);
        mc.applyFigure(field, new Point(3,1), Figure.O);
        mc.applyFigure(field, new Point(3,2), Figure.X);
        mc.applyFigure(field, new Point(3,3), Figure.O);

        final Figure actualValue = cmc.currentMove(field);

        assertNull(actualValue);
    }
}