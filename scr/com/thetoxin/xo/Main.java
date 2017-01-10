package com.thetoxin.xo;


import com.thetoxin.xo.model.Field;
import com.thetoxin.xo.model.Figure;
import com.thetoxin.xo.model.Game;
import com.thetoxin.xo.model.Player;
import com.thetoxin.xo.view.ConsoleView;

public class Main {
     public static void main(final  String[] args) {

         final String name0 = "Player_0";
         final String name1 = "Player_1";

         final Player[] players = new Player[2];
         players[0] = new Player(name0, Figure.X);
         players[1] = new Player(name1, Figure.O);

         final Game game = new Game(players, new Field(3), "XO");

         final ConsoleView view = new ConsoleView();
         view.show(game);
         while (view.move(game)) {
             view.show(game);
         }
     }
}
