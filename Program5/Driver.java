
/**
 * Driver program for CSCI 111 Program 5.
 * 
 * @author Gavin Goroski & Aaron Mead
 * @version November 7, 2012
 */

import java.util.Scanner;

public class Driver
{
    public static void main (String [] args)
    {
        final int QUIT = 1;         // user wants to quit
        final int ADD_NOTE = 2;     // user wants to add a note
        final int REPEAT = 3;       // user wants to repeat notes
        final int PRINT = 4;        // user wants to print the score
        final int NEW_SCORE = 5;    // start over with an empty score
        final int PLAY_SONG = 6;    // plays the notes in the score
        
        int menuChoice = 0;         // current menu choice of user

        Scanner in = new Scanner (System.in);      // input
        
        MusicScore myScore = new MusicScore();     // the music score
        
        System.out.println("CSCI 111, Program 5: Music Composition");
        
        myScore.newScore();
        
        while (menuChoice != QUIT)
        {
            System.out.println("\n1. Quit.");
            System.out.println("2. Add a note to your score.");
            System.out.println("3. Repeat notes at the end of your score.");
            System.out.println("4. Print the score.");
            System.out.println("5. Start with a new score.");
            System.out.println("6. Play the recorded score. \n");
            
            System.out.print("Please enter your choice > ");
            menuChoice = in.nextInt();
            
            switch (menuChoice)
            {
                case QUIT:
                    System.out.println("Goodbye!");
                    break;
                case ADD_NOTE:
                    myScore.addNote();
                    break;
                case REPEAT:
                    myScore.repeatNotes();
                    break;
                case PRINT:
                    myScore.printScore();
                    break;
                case NEW_SCORE:
                    myScore.newScore();
                    break;
                case PLAY_SONG:
                    myScore.playSong();
                    break;
                default:
                    System.out.println("That is an invalid choice.  Please try again.");
            }
        }
    }
}