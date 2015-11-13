/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author Brendan
 */
public class AdjMat_Graph {
    
    public int[][] M; // adjacency matrix
    int numVertices;
    
    public AdjMat_Graph(int n) {
        numVertices = n;
        M = new int[n][n];        
    }
    
    
    
}
