package Pieces;

import GUI.Chess;
import Game.Player;
import Game.Type;
import Game.Game;

public class Rook extends Piece {

    public Rook(int x, int y, Player player){
        super(x, y, player);
    }

    /**
     * Returns true if the path the rook is taking is valid
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return
     */
    public boolean isValidPath(int finalX, int finalY) {
        Game game = Chess.getInstance().getGame();
        if (rookCanCapture(finalX, finalY)){
            System.out.println("In capture block");
            game.setCapture(true);
            game.setInvalid(false);
            return true;
        }
        if (rookCanMove(finalX, finalY)){
            System.out.println("In move block");
            game.setInvalid(false);
            return true;
        }

        // all failed, move is invalid
        game.setInvalid(true);
        return false;
    }

    private boolean rookCanMove(int finalX, int finalY) {
        int x = this.getX();
        int y = this.getY();
        int Y_diff = finalY - y;
        int X_diff = finalX - x;
        int abs_Y_diff = Math.abs(Y_diff);
        int abs_X_diff = Math.abs(X_diff);
        Game game = Chess.getInstance().getGame();
        Piece[][] boardArray = Chess.getInstance().getGame().getGameBoard().getBoardArray();
        if (Y_diff >= 1) {
            if ((abs_Y_diff >= 1 && abs_Y_diff <= 7)
                    && (boardArray[finalX][finalY] == null)) {
                boolean pieceInWay = false;
                int j = Math.min(finalY, y);
                for (int i = Math.max(finalY, y); i > j; i--) {
                    if (boardArray[x][i] != null && !(boardArray[x][i] == this)) {
                        pieceInWay = true;
                    }
                }
                if (pieceInWay) {
                    return false;
                }
            } else if (boardArray[finalX][finalY] != null){
                return false;
            }
        }
        if (X_diff <= 1) {
            if (abs_X_diff >= 1 && abs_X_diff <= 7
                    && (boardArray[finalX][finalY] == null)) {
                boolean pieceInWay = false;
                // get the larger of finalX and x to find any pieces in the way
                int j = Math.max(finalX, x);
                for (int i = Math.min(finalX, x); i < j; i++) {
                    if (boardArray[i][y] != null && !(boardArray[i][y] == this)) {
                        pieceInWay = true;
                    }
                }
                if (pieceInWay) {
                    return false;
                }
            } else if (boardArray[finalX][finalY] != null){
                return false;
            }
        }
        if (Y_diff <= 1) {
            if ((abs_Y_diff >= 1 && abs_Y_diff <= 7)
                    && (boardArray[finalX][finalY] == null)) {
                boolean pieceInWay = false;
                int j = Math.max(finalY, y);
                for (int i = Math.min(finalY, y); i < j; i++) {
                    if (boardArray[x][i] != null && !(boardArray[x][i] == this)) {
                        pieceInWay = true;
                    }
                }
                if (pieceInWay) {
                    return false;
                }
            } else if (boardArray[finalX][finalY] != null){
                return false;
            }
        }
        if (X_diff >= 1) {
            if (abs_X_diff >= 1 && abs_X_diff <= 7
                    && (boardArray[finalX][finalY] == null)) {
                boolean pieceInWay = false;
                int j = Math.min(finalX, x);
                for (int i = Math.max(finalX, x); i > j; i--) {
                    if (boardArray[i][y] != null && !(boardArray[i][y] == this)) {
                        pieceInWay = true;
                    }
                }
                if (pieceInWay) {
                    return false;
                }
            } else if (boardArray[finalX][finalY] != null){
                return false;
            }
        }

        if (abs_X_diff >= 1 && abs_Y_diff >= 1){
            return false;
        }
        return true;
    }

    /**
     * Essentially the same as if it can move, but making sure there is a piece where they wish to land
     * and that that piece is not the same
     * @param finalX
     * @param finalY
     * @return
     */
    private boolean rookCanCapture(int finalX, int finalY){
        int x = this.getX();
        int y = this.getY();
        int Y_diff = finalY - y;
        int X_diff = finalX - x;
        int abs_Y_diff = Math.abs(Y_diff);
        int abs_X_diff = Math.abs(X_diff);
        Game game = Chess.getInstance().getGame();
        Piece[][] boardArray = Chess.getInstance().getGame().getGameBoard().getBoardArray();
        // just a regular move
        if (boardArray[finalX][finalY] == null){
            return false;
        }
        if (Y_diff >= 1) {
            if ((abs_Y_diff >= 1 && abs_Y_diff <= 7)
                    && (boardArray[finalX][finalY] != null)) {
                int j = Math.min(finalY, y);
                for (int i = Math.max(finalY, y); i > j; i--) {
                    if (boardArray[x][i] != null && !(boardArray[x][i] == this) && !(boardArray[x][i] == boardArray[finalX][finalY])) {
                        // there is a piece in the way that isn't the piece to capture
                        return false;
                    }
                }
            }
        }
        if (X_diff <= 1) {
            if (abs_X_diff >= 1 && abs_X_diff <= 7
                    && (boardArray[finalX][finalY] != null)) {
                // get the larger of finalX and x to find any pieces in the way
                int j = Math.max(finalX, x);
                for (int i = Math.min(finalX, x); i < j; i++) {
                    if (boardArray[i][y] != null && !(boardArray[i][y] == this) && !(boardArray[i][y] == boardArray[finalX][finalY])) {
                        // there is a piece in the way
                        return false;
                    }
                }
            }
        }
        if (Y_diff <= 1) {
            if ((abs_Y_diff >= 1 && abs_Y_diff <= 7)
                    && (boardArray[finalX][finalY] != null)) {
                int j = Math.max(finalY, y);
                for (int i = Math.min(finalY, y); i < j; i++) {
                    if (boardArray[x][i] != null && !(boardArray[x][i] == this) && !(boardArray[x][i] == boardArray[finalX][finalY])) {
                        // there is a piece in the way
                        return false;
                    }
                }
            }
        }
        if (X_diff >= 1) {
            if (abs_X_diff >= 1 && abs_X_diff <= 7
                    && (boardArray[finalX][finalY] != null)) {
                int j = Math.min(finalX, x);
                for (int i = Math.max(finalX, x); i > j; i--) {
                    if (boardArray[i][y] != null && !(boardArray[i][y] == this) && !(boardArray[i][y] == boardArray[finalX][finalY])) {
                        // there is  apiece in the way
                        return false;
                    }
                }
            }
        }
        if (abs_X_diff >= 1 && abs_Y_diff >= 1){
            return false;
        }

        return true;
    }

    public Type getType() {
        return Type.ROOK;
    }
}
