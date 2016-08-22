package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.AbstractXOException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {
    @Test
    public void checkByRow() throws Exception {

    }

    @Test
    public void checkFirstEmptyRow() throws Exception {
       final Field field = new Field();

        final Figure actualValue = WinnerController.checkOneRow(0, field);

        assertNull(actualValue);
    }

    @Test
    public void checkOneRowWithOneFigure() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(1, 2);

        field.setFigure(p1, Figure.X);

        final Figure actualValue = WinnerController.checkOneRow(1, field);

        assertNull(actualValue);
    }

    @Test
    public void checkOneRowWithTwoFigures() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(1,2);

        final Point p2 = new Point(1,1);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);

        final Figure actualValue = WinnerController.checkOneRow(1, field);

        assertNull(actualValue);
    }

    @Test
    public void checkOneRowWithThreeFigures() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(1,2);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(1,0);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);
        field.setFigure(p3, Figure.X);

        final Figure actualValue = WinnerController.checkOneRow(1, field);

        assertNull(actualValue);
    }

    @Test
    public void checkOneRowWithThreeSameFigures() throws Exception {
        final Field field = new Field();

        final Figure inputValue = Figure.X;

        final Figure expectedValue = inputValue;

        final Point p1 = new Point(1,2);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(1,0);

        field.setFigure(p1, inputValue);
        field.setFigure(p2, inputValue);
        field.setFigure(p3, inputValue);

        final Figure actualValue = WinnerController.checkOneRow(1, field);

        assertEquals(expectedValue, actualValue);
    }
}