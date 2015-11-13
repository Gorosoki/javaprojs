
import java.awt.GridLayout;
import javax.swing.*;


/**
 * Write a description of class TicTacToe here.
 * 
 * @author Brendan
 * @version 13 Jan 2011
 */
public class TicTacToe extends JFrame
{
    // instance variables - replace the example below with your own
    private char curPlayer;
    private char[][] board;

    /**
     * Constructor for objects of class TicTacToe
     */
    public TicTacToe()
    {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new char[3][3]; // initialize board

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {                
                board[i][j] = ' '; // blank char
            }
        }
        getContentPane().add(new TTTPanel(this));
        pack();
        curPlayer = 'X';
        
        setLocationRelativeTo(null);

        setVisible(true); // Show the JFrame.

    }

    public char getCurPlayer() {
        return curPlayer;
    }


    public void switchPlayer() {
        if (curPlayer == 'X')
            curPlayer = 'O';
        else
            curPlayer = 'X';
    }

    public void setSquare(int x, int y, char c) 
    {
        board[x][y] = c;
    }

    public char getSquare(int x, int y) 
    {
        return board[x][y];
    }

    public void printBoard() 
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean checkForWin(char p) {

        boolean win = false;
        // check row wins:
        for (int i = 0; i < 3; i++) {
            win = win || (board[i][0] == p && board[i][1] == p && board[i][2] == p);
        }
        // check column wins:
        for (int j = 0; j < 3; j++) {
            win = win || (board[0][j] == p && board[1][j] == p && board[2][j] == p);
        }
        // check diagonal wins:
        win = win || (board[0][0] == p && board[1][1] == p && board[2][2] == p);
        win = win || (board[0][2] == p && board[1][1] == p && board[2][0] == p);

        return win;
    }

    private boolean checkFullBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public void checkForGameEnd() {
        if (checkForWin('X')) {
            JOptionPane.showMessageDialog(this, "X wins!!!!");
            System.exit(0);
        } else if (checkForWin('O')) {
            JOptionPane.showMessageDialog(this, "O wins!!!!");
            System.exit(0);
        } else if (checkFullBoard()) {
            JOptionPane.showMessageDialog(this, "Game over, draw.");
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        TicTacToe newGame = new TicTacToe();
        //JOptionPane.showMessageDialog(newGame, "This is a test.");
    }
}
