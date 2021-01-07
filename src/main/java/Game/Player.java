package Game;

import GUI.Chess;
import Pieces.Piece;

import java.util.Vector;

public class Player {

    private Color color;
    private Game game;
    private String name;

    public Player(Color color, Game game, String name){
        this.color = color;
        this.game = game;
        this.name = name;
    }

    public Vector<Piece> getPlayerPieces(){
        if (color == Color.WHITE){
            return Chess.getInstance().getGame().getGameBoard().getWhitePieces();
        }
        else if (color == Color.BLACK){
           return Chess.getInstance().getGame().getGameBoard().getBlackPieces();
        }
        // This will never be reached
        return new Vector<Piece>();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
