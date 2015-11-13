/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test1;

/**
 *
 * @author Gavin
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int zed[] = {1,2,3,4,5,6,7};
        int yew[] = {6,7,8,9,10};
        yew = zed;
        for (int i = 0; i < yew.length; i++)
        {
            zed[i] = 0;
            System.out.print(yew[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < zed.length; i++)
        {
            System.out.print(zed[i] + ", ");
        }
        // TODO code application logic here
    }
    
}
