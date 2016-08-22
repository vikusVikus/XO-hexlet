package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.Point;

public class Field{
    private static final int MIN_COORDINATE = 0;

    private final int fieldSize;

    private final Figure[][] field;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        this.field = new Figure[fieldSize][fieldSize];
    }

    public int getFieldSize() {
        return fieldSize;
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
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    public boolean checkCoordinate(int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < getFieldSize();
    }
}
