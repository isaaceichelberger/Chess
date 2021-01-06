package Game;

import GUI.Chess;
import Pieces.*;

import java.util.Vector;

public class Board {
    private Piece[][] boardArray;
    private int height, width;
    private Game game;
    private Vector<Piece> whitePieces = new Vector<Piece>(16);
    private Vector<Piece> blackPieces = new Vector<Piece>(16);

    /**
     * Creates the board
     * @param height
     * @param width
     * @param game
     */
    public Board(int height, int width, Game game){
        this.height = height;
        this.width = width;
        this.game = game;
        boardArray = new Piece[width][height];
    }

    /**
     * Sets pieces on the board and initializes lists of pieces.
     */
    public void setPieces(){
        setPlayer2Pieces();
        setPlayer1Pieces();
        setPieceVectors();
    }

    /**
     * Places Player 2's pieces on the board.
     */
    public void setPlayer2Pieces() {
        Piece[][] board = this.boardArray;
        Player player2 = game.getPlayer2();

        for (int i = 0; i < 8; i++) {
            Piece pawn = new Pawn(i, 1, player2);
        }



        // TODO other pieces
    }

    /**
     * Places PLayer 1's pieces on the board. (WHITE)
     */
    public void setPlayer1Pieces()
    {
        Piece[][] board = this.boardArray;
        Player player1 = game.getPlayer1();

        for(int i = 0; i < 8; i++)
        {
            Piece pawn = new Pawn(i, 6, player1);
        }

        // TODO other pieces
    }

    /**
     * Initializes the game's vectors of Player 1 and Player 2's pieces.
     */
    public void setPieceVectors()
    {
        for(int i = 0; i < 8; i++)
        {
            whitePieces.add(this.boardArray[i][6]);
            whitePieces.add(this.boardArray[i][7]);
            blackPieces.add(this.boardArray[i][0]);
            blackPieces.add(this.boardArray[i][1]);
        }
    }

    public void movePiece(Piece piece, int finalX, int finalY)
    {
        // todo
    }

    public Piece[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(Piece[][] boardArray) {
        this.boardArray = boardArray;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Vector<Piece> getWhitePieces() {
        return whitePieces;
    }

    public void setWhitePieces(Vector<Piece> whitePieces) {
        this.whitePieces = whitePieces;
    }

    public Vector<Piece> getBlackPieces() {
        return blackPieces;
    }

    public void setBlackPieces(Vector<Piece> blackPieces) {
        this.blackPieces = blackPieces;
    }
}
