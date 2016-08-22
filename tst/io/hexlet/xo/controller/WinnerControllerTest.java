package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {
    @Test
    public void checkFirstEmptyRow() throws Exception {
       final Field field = new Field();

        final Figure actualValue = WinnerController.checkOneRow(0, field);

        assertNull(actualValue);
    }

    @Test
    public void checkOneRowWithOneFigure() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(1, 2);

        field.setFigure(p1, Figure.X);

        final Figure actualValue = WinnerController.checkOneRow(1, field);

        assertNull(actualValue);
    }

    @Test
    public void checkOneRowWithThreeFigures() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(1,2);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(1,0);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);
        field.setFigure(p3, Figure.X);

        final Figure actualValue = WinnerController.checkOneRow(1, field);

        assertNull(actualValue);
    }

    @Test
    public void checkOneRowWithThreeSameFigures() throws Exception {
        final Field field = new Field();

        final Figure inputValue = Figure.X;

        final Figure expectedValue = inputValue;

        final Point p1 = new Point(1,2);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(1,0);

        field.setFigure(p1, inputValue);
        field.setFigure(p2, inputValue);
        field.setFigure(p3, inputValue);

        final Figure actualValue = WinnerController.checkOneRow(1, field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkByRowWithEmptyField() throws Exception {
        final Field field = new Field();

        final Figure actualValue = WinnerController.checkByRow(field);

        assertNull(actualValue);
    }

    @Test
    public void checkByRowWithSeveralFiguresInTheField() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(0,0);

        final Point p2 = new Point(0,2);

        final Point p3 = new Point(1,2);

        final Point p4 = new Point(2,2);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);
        field.setFigure(p3, Figure.X);
        field.setFigure(p4, Figure.O);

        final Figure actualValue = WinnerController.checkByRow(field);

        assertNull(actualValue);
    }

    @Test
    public void checkByRowWithRowFilled() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(1,0);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(1,2);

        final Figure inputValue = Figure.X;

        final Figure expectedValue = inputValue;

        field.setFigure(p1, inputValue);
        field.setFigure(p2, inputValue);
        field.setFigure(p3, inputValue);


        final Figure actualValue = WinnerController.checkByRow(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkFirstEmptyColumn() throws Exception {
        final Field field = new Field();

        final Figure actualValue = WinnerController.checkOneColumn(0, field);

        assertNull(actualValue);
    }


    @Test
    public void checkOneColumnWithOneFigure() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(1, 2);

        field.setFigure(p1, Figure.X);

        final Figure actualValue = WinnerController.checkOneColumn(2, field);

        assertNull(actualValue);
    }

    @Test
    public void checkOneColumnWithThreeFigures() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(0,0);

        final Point p2 = new Point(1,0);

        final Point p3 = new Point(2,0);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);
        field.setFigure(p3, Figure.X);

        final Figure actualValue = WinnerController.checkOneColumn(0, field);

        assertNull(actualValue);
    }


    @Test
    public void checkOneColumnWithThreeSameFigures() throws Exception {
        final Field field = new Field();

        final Figure inputValue = Figure.X;

        final Figure expectedValue = inputValue;

        final Point p1 = new Point(0,1);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(2,1);

        field.setFigure(p1, inputValue);
        field.setFigure(p2, inputValue);
        field.setFigure(p3, inputValue);

        final Figure actualValue = WinnerController.checkOneColumn(1, field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkByColumnWithEmptyField() throws Exception {
        final Field field = new Field();

        final Figure actualValue = WinnerController.checkByColumn(field);

        assertNull(actualValue);
    }

    @Test
    public void checkByColumnWithSeveralFiguresInTheField() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(0,0);

        final Point p2 = new Point(0,2);

        final Point p3 = new Point(1,2);

        final Point p4 = new Point(2,2);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);
        field.setFigure(p3, Figure.X);
        field.setFigure(p4, Figure.O);

        final Figure actualValue = WinnerController.checkByColumn(field);

        assertNull(actualValue);
    }

    @Test
    public void checkByColumnWithRowFilled() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(0,1);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(2,1);

        final Figure inputValue = Figure.X;

        final Figure expectedValue = inputValue;

        field.setFigure(p1, inputValue);
        field.setFigure(p2, inputValue);
        field.setFigure(p3, inputValue);

        final Figure actualValue = WinnerController.checkByColumn(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkFirstDiagonalWithNoFigures() throws Exception {
        final Field field = new Field();

        Figure actualValue = WinnerController.checkFirstDiagonal(field);

        assertNull(actualValue);
    }

    @Test
    public void checkFirstDiagonalWithThreeRandomFigures() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(0,0);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(2,2);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);
        field.setFigure(p3, Figure.X);

        Figure actualValue = WinnerController.checkFirstDiagonal(field);

        assertNull(actualValue);
    }

    @Test
    public void checkFirstDiagonalWithThreeEqaulFigures() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(0,0);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(2,2);

        final Figure inputValue = Figure.X;

        final Figure expectedValue = inputValue;

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.X);
        field.setFigure(p3, Figure.X);

        Figure actualValue = WinnerController.checkFirstDiagonal(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkSecondDiagonalWithNoFigures() throws Exception {
        final Field field = new Field();

        Figure actualValue = WinnerController.checkSecondDiagonal(field);

        assertNull(actualValue);
    }

    @Test
    public void checkSecondDiagonalWithThreeRandomFigures() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(2,0);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(0,2);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);
        field.setFigure(p3, Figure.X);

        Figure actualValue = WinnerController.checkSecondDiagonal(field);

        assertNull(actualValue);
    }

    @Test
    public void checkSecondDiagonalWithThreeEqaulFigures() throws Exception {
        final Field field = new Field();

        final Point p1 = new Point(2,0);

        final Point p2 = new Point(1,1);

        final Point p3 = new Point(0,2);

        final Figure inputValue = Figure.X;

        final Figure expectedValue = inputValue;

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.X);
        field.setFigure(p3, Figure.X);

        Figure actualValue = WinnerController.checkSecondDiagonal(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWinnerTestWithEmptyField() throws  Exception {
        final Field field = new Field();

        Figure actualValue = WinnerController.getWinner(field);

        assertNull(actualValue);
    }

    @Test
    public void getWinnerTestWithSeveralFigures() throws  Exception {
        final Field field = new Field();

        final Point p1 = new Point(0,0);

        final Point p2 = new Point(0,2);

        final Point p3 = new Point(1,0);

        final Point p4 = new Point(2,2);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);
        field.setFigure(p3, Figure.X);
        field.setFigure(p4, Figure.O);

        Figure actualValue = WinnerController.getWinner(field);

        assertNull(actualValue);
    }

    @Test
    public void getWinnerTestWithAWinnerFigure() throws  Exception {
        final Field field = new Field();

        final Figure expectedValue = Figure.X;

        final Point p1 = new Point(0,0);

        final Point p2 = new Point(0,2);

        final Point p3 = new Point(1,1);

        final Point p4 = new Point(1,2);

        final Point p5 = new Point(2,2);

        field.setFigure(p1, Figure.X);
        field.setFigure(p2, Figure.O);
        field.setFigure(p3, Figure.X);
        field.setFigure(p4, Figure.O);
        field.setFigure(p5, Figure.X);

        Figure actualValue = WinnerController.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }
}