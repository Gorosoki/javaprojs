/*
 * @author Gavin Goroski
 * @date 2/19/2012
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class InLab6
{

    public static int something = 0;
    public static int time = 0;
    public static int maxGroup = 4;
    public static int numQueues = 3;
    static Random randomGenerator;
    private static int tempPost;
    public static int simulation()
    {
        ArrayList<Queues> stationQ1 = new ArrayList<>();
        ArrayList<Queues> stationQ2 = new ArrayList<>();
        ArrayList<Queues> stationQ3 = new ArrayList<>();
        //initialize variables
        int currentNum1 = 0;
        int currentNum2 = 0;
        int currentNum3 = 0;
        int sizeQ1 = 0;
        int sizeQ2 = 0;
        int sizeQ3 = 0;
        int aveQ1 = 0;
        int aveQ2 = 0;
        int aveQ3 = 0;
        int addQ1 = 0; 
        int addQ2 = 0; 
        int addQ3 = 0;
        int totalPeople = 0;
        for (int i = 1; i <= 500; i++)
        {

            Queues newJob = new Queues(randomGenerator.nextInt(maxGroup) + 1);
            //adds group to smallest Queue
            if (currentNum1 <= currentNum2 && currentNum1 <= currentNum3)
            {
                stationQ1.add(newJob);
                currentNum1++;
                aveQ1 = newJob.numPeople + aveQ1;
                addQ1 = newJob.numPeople + addQ1;
                System.out.print("Minute "+ i +": A group of " + newJob.numPeople + " has been added to Station 1.");
            }
            else if (currentNum2 < currentNum1 && currentNum2 < currentNum3)
                {
                    stationQ2.add(newJob);
                    currentNum2++;
                    aveQ2 = newJob.numPeople + aveQ2;
                    addQ2 = newJob.numPeople + addQ2;
                    System.out.print("Minute "+ i +": A group of " + newJob.numPeople + " has been added to Station 2.");
                }
                else
                {
                    stationQ3.add(newJob);
                    currentNum3++;
                    aveQ3 = newJob.numPeople + aveQ3;
                    addQ3 = newJob.numPeople + addQ3;
                    System.out.print("Minute "+ i +": A group of " + newJob.numPeople + " has been added to Station 3.");
                }
            //checks for largest amount of people in a queue
            if (aveQ1 > sizeQ1)
            {
                sizeQ1 = aveQ1;
            }
            if (aveQ2 > sizeQ2)
            {
                sizeQ2 = aveQ2;
            }
            if (aveQ3 > sizeQ3)
            {
                sizeQ3 = aveQ3;
            }

            tempPost = (int) ((Math.random() * 3) + 1);
            //removes a random group every 2 minutes
            
            if (tempPost == 1 && !stationQ1.isEmpty() && i % 2 == 0)
            {
                aveQ1 = (aveQ1 - stationQ1.get(0).numPeople);
                System.out.println(" A group of " + stationQ1.get(0).numPeople + " from Station 1 has been processed.");
                stationQ1.remove(0);
                currentNum1--;
                
            }
            
            else if (tempPost == 2 && !stationQ2.isEmpty() && i % 2 == 0)
                {
                    aveQ2 = (aveQ2 - stationQ2.get(0).numPeople);
                    System.out.println(" A group of " + stationQ2.get(0).numPeople + " from Station 1 has been processed.");
                    stationQ2.remove(0);
                    currentNum2--;
                }
            
            else if (tempPost == 3 && !stationQ3.isEmpty() && i % 2 == 0)
                    {
                        aveQ3 = (aveQ3 - stationQ3.get(0).numPeople);
                        System.out.println(" A group of " + stationQ3.get(0).numPeople + " from Station 1 has been processed.");
                        stationQ3.remove(0);
                        currentNum3--;
                    }
            else
            {
                System.out.println();
            }
            totalPeople = aveQ1 + aveQ2 + aveQ3 + totalPeople;
            }
        
        //Prints Statistics
        System.out.println();
        System.out.println("The maximum line for Station 1 was: " + sizeQ1);
        System.out.println("The maximum line for Station 2 was: " + sizeQ2);
        System.out.println("The maximum line for Station 3 was: " + sizeQ3);
        System.out.println("Average number of people in a line was: " + (totalPeople / 1500));
        return something;
}

    /**
     * main driver, runs programs
     */
    public static void main(String[] args)
    {

        randomGenerator = new Random();
        simulation();
    }

}
