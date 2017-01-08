package com.thetoxin.xo.model;

import com.thetoxin.xo.model.exceptions.InvalidePointException;
import com.thetoxin.xo.model.exceptions.PointAlreadyException;

import java.awt.*;

public class Field {

    public final static int FILED_SIZE = 3;
    public final static int MIN_COORDINATE = 0;
    public final static int MAX_COORDINATE = 3;

    private final Figure[][] field = new Figure[FILED_SIZE][FILED_SIZE];

    public int getSize() {
        return FILED_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidePointException {
        if (!checkPoint(point))
            throw  new InvalidePointException();

        return  field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidePointException, PointAlreadyException {
        if (!checkPoint(point))
            throw  new InvalidePointException();
        if (field[point.x][point.y] != null)
            throw new PointAlreadyException();
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }
}
