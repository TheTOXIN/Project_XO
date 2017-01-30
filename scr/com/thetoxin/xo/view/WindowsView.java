package com.thetoxin.xo.view;

import com.thetoxin.xo.Main;
import com.thetoxin.xo.controller.CurrnetMoveController;
import com.thetoxin.xo.controller.MoveController;
import com.thetoxin.xo.controller.WinnerController;
import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.Game;
import com.thetoxin.xo.model.Player;

import javax.swing.*;
import java.awt.*;

public class WindowsView extends JFrame {

    private Image icon = new ImageIcon("res/icon.png").getImage();
    private JPanel control = new JPanel(new FlowLayout());
    private JLabel turn = new JLabel();
    private Font font = new Font("Obelixpro", Font.BOLD, 25);
    private Canvas canvas = new Canvas();

    private CurrnetMoveController currnetMoveController = new CurrnetMoveController();
    private WinnerController winnerController = new WinnerController();
    private MoveController moveController = new MoveController();

    public WindowsView() {

        setTitle("XO");
        setSize(500,500);
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        turn.setFont(font);
        turn.setBackground(Color.blue);
        turn.setText("Hello");

        control.setBackground(Color.GRAY);
        control.add(turn);

        add(control, BorderLayout.SOUTH);
        add(canvas);
    }

    public void loop() {
        final Field field = Main.game.getField();
        final Figure winner = winnerController.getWinner(field);
        final Figure currentFigure = currnetMoveController.currnetMove(field);

        if (currentFigure.equals(Figure.X)) {
            String s = searchPlayerName(Main.game, currentFigure);
            turn.setText("Turn is - " + s + " - X");
        }
        else {
            String s = searchPlayerName(Main.game, currentFigure);
            turn.setText("Turn is - " + s + " - O");
        }

        control.repaint();
        canvas.repaint();

        if (winner != null) {
            String s = searchPlayerName(Main.game, winner);
            JOptionPane.showMessageDialog(null, "Winner is - " + s);
        }
    }

    private String searchPlayerName(Game game, Figure figure) {
        final Player[] players = game.getPlayers();

        for(int i = 0; i < players.length ; i++) {
            if(players[i].getFigure().equals(figure)) {
                return players[i].getName();
            }
        }
        return  null;
    }
}
