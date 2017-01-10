package com.thetoxin.xo.view;

import com.thetoxin.xo.controller.CurrnetMoveController;
import com.thetoxin.xo.controller.MoveController;
import com.thetoxin.xo.controller.WinnerController;
import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.Game;
import com.thetoxin.xo.model.exceptions.InvalidPointException;
import com.thetoxin.xo.model.exceptions.PointAlreadyException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private CurrnetMoveController currnetMoveController = new CurrnetMoveController();
    private WinnerController winnerController = new WinnerController();
    private MoveController moveController = new MoveController();
    public void show(final Game game) {
        System.out.format("Game name %s\n", game.getName());
        final Field field = game.getField();
        for(int x = 0; x < field.getSize(); x++) {
            System.out.println("-------");
            System.out.print("|");
            for(int y = 0; y < field.getSize(); y++) {
                final Figure figure;
                try {
                    figure = field.getFigure(new Point(x, y));
                } catch (final InvalidPointException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                System.out.print(figure != null ? figure : " ");
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is %s", winner);
            return false;
        }
        final Figure currentFigure = currnetMoveController.currnetMove(field);
        if (currentFigure == null) {
            System.out.println("No winner and moves left!");
            return false;
        }
        System.out.format("Please enter move point for %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field,point,currentFigure);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        } catch (PointAlreadyException e) {
            System.out.println("Point is wrong!");
        }
        return true;
    }


    private Point askPoint() {
        return new Point(askCoordinate("Х")-1, askCoordinate("Y")-1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Input %s", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("0_0 wat???");
            return askCoordinate(coordinateName);
        }
    }
}
