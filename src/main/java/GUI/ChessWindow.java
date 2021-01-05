package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.IOException;
import Listeners.ChessAction;

public class ChessWindow extends JPanel {

    public ChessWindow() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < 8; row++)
            for (int col = 0; col < 8; col++) {
                gbc.gridx = col;
                gbc.gridy = row;

                Border border;
                if (row < 7) {
                    if (col < 7) {
                        border = new MatteBorder(1, 1, 0, 0, Color.BLACK);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.BLACK);
                    }
                } else {
                    if (col < 7) {
                        border = new MatteBorder(1, 1, 1, 0, Color.BLACK);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                    }
                }
                JButton button = new JButton();

                // TODO Add Black or White for the normal player
                if (row == 1) {
                    Image blackPawn;
                    try {
                        blackPawn = ImageIO.read(getClass().getResource("Assets/blackPawn.png"));
                        button.setIcon(new ImageIcon(blackPawn));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (row == 6) {
                    Image whitePawn;
                    try {
                        whitePawn = ImageIO.read(getClass().getResource("Assets/whitePawn.png"));
                        button.setIcon(new ImageIcon(whitePawn));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                if (row == 0 && (col == 0 || col == 7)) {
                    Image blackRook;
                    try {
                        blackRook = ImageIO.read(getClass().getResource("Assets/blackRook.png"));
                        button.setIcon(new ImageIcon(blackRook));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (row == 7 && (col == 0 || col == 7)) {
                    Image whiteRook;
                    try {
                        whiteRook = ImageIO.read(getClass().getResource("Assets/whiteRook.png"));
                        button.setIcon(new ImageIcon(whiteRook));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (row == 0 && (col == 1 || col == 6)) {
                    Image blackKnight;
                    try {
                        blackKnight = ImageIO.read(getClass().getResource("Assets/blackKnight.png"));
                        button.setIcon(new ImageIcon(blackKnight));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (row == 7 && (col == 1 || col == 6)) {
                    Image whiteKnight;
                    try {
                        whiteKnight = ImageIO.read(getClass().getResource("Assets/whiteKnight.png"));
                        button.setIcon(new ImageIcon(whiteKnight));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (row == 0 && (col == 2 || col == 5)) {
                    Image blackBishop;
                    try {
                        blackBishop = ImageIO.read(getClass().getResource("Assets/blackBishop.png"));
                        button.setIcon(new ImageIcon(blackBishop));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                if (row == 7 && (col == 2 || col == 5)) {
                    Image whiteBishop;
                    try {
                        whiteBishop = ImageIO.read(getClass().getResource("Assets/whiteBishop.png"));
                        button.setIcon(new ImageIcon(whiteBishop));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (row == 0 && col == 3) {
                    Image blackQueen;
                    try {
                        blackQueen = ImageIO.read(getClass().getResource("Assets/blackQueen.png"));
                        button.setIcon(new ImageIcon(blackQueen));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (row == 7 && col == 3) {
                    Image whiteQueen;
                    try {
                        whiteQueen = ImageIO.read(getClass().getResource("Assets/whiteQueen.png"));
                        button.setIcon(new ImageIcon(whiteQueen));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (row == 0 && col == 4) {
                    Image blackKing;
                    try {
                        blackKing = ImageIO.read(getClass().getResource("Assets/blackKing.png"));
                        button.setIcon(new ImageIcon(blackKing));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (row == 7 && col == 4) {
                    Image whiteKing;
                    try {
                        whiteKing = ImageIO.read(getClass().getResource("Assets/whiteKing.png"));
                        button.setIcon(new ImageIcon(whiteKing));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                if (row == 0 || row == 2 || row == 4 || row == 6)
                {
                    if (col == 0 || col == 2 || col == 4 || col == 6){
                        button.setBackground(Color.WHITE);
                    }
                    if (col == 1 || col == 3 || col == 5 || col == 7){
                        button.setBackground(Color.DARK_GRAY);
                    }
                }

                if (row == 1 || row == 3 || row == 5 || row == 7)
                {
                    if (col == 0 || col == 2 || col == 4 || col == 6){
                        button.setBackground(Color.DARK_GRAY);
                    }
                    if (col == 1 || col == 3 || col == 5 || col == 7){
                        button.setBackground(Color.WHITE);
                    }
                }

                button.setBorderPainted(true);
                button.setPreferredSize(new Dimension(100, 100));
                ChessAction chessAction = new ChessAction();
                button.addActionListener(chessAction);
                button.setBorder(border);
                add(button, gbc);
            }
    }
}
