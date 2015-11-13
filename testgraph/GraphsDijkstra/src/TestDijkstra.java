
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Program to solve a maze represented as a graph.
 *  This program performs a breadth-first search of the graph
 *  to find the "shortest" path from the start vertex to the
 *  end. It is assumed that the start vertex is 0, and the
 *  end vertex is numV-1.
 *  @author Gavin Goroski & Aaron Mead
 */
public class TestDijkstra {
//        private static boolean has;
        private static Integer[][] asteroids;
        private static Integer[][] planets;
        private static String BLANK = "";
        private static Integer x = 0;
        private static Integer y = 0;
        public static String[] pNames;
        public static Planets[] array;
        public static final int Alderan = 1;
        public static final int Anoat = 2;
        public static final int Ansion = 3;
        public static final int Bespin = 4;
        public static final int Bogden = 5;
        public static final int BozPity = 6;
        public static final int CatoNeimoidia = 7;
        public static final int Corellia = 8;
        public static final int Coruscant = 9;
        public static final int Dagobah = 10;
        public static final int Dantooine = 11;
        public static final int Endor = 12;
        public static final int Felucia = 13;
        public static final int Geonosis = 14;
        public static final int Hoth = 15;
        public static final int Iego = 16;
        public static final int Kamino = 17;
        public static final int Kashyyyk = 18;
        public static final int Kessel = 19;
        public static final int Malastare = 20;
        public static final int Mustafar = 21;
        public static final int Mygeeto = 22;
        public static final int Naboo = 23;
        public static final int NarShaddaa = 24;
        public static final int OrdMantell = 25;
        public static final int PolisMassa = 26;
        public static final int Saleucami = 27;
        public static final int Subterrel = 28;
        public static final int Sullust = 29;
        public static final int Taanub = 30;
        public static final int Tatooine = 31;
        public static final int Tund = 32;
        public static final int Utapau = 33;
        public static final int Yavin = 34;
        public static final int YavinIV  = 35;
        
    /** Main method to solve the maze.
     *  pre: args[0] contains the name of the input file.
     *  @param args Command line argument
     */
    public static void main(String[] args) {
        final int QUIT = 1;
        final int RESTART = 2;
        final int LIST = 3;
        asteroids = new Integer[10][3];
        planets = new Integer[35][2];
        array = new Planets[35];
        pNames = new String[35];
        pNames[0] = "Alderan";
        pNames[1] = "Anoat";
        pNames[2] = "Ansion";
        pNames[3] = "Bespin";
        pNames[4] = "Bogden";
        pNames[5] = "Boz Pity";
        pNames[6] = "Cato Neimoidia";
        pNames[7] = "Corellia";
        pNames[8] = "Coruscant";
        pNames[9] = "Dagobah";
        pNames[10] = "Dantooine";
        pNames[11] = "Endor";
        pNames[12] = "Felucia";
        pNames[13] = "Geonosis";
        pNames[14] = "Hoth";
        pNames[15] = "Iego";
        pNames[16] = "Kamino";
        pNames[17] = "Kashyyyk";
        pNames[18] = "Kessel";
        pNames[19] = "Malastare";
        pNames[20] = "Mustafar";
        pNames[21] = "Mygeeto";
        pNames[22] = "Naboo";
        pNames[23] = "Nar Shaddaa";
        pNames[24] = "Ord Mantell";
        pNames[25] = "Polis Massa";
        pNames[26] = "Saleucami";
        pNames[27] = "Subterrel";
        pNames[28] = "Sullust";
        pNames[29] = "Taanub";
        pNames[30] = "Tatooine";
        pNames[31] = "Tund";
        pNames[32] = "Utapau";
        pNames[33] = "Yavin";
        pNames[34] = "YavinIV";
        
        
        int menuChoice = 0;
        SetArray();
                
        Scanner in = new Scanner (System.in);
        System.out.println("Intergalactic Navagation");;
        while (menuChoice != QUIT)
        {
            System.out.println("1. Quit. ");
            System.out.println("2. Travel.");
            System.out.println("3. Print a List of Destinations.");
        System.out.println("Please enter your choice > ");
       menuChoice = in.nextInt();
        switch (menuChoice)
        {
            case QUIT:
                System.out.println("Goodbye!");
                break;
            case RESTART:
                travel(in);
                break;
            case LIST:
                for(int i = 0; i < 35; i++)
                {
                System.out.println((i+1) + ". " + pNames[i]);
                }

                System.out.println();
                         
                break;
            default:
                System.out.println("Careful you almost hit an asteroid!");
        }
       
    }
    }
    
    public static void travel(Scanner in)
    {
        int numV = 35; // The number of vertices.
        int planet = 0;
        Graph theGraph = null;
        try
        {
            theGraph = AbstractGraph.createGraph(array, false, "Matrix");
    //        switch(planet)
    //        {
    //            case HOTH:
    //                System.out.println("HOTH");
    //                break;
    //            case APPLE:
    //                System.out.println("APPLE");
    //                break;
    //            case PEAR:
    //                System.out.println("PEAR");
    //                break;
    //            default:
    //                System.out.println("FAILURE!!!!!!!!");
    //        }
             //Load the graph data from a file.
    //        try {
    //            Scanner scan = new Scanner(new FileReader(".\\src\\testgraph1.txt"));
    //            theGraph = AbstractGraph.createGraph(arrray, false, "Matrix");
    //            numV = theGraph.getNumV();
    //        } catch (IOException ex) {
    //            System.err.println("IO Error while reading graph");
    //            System.err.println(ex.toString());
    // starting  vertex
    //        }
             // starting  vertex
        }
        catch (IOException ex)
        {
            Logger.getLogger(TestDijkstra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int start = 0;
        int destination = 0;
        int begin = 0;
        int end = 0;
        
        try {
            System.out.print("\n" + "Enter a planet to start from > ");
            begin = (in.nextInt()-1);
            System.out.print(array[begin].getX() + " " + array[begin].getY());
            
            System.out.print("\n" + "Enter a planet to travel to > ");
            end = (in.nextInt()-1);
            System.out.print(array[end].getX() + " " + array[end].getY());
            
            start = begin;
            destination = end;    
        
        
        
        
        int parent[] = new int[numV];
        double dist[] = new double[numV];
        DijkstrasAlgorithm.dijkstrasAlgorithm(theGraph, start, parent, dist);

        // Construct the path.
        
        
        int v = destination;
        Deque<Integer> thePath = new ArrayDeque<Integer>();
        while (parent[v] != -1) {
            thePath.push(new Integer(v));
            v = parent[v];
        }
        // Output the path.
        System.out.print("The Shortest path from " + pNames[start] + " to " + pNames[destination] + " is: " + pNames[start]);
        while (!thePath.isEmpty()) {
            System.out.print("->" + thePath.pop());
        }
        System.out.println();
        System.out.println("The path distance is: " + dist[destination]);
        
        }
        catch(InputMismatchException exception)
        {
            return;
        }
    }
    public static void SetArray()
    {
        
        int xx = -1;
        int yy = -1;
        for(int x1 = 0; x1 < 35; x1++)
        {
            
            
                Planets zone = new Planets(xx, yy);
//                zone.setStuff(has);
                array[x1] = zone;            
        }
        for(int i = 0; i < 10; i++)
        {
               
        x = ((int)(Math.random()*1000));
        y = ((int)(Math.random()*1000));
        Integer r = (int)(Math.random()*50 + 50);
//        asteroids[i] =
        
        }
        
        for(int i = 0; i < 35; i++)
        {
        Random(i);
        
        }
        
    }
    public static void Random(int i)
    {
        x = ((int)(Math.random()*1000));
        y = ((int)(Math.random()*1000));
        if (array[i].getX() == -1 && array[i].getY() == -1)
        {
        array[i].setX(x);
        array[i].setY(y);
        }        
        else
        {
            Random(i);
        }
            System.out.println(pNames[i] + " " + x + " " + y);
            
//            try{
//            PrintWriter writer = new PrintWriter("testgraph1.txt", "UTF-8");
//            writer.println(x+" " + y);
//            writer.close();
//               }
//            catch(FileNotFoundException exception)
//            {
//                System.out.println("oops1");
//            }
//            catch(UnsupportedEncodingException exception)
//            {
//                System.out.println("oops2");                
//            }
        
            

    }

    
    }

/*</listing>*/

