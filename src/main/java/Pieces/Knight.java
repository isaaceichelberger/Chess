package Pieces;

import GUI.Chess;
import Game.Player;
import Game.Type;
import Game.Game;

public class Knight extends Piece {

    public Knight(int x, int y, Player player){
        super(x, y, player);
    }


    public boolean isValidPath(int finalX, int finalY) {
        Game game = Chess.getInstance().getGame();
        if (knightCanCapture(finalX, finalY)){
            game.setCapture(true);
            game.setInvalid(false);
            return true;
        }
        if (knightCanMove(finalX, finalY)){
            game.setInvalid(false);
            return true;
        }
        game.setInvalid(true);
        return false;
    }

    /**
     * A function to determine if a knight can capture another piece
     * @param finalX
     * @param finalY
     * @return
     */
    private boolean knightCanCapture(int finalX, int finalY){
        int x = this.getX();
        int y = this.getY();
        int abs_x_diff = Math.abs(finalX - x);
        int abs_y_diff = Math.abs(finalY - y);
        double distance = Math.hypot(abs_x_diff, abs_y_diff);
        distance = (double) Math.round(distance * 100000d) / 100000d;
        Piece[][] boardArray = Chess.getInstance().getGame().getGameBoard().getBoardArray();
        Game game = Chess.getInstance().getGame();

        // This distance is the hypotenuse for a triangle with sides 1 and 2
        if (distance == 2.23607
                && boardArray[finalX][finalY] != null
                && !boardArray[finalX][finalY].getPlayer().getName().equalsIgnoreCase(game.getCurrentPlayer().getName())){
            return true;
        }

        return false;
    }

    /**
     * A function to determine if a knight can move
     * @param finalX
     * @param finalY
     * @return
     */
    private boolean knightCanMove(int finalX, int finalY){
        int x = this.getX();
        int y = this.getY();
        int abs_x_diff = Math.abs(finalX - x);
        int abs_y_diff = Math.abs(finalY - y);
        double distance = Math.hypot(abs_x_diff, abs_y_diff);
        distance = (double) Math.round(distance * 100000d) / 100000d;
        Piece[][] boardArray = Chess.getInstance().getGame().getGameBoard().getBoardArray();

        // This distance is the hypotenuse for a triangle with sides 1 and 2
        if (distance == 2.23607 && boardArray[finalX][finalY] == null){
            return true;
        }

        return false;
    }

    public Type getType() {
        return Type.KNIGHT;
    }
}
