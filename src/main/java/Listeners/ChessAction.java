package Listeners;

import GUI.Chess;
import Pieces.Pawn;
import Pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Game.Game;
import Game.Board;
import Game.Player;

public class ChessAction implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
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
        } else if (selection instanceof Pawn){ // todo add other pieces
            if (selection.getPlayer() == Chess.getInstance().getGame().getCurrentPlayer()){
                Chess.getInstance().setSelectedPiece(selection);
                Chess.getInstance().setSelectedPieceButton(button);
            } else {
                JOptionPane.showMessageDialog(null, "That is not your piece!");
            }
        }

        if (Chess.getInstance().getSelectedSpace() != null && Chess.getInstance().getSelectedPiece() != null) {
            Chess.getInstance().getSelectedPiece().getPlayer().getGame().getGameBoard().movePiece(Chess.getInstance().getSelectedPiece(), button.getLocation(rv).x / 100, button.getLocation(rv).y / 100);
            if (Chess.getInstance().getGame().isCapture()) {
                //todo, add piece to captured window
            } else if (Chess.getInstance().getGame().isInvalid()) {
                //todo
            } else {
                Icon img = Chess.getInstance().getSelectedPieceButton().getIcon();
                Chess.getInstance().getSelectedSpace().setIcon(img);
                Chess.getInstance().getSelectedPieceButton().setIcon(null);
            }

            Chess.getInstance().getGame().setCapture(false);
            Chess.getInstance().setSelectedPieceButton(null);
            Chess.getInstance().setSelectedPiece(null);
            Chess.getInstance().setSelectedSpace(null);
            Chess.getInstance().getGame().setInvalid(false);
            Chess.getInstance().getGui().notifyInput();
            // Change Who's turn it is message wise in the other GUI
            Chess.getInstance().getTurnButton().setText(Chess.getInstance().getGame().getCurrentPlayer().getName() + "'s Turn");
        }
    }
}
