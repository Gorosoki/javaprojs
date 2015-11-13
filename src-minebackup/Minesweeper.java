
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Write a description of class TicTacToe here.
 *
 * @author Brendan
 * @version 13 Jan 2011
 */
public class Minesweeper extends JFrame {
    // instance variables - replace the example below with your own

    private char[][] board;
    private int mines;
    private int moves;

    /**
     * Constructor for objects of class TicTacToe
     */
    public Minesweeper() {
        
        super("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mines = 0;
        board = new char[15][15]; // initialize board

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = ' '; // blank char
            }
        }
        getContentPane().add(new MinePanel(this));
        pack();
        setLocationRelativeTo(null);

        setVisible(true); // Show the JFrame.
        setupBoard();
    }

    public void setupBoard() {
        if(mines <= 40)
        {
       
        int x = (int) (Math.random() * 15);
        int y = (int) (Math.random() * 15);
            if (board[x][y] == ' ') {
                setSquare(x, y, '*');
                mines++;
                setupBoard();
            }
            else{
                setupBoard();
            }
        }
        

        }

    public void setSquare(int x, int y, char c) {
        board[x][y] = c;
    }

    public char getSquare(int x, int y) {
        return board[x][y];
    }

    public void printBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public boolean checkForLose(char p) {

        boolean lose = false;
        // check row wins:
        if (moves == (board.length * board.length) - mines) {
            return lose;
        } else if (p == '*') {
            return lose;
        }

        return lose;
    }

    private boolean checkFullBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void checkForGameEnd() {
        if (checkForLose('*')) {
            JOptionPane.showMessageDialog(this, "You Lose");
            System.exit(0);
        } else if (checkFullBoard()) {
            JOptionPane.showMessageDialog(this, "You Win");
            System.exit(0);
        }

    }

    public char checkForMines(int x, int y) {
        int bombs = 0;
        char cbombs = 0;
        try{
        for (int i = (x - 1); i <= (x + 1); i++) {
            for (int j = (y - 1); j <= (y + 1); j++) {
                if (board[i][j] == '*') {
                    bombs++;
                }
            }
        }
        }
        catch(ArrayIndexOutOfBoundsException exception){
            return 0;          
        }
        //char cbombs = (char)bombs;
        if (bombs >= 0 && bombs <= 9) {
            cbombs = Character.forDigit(bombs, 10);
        }
        return cbombs;
        

        
    }

    public static void main(String[] args) {
        Minesweeper newGame = new Minesweeper();
        //JOptionPane.showMessageDialog(newGame, "This is a test.");
    }
}
