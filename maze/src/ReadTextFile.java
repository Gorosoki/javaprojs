/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Aaron Mead & Gavin Goroski
 */
public class ReadTextFile
{

    private static int startX;
    private static int startY;
    //assigns the file location to a string
    private static String fileName = "maze.txt";
    private static int x;
    private static int y;
    private static Character content;
    private final static Character move = '+';
    private final static Character clear = ' ';
    private final static Character wall = '*';
    private final static Character start = 'S';
    private final static Character crumb = 'b';
    private final static Character finish = 'T';
    private static Character[][] list;
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        //prints original array
        try
        {
            Scanner scanner = new Scanner(new FileReader(fileName));

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                char[] row = line.toCharArray();
                System.out.println(row);
            }
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println();
        //find the maze size
        try
        {
            Scanner v = new Scanner(new File(fileName));
            String size = v.nextLine();
            char[] temp = size.toCharArray();
            if(temp.length == 5)
            {
                char i = temp[0];
                char j = temp[1];
                x = Integer.valueOf(String.valueOf(i) + String.valueOf(j));
                
                char k = temp[3];
                char l = temp[4];
                y = Integer.valueOf(String.valueOf(k) + String.valueOf(l));
                
            }
            
            else if(temp.length == 3)
            {
                char i = temp[0];
                char j = temp[2];
                int x = Integer.valueOf(String.valueOf(i));
                int y = Integer.valueOf(String.valueOf(j));
            }
            else{
                System.out.println("Invalid Maze size");
                }
            v.close();
        }
         catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }

       list = new Character[y][x];


        try
        {
            Scanner s = new Scanner(new File(fileName));
            String size = s.nextLine();

            while (s.hasNextLine())
            {
                for (int i = 0; i < y; i++)
                {
                    String line = s.nextLine();
                    char[] row = line.toCharArray();
                    for (int j = 0; j < x; j++)
                    {
                        list[i][j] = row[j];
                    }
                }

            }
            s.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }

        for (int i = 0; i < (y - 1); i++)
        {
            for (int j = 0; j < (x - 1); j++)
            {

                if (list[i][j].equals(start))
                {

                    startY = i;
                    startX = j;
//                    System.out.println(i + " " + j);
                    break;
                }
            }
            if (list[startY][startX].equals(start))
            {
                break;
            }
        }
        explore(startY, startX);
    }

    public static void explore(int currentY, int currentX)
    {
             // check for finish
            try{
            if (list[currentY - 1][currentX].equals(finish) || list[currentY + 1][currentX].equals(finish) 
                || list[currentY][currentX+1].equals(finish) || list[currentY][currentX-1].equals(finish))
                {
                System.out.println();
                printList();
                System.out.println("Congratulations you Win!!");
                return;
                }
            }
            catch (ArrayIndexOutOfBoundsException exception)
            {
                System.out.println("Check for win failed!");
            }
            

        try
            { 
            printList();
            
            //check up
            if (list[currentY - 1][currentX].equals(clear))
            {
                list[currentY - 1][currentX] = move;
                currentY--;
                explore(currentY, currentX);
            }
                 //check down
                else if (list[currentY + 1][currentX].equals(clear))
                    {
                        list[currentY + 1][currentX] = move;
                        currentY++;
                        explore(currentY, currentX);
                    }

                //check right
                else if (list[currentY][currentX + 1].equals(clear))
                            {
                                list[currentY][currentX + 1] = move;
                                currentX++;
                                explore(currentY, currentX);
                            }
                    //check left
                    else if (list[currentY][currentX - 1].equals(clear))
                        {
                            list[currentY][currentX - 1] = move;
                            currentX--;
                            explore(currentY, currentX);
                        }
            
                    //check up move back
                        else if (list[currentY - 1][currentX].equals(move))
                        {
                            list[currentY][currentX] = crumb;
                            currentY--;
                            explore(currentY, currentX);
                        }
                            //check down move back
                            else if (list[currentY + 1][currentX].equals(move))
                                    {
                                        list[currentY][currentX] = crumb;
                                        currentY++;
                                        explore(currentY, currentX);
                                    } 
                                //check right move back
                                else if (list[currentY][currentX + 1].equals(move))
                                        {
                                            list[currentY][currentX + 1] = crumb;
                                            currentX++;
                                            explore(currentY, currentX);
                                        }
                                     //check left move back
                                    else if (list[currentY][currentX - 1].equals(move))
                                        {
                                            list[currentY][currentX] = crumb;
                                            currentX--;
                                            explore(currentY, currentX);
                                        }

                                     else
                                        {

                                            System.out.println("Cannot Find RouteQ");
                                        }
            }

        catch (ArrayIndexOutOfBoundsException exception)
            {

            }

    }
    
    public static void printList()
    {
        for (int i = 0; i < y; i++)
        {
            for (int j = 0; j < x; j++)
            {
                System.out.print(list[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
