package Pieces;

import GUI.Chess;
import Game.Player;
import Game.Type;
import Game.Game;


public class Pawn extends Piece {

    Type type;
    private boolean pawnHasMoved;

    /**
     * @param x
     * @param y
     * @param player
     */
    public Pawn(int x, int y, Player player) {
        super(x, y, player);
        type = Type.PAWN;
        this.pawnHasMoved = false;
    }

    /**
     * A function that determines whether the pawn is moving in a valid path.
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return a boolean indicating whether the path is valid
     */
    public boolean isValidPath(int finalX, int finalY) {
        //checks if it is the player's first turn, and if there are no units along the path
        //if so, it will let the pawn move two spaces forward
        Game game = Chess.getInstance().getGame();
        if (pawnCanMoveTwo(finalX, finalY)) {
            game.setInvalid(false);
            return true;
        }

        //checks if pawn is moving on a diagonal, if it is moving only one space, and if there is an enemy in that space
        if (pawnCanCapture(finalX, finalY)) {
            game.setCapture(true);
            game.setInvalid(false);
            return true;
        }

        System.out.println("before pawn can move foward");


        //checks if pawn is moving one space forward, does not let it move forward unless space is empty
        if (pawnCanMoveForward(finalX, finalY)) {
            System.out.println("In pawn can move forward");
            game.setInvalid(false);
            return true;
        }

        game.setInvalid(true);
        return false;
    }


    /**
     * A function determining whether a pawn can move forward two spaces.
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return a boolean indicating whether a pawn can move forward two spaces
     */
    protected boolean pawnCanMoveTwo(int finalX, int finalY)
    {
        int x = this.getX();
        int y = this.getY();
        int abs_Y_diff = Math.abs(finalY - y);
        Game game = Chess.getInstance().getGame();
        String name = game.getCurrentPlayer().getName();
        Piece[][] boardArray = Chess.getInstance().getGame().getGameBoard().getBoardArray();

        if ((abs_Y_diff == 2)
                &&(!this.pawnHasMoved)
                &&(boardArray[finalX][finalY] == null)
                &&((name.equalsIgnoreCase("White") && boardArray[x][y - 1] == null)
                || (name.equalsIgnoreCase("Black")&& boardArray[x][y + 1] == null))) {
            return true;
        }

        else
            return false;
    }

    /**
     * A function determining if a pawn can move forward
     * @param finalX
     * @param finalY
     * @return
     */
    protected boolean pawnCanMoveForward(int finalX, int finalY)
    {
        int x = this.getX();
        int y = this.getY();
        int abs_Y_diff = Math.abs(finalY - y);
        int Y_diff = (finalY - y);
        Game game = Chess.getInstance().getGame();
        String name = game.getCurrentPlayer().getName();
        Piece[][] boardArray = Chess.getInstance().getGame().getGameBoard().getBoardArray();

        System.out.println(finalY);
        System.out.println(y);
        System.out.println(Y_diff);
        System.out.println(abs_Y_diff);
        System.out.println(game.isInvalid());
        System.out.println(boardArray[finalX][finalY]);
        System.out.println(x);
        System.out.println(finalX);
        if (((name.equalsIgnoreCase("White") && Y_diff < 0 && abs_Y_diff == 1 ) ||
                (name.equalsIgnoreCase("Black") && Y_diff > 0 && abs_Y_diff == 1)) &&
                boardArray[finalX][finalY] == null && x == finalX) {
            return true;
        }

        return false;
    }

    protected boolean pawnCanCapture(int finalX, int finalY)
    {
        int x = this.getX();
        int y = this.getY();
        int abs_X_diff = Math.abs(finalX - x);
        int abs_Y_diff = Math.abs(finalY - y);
        int Y_diff = (finalY - y);
        Game game = Chess.getInstance().getGame();
        String name = game.getCurrentPlayer().getName();
        Piece[][] boardArray = Chess.getInstance().getGame().getGameBoard().getBoardArray();

        if((abs_X_diff == abs_Y_diff) && (abs_Y_diff == 1))
        {
            if(name.equalsIgnoreCase("White") && ((boardArray[finalX][finalY] != null
                    && boardArray[finalX][finalY].getPlayer().getName().equalsIgnoreCase("Black")))
                    && Y_diff < 0){
                return true;
            }

            if(name.equalsIgnoreCase("Black") && ((boardArray[finalX][finalY] != null
                    && boardArray[finalX][finalY].getPlayer().getName().equalsIgnoreCase("White")))
                    && Y_diff > 0)
                return true;
        }
        return false;

    }

    public Type getType() {
        return null;
    }

    public boolean isPawnHasMoved() {
        return pawnHasMoved;
    }

    public void setPawnHasMoved(boolean pawnHasMoved) {
        this.pawnHasMoved = pawnHasMoved;
    }
}
