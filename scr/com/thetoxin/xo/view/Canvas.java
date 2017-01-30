package com.thetoxin.xo.view;

import com.thetoxin.xo.Main;
import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.exceptions.InvalidPointException;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    public final Image krestick = new ImageIcon("res/krestick.png").getImage();
    public final Image nolick = new ImageIcon("res/nolick.png").getImage();

    public final int countLine = Main.sizeField - 1;
    public final int space = 450 / Main.sizeField;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);

        g2.setColor(Color.BLACK);

        int pos = space + 5;
        int widthLine = 50 / countLine;
        if (widthLine < 1) {
            widthLine = 1;
        }
        for(int i = 0; i < countLine; i++) {
            g2.fillRoundRect(pos, 0, widthLine, 400, 10, 10);
            g2.fillRoundRect(35, pos-40, 400, widthLine, 10, 10);
            pos += space;
        }

        final Field field = Main.game.getField();

        for(int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                Figure figure;
                try {
                    figure = field.getFigure(new Point(y, x));
                } catch (final InvalidPointException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                if (figure == Figure.X) {
                    g2.drawImage(krestick, x*space+20+widthLine, y*space, 200 / countLine, 200 / countLine, null);
                }
                if (figure == Figure.O) {
                    g2.drawImage(nolick, x*space+20+widthLine, y*space, 200 / countLine, 200 / countLine, null);
                }
            }
        }
    }

    public void paintLine() {

    }

    public void paintFigure() {

    }

    public void drawX() {

    }

    public void drawY() {

    }
}