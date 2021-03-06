package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void getFieldSizeTest() throws Exception {
        final int inputValue = 4;

        final int expectedValue = inputValue;

        final Field <Figure> field = new Field<>(inputValue);

        final int actualValue = field.getFieldSize();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void setFigureTest() throws Exception {
        final Field <Figure> field = new Field<>(4);

        final Point inputPoint = new Point(2,1);

        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void getFigureWhenFigureNotSetTest() throws Exception {
        final Field <Figure> field = new Field<>(4);

        final Point inputPoint = new Point(0,0);

        final Figure actualValue = field.getFigure(inputPoint);

        assertNull(actualValue);
    }

    @Test
    public void getFigureWhenXIsLessThenZeroTest() throws Exception {
        final Field <Figure> field = new Field<>(4);

        final Point inputPoint = new Point(-1,0);

        try {
            final Figure actualValue = field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) { }
    }

    @Test
    public void getFigureWhenYIsLessThenZeroTest() throws Exception {
        final Field <Figure> field = new Field<>(4);

        final Point inputPoint = new Point(0, -1);

        try {
            final Figure actualValue = field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenXIsMoreThenWidthTest() throws Exception {
        final Field <Figure> field = new Field<>(4);

        final Point inputPoint = new Point(4, 0);

        try {
            final Figure actualValue = field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenYIsMoreThenZero()  throws Exception {
        final Field <Figure> field = new Field<>(4);

        final Point inputPoint = new Point(0,6);

        try {
            final Figure actualValue = field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }

}