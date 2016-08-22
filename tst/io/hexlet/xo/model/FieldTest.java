package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by vikus on 22.8.2016.
 */
public class FieldTest {
    @Test
    public void getSize() throws Exception {
        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

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
}