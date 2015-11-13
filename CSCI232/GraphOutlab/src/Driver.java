import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Gavin
 * @date 3/19/2014
 */
public class Driver
{
//    private int g[][];
//    private int v, e;
//    private int d[], p[], visited[];
    //assigns the file location to a string
//    private final static String fileName = "testgraph1.txt";
//    private final static String fileName2 = "testgraph2.txt";

    private static int x, x2, y;
    private static char[][] list;
    private static Double[][] list2;
    private static final char[] alpha = new char[10];
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
        alpha[8] = 'i';
        alpha[9] = 'j';

//        breadthFirst(list);
//        depthFirst(list);
        readInMatrix("graph.txt");
        breadthFirst(list);
        depthFirst(list);
        readInMatrix("testgraph1.txt");
        readInWeightedMatrix("testgraph2.txt");
        warshalls();
        floydwarshalls();
        Graph g = new Graph();
        g.callprim();
        dijkstra(list2, 0);
        dijkstra(list2, 3);
    }

    public static void readInMatrix(String fileName)
    {
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
        System.out.println("Oringal Unweighted Matrix!");
        //prints original array
        for (int g = 0; g < x; g++)
        {
            for (int y = 0; y < x; y++)
            {
                System.out.print(list[g][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void readInWeightedMatrix(String fileName2)
    {
        try
        {
            Scanner scanner = new Scanner(new FileReader(fileName2));
            x2 = 0;
            while (scanner.hasNextInt())
            {
//            String line = scanner.nextLine();
                int temp = scanner.nextInt();

                x2++;

//                char[] row = line.toCharArray();
//                System.out.println(row);
            }
            scanner.close();
            x2 = (int) Math.sqrt(x2);
//            System.out.println(x2);
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println();

        list2 = new Double[x2][x2];

        try
        {
            Scanner s = new Scanner(new File(fileName2));
            //String size = s.nextLine();

            int y = 0;
            int q = 0;
            while (s.hasNextInt())
            {
                double weight = s.nextInt();
                if (q == x2)
                {
                    y++;
                    if (weight < 0)
                    {
                        list2[y][0] = Double.POSITIVE_INFINITY;
                    }
                    else
                    {
                        list2[y][0] = weight;
                    }
                    q = 1;
                }
//                String line = s.nextLine();
//                char[] row = line.toCharArray();
//                        System.out.println(row);
                else
                {
//                    System.out.println(y +" " + q);
                    if (weight < 0)
                    {
                        list2[y][q] = Double.POSITIVE_INFINITY;
                    }
                    else
                    {
                        list2[y][q] = weight;
                    }
                    q++;
                }

            }

            s.close();
        }

        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println("Original Weighted Matrix!");
        //prints original array
        for (int g = 0; g < x2; g++)
        {
            for (int j = 0; j < x2; j++)
            {
                System.out.print(list2[g][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void breadthFirst(char array[][])
    {
        int[] queue = new int[x];
        Queue<Integer> test = new LinkedList();
        int i = 0;
        int q = 1;
        int m = 0;

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
                    if (list[i][z] == '1')
                    {
                        if (checkQueue(queue, z) && q < x)
//                        if(checkQueue2(test, z) && q < x)
                        {
//                            test.add(z);
                            queue[q] = z;
                            q++;
                        }
                    }
                }
            }
            if (m < x)
            {
//                i = test.remove();
                i = queue[m++];
//                m++;
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

//    public static boolean checkQueue2(Queue test, int x)
//    {
//        return false;
//    }

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
        while (m < x || queue[x - 1] == -1)
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

            if (!searching && visited[x - 1] == -1)
            {
//                System.out.println("if statement");
                int p = 1;
                i = visited[(q - 2)];
//                System.out.println(i);
                searching = false;
                p++;
            }
            else
            {
                if (m < x)
                {
                    i = visited[q - 1];
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
    }

    public static void warshalls()
    {
        int dist[][] = new int[x][x];
//      System.arraycopy(list,0,dist,0,x);
        for (int g = 0; g < x; g++)
        {
            for (int h = 0; h < x; h++)
            {
                if(list[g][h] == '1')
                {
                dist[g][h] = 1;
                }
                else
                {
                    dist[g][h] = 0;
                ;
            }
        }
        }
        for (int k = 0; k < x; k++)
        {
            for (int i = 0; i < x; i++)
            {
                if (dist[i][k] == 0)
                {
                    continue;
                }
                for (int j = 0; j < x; j++)
                {
                    if (dist[i][k] == 1 && dist[k][j] == 1)
                    {
                        dist[i][j] = 1;
                    }

                }
            }
        }
        
        System.out.println("Warshall's Adjacency!");
        //prints array
        for (int a = 0; a < x; a++)
        {
            for (int b = 0; b < x; b++)
            {
                System.out.print(dist[a][b] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

public static void floydwarshalls()
    {
        double dist[][] = new double[x2][x2];
        for (int g = 0; g < x2; g++)
        {
            for (int h = 0; h < x2; h++)
            {
                dist[g][h] = list2[g][h];
            }
        }
        for (int k = 0; k < x2; k++)
        {
            for (int i = 0; i < x2; i++)
            {
                for (int j = 0; j < x2; j++)
                {
                    if (dist[i][j] > (dist[i][k] + dist[k][j]) && dist[i][k] + dist[k][j] > 0)
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }

                }
            }
        }
        System.out.println("Floyd Warshall's Shortest Path!");
        //prints array
        for (int g = 0; g < x2; g++)
        {
            for (int j = 0; j < x2; j++)
            {
                System.out.print(dist[g][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void dijkstra(Double listd[][], int startpoint)
    {
        System.out.println("\n\nDijkstra's!");
        System.out.println("Point   Distance from Starting point " + startpoint + " to each vertex.");
        double dist[] = new double[x2];     // The output array.  dist[i] will hold the shortest path from start to i
        boolean sptSet[] = new boolean[x2]; // sptSet[i] will true if vertex i is included in shortest

        // Initialize all distances as INFINITY and boolean array to false
        for (int i = 0; i < x2; i++)
        {
            dist[i] = Double.POSITIVE_INFINITY;
            sptSet[i] = false;
        }
        // Distance of source vertex =0
        dist[startpoint] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < x2 - 1; count++)
        {
            double u = minDistance(dist, sptSet);
            sptSet[(int) u] = true;

            for (int v = 0; v < x2; v++)

  
            {
                if (!sptSet[v])
                {
                 if (listd[(int) u][v] != 500000)
                    {
                        if (dist[(int) u] != 500000)
                        {

                            if (dist[(int) u] + listd[(int) u][v] < dist[v])
                            {
                                dist[v] = dist[(int) u] + listd[(int) u][v];
                            }
                        }
                    }
                }
            }
        }

        // print the constructed distance array
        printSolution(dist, x2);
    }

    public static double minDistance(double dist[], boolean sptSet[])
    {
        // Initialize min value at infinity
        double min = Double.POSITIVE_INFINITY;
        double min_index = 0;

        for (int v = 0; v < x2; v++)
        {
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

// Prints the final results
    public static void printSolution(double dist[], int n)
    {
        
        for (int i = 0; i < x2; i++)
        {
            System.out.println(i  + "\t" + dist[i]);
        }
    }

    public static class Graph
    {

        int v;
        int p[], visited[];
        double d[];
        double dist[][] = new double[x2][x2];

        private void prim()
        {
            for (int l = 0; l < x2; l++)
            {
                for (int h = 0; h < x2; h++)
                {
                    dist[l][h] = list2[l][h];
                }
            }
            int c, current, mincost = 0;
            current = 1;
            visited[current] = 1;
            d[current] = 0;
            c = 1;
            while (c != v)
            {
                for (int i = 1; i <= v; i++)
                {
                    if (dist[current][i] != 0 && visited[i] != 1)
                    {
                        if (dist[current][i] < d[i])
                        {
                            d[i] = dist[current][i];
                            p[i] = current;
                        }
                    }
                }
                double min = 50000;
                for (int i = 1; i <= v; i++)
                {
                    if (visited[i] != 1 && d[i] < min)
                    {
                        min = d[i];
                        current = i;
                    }
                }
                visited[current] = 1;
                c = c + 1;
            }
            for (int i = 1; i <= v; i++)
            {
                mincost += d[i];
            }
            System.out.println("Prim's!");
            System.out.println("Minimum cost= " + mincost);
        }

        void callprim()
        {
            v = x2 - 1;
            visited = new int[v + 1];
            d = new double[v + 1];
            p = new int[v + 1];
            for (int i = 1; i <= v; i++)
            {
                p[i] = visited[i] = 0;
            }
            for (int i = 1; i <= v; i++)
            {
                d[i] = Double.POSITIVE_INFINITY;
            }
            prim();
        }

    }

}
