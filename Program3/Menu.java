
/**
 * Allow a user to play the Petals around the Roses game.
 * This is the driver program for Program 3.
 * 
 * @author John Paxton
 * @version September 19, 2012
 */

import java.util.Scanner;

public class Menu
{
    private static final int QUIT = 1;      // indicates the user wants to quit playing
    private static final int PLAY = 2;      // indicates the user wants to play another game
    
    public static void main (String [] args)
    {
        Scanner in = new Scanner(System.in);    // to read input from the console
        
        PetalsGame game = new PetalsGame();     // a Petals Around the Roses game
        
        int choice = PLAY;                      // the player's menu choice
        
        System.out.println("CSCI 111: Petals Around the Roses");
        System.out.println("---------------------------------\n");
        
        while (choice != QUIT)                  
        {
            System.out.println("1. Quit.");
            System.out.println("2. Play.");
            
            System.out.print("\nPlease enter your choice > ");
            choice = in.nextInt();
            System.out.println();
            
            switch (choice)
            {
                case QUIT:
                    System.out.println("Thank you for playing.");
                    break;
                case PLAY:
                    game.rollDice();
                    game.printDice();
                    System.out.println("The number of petals around the roses is " 
                                       + game.calculateAllPetals() + "\n");
                    break;
                default:
                    System.out.println("That is an invalid choice.  Please try again.\n");
            }
        }                
    }    
}