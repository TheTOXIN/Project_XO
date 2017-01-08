package com.thetoxin.xo.model;

public class Player {

    private final String name;

    private final Figure figure;

    public  Player (final String name, final Figure figure) {
        this.figure = figure;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }


}
