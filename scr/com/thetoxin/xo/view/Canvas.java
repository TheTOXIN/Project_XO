package com.thetoxin.xo.view;

import com.thetoxin.xo.Main;
import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.exceptions.InvalidPointException;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    final Field field = Main.game.getField();

    public final Image krestick = new ImageIcon("res/krestick.png").getImage();
    public final Image nolick = new ImageIcon("res/nolick.png").getImage();
    public final Image kursor = Main.game.getCursor().getImageKursor();

    public final int countLine = Main.sizeField - 1;
    public int  widthLine = 50 / countLine;
    public final int space = (500 - widthLine*countLine) / Main.sizeField ;


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.BLACK);
        paintLine(g2);
        paintFigure(g2);
        paintCursor(g2);
    }

    public void paintLine(Graphics2D g2) {
        if (widthLine < 1) {
            widthLine = 1;
        }

        int pos = space;
        for(int i = 0; i < countLine; i++) {
            g2.fillRoundRect(pos, 0, widthLine, 500, 10, 10);
            g2.fillRoundRect(0, pos, 495, widthLine, 10, 10);
            pos += space + widthLine;
        }
    }

    public void paintFigure(Graphics2D g2) {
        int xFigure;
        int yFigure;
        int widthFigure;

        for(int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                Figure figure;
                try {
                    figure = field.getFigure(new Point(y, x));
                } catch (final InvalidPointException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                xFigure = x*space+widthLine*(x+1);
                yFigure = y*space+widthLine*(y+1);
                widthFigure =  ((space-widthLine*2));
                if (figure == Figure.X) {
                    g2.drawImage(krestick, xFigure, yFigure, widthFigure, widthFigure, null);
                }
                if (figure == Figure.O) {
                    g2.drawImage(nolick, xFigure, yFigure, widthFigure, widthFigure, null);
                }
            }
        }
    }

    public void paintCursor(Graphics2D g2) {
        int x = Main.game.getCursor().getX();
        int y = Main.game.getCursor().getY();
        x = x * space + widthLine * x;
        y = y * space + widthLine * y;
        int widthCursor = space;
        g2.drawImage(kursor, x, y, widthCursor,  widthCursor,  null);
    }
}