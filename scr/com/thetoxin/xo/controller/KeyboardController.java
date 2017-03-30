package com.thetoxin.xo.controller;

import com.thetoxin.xo.model.Cursor;
import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.exceptions.InvalidPointException;
import com.thetoxin.xo.model.exceptions.PointAlreadyException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.thetoxin.xo.Main.game;

public class KeyboardController extends KeyAdapter {

    public final Cursor cursor = game.getCursor();

    private CurrnetMoveController currnetMoveController = new CurrnetMoveController();
    private WinnerController winnerController = new WinnerController();
    private MoveController moveController = new MoveController();

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
                cursor.setX(0);
                cursor.setY(-1);
        }
        else if (key == KeyEvent.VK_DOWN) {
                cursor.setX(0);
                cursor.setY(1);
        }
        else if (key == KeyEvent.VK_LEFT) {
                cursor.setX(-1);
                cursor.setY(0);
        }
        else if (key == KeyEvent.VK_RIGHT) {
                cursor.setX(1);
                cursor.setY(0);
        }
        else if (key == KeyEvent.VK_SPACE) {
            int x = cursor.getX();
            int y = cursor.getY();

            final Field field = game.getField();
            final Figure currentFigure = currnetMoveController.currnetMove(field);

            Point point = new Point(y,x);
            try {
                moveController.applyFigure(field,point,currentFigure);
                winnerController.searchTriple(point, currentFigure, field);
            } catch (InvalidPointException e2) {
                JOptionPane.showMessageDialog(null, "WAT? xD");
            } catch (PointAlreadyException e2) {
                JOptionPane.showMessageDialog(null, "Really?");
            }
        }
    }
}
