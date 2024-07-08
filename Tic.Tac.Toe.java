import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static final int SIZE = 3;
    private static JButton[][] buttons = new JButton[SIZE][SIZE];
    private static boolean isPlayer1Turn = true;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("Tic-Tac-Toe");
            window.setLayout(new GridLayout(SIZE, SIZE));

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    buttons[i][j] = new JButton();
                    buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                    buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                    window.add(buttons[i][j]);
                }
            }

            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(400, 400);
            window.setVisible(true);
        });
    }

    private static class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = buttons[row][col];
            if (!button.getText().isEmpty()) {
                return;
            }

            button.setText(isPlayer1Turn ? "X" : "O");
            isPlayer1Turn = !isPlayer1Turn;

            if (checkForWin()) {
                JOptionPane.showMessageDialog(null, (isPlayer1Turn ? "Player 2" : "Player 1") + " wins!");
                resetBoard();
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(null, "It's a draw!");
                resetBoard();
            }
        }
    }

    private static boolean checkForWin() {
        for (int i = 0; i < SIZE; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                !buttons[i][0].getText().isEmpty()) {
                return true;
            }
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                !buttons[0][i].getText().isEmpty()) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][2].getText()) &&
            !buttons[0][0].getText().isEmpty()) {
            return true;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText()) &&
            !buttons[0][2].getText().isEmpty()) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("");
            }
        }
        isPlayer1Turn = true;
    }
}
