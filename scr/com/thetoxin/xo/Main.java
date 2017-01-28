package com.thetoxin.xo;

import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.Game;
import com.thetoxin.xo.model.Player;
import com.thetoxin.xo.view.ConsoleView;
import com.thetoxin.xo.view.InputDate;

public class Main {
     public static void main(final  String[] args) {

         System.out.println("Input player name -X-");
         final String name0 = InputDate.inputPlayerName();
         System.out.println("Input player name -O-");
         final String name1 = InputDate.inputPlayerName();

         System.out.print("Input size field: ");
         int sizeField = InputDate.inputSizeField();

         final Player[] players = new Player[2];
         players[0] = new Player(name0, Figure.X);
         players[1] = new Player(name1, Figure.O);

         final Game game = new Game(players, new Field(sizeField), "XO");

         final ConsoleView view = new ConsoleView();
         view.show(game);

         while (view.move(game)) {
             view.show(game);
         }
     }
}
