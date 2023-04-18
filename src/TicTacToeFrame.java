import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class TicTacToeFrame extends JFrame
{
    JPanel mainPnl, centerPnl, bottomPnl;

    JButton quitBtn;
    JLabel turn;

    public TicTacToeFrame() {

        setSize( 540,600);

        setTitle("Tic Tac Toe Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createGUI();
        setVisible(true);

    }

    public void createGUI()
    {
        mainPnl = new JPanel();
        centerPnl = new JPanel();
        bottomPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(centerPnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl,BorderLayout.SOUTH);

        add(mainPnl);

        createGridPnl();
        createBottomPnl();

    }

    public void createGridPnl() {
        centerPnl.setLayout(new GridLayout(3, 3));

        TicTacToeBoard.createGame(centerPnl);
        TicTacToeBoard.playGame(turn);

    }
    public void createBottomPnl()
    {
        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.add(quitBtn);
    }
}