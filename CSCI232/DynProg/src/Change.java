/*
 * To Change this license header, choose License Headers in Project Properties.
 * To Change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gavin
 */
/**
 * Use dynamic programming to solve the coins problem.
 * 
 * @author John Paxton
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Change
{
    Change (String inputFile) throws FileNotFoundException
    {
        in = new Scanner (new File (inputFile) );
    }
    
    public void initialize()
    {
        int numberCoins;
        int maxChange;
//        char characters[] = new char[20];
        int k = 0;
        
        numberCoins = in.nextInt();
        in.nextLine();
        
       
        
        
            String coin = in.nextLine(); 
            //coins[i] 
            char words[] = coin.toCharArray();
            String newString = new String(words);
            numberCoins = newString.length();
            System.out.println("Word " + (1) + "'s value = " + newString);
             coins = new char[numberCoins];
            System.out.println("Length of Word 1 = " + numberCoins);
            for (int j = 0; j < words.length; j++)
            {
                coins[j] =(words[j]);
                
            }
//            coins[k] = ' ';
            k++;
            coin = in.nextLine();
            
            char words2[] = coin.toCharArray();
            String newString2 = new String(words);
            maxChange = newString2.length();
            coins2 = new char[maxChange];
            
//            k = 0;
            System.out.println("Word " + (2) + "'s value = " + newString2);
            for (int j = 0; j < words.length; j++)
            {
                coins2[j] =(words2[j]);
//                k++;
            }
        
//        maxChange = in.nextInt();
        System.out.println("Length of word 2 = " + maxChange);
        
        solutions = new int [maxChange + 1][numberCoins + 1];
        
        for (int i = 1; i <= maxChange; i++)
        {
            solutions[i][0] = coins[i-1];
        }
        for (int i = 1; i <= numberCoins; i++)
        {
            solutions[0][i] = coins2[i-1];
        }
        
        for (int i = 1; i <= maxChange; i++)
        {
            for (int j = 1; j < numberCoins; j++)
            {
                solutions[i][j] = 0;
            }
        }
        
        printTable();
        }
    
    private void printTable()
    {
        System.out.println("Table");
        for (int i = 0; i < solutions.length; i++)
        {
//            System.out.println(solutions.length);
//            System.out.println(coins2.length);
            for (int j = 0; j < coins2.length; j++)
            {
                System.out.print(solutions[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
    public void fillTable()
    {
        for (int column = 1; column < coins.length; column++)
        {
            for (int row = 0; row < solutions.length; row++)
            {
                // Dynamic Programming
                if (coins[column] > row)
                {
                    solutions[row][column] = solutions[row][column - 1];
                }
                else
                {
                    solutions[row][column] = Math.min (
                      solutions[row][column - 1],
                      solutions[row - coins[column]][column] + 1 );
                }
            }
        }
        printTable();
    }
    
    public void solveProblems()
    {
//        int changeAmount;
        
//        while (in.hasNext())
//        {
////            changeAmount = in.nextInt();
//            System.out.println("The least number of coins for "
//              + " is " + solutions[changeAmount][coins.length - 1]);
//        }
    }
    
    private char coins[], coins2[];
    private int solutions[][];
    private Scanner in;
}