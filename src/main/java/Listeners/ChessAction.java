package Listeners;

import GUI.Chess;
import Pieces.Pawn;
import Pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Game.Game;
import Game.Board;
import Game.Player;

public class ChessAction implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
        Piece selectedPiece = Chess.getInstance().getSelectedPiece();
        JButton selectedPieceButton = Chess.getInstance().getSelectedPieceButton();
        JButton selectedSpace = Chess.getInstance().getSelectedSpace();
        Game game = Chess.getInstance().getGame();
        Point rv = new Point();
        Piece[][] boardArray = Chess.getInstance().getGameBoard().getBoardArray();
        Piece selection = boardArray[button.getLocation(rv).x/100][button.getLocation(rv).y/100];
        if (selection == null){
            if (Chess.getInstance().getSelectedPiece() != null){
                Chess.getInstance().setSelectedSpace(button);
            }
            else{
                JOptionPane.showMessageDialog(null, "Select a piece first!");
            }
            // if it's a piece
        } else {
            // If it is your own piece
            if (selection.getPlayer() == game.getCurrentPlayer()){
                Chess.getInstance().setSelectedPiece(selection);
                Chess.getInstance().setSelectedPieceButton(button);
                // if it is another player's piece and you haven't selected a piece yet
            } else if (selectedPiece == null){
                JOptionPane.showMessageDialog(null, "That is not your piece!");
                // if it is another player's piece to capture
            } else if (selection.getPlayer() != game.getCurrentPlayer()){
                Chess.getInstance().setSelectedSpace(button);
            }
        }

        // Refresh the button values
        selectedPiece = Chess.getInstance().getSelectedPiece();
        selectedPieceButton = Chess.getInstance().getSelectedPieceButton();
        selectedSpace = Chess.getInstance().getSelectedSpace();

        if (selectedSpace != null && selectedPiece != null) {
            // if path is invalid, does nothing
            game.getGameBoard().movePiece(selectedPiece, button.getLocation(rv).x / 100, button.getLocation(rv).y / 100);
            if (game.isCapture()) {
                // Get the Current button to put the piece in
                JButton captureButton = Chess.getInstance().getSetCaptureButton();
                captureButton.setIcon(Chess.getInstance().getSelectedSpace().getIcon());
                // Update space
                Icon img = selectedPieceButton.getIcon();
                selectedSpace.setIcon(img);
                selectedPieceButton.setIcon(null);
                // Reset gui
                resetGUI();
            } else if (game.isInvalid()) {
                JOptionPane.showMessageDialog(null, "Invalid move!");
                resetGUI();
            } else {
                Icon img = selectedPieceButton.getIcon();
                selectedSpace.setIcon(img);
                selectedPieceButton.setIcon(null);
                resetGUI();
            }
        }
    }

    /**
     * Resets the GUIs for the next turn
     */
    public void resetGUI(){
        Chess.getInstance().setSelectedPieceButton(null);
        Chess.getInstance().setSelectedPiece(null);
        Chess.getInstance().setSelectedSpace(null);
        Chess.getInstance().getGui().notifyInput();
        Chess.getInstance().getGame().setInvalid(false);
        Chess.getInstance().getGame().setCapture(false);
        // Change Who's turn it is message wise in the other GUI
        Chess.getInstance().getTurnButton().setText(Chess.getInstance().getGame().getCurrentPlayer().getName() + "'s Turn");
    }
}
