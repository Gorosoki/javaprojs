/*<listing chapter="10" number="2">*/


import java.io.IOException;
import java.util.Scanner;

/**
 * Abstract base class for graphs. A graph is a set
 * of vertices and a set of edges. Vertices are
 * represented by integers from 0 to n - 1. Edges
 * are ordered pairs of vertices.
 * @author Gavin Goroski & Aaron Mead
 */
public abstract class AbstractGraph implements Graph {

    // Data Fields
    /** The number of vertices */
    private int numV;
    /** Flag to indicate whether this is a directed graph */
    private boolean directed;

    // Constructor
    /**
     * Construct a graph with the specified number of vertices
     * and the directed flag. If the directed flag is true,
     * this is a directed graph.
     * @param numV The number of vertices
     * @param directed The directed flag
     */
    public AbstractGraph(Planets[] p, boolean directed) {
        this.numV = numV;
        this.directed = directed;
    }

    // Accessor Methods
    /**
     * Return the number of vertices.
     * @return The number of vertices
     */
    @Override
    public int getNumV() {
        return numV;
    }

    /**
     * Return whether this is a directed graph.
     * @return true if this is a directed graph
     */
    @Override
    public boolean isDirected() {
        return directed;
    }

    // Other Methods
    /**
     * Load the edges of a graph from the data in an input file.
     * The file should contain a series of lines, each line
     * with two or three data values. The first is the source,
     * the second is the destination, and the optional third
     * is the weight.
     * @param bR The buffered reader containing the data
     * @throws IOException if an I/O error occurs
     */
    public void loadEdgesFromFile(Planets[] p) throws IOException {
        /*<exercise chapter="10" section="3" type="programming" number="1">*/
        String line;
        int source = 1;
        int dest = 3;
        double weight = 1.0;
        for(int i = 0; i < p.length; i++)
        {
            for(int j = 0; j < p.length; j++)
            {
//                if(p.getX(i) != -1 && p.getY(i) != -1 )
                insert(new Edge(source, dest, weight));
            }
        }
//        while (scan.hasNextLine()) {
//            line = scan.nextLine();
//            String[] tokens = line.split("\\s+");
//            
//            double weight = 1.0;
//            if (tokens.length == 3) {
//                
//            }

//        }
        /*</exercise>*/
    }

    /**
     * Factory method to create a graph and load the data from an input
     * file. The first line of the input file should contain the number
     * of vertices. The remaining lines should contain the edge data as
     * described under loadEdgesFromFile.
     * @param scan The Scanner connected to the data file
     * @param isDirected true if this is a directed graph,
     *                   false otherwise
     * @param type The string "Matrix" if an adjacency matrix is to be
     *             created, and the string "List" if an adjacency list
     *             is to be created
     * @throws IllegalArgumentException if type is neither "Matrix"
     *                                  nor "List"
     */
    public static Graph createGraph(Planets[] p,
            boolean isDirected,
            String type) throws IOException {
        int numV = p.length;
       // scan.nextLine();
        AbstractGraph returnValue = null;
        if (type.equalsIgnoreCase("Matrix")) {
            returnValue = new MatrixGraph(p, numV, isDirected);
        } else if (type.equalsIgnoreCase("List")) {
            returnValue = new ListGraph(p, numV, isDirected);
        } else {
            throw new IllegalArgumentException();
        }
        returnValue.loadEdgesFromFile(p);
        return returnValue;
    }
}
/*</listing>*/
