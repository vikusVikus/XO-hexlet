package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {
//    public Figure getWinner (final Field field) {
//
//
//    }

    public static Figure checkByRow (final Field field){
        final int length = field.getSize();

        Figure figure = null;

        for (int row = 0; row < length; row++) {
            figure = checkOneRow(row, field);
        }

        return figure;
    }

    public static Figure checkOneRow (final int row, final Field field) {
        Figure tmpFigure = null;

        int length = field.getSize() - 1;

        for (int col = 0; col < length; col++ ) {
            final Point p1 = new Point(row, col);

            final Point p2 = new Point(row, col+1);

            try {
                if (field.getFigure(p1) == null || field.getFigure(p2) == null) {
                    return null;
                }

                if (!field.getFigure(p1).equals(field.getFigure(p2))) {
                    return null;
                }

                tmpFigure = field.getFigure(p1);

            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }

        return tmpFigure;
    }
}
