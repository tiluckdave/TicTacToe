import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        // frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,680);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // text field setup
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(200,200,200));
        textfield.setFont(new Font("Verdana", Font.BOLD,65));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        // title panel setup
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,600,80);

        // button panel setup
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        // buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setBackground(new Color(200, 200, 200));
            buttons[i].setFont(new Font("Verdana", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setEnabled(false);
        }

        // adding text and panel to frame
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        try {

            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        };
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if  (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O's turn");
                        check();
                    }
                }
                else {
                    if  (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X's turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        buttons[i].setEnabled(true);
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X's turn");
        }
        else {
            player1_turn = false;
            textfield.setText("O's turn");
        }
    }

    public void check() {
        // check X win conditions
        if ((buttons[0]).getText() == "X" && (buttons[1]).getText() == "X" && (buttons[2]).getText() == "X") {
            xWins(0,1,2);
        }
        if ((buttons[3]).getText() == "X" && (buttons[4]).getText() == "X" && (buttons[5]).getText() == "X") {
            xWins(3,4,5);
        }
        if ((buttons[6]).getText() == "X" && (buttons[7]).getText() == "X" && (buttons[8]).getText() == "X") {
            xWins(6,7,8);
        }
        if ((buttons[0]).getText() == "X" && (buttons[3]).getText() == "X" && (buttons[6]).getText() == "X") {
            xWins(0,3,6);
        }
        if ((buttons[1]).getText() == "X" && (buttons[4]).getText() == "X" && (buttons[7]).getText() == "X") {
            xWins(1,4,7);
        }
        if ((buttons[2]).getText() == "X" && (buttons[5]).getText() == "X" && (buttons[8]).getText() == "X") {
            xWins(2,5,8);
        }
        if ((buttons[0]).getText() == "X" && (buttons[4]).getText() == "X" && (buttons[8]).getText() == "X") {
            xWins(0,4,8);
        }
        if ((buttons[2]).getText() == "X" && (buttons[4]).getText() == "X" && (buttons[6]).getText() == "X") {
            xWins(2,4,6);
        }

        // check O win conditions
        if ((buttons[0]).getText() == "O" && (buttons[1]).getText() == "O" && (buttons[2]).getText() == "O") {
            oWins(0,1,2);
        }
        if ((buttons[3]).getText() == "O" && (buttons[4]).getText() == "O" && (buttons[5]).getText() == "O") {
            oWins(3,4,5);
        }
        if ((buttons[6]).getText() == "O" && (buttons[7]).getText() == "O" && (buttons[8]).getText() == "O") {
            oWins(6,7,8);
        }
        if ((buttons[0]).getText() == "O" && (buttons[3]).getText() == "O" && (buttons[6]).getText() == "O") {
            oWins(0,3,6);
        }
        if ((buttons[1]).getText() == "O" && (buttons[4]).getText() == "O" && (buttons[7]).getText() == "O") {
            oWins(1,4,7);
        }
        if ((buttons[2]).getText() == "O" && (buttons[5]).getText() == "O" && (buttons[8]).getText() == "O") {
            oWins(2,5,8);
        }
        if ((buttons[0]).getText() == "O" && (buttons[4]).getText() == "O" && (buttons[8]).getText() == "O") {
            oWins(0,4,8);
        }
        if ((buttons[2]).getText() == "O" && (buttons[4]).getText() == "O" && (buttons[6]).getText() == "O") {
            oWins(2,4,6);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(0, 255, 0));
        buttons[b].setBackground(new Color(0, 255, 0));
        buttons[c].setBackground(new Color(0, 255, 0));
        for (int i = 0 ; i<9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(0, 255, 0));
        buttons[b].setBackground(new Color(0, 255, 0));
        buttons[c].setBackground(new Color(0, 255, 0));
        for (int i = 0 ; i<9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins");
    }
}
