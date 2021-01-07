package Game;

import GUI.Chess;

import java.util.Random;

public class Game {
    private Board gameBoard;
    private Player player1, player2; // player 1 is white, player 2 is black
    private int turn;
    final static int standardHeight = 8, standardWidth = 8;
    private boolean invalid = false;
    private boolean capture = false;
    private Player currentPlayer;

    /**
     * Default constructor for a game.
     */
    public Game()
    {
        setStandardGame();
    }

    /**
     * Sets up a standard game with two players and an 8 x 8 board.
     */
    public void setStandardGame()
    {
        this.gameBoard = new Board(standardHeight,standardWidth, this);
        setPlayers();
        this.currentPlayer = player1; // For now
        this.gameBoard.setPieces();
        this.turn = 1;
    }

   /*
     * Initializes both players for a game.
     */
    public void setPlayers()
    {
        // todo allow these to be changed
        player1 = new Player(Color.WHITE, gameBoard.getGame(), "White");
        player2 = new Player(Color.BLACK, gameBoard.getGame(), "Black");
        gameBoard.getGame().setPlayer1(player1);
        gameBoard.getGame().setPlayer2(player2);

    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public static int getStandardHeight() {
        return standardHeight;
    }

    public static int getStandardWidth() {
        return standardWidth;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public boolean isCapture() {
        return capture;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
