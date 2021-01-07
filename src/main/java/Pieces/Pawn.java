package Pieces;

import Game.Player;
import Game.Type;

public class Pawn extends Piece {

    Type type;
    private boolean pawnHasMoved;

    /**
     *
     * @param x
     * @param y
     * @param player
     */
    public Pawn(int x, int y, Player player){
        super(x, y, player);
        type = Type.PAWN;
        this.pawnHasMoved = false;
    }

    /**
     *
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return
     */
    public boolean isValidPath(int finalX, int finalY) {
        //for now for testing
        return true;
    }

    /**
     *
     * @param startX   the initial X location
     * @param startY   the initial Y location
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return
     */
    public int[][] drawPath(int startX, int startY, int finalX, int finalY) {
        return new int[0][];
    }

    protected boolean pawnCanMoveTwo(){
        return !pawnHasMoved;
    }

    protected boolean pawnCanMoveForward(){

        return false;
    }

    protected boolean pawnCanCapture(){
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
