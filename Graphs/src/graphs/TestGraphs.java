/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Brendan
 */
public class TestGraphs {

    /**
     * @param args the command line arguments
     */
    public static int a;
    public static int b;
    public static void main(String[] args) {
        // TODO code application logic here
        String fileName = "C:/Users/Gavin/Desktop/testgraph1.txt";
        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            int n = scanner.nextInt(); // first line
            AdjMat_Graph graph = new AdjMat_Graph(n);
            while (scanner.hasNextLine()) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                graph.M[a][b] = graph.M[b][a] = 1;
                System.out.println("added edge: " + a + " " + b);
            }        for(int i = 0; i < b; i++)
        {
            System.out.println();
            System.out.print("[" + i + "] ");
            for (int j = 0; j <a; j++)
            {
            System.out.print(graph.M[i][j]);
            }
            System.out.println();
        }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
