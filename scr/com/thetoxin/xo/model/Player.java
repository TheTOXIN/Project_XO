package com.thetoxin.xo.model;

public class Player {

    private final String name;
    private final Figure figure;
    private int score;

    public  Player (final String name, final Figure figure) {
        this.figure = figure;
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }
}
