package com.thetoxin.xo.controller;

import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.Player;
import com.thetoxin.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrnetMoveController {

    public Figure currnetMove(final Field field) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                try {
                    if (field.getFigure(new Point(x,y)) != null)
                        countFigure++;
                }catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }
        if(countFigure == field.getSize()*field.getSize())
            return null;

        if (countFigure % 2 ==0)
            return Figure.X;
        return Figure.O;
    }
}
