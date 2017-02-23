package com.thetoxin.xo.model;

public class Game {

    private final Player[] players;
    private final Field field;
    private final String name;
    private final Cursor cursor;
    public Boolean isEnd;

    public Game(final Player[] players, final Field field, final String name, final Cursor cursor) {
        this.players = players;
        this.field = field;
        this.name = name;
        this.cursor = cursor;
        this.isEnd = true;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public Boolean getEnd() {
        return isEnd;
    }
}
