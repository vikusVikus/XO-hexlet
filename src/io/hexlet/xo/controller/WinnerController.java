package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.awt.image.PackedColorModel;

public class WinnerController {
//    public Figure getWinner (final Field field) {
//
//
//    }

    public static Figure checkByRow (final Field field){
        final int length = field.getSize();

        for (int row = 0; row < length; row++) {
            Figure figure = checkOneRow(row, field);

            if (figure != null) { return figure;}
        }

        return null;
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

    public static Figure checkByColumn (final Field field){
        final int length = field.getSize();

        for (int col = 0; col < length; col++) {
            Figure figure = checkOneColumn(col, field);

            if (figure != null) { return figure;}
        }

        return null;
    }

    public static Figure checkOneColumn (final int col, final Field field) {
        Figure tmpFigure = null;

        int length = field.getSize() - 1;

        for (int row = 0; row < length; row++ ) {
            final Point p1 = new Point(row, col);

            final Point p2 = new Point(row + 1, col);

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

    public static Figure checkFirstDiagonal(final Field field) {
        Figure tmpFigure = null;

        final int length = field.getSize() - 1;

        for (int i = 0; i < length; i++ ) {

            final Point p1 = new Point(i, i);

            final Point p2 = new Point(i+1, i+1);

            try {
                if (field.getFigure(p1) == null || field.getFigure(p2) == null ) {
                    return null;
                }

                if (!field.getFigure(p1).equals(field.getFigure(p2))) {
                    return null;
                }

                tmpFigure =  field.getFigure(p1);

            } catch (InvalidPointException e) {}
        }

        return tmpFigure;
    }

    public static Figure checkSecondDiagonal(final Field field) {
        Figure tmpFigure = null;

        final int length = field.getSize()-1;

        for (int row = 0, column = length; row < length; row++, column-- ) {

            final Point p1 = new Point(row, column);

            final Point p2 = new Point(row+1, column-1);

            try {
                if (field.getFigure(p1) == null || field.getFigure(p2) == null ) {
                    return null;
                }

                if (!field.getFigure(p1).equals(field.getFigure(p2))) {
                    return null;
                }

                tmpFigure =  field.getFigure(p1);

            } catch (InvalidPointException e) {}
        }

        return tmpFigure;
    }
}
