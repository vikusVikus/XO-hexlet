package io.hexlet.xo;

import io.hexlet.xo.model.*;
import io.hexlet.xo.model.exceptions.*;
import io.hexlet.xo.controller.*;
import io.hexlet.xo.view.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        final Field <Figure> field = new Field<>(3);
        final Player p1 = new Player("Tom", Figure.X);
        final Player p2 = new Player("Jerry", Figure.O);
        final Player[] players = new Player[] {p1, p2};
        final Game<Figure> game = new Game<>(players, field, "Titans clash in a brutal fight");

        final MoveController moveController = new MoveController();
        final ConsoleView consoleView = new ConsoleView();


        while(consoleView.move(game)) {
            consoleView.show(game);
        }
    }
}
