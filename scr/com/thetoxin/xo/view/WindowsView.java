package com.thetoxin.xo.view;

import com.thetoxin.xo.Main;
import com.thetoxin.xo.controller.CurrnetMoveController;
import com.thetoxin.xo.controller.KeyboardController;
import com.thetoxin.xo.controller.MoveController;
import com.thetoxin.xo.controller.WinnerController;
import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.Game;
import com.thetoxin.xo.model.Player;

import javax.swing.*;
import java.awt.*;

public class WindowsView extends JFrame {

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension windowSize = new Dimension(500, 550);

    private Image icon = new ImageIcon("res/icon.png").getImage();
    private JPanel control = new JPanel();
    private JLabel turn = new JLabel();
    private Font font = new Font("Obelixpro", Font.BOLD, 25);
    private Canvas canvas = new Canvas();

    private CurrnetMoveController currnetMoveController = new CurrnetMoveController();
    private WinnerController winnerController = new WinnerController();
    private MoveController moveController = new MoveController();
    private Player[] players = Main.game.getPlayers();

    private int hueta = 21;

    public WindowsView() {
        setLocation((int) (screenSize.getWidth()/2-windowSize.getWidth()/2), (int) (screenSize.getHeight()/2-windowSize.getHeight()/2));
        setTitle("XO");
        setSize(windowSize.width, windowSize.height + hueta);
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setFocusable(true);
        addKeyListener(new KeyboardController());

        turn.setFont(font);
        turn.setText("Hello");

        control.setBackground(Color.GRAY);
        control.add(turn);
        control.setSize(500,50);
        control.setLocation(0, 500);

        add(control);
        add(canvas);
    }

    public void loop() {
        final Field field = Main.game.getField();
        final Figure currentFigure = currnetMoveController.currnetMove(field);

        if (currentFigure == null) {
            final Player winner = winnerController.getWinner(players);
            if (winner != null) {
                JOptionPane.showMessageDialog(null, "Winner is - " + winner.getName());
            } else {
                JOptionPane.showMessageDialog(null, "NO WINNER =(");
            }
            Main.game.isEnd = false;
            System.exit(1);
        }

        Player player = searchPlayer(Main.game, currentFigure);
        turn.setText("Turn is - " + player.getName() + " - " + player.getScore() );
    }

    private Player searchPlayer(Game game, Figure figure) {
        final Player[] players = game.getPlayers();
        for(int i = 0; i < players.length ; i++) {
            if(players[i].getFigure().equals(figure)) {
                return players[i];
            }
        }
        return  null;
    }
}
