
/**
 * Write a description of class aRecursiveMethod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class aRecursiveMethod
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class aRecursiveMethod
     */
    public aRecursiveMethod()
    {
        // initialise instance variables
        x = 0;
    }

    public void aRecursiveMethod (int number1, int number2)
    {
        System.out.println("Number 1 = " + number1 + ", Number 2 = " + number2);
        if (number2 != 0)
        {
            aRecursiveMethod (number2, number1 % number2);
        }
    }

    private void printRow (int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }

    public void printSquare (int n) // n is the dimension of the square, assume it is at least 1
    {
        printRow(n);
        for(int i = 0; i < n-2; i++)
        {
            System.out.format("%S %3S","*","*");
            System.out.println();
        }
        printRow(n);
    }

    public int italianThreeDayPass (int travelers, int trainClass)
    {
        if (trainClass == 1)
        {
            if(travelers > 1)
            {
                return (travelers* 175);
            }

            else
            {
                return (200 * travelers);
            }
        }
        else
        {
            return (150 * travelers);
        }
    }

    public int divide (int number1, int number2)        // your solution
    {
        try{
            return number1 / number2;
        }

        catch(ArithmeticException exception)
        {
            System.out.println("Cannot Divide By Zero");
        }
        return 0;
    }
}