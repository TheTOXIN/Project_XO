package com.thetoxin.xo.model;

import com.thetoxin.xo.Main;

import javax.swing.*;
import java.awt.*;

public class Cursor {

    public final Image kursor = new ImageIcon("res/kursor.png").getImage();

    public int X;
    public int Y;

    public Cursor(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        X += x;
        if(X < 0 || X > Main.game.getField().getSize()-1) {
            X -= x;
        }
    }

    public void setY(int y) {
        Y += y;
        if(Y < 0 || Y > Main.game.getField().getSize()-1) {
            Y -= y;
        }
    }

    public Image getImageKursor() {
        return kursor;
    }
}
