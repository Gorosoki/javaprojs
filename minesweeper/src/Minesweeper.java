
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Main class of the game Minesweeper
 *
 * @author Gavin Goroski & Aaron Mead
 * @version 27 Jan 2013
 */
public class Minesweeper extends JFrame
{
    // instance variables

    private Square[][] board;
    private int mines;
    private String EMPTY = " ";
    private String BOOM = "*";
//    private int size;
    /**
     * Constructor for objects of class MineSweeper
     */
    public Minesweeper(int size)
    {

        super("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mines = 0;

        board = new Square[size][size]; //initialize board
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                Square tile = new Square();
                tile.setContents(EMPTY);
                board[i][j] = tile;
            }
        }
        setupBoard();
        getContentPane().add(new MinePanel(this));
        pack();
        setLocationRelativeTo(null);

        setVisible(true); // Show the JFrame.



    }

    private void setupBoard()
    {
        printBoard(false);

        if (mines <= 40)
        {

            int x = (int) (Math.random() * board.length);
            int y = (int) (Math.random() * board.length);
            if (board[x][y].getContents() == EMPTY)
            {
                board[x][y].setContents(BOOM);
                mines++;
                setupBoard();
            }
            else
            {
                setupBoard();
            }
        }
    }

    public void printBoard(boolean reveal)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                board[i][j].setKnown(reveal);
            }

        }
    }

    public void checkForLose(int x, int y)
    {

        // check row wins:
        if (checkFullBoard())
        {
            JOptionPane.showMessageDialog(this, "You Win!");
            System.exit(0);
        }
        else if (board[x][y].getContents() == BOOM)
        {
            JOptionPane.showMessageDialog(this, "You Lose");
            System.exit(0);
        }

    }

    private boolean checkFullBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                if (board[i][j].getContents() == EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void checkForGameEnd()
    {
        if (checkFullBoard())
        {
            JOptionPane.showMessageDialog(this, "You Win");
            System.exit(0);
        }

    }

    public String checkForMines(int x, int y)
    {
        int bombs = 0;
        for (int i = (x - 1); i <= (x + 1); i++)
        {
            for (int j = (y - 1); j <= (y + 1); j++)
            {
                try
                {
                    if (board[i][j].getContents() == BOOM)
                    {
                        bombs++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException exception)
                {
                }

            }
        }
        String bombcount = Integer.toString(bombs);
        return bombcount;
    }

    public static void main(String[] args)
    {
        Minesweeper newGame = new Minesweeper(15);
    }

    public void player(int x, int y)
    {
        if (board[x][y].getContents() == EMPTY)
        {
            board[x][y].setContents(checkForMines(x, y));
            board[x][y].setKnown(true);
            repaint();
            checkForLose(x, y);
        }
        else if (board[x][y].getContents() == BOOM)
        {
            board[x][y].setKnown(true);
            repaint();
            printBoard(true);
            checkForLose(x, y);

        }
        else
        {
            JOptionPane.showMessageDialog(this, "You have clicked there already!");
        }


    }

    public String getStuff(int l, int k)
    {
        String stuff = board[l][k].getContents();
        return stuff;
    }

    public boolean getFound(int l, int k)
    {
        return board[l][k].getKnown();
    }

}
