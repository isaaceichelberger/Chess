package Pieces;

import GUI.Chess;
import Game.Player;
import Game.Type;
import Game.Game;

public class Bishop extends Piece {

    public Bishop(int x, int y, Player player){
        super(x, y, player);
    }

    public boolean isValidPath(int finalX, int finalY) {
        Game game = Chess.getInstance().getGame();
        if (bishopCanCapture(finalX, finalY)){
            game.setCapture(true);
            game.setInvalid(false);
            return true;
        }
        if (bishopCanMove(finalX, finalY)){
            game.setInvalid(false);
            return true;
        }
        game.setInvalid(true);
        return false;
    }

    private boolean bishopCanCapture(int finalX, int finalY){
        int x = this.getX();
        int y = this.getY();
        int abs_x_diff = Math.abs(finalX - x);
        int abs_y_diff = Math.abs(finalY - y);
        Game game = Chess.getInstance().getGame();
        Piece[][] boardArray = game.getGameBoard().getBoardArray();

        if (abs_x_diff == abs_y_diff
                && boardArray[finalX][finalY] != null){
            return !checkForPieces(x, y, finalX, finalY, true); // return true if no pieces are found
        }
        return false;
    }

    private boolean bishopCanMove(int finalX, int finalY){
        int x = this.getX();
        int y = this.getY();
        int abs_x_diff = Math.abs(finalX - x);
        int abs_y_diff = Math.abs(finalY - y);
        Game game = Chess.getInstance().getGame();
        Piece[][] boardArray = game.getGameBoard().getBoardArray();

        if (abs_x_diff == abs_y_diff
                && boardArray[finalX][finalY] == null){
            return !checkForPieces(x, y, finalX, finalY, false); // return true if no pieces are found
        }
        return false;
    }

    public Type getType() {
        return Type.BISHOP;
    }

    /**
     * Returns true if there are no pieces in between the final x and y
     * @param x
     * @param y
     * @param finalX
     * @param finalY
     * @return
     */
    private boolean checkForPieces(int x, int y, int finalX, int finalY, boolean isCapture){
        Game game = Chess.getInstance().getGame();
        Piece[][] boardArray = game.getGameBoard().getBoardArray();
        if (!isCapture) {
            if (boardArray[finalX][finalY] == null) {
                if (finalX > x && finalY > y) {
                    int i = x;
                    int j = y;
                    while (i < finalX && j < finalY) {
                        if (boardArray[i][j] != null && boardArray[i][j] != this) {
                            // piece found
                            return true;
                        }
                        i++;
                        j++;
                    }

                } else if (finalX > x && finalY < y) {
                    int i = x;
                    int j = y;
                    while (i < finalX && finalY < j) {
                        if (boardArray[i][j] != null && boardArray[i][j] != this) {
                            // piece found
                            return true;
                        }
                        i++;
                        j--;
                    }

                } else if (finalX < x && finalY > y) {
                    int i = x;
                    int j = y;
                    while (finalX < i && j < finalY) {
                        if (boardArray[i][j] != null && boardArray[i][j] != this) {
                            // piece found
                            return true;
                        }
                        i--;
                        j++;
                    }

                } else if (finalX < x && finalY < y) {
                    int i = x;
                    int j = y;
                    while (finalX < i && finalY < j) {
                        if (boardArray[i][j] != null && boardArray[i][j] != this) {
                            // piece found
                            return true;
                        }
                        i--;
                        j--;
                    }
                }
            } else {
                return true;
            }
            if (boardArray[finalX][finalY] == null){
                return false;
            }
        }
        if (isCapture){
            if (boardArray[finalX][finalY] != null) {
                if (finalX > x && finalY > y) {
                    while (x < finalX && y < finalY) {
                        if (boardArray[x][y] != null && boardArray[x][y] != this
                                && !(boardArray[finalX][finalY] == boardArray[x][y])) { // this line problematic i think {
                            // piece found
                            return true;
                        }
                            x++;
                            y++;
                        }
                    }

                } else if (finalX > x && finalY < y) {
                    while (x < finalX && finalY < y) {
                        if (boardArray[x][y] != null && boardArray[x][y] != this
                                && !(boardArray[finalX][finalY] == boardArray[x][y])) {
                            // piece found
                            return true;
                        }
                        x++;
                        y--;
                    }

                } else if (finalX < x && finalY > y) {
                    while (finalX < x && y < finalY) {
                        if (boardArray[x][y] != null && boardArray[x][y] != this
                                && !(boardArray[finalX][finalY] == boardArray[x][y])) {
                            // piece found
                            return true;
                        }
                        x--;
                        y++;
                    }

                } else if (finalX < x && finalY < y) {
                    while (finalX < x && finalY < y) {
                        if (boardArray[x][y] != null && boardArray[x][y] != this
                                && !(boardArray[finalX][finalY] == boardArray[x][y])) {
                            // piece found
                            return true;
                        }
                        x--;
                        y--;
                    }
                }
            } else {
                return true;
            }
        if (boardArray[finalX][finalY] != null){
            return false;
        }
        return true;
    }
}
