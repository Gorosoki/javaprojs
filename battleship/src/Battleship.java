
import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.InputMismatchException;

/**
 * The Game of Battleship
 *
 * @author Aaron Mead & Gavin Goroski
 * @version December 3, 2012
 */
public class Battleship {
    // instance variables

    private Square[][] board;
    private int hits;
    public int size;
    private int movesMade;
    private final int pboat = 2;
    private final int carrier = 5;
    private final int battleship = 4;
    private final int sub = 3;
    private int boat;
    private boolean boatdock = false;

    /**
     * Constructor for objects of class Battleship
     */
    public Battleship(int inSize) {
        size = inSize;
        board = new Square[size][size];
        resetBoard();
    }

    /**
     * resetBoard()
     *
     * resets the board
     *
     */
    public void resetBoard() {
        movesMade = 0;
        hits = 0;
        initialize();
        boat(carrier);
        boat(battleship);
        boat(sub);
        boat(pboat);
    }

    /**
     * boat()
     *
     * randomly places the boats
     */
    public void boat(int boat) {
        boatdock = false;
        int rotation = rotation();
        if (rotation == 0) {
            int y = depth(boat);
            int x = position();
            for (int i = 0; i < boat; i++) {
                if (board[x][y + i].getContents() != 0) {
                    boatdock = true;
                }
            }
            if (boatdock == true) {
                boat(boat);
            } else {
                for (int i = 0; i < boat; i++) {
                    board[x][y + i].setContents(boat);
                }
            }
        } else {
            int x = depth(boat);
            int y = position();
            for (int i = 0; i < boat; i++) {
                if (board[x + i][y].getContents() != 0) {
                    boatdock = true;
                }
            }
            if (boatdock == true) {
                boat(boat);
            } else {
                for (int i = 0; i < boat; i++) {
                    board[x + i][y].setContents(boat);
                }
            }
        }
    }

    /**
     * position()
     *
     * chooses the starting position
     */
    private int position() {
        int position = (int) (Math.random() * size);
        return position;
    }

    /**
     * rotation()
     *
     * chooses horizontal or vertical starting position
     */
    private int rotation() {
        int rotation = (int) (Math.random() * 2);
        return rotation;
    }

    /**
     * depth
     *
     * chooses a restricted starting position
     */
    private int depth(int boat) {
        int depth = (int) (Math.random() * (size - boat));
        return depth;
    }

    /**
     * printBoard(boolean)
     *
     * prints the board, also prints the board with the locations hidden
     */
    public void printBoard(boolean reveal) {
        if (reveal == true) {
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    board[y][x].setKnown(true);
                }
            }
            System.out.println();
            printSeparator();

            for (int i = 0; i <= size - 1; i++) {
                printY(i);
                printSeparator();
            }
            printNumbers();

            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    board[y][x].setKnown(false);
                }
            }
        } else {
            System.out.println();
            printSeparator();
            for (int i = 0; i <= size - 1; i++) {
                printY(i);
                printSeparator();
            }
            printNumbers();
        }
    }

    /**
     * printX()
     *
     * assists the printBoard, print the pipes and the Array values
     */
    private void printY(int y) {
        if (board[0][y].getKnown() == true) {
            System.out.print((y + 1) + " |" + board[0][y].getContents() + "|");
        } else {
            System.out.print((y + 1) + " |" + " " + "|");
        }

        for (int x = 1; x < size; x++) {
            if (board[x][y].getKnown() == true) {
                System.out.print(board[x][y].getContents() + "|");
            } else {
                System.out.print(" " + "|");
            }
        }

        System.out.println();
    }

    /**
     * printSeparator()
     *
     * prints the row separators
     */
    private void printSeparator() {
        System.out.print(" " + " ");
        for (int i = 0; i < size; i++) {
            System.out.print("+-");
        }
        System.out.println("+");
    }

    /**
     * printNumber()
     *
     * prints the numbers at the bottom of the board
     */
    private void printNumbers() {
        System.out.print(" " + " " + " 1 ");
        for (int i = 2; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * over()
     *
     * decides when the game is over, prints an exit message
     */
    public boolean over() {
        boolean gameover = false;

        if (hits < 14) {
            gameover = false;
        } else {
            gameover = true;
        }

        return gameover;
    }

    /**
     * printStatistics()
     *
     * prints the number of guesses
     */
    public void printStatistics() {
        System.out.println("Congratulations! You sunk the enemy fleet using " + movesMade + " guesses! Game Over.");
    }

    /**
     * makeGuess()
     *
     * allows user to guess row,column coordiantes
     */
    public void makeGuess() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("\n" + "Enter a row to guess > ");
            int y = (in.nextInt() - 1);

            System.out.print("\n" + "Enter a column to guess > ");
            int x = (in.nextInt() - 1);

            if ((x >= 0) && (x <= size - 1)) {
                x = x;
            } else {
                throw (new OutOfBoundsException("Error: Invalid Column."));
            }
            if (board[x][y].getKnown() == true) {
                System.out.println("You already guessed that square!");
                movesMade++;
            } else {
                if (board[x][y].getContents() == 0) {
                    System.out.println("Miss! There is nothing there.");
                } else if (board[x][y].getContents() == 5) {
                    System.out.println("Hit! You just sunk part of the Aircraft Carrier.");
                    hits++;
                } else if (board[x][y].getContents() == 4) {
                    System.out.println("Hit! You just sunk part of the Battleship.");
                    hits++;
                } else if (board[x][y].getContents() == 3) {
                    System.out.println("Hit! You just sunk part of the Submarine.");
                    hits++;
                } else if (board[x][y].getContents() == 2) {
                    System.out.println("Hit! You just sunk part of the Patrol Boat.");
                    hits++;
                } else {
                    System.out.println("Invalid Point");
                }
                board[x][y].setKnown(true);
            }
        } catch (OutOfBoundsException exception) {
            System.out.println(exception);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Error: Invalid Row");
        } catch (InputMismatchException exception) {
            System.out.println("Error: Invalid Entry");
        }

        in.nextLine();
        movesMade++;
    }

    /**
     * initialize()
     *
     * sets the whole array to a given value
     *
     */
    public void initialize() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Square tile = new Square();
                tile.setContents(0);
                board[x][y] = tile;
            }
        }
    }
}
