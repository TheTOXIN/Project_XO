package com.thetoxin.xo.controller;

import com.thetoxin.xo.Main;
import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.Game;
import com.thetoxin.xo.model.Player;
import com.thetoxin.xo.model.exceptions.InvalidPointException;
import com.thetoxin.xo.model.exceptions.PointAlreadyException;

import java.awt.*;

public class WinnerController {

    public Player getWinner (final Player players[]) {
        Player winner = null;
        int max = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getScore() > max) {
                max = players[i].getScore();
                winner = players[i];
            }
        }
        return winner;
    }

    public void searchTriple(final Point point, Figure figure, final Field field) {
        int score = 0;
        int x = point.x;
        int y = point.y;

        for (int i = 0; i <= 4; i+=3) {

            try {
                if (figure == field.getFigure(new Point(x, y - 1)) &&
                        figure == field.getFigure(new Point(x, y - 2 + i))) {
                    score++;
                    setNullFigure(new Point(x, y - 1), field);
                    setNullFigure(new Point(x, y - 2 + i), field);
                }
            } catch (InvalidPointException e) {
                //LOL
            }

            try {
                if (figure == field.getFigure(new Point(x + 1, y - 1)) &&
                        figure == field.getFigure(new Point(x + 2 - i, y - 2 + i))) {
                    score++;
                    setNullFigure(new Point(x + 1, y - 1), field);
                    setNullFigure(new Point(x + 2 - i, y - 2 + i), field);
                }
            } catch (InvalidPointException e) {
                //LOL
            }

            try {
                if (figure == field.getFigure(new Point(x + 1, y)) &&
                        figure == field.getFigure(new Point(x + 2 - i, y))) {
                    score++;
                    setNullFigure(new Point(x + 1, y), field);
                    setNullFigure(new Point(x + 2 - i, y), field);
                }
            } catch (InvalidPointException e) {
                //LOL
            }

            try {
                if (figure == field.getFigure(new Point(x + 1, y + 1)) &&
                        figure == field.getFigure(new Point(x + 2 - i, y + 2 - i))) {
                    score++;
                    setNullFigure(new Point(x + 1, y + 1), field);
                    setNullFigure(new Point(x + 2 - i, y + 2 - i), field);
                }
            } catch (InvalidPointException e) {
                //LOL
            }

            try {

                if (figure == field.getFigure(new Point(x, y + 1)) &&
                        figure == field.getFigure(new Point(x, y + 2 - i))) {
                    score++;
                    setNullFigure(new Point(x, y + 1), field);
                    setNullFigure(new Point(x, y + 2 - i), field);
                }
            } catch (InvalidPointException e) {
                //LOL
            }

            try {

                if (figure == field.getFigure(new Point(x - 1, y + 1)) &&
                        figure == field.getFigure(new Point(x - 2 + i, y + 2 - i))) {
                    score++;
                    setNullFigure(new Point(x - 1, y + 1), field);
                    setNullFigure(new Point(x - 2 + i, y + 2 - i), field);
                }
            } catch (InvalidPointException e) {
                //LOL
            }

            try {

                if (figure == field.getFigure(new Point(x - 1, y)) &&
                        figure == field.getFigure(new Point(x - 2 + i, y))) {
                    score++;
                    setNullFigure(new Point(x - 1, y), field);
                    setNullFigure(new Point(x - 2 + i, y), field);
                }
            } catch (InvalidPointException e) {
                //LOL
            }

            try {
                if (figure == field.getFigure(new Point(x - 1, y - 1)) &&
                        figure == field.getFigure(new Point(x - 2 + i, y - 2 + i))) {
                    score++;
                    setNullFigure(new Point(x - 1, y - 1), field);
                    setNullFigure(new Point(x - 2 + i, y - 2 + i), field);
                }
            } catch (InvalidPointException e) {
                //LOL
            }
        }

        if (score != 0) {
            setNullFigure(point, field);
        }
        setScore(Main.game, figure, score);
    }

    private void setScore(final Game game, final Figure figure,  final int score) {
        final Player[] players = game.getPlayers();
        for(int i = 0; i < players.length ; i++) {
            if(players[i].getFigure().equals(figure)) {
                players[i].addScore(score);
            }
        }
    }

    private void setNullFigure(final Point point, final Field field) {
        try {
            field.setFigure(point, null);
            new MoveController().applyFigure(field, point, Figure.N);
        } catch (InvalidPointException e) {
            //LOL
        } catch (PointAlreadyException e) {
            //LOL
        }
    }
}
