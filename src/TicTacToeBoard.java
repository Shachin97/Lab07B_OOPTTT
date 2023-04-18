import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeBoard {

    private static TicTacToeTile[][] board = new TicTacToeTile[3][3];
    private static int numMove = 0;
    private static String player = "X";

    public static void createGame(JPanel panel) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                board[row][col] = new TicTacToeTile(row, col);
                board[row][col].setText(" ");
                board[row][col].setFont(new Font(Font.SERIF, Font.PLAIN, 30));
                panel.add(board[row][col]);
            }
    }

    public static boolean restartGame() {
        int dialogButton = JOptionPane.showConfirmDialog(null, "Do you play the game again?", "End Game?", JOptionPane.YES_NO_OPTION);
        if (dialogButton == JOptionPane.YES_OPTION) {
            TicTacToeGame.clearBoard();
            for (int row = 0; row < 3; row++)
                for (int col = 0; col < 3; col++) {
                    board[row][col].setText(" ");
                }

        } else {
            System.exit(0);
        }
        return false;
    }

    public static void playGame(JLabel game) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
            {
                board[row][col].setFont(new Font(Font.SERIF, Font.ITALIC, 15));
                board[row][col].addActionListener((ActionEvent ae) ->
                {
                    TicTacToeTile player = (TicTacToeTile) ae.getSource();

                        if (!player.getText().equals(" ")) {
                            JOptionPane.showMessageDialog(null, "Illegal Move. Choose an empty square");
                            return;

                        } else {
                            player.setText(String.valueOf(TicTacToeBoard.player));
                            TicTacToeGame.updateGame(String.valueOf(TicTacToeBoard.player), player.getRow(), player.getCol());
                        }

                            numMove++;
                            updatePlayer();

                            if (numMove >= 5) {
                                winGame();
                            }
                            if (numMove >= 7) {
                                tieGame();
                            }

                });
            }
            }

    private static void tieGame() {
        if (TicTacToeGame.isTie()) {
            JOptionPane.showMessageDialog(null, "Tie game!");
            restartGame();
        }
    }

    private static void winGame() {
        if (TicTacToeGame.isWin(player)) {
            JOptionPane.showMessageDialog(null, "Player " + player + " " + "wins!");
            restartGame();

            player = "X";
        }
    }

    public static void updatePlayer() {
        if (player == "X") {
            player = "O";
        } else {
            player = "X";
        }
    }
}

