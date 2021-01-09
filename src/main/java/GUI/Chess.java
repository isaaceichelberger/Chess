package GUI;

import Game.Game;
import Game.Board;
import Pieces.Piece;

import javax.swing.*;
import java.util.ArrayList;

public class Chess {

    private BoardGUI gui;
    private Game game;
    private Board gameBoard;
    private static Chess instance;
    private Piece selectedPiece;
    private JButton selectedPieceButton;
    private JButton selectedSpace;
    private JButton turnButton;
    private int buttonNum;
    private ArrayList<JButton> buttons;

    public Chess(){
        this.gui = new BoardGUI();
        this.game = new Game();
        this.gameBoard = game.getGameBoard();
        if (instance == null){
            instance = this;
        }
        gui.setGame(this.game);
        this.buttonNum = 0;
    }

    public void gameLoop(){
        Chess chessGame = new Chess();
    }

    public BoardGUI getGui() {
        return gui;
    }

    public void setGui(BoardGUI gui) {
        this.gui = gui;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public static Chess getInstance(){
        return instance;
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    public JButton getSelectedSpace() {
        return selectedSpace;
    }

    public void setSelectedSpace(JButton selectedSpace) {
        this.selectedSpace = selectedSpace;
    }

    public JButton getSelectedPieceButton() {
        return selectedPieceButton;
    }

    public void setSelectedPieceButton(JButton selectedPieceButton) {
        this.selectedPieceButton = selectedPieceButton;
    }

    public JButton getTurnButton() {
        return turnButton;
    }

    public void setTurnButton(JButton turnButton) {
        this.turnButton = turnButton;
    }

    public void setButtons(ArrayList<JButton> buttons){
        this.buttons = buttons;
    }

    public int getButtonNum() {
        return buttonNum;
    }

    public void setButtonNum(int buttonNum) {
        this.buttonNum = buttonNum;
    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }

    public JButton getSetCaptureButton(){
        JButton button = buttons.get(buttonNum);
        buttonNum += 1;
        return button;
    }
}
