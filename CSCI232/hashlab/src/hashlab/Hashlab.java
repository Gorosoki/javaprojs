/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hashlab;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Gavin
 */
public class Hashlab
{
    private static String fileName = ("file.txt");
    private static int size = 10;
    private static int balance = 0;
    private static Data nullNode = new Data ("", -1);
    private static Data delNode = new Data ("blank", -99);
    private static boolean runs = false;
    private static Data[] table2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Data[] table = new Data[size];
        for (int i = 0; i < size; i++)
        {
            table[i] = nullNode;
        }
         scanin(table);
         while(runs)
         {
            balance = 0;
            System.out.println("Table is almost full...");
            System.out.println("Doubling table size.");
            System.out.println();
             size = 2*size;
             table2 = new Data[size];
                for (int i = 0; i < size; i++)
                {
                    table2[i] = nullNode;
                }
           scanin(table2);
         }
         
        final int QUIT = 1;         // user wants to quit
        final int ADD_VALUE = 2;     // user wants to add a value
        final int DEL_VALUE = 3;       // user wants to delete values
        final int PRINT = 4;        // user wants to print the table
        final int SEARCH_NUM = 5;
        final int SEARCH_WORD = 6;
        
        int menuChoice = 0;         // current menu choice of user
        Scanner in = new Scanner (System.in);
        
        while (menuChoice != QUIT)
        {
            
            System.out.println("\n1. Quit.");
            System.out.println("2. Add a value to the table.");
            System.out.println("3. Delete a value from the table");
            System.out.println("4. Print the score.");
            System.out.println("5. Search using a number");
            System.out.println("6. Search using a word");
            
            System.out.print("Please enter your choice > ");
            menuChoice = in.nextInt();
            
            switch (menuChoice)
            {
                case QUIT:
                    System.out.println("Goodbye!");
                    break;
                case ADD_VALUE:
                    addValue();
                    break;
                case DEL_VALUE:
                    delValue();
                    break;
                case PRINT:
                    print(table2);
                    break;
                case SEARCH_NUM:
                     searchNum();
                     break;
                case SEARCH_WORD:
                     searchWord();
                     break;
                default:
                    System.out.println("That is an invalid choice.  Please try again.");
            }
        }
    
    }
    
    private static boolean loadcheck(int status)
    {
        double check = ((double)status / (double)size); 
//        System.out.println(check);
        if (check >= .8)
        {
            runs = true;
            return true;
        }
        else
        {
            return false;
        }
    }
    private static void scanin(Data[] hashtable)
    {
        
        runs = false;
        try
        {
            
            Scanner scanner = new Scanner(new FileReader(fileName));
            

            while (scanner.hasNextLine() && !loadcheck(balance))
            {
//                if (loadcheck(balance) == true)
//                {
//                    System.out.println("break stupid");
//                    break;
//                    
//                }
                int number = scanner.nextInt();
                String line = scanner.next();
                scanner.nextLine();
                int modnumber = number % size;
                Data value = new Data(line, number);
                balance++;
//                System.out.println(balance + " b");
//                char[] row = line.toCharArray();
                if (hashtable[modnumber] == nullNode)
                    {
                        
                        hashtable[modnumber] = value;
//                        System.out.println(number);
//                        System.out.println(line);
                    }
                else
                    {
                        boolean added = false;
                        while(!added)
                        {
                            modnumber++;
//                            System.out.println(modnumber);
                            modnumber %= size;
//                            System.out.println(modnumber);

                            if(hashtable[modnumber] == nullNode)
                            {
                                hashtable[modnumber] = value;
//                                System.out.println(number);
//                                System.out.println(line);
                                added = true;
                            }
                            else
                            {
                                
                            }
                            
                        }
                    }
            }
            for (int i = 0; i < size; i++)
            {
                System.out.print(i + ": ");
                System.out.println(hashtable[i].getNumber() + " " + hashtable[i].getLine());
            }
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println();
    }
    
    private static void print(Data hashtable[])
    {
                    for (int i = 0; i < size; i++)
            {
                System.out.print(i + ": ");
                System.out.println(hashtable[i].getNumber() + " " + hashtable[i].getLine());
            }
    }
    
    private static void addValue()
    {
        Scanner input = new Scanner (System.in);
        System.out.print("Please enter a number > ");
        int inputNum = input.nextInt();
        System.out.println();
        System.out.print("Please enter a name > ");
        String inputName = input.next();
        input.nextLine();
        System.out.println();
        System.out.println(size);
        
        Data value = new Data(inputName, inputNum);
                balance++;
                int modnumber = inputNum % size;
                if (table2[modnumber] == nullNode)
                    {
                        
                        table2[modnumber] = value;
                    }
                else
                    {
                        boolean added = false;
                        while(!added)
                        {
                            modnumber++;
                            modnumber %= size;

                            if(table2[modnumber] == nullNode)
                            {
                                table2[modnumber] = value;
                                added = true;
                                System.out.println(inputName + " " + inputNum + " was added to the table.");
                            }
                            else
                            {
                                
                            }
                            
                        }
                    }
                balance++;
                
    }
    
    private static void delValue()
    {
        Scanner input = new Scanner (System.in);
        System.out.print("Please enter a number > ");
        int inputNum = input.nextInt();
        System.out.println();
        System.out.print("Please enter a name > ");
        String inputName = input.next();
        input.nextLine();
        System.out.println();
//        System.out.println(size);
        Data inputVal = new Data(inputName, inputNum);
        
        for (int i = 0; i < size; i++)
        {
            if (table2[i].equals(inputVal))
            {
                System.out.println("first one");
            }
            if (table2[i].getLine().equals(inputName) && table2[i].getNumber() == inputNum)
            {
                table2[i] = delNode; 
                System.out.println("second one");
            }
            else
            {
                
            }
        }
    }
    
    private static void searchNum()
    {
        Scanner input = new Scanner (System.in);
        System.out.print("Please enter a number > ");
        int inputNum = input.nextInt();
        System.out.println();
//        System.out.println(size);
        
        for (int i = 0; i < size; i++)
        {
            if (table2[i].getNumber() == inputNum)
            {
                
                System.out.println(table2[i].getLine());
            }
            else
            {
                
            }
        }
    }
    
    private static void searchWord()
    {
        Scanner input = new Scanner (System.in);
        System.out.print("Please enter a name > ");
        String inputName = input.next();
        input.nextLine();
        System.out.println();
        
                for (int i = 0; i < size; i++)
        {
//            System.out.println(size);
            if (table2[i].getLine().equals(inputName))
            {
                
                System.out.println(table2[i].getNumber());
            }
            else
            {
                
            }
        }
    }
    
}
