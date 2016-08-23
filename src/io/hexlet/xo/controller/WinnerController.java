package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < field.getFieldSize(); i++) {
                if (checkPoints(field, new Point(i, 0), p -> new Point(p.x, p.y+1))) {
                    return field.getFigure(new Point(i,0));
                }
            }
            for (int i = 0; i < field.getFieldSize(); i++ ) {
                if (checkPoints(field, new Point(0, i), p-> new Point(p.x+1, p.y))) {
                    return field.getFigure(new Point(0,i));
                }
            }
            if (checkPoints(field, new Point(0,0), p-> new Point(p.x+1, p.y+1))) {
                return field.getFigure(new Point(0,0));
            }
            if (checkPoints(field, new Point(0, field.getFieldSize()-1), p->new Point(p.x+1, p.y-1))) {
                return field.getFigure(new Point(0, field.getFieldSize()-1));
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }


        return null;
    }

    private boolean checkPoints(final Field field,
                               final Point currentPoint,
                               final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;
        if (currentFigure != nextFigure) return  false;

        return checkPoints(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {
        Point next(Point point);
    }
}
