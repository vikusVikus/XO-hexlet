package io.hexlet.xo.view;

import io.hexlet.xo.controller.CurrentMoveController;
import io.hexlet.xo.controller.MoveController;
import io.hexlet.xo.controller.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {
    private CurrentMoveController currentMoveController = new CurrentMoveController();
    private MoveController moveController = new MoveController();
    private WinnerController winnerController = new WinnerController();

    public void show(final Game<Figure> game) {
        final Field <Figure> field = game.getField();
        final int fieldSize = field.getFieldSize() - 1;
        System.out.format("Game name %s\n", game.getName());

        for(Player p : game) {
            System.out.printf("Players %s is playing with %s.", p.getName(), p.getFigure());
            System.out.println();
        }

        for (int row = 0; row <= fieldSize; row++ ) {
            printFigures(field, row);
            if (row != fieldSize)  printLine(field);
        }
    }

    public boolean move(final Game<Figure> game) {
        final Field <Figure> field = game.getField();

        try {
            if(currentMoveController.currentMove(field) == null) {
                System.out.println("The game is a draw");
                return false;
            }
            if (winnerController.getWinner(field) != null) {
                System.out.println("The winner of a game is " + winnerController.getWinner(field));
                return false;
            }
            moveController.applyFigure(field, askPoint(), currentMoveController.currentMove(field));
        } catch (AlreadyOccupiedException e) {
            System.out.println("This cell is already occupied. Please enter coordinates for an empty cell");
        } catch (InvalidPointException e) {
            System.out.println("Please enter coordinates within the field size starting from Point(1, 1)");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        final Scanner scanner = new Scanner(System.in);
        System.out.format("Please input  %s  coordinate ", coordinateName);
        return scanner.nextInt();
    }

    public void printLine(final Field <Figure> field) {
        for (int i = 0; i < field.getFieldSize(); i++ ) {
            System.out.print("___ ");
        }
        System.out.println();
    }

    public void printFigures(final Field <Figure> field, final int row) {
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
                    System.out.print("|" + field.getFigure(new Point(row, i)) + "  ");
                }
            }

        System.out.println();

        } catch (InvalidPointException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
