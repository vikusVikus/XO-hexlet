package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void getFieldWidthTest() throws Exception {
        final int inputValue = 4;

        final int expectedValue = inputValue;

        final Field field = new Field(inputValue, 0);

        final int actualValue = field.getFieldWidth();

        assertEquals(expectedValue, actualValue);
    }

    public void getFieldHeightTest() throws Exception {
        final int inputValue = 4;

        final int expectedValue = inputValue;

        final Field field = new Field(0, inputValue);

        final int actualValue = field.getFieldHeight();

        assertEquals(expectedValue, actualValue);
    }


    /*
    @Test
    public void setFigure() throws Exception {
        final Field field = new Field();

        final Point inputPoint = new Point(2,1);

        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void getFigureWhenFigureNotSet() throws Exception {
        final Field field = new Field();

        final Point inputPoint = new Point(0,0);

        final Figure actualValue = field.getFigure(inputPoint);

        assertNull(actualValue);
    }

    @Test
    public void getFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field();

        final Point inputPoint = new Point(-1,0);

        try {
            final Figure actualValue = field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) { }
    }

    @Test
    public void getFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field();

        final Point inputPoint = new Point(0, -1);

        try {
            final Figure actualValue = field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenXIsMoreThenZero() throws Exception {
        final Field field = new Field();

        final Point inputPoint = new Point(3, 0);

        try {
            final Figure actualValue = field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenYIsMoreThenZero()  throws Exception {
        final Field field = new Field();

        final Point inputPoint = new Point(0,3);

        try {
            final Figure actualValue = field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }
    */
}