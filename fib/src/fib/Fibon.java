/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fib;

/**
 *
 * @author Gavin
 */
public class Fibon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(-1));
        System.out.println(fibonacci(0));
    }
    
    public static int fibonacci (int i)
    {        int fib1 = 1;
            int fib2 = 1;
            int fib = 0;
            int j;
            if(i <= 1)
            {
                fib = 1;
            }
                else
                {
                    for (j=1; j<i; j++)
                    {
                        fib = fib2+ fib1;
                        fib2 = fib;
                        fib1 = fib;
                    }
                }    
                    return fib;
                   
                
    }

}
