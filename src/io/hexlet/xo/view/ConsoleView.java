package io.hexlet.xo.view;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class ConsoleView {
    public void show(final Game game) {
        final Field field = game.getField();

        final int fieldSize = field.getFieldSize() - 1;

        System.out.format("Game name %s\n", game.getName());

        for (int row = 0; row <= fieldSize; row++ ) {
            printFigures(field, row);

            if (row != fieldSize)  printLine(field);
        }
    }

    public void move(final Game game) {
    }

    public void printLine(final Field field) {
        for (int i = 0; i < field.getFieldSize(); i++ ) {
            System.out.print("___ ");
        }
        System.out.println();
    }

    public void printFigures(final Field field, final int row) {
        try {
            if (field.getFigure(new Point(row, 0)) == null){
                System.out.print("   ");
            } else {
                System.out.print(" " + field.getFigure(new Point(row, 0)) + " ");
            }

        for (int i = 1; i < field.getFieldSize(); i++ ) {
            if (field.getFigure(new Point(row, i)) == null){
                System.out.print("|   ");
            } else {
                System.out.print("|" + field.getFigure(new Point(row, i)) + " ");
            }
        }

        System.out.println();

        } catch (InvalidPointException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
