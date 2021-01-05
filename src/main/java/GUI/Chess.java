package GUI;

import Game.Game;

public class Chess {

    public void gameLoop(){
        BoardGUI gui = new BoardGUI();
        gui.game = new Game();
    }
}
