
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Gavin
 * @date 2/28/2014
 */
public class Driver
{

    //assigns the file location to a string
    private final static String fileName = "graph.txt";
    private static int x;
    private static int y;
    private static char[][] list;
    private static char[] alpha = new char[9];
    public static void main(String[] args)
    {
        alpha[0] = 'a';
        alpha[1] = 'b';
        alpha[2] = 'c';
        alpha[3] = 'd';
        alpha[4] = 'e';
        alpha[5] = 'f';
        alpha[6] = 'g';
        alpha[7] = 'h';
        

        try
        {
            Scanner scanner = new Scanner(new FileReader(fileName));
//            while (scanner.hasNextLine())
//            {
            String line = scanner.nextLine();
            x = line.length();
            y = x;
//                char[] row = line.toCharArray();
//                System.out.println(row);
//            }
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println();

        list = new char[x][x];

        try
        {
            Scanner s = new Scanner(new File(fileName));
            //String size = s.nextLine();

            int y = 0;
            while (s.hasNextLine())
            {

                String line = s.nextLine();
                char[] row = line.toCharArray();
//                        System.out.println(row);

                for (int q = 0; q < x; q++)
                {
                    list[y][q] = row[q];

                }
                y++;

            }
            s.close();
        }

        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        //prints original array
        for (int x = 0; x < 5; x++)
        {
            for (int y = 0; y < 5; y++)
            {
                System.out.print(list[x][y]);
            }
            System.out.println();
        }
        System.out.println();
        breadthFirst(list);
        depthFirst(list);
    }

    public static void breadthFirst(char array[][])
    {
        int[] queue = new int[x];
        int i = 0;
        int q = 1;
        int m = 0;
//    int z = 0;

        for (int j = 0; j < x; j++)
        {
            queue[j] = -1;
        }
        queue[0] = 0; //start at first vertex
        while (m < x)
        {
            {
                for (int z = 0; z < x; z++)
                {
                    if (array[i][z] == '1')
                    {
                        if (checkQueue(queue, z) && q < x)
                        {
                            queue[q] = z;
                            q++;
                        }
                    }
                }
            }
            if (m < x)
            {
                i = queue[m++];
            }
        }
            System.out.println("Breadth First Search...");
        for (int k = 0; k < x; k++)
        {
            System.out.print(alpha[queue[k]] + " ");
        }
        System.out.println();
//    System.out.println("A, B, C, E, D");
    }

    public static boolean checkQueue(int[] queue, int x)
    {
        for (int w = 0; w < y; w++)
        {
            if (queue[w] == x)
            {
                return false;
            }

        }
        return true;
    }

    public static void depthFirst(char array[][])
    {
        int[] queue = new int[x];
        int[] visited = new int[x];
        int i = 0;
        int q = 1;
        int m = 0;
        int z = 0;
        int position = 0;
        boolean searching = false;
//    int z = 0;

        for (int j = 0; j < x; j++)
        {
            visited[j] = -1;
            queue[j] = -1;
        }
        queue[0] = 0;//start at first vertex
        visited[0] = 0;
        while (m < x || queue[x-1] == -1)
        {
                z = 0;
                while (!searching && z < x && i < x)
                {
                    if (array[i][z] == '1')
                    {
                        if (checkQueue(visited, z) && q < x)
                        {
                            queue[q] = z;
                            visited[q] = z;
                            searching = true;
                            q++;
                        }

                    }
                    if (!searching)
                    {
                        z++;
                    }
                  

                }
            
            if (!searching && visited[x-1] == -1)
            {
//                System.out.println("if statement");
                int p = 1;
                i = visited[(q-2)];
//                System.out.println(i);
                searching = false;
                p++;
            }
            else
            {
                if (m < x)
                {
                    i = visited[q-1];
                    m++;
                    searching = false;
                }
            }
        }
        System.out.println("Depth First Search...");
        for (int k = 0; k < x; k++)
        {
            System.out.print(alpha[queue[k]] + " ");
        }
        System.out.println();

//        System.out.println("A, B, D, E, C");
    }

}
