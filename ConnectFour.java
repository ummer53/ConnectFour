package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectFour extends JFrame {
    int b = 0;
    int[] turn = new int[1];
    JButton[] buttonArray = new JButton[42];
    private int[] freeButton = new int[7];
    public ConnectFour() {

        super("Connect 4");
        setFreeButton();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                String cell = "" + (char)('A' + c) + (6 - r);
                buttonArray[b] = new JButton(" " );
                buttonArray[b].setName("Button"+ cell);
                buttonArray[b].addActionListener(new action(buttonArray, turn, freeButton) );
                add(buttonArray[b]);
                b++;
            }
        }

        setLayout(new GridLayout(6, 7, 0, 0));
        setVisible(true);
    }

    private void setFreeButton() {
        for (int i = 0; i < freeButton.length; i++) {
            freeButton[i] = 35 + i;
        }
    }
}

class action implements ActionListener {
    int[] turn;
    private int[] freeButton;
    JButton[] buttons;

    public action(JButton[] buttons,int[] turn, int[] freeButton) {
        this.buttons = buttons;
        this.freeButton = freeButton;
       this.turn = turn;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        for (int i = 0; i < buttons.length; i++) {
                if( button == buttons[i]) {
                    System.out.println("button clicked"+button.getName());
                    if (turn[0] % 2 == 0) {
                        button = buttons[freeButton[i % 7]];
                        buttons[freeButton[i % 7]].setText("X");
                        System.out.println("button filled"+button.getName());
                        button = null;
                    }
                    else {
                        button = buttons[freeButton[i % 7]];
                        buttons[freeButton[i % 7]].setText("O");
                        System.out.println("button filled"+button.getName());
                        button = null;
                    }
                    freeButton[i % 7] -= 7;
                    turn[0]++;
                }
            }
        }

}