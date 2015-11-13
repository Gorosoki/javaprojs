/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gavin
 */

/**
 * Driver for Coins problem.
 * 
 * @author John Paxton
 * 
 */

import java.io.FileNotFoundException;

public class Driver
{
    public static void main (String [] args) throws FileNotFoundException
    {
        Change coins = new Change ("coins.in");
        coins.initialize();
        coins.fillTable();
        coins.solveProblems();
    }
}
