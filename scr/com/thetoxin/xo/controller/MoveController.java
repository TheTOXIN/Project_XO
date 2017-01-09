package com.thetoxin.xo.controller;

import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.exceptions.InvalidPointException;
import com.thetoxin.xo.model.exceptions.PointAlreadyException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field, final Point point, Figure figure) throws InvalidPointException, PointAlreadyException {
        if (field.getFigure(point) != null) {
            throw new PointAlreadyException();
        }
        field.setFigure(point, figure);
    }
}
