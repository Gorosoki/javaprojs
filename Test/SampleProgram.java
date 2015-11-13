/**
 * Sample program showing how to use a random number generator.  This is NOT your program.
 * You will need to add many things and change others.  This program is only used to
 * illustrate some of the concepts you will need.
 * 
 * @author Dale Reed 
 * @version Jan 24, 2011
 * 
 */

import java.util.Scanner;		  // allows user input from the keyboard
import java.util.Random;          // allows getting a random number


public class SampleProgram
{      	

    public static void main(String[] args)
    {       
        // variable declarations
        Scanner keyboard = new Scanner( System.in);     // used to read user input
        Random randomNumberGenerator = new Random(1); 	// Use 1 as the random seed, to give reproducible results 
        											    //     between program runs.  Removing the 1 will give different
        												//     results each time.
        int userInput;
        
        // Display identifying information
		System.out.println("Author: Dale Reed \n"
				+ "Program: #2, Petals of the Rose \n" 
				+ "CS 107 "
				+ "TA: Englebert Humberdink, T 4-5 \n"
				+ "Jan 24, 2011");
		System.out.println();
                 
        // Display game instructions 
		System.out.println("Welcome to the Petals of the Rose puzzle.  On each turn you will  \n" 
		                 + "be presented with 5 dice values which are randomly chosen.  These  \n"
		                 + "dice represent a numerical value, which will always be even.  If   \n"
		                 + "you can correctly identify the right answer 6 times in a row, you  \n"
		                 + "become an official \"Keeper of the Rose.\" " 
		                 + "   \n"
		                 + "For example consider the following dice:  \n"
		                 + "-------  \n"
		                 + "|*    |  \n"
		                 + "|  *  |  \n"
		                 + "|    *|  \n"
		                 + "-------  \n"
		                 + "  \n"
		                 + "-------  \n"
		                 + "|*   *|  \n"
		                 + "|  *  |  \n"
		                 + "|*   *|  \n"
		                 + "-------  \n"
		                 + "  \n"
		                 + "-------  \n"
		                 + "|*   *|  \n"
		                 + "|*   *|  \n"
		                 + "|*   *|  \n"
		                 + "-------  \n"
		                 + "  \n"
		                 + "-------  \n"
		                 + "|     |  \n"
		                 + "|  *  |  \n"
		                 + "|     |  \n"
		                 + "-------  \n"
		                 + "  \n"
		                 + "-------  \n"
		                 + "|*   *|  \n"
		                 + "|     |  \n"
		                 + "|*   *|  \n"
		                 + "-------  \n"
		                 + "  \n"
		                 + "The answer to this would be 6. OK, here we go:   \n");
		
		// Get a random number
		int randomValue = randomNumberGenerator.nextInt( 6) + 1;   // get random number 0..5 and add 1 to it
		System.out.println("randomValue is: " + randomValue);
		
		// Display the "graphical" representation for the number 5
		System.out.println("-------  \n"
				         + "|*   *|  \n"
				         + "|  *  |  \n"
				         + "|*   *|  \n"
				         + "-------  \n");
		// and so on...
		
		System.out.print("Enter some number to use in the following loop: ");
		userInput = keyboard.nextInt();
		
		if( userInput == 5) {
			System.out.println("You entered a 5.");
		}
		else {
			System.out.println("You did NOT enter a 5.");
		}

		
		// If you repeatedly call the random number generator, you will start to get different values
		int counter = 0;
		System.out.print("Random values are: ");
		while( counter < userInput) {
			randomValue = randomNumberGenerator.nextInt( 6) + 1;   // get random number 0..5 and add 1 to it
			System.out.print( randomValue + " ");
			counter++;	// add 1 to the counter to avoid having an infinite loop
		}
		
		System.out.println("Exiting program...");
    }//end method main()


}// end class SampleProgram()