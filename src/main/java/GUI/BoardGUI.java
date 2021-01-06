package GUI;

import Game.Game;
import javax.swing.*;
import java.awt.*;


public class BoardGUI {

    private Game game;
    private boolean endTurn = false;

    public static void main(String[] args) throws InterruptedException {
        Chess inst = new Chess();
        inst.gameLoop();
    }


    public synchronized void waitForInput()
    {
        while(!endTurn)
        {
            try{
                wait();
            } catch (InterruptedException e){ e.printStackTrace();}
        }
    }

    public synchronized void notifyInput()
    {
        endTurn = true;
        notifyAll();
    }

    /**
     * Initializes the GUI.
     */
    public BoardGUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Chess");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                ChessWindow window = new ChessWindow();
                frame.add(window);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isEndTurn() {
        return endTurn;
    }

    public void setEndTurn(boolean endTurn) {
        this.endTurn = endTurn;
    }
}
