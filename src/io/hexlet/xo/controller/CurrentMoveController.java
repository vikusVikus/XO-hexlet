package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {
    public Figure currentMove(final Field field) {
        final int size = field.getFieldSize();

        int counter = 0;

        for (int row = 0; row < size; row++ ) {
            counter += countFigureRow(field, row);
        }

        if (counter == size*size) return null;
        return counter%2 == 0? Figure.X : Figure.O;
    }

    private int countFigureRow(final Field field, final int row) {
        int countFigures = 0;
        for (int col = 0; col < field.getFieldSize(); col++ ) {
            try {
                if (field.getFigure(new Point(row, col)) != null ) countFigures++;
            } catch (InvalidPointException e) {}
        }

        return countFigures;
    }
}
