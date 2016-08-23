package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import org.junit.Test;

import java.awt.*;
import java.awt.image.PackedColorModel;

import static org.junit.Assert.*;

public class MoveControllerTest {
    @Test
    public void applyFigureTest() throws Exception {
        final MoveController mv = new MoveController();

        final Field field = new Field(4);

        final Point point = new Point(1, 1);

        final Figure inputValue = Figure.X;

        final Figure expectedValue = inputValue;

        mv.applyFigure(field, point, inputValue);

        final Figure actualValue = field.getFigure(point);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void pointAlreadyOccupiedTest() throws Exception {
        final MoveController mv = new MoveController();

        final Field field = new Field(4);

        final Point point = new Point(1, 1);

        mv.applyFigure(field, point, Figure.X);

        try {
            mv.applyFigure(field, point, Figure.X);
            fail();
        } catch (AlreadyOccupiedException e) {}
    }
}