package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.Point;

public class Field{
    private static final int MIN_COORDINATE = 0;

    private final int fieldWidth;

    private final int fieldHeight;

    private final Figure[][] field;

    public Field(int fieldWidth, int fieldHeight) {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.field = new Figure[fieldWidth][fieldHeight];
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public Figure getFigure (final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    public void setFigure (final Point point, final Figure figure )throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    public boolean checkPoint(Point point){
        return checkCoordinateX(point.x) && checkCoordinateY(point.y);
    }

    public boolean checkCoordinateX(int x) {
        return x >= MIN_COORDINATE && x < getFieldWidth();
    }

    public boolean checkCoordinateY(int y) {
        return y >= MIN_COORDINATE && y < getFieldHeight();
    }
}
