package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CapturedWindow extends JPanel {

    private ArrayList<JButton> buttons = new ArrayList<JButton>();

    public CapturedWindow(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int row = 0; row < 8; row++)
            for (int col = 0; col < 8; col++) {
                gbc.gridx = col;
                gbc.gridy = row;

                JButton button1 = new JButton();
                button1.setBackground(Color.WHITE);
                button1.setBorderPainted(false);
                button1.setPreferredSize(new Dimension(35, 35));
                add(button1, gbc);
                buttons.add(button1);
            }

        JButton button = new JButton(Chess.getInstance().getGame().getCurrentPlayer().getName() + "'s Turn");
        gbc.weightx = 0.0;
        gbc.gridwidth = 8;
        gbc.gridx = 0;
        gbc.gridy = 8;
        button.setBackground(Color.WHITE);
        add(button, gbc);
        Chess.getInstance().setTurnButton(button);
    }

    public ArrayList<JButton> getButtons(){
        return buttons;
    }
}
