package com.thetoxin.xo;

import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.Game;
import com.thetoxin.xo.model.Player;
import com.thetoxin.xo.view.ConsoleView;
import com.thetoxin.xo.view.InputData;
import com.thetoxin.xo.view.WindowsView;

public class Main {

    public static Game game;
    public static int sizeField;

     public static void main(final  String[] args) {

         System.out.println("Input player name -X-");
         final String name0 = InputData.inputPlayerName();
         System.out.println("Input player name -O-");
         final String name1 = InputData.inputPlayerName();

         System.out.print("Input size field: ");
         sizeField = InputData.inputSizeField();

         final Player[] players = new Player[2];
         players[0] = new Player(name0, Figure.X);
         players[1] = new Player(name1, Figure.O);

         game = new Game(players, new Field(sizeField), "XO");

         final ConsoleView consoleView = new ConsoleView();
         consoleView.show(game);

         final WindowsView windowsView = new WindowsView();

         while (consoleView.move(game)) {
             consoleView.show(game);
             windowsView.loop();
         }
     }
}
