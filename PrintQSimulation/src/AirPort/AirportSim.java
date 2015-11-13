/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AirPort;

/**
 *
 * @author Brendan
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class AirportSim
{

    static double arrivalProbability = 1;
    static int updatePeriod = 60;
    static int numSecondsPerStation = 60;
    static int maxGroup = 4;
    static int simulationTime = 30000;
    static int numStations = 3; // initial value
    static int threshold = 500; // 10 minutes
    static Random randomGenerator;
    /**
     * @param args the command line arguments
     */
    public static int doSimulation()
    {

        int largestQ = 0;
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;
        // print queue:
        LinkedList<AirPort> stationQ[] = new LinkedList[numStations];
        // list of jobs:
        ArrayList<AirPort> jobList = new ArrayList<>();


        for (int i = 0; i < numStations; i++)
        {
            stationQ[i] = new LinkedList<>();
        }

        // main simulation loop:
        int[] nextFreeTime = new int[numStations];
        for (int i = 0; i < numStations; i++)
        {
            nextFreeTime[i] = 0;
        }
        boolean done = false;
        int t = 0;
        while (!done)
        {
            // check to add new jobs to the queue:
            if (t % updatePeriod == 0 && t < simulationTime)
            {
                if (randomGenerator.nextDouble() < arrivalProbability)
                {
                    // create a new print job:
                    int tempq1 = 0;
                    int tempq2 = 0;
                    int tempq3 = 0;
                    
                    for (int i = 0; i <= 2; i++)
                    {
                        tempq1 = 0;
                        tempq2 = 0;
                        tempq3 = 0;
                        
                        for (int j = 0; j < stationQ[i].size(); j++)
                        {
                            if (i == 0)
                            {
                                tempq1 = stationQ[i].get(j).NumPeople() + q1;
                            }
                            if (i == 1)
                            {
                                tempq2 = stationQ[i].get(j).NumPeople() + q2;
                            }
                            if (i == 2)
                            {
                                tempq3 = stationQ[i].get(j).NumPeople() + q3;
                            }
                        }
                        if (tempq1 > q1)
                        {
                            q1 = tempq1;
                        }
                        if (tempq2 > q2)
                        {
                            q2 = tempq2;
                        }
                        if (tempq3 > q3)
                        {
                            q3 = tempq3;
                        }
                    }
                    AirPort newJob = new AirPort(randomGenerator.nextInt(maxGroup) + 1);
                    newJob.arrivalTime = t;
                    int randQ = randomGenerator.nextInt(numStations);
                    stationQ[randQ].offer(newJob);
//                    System.out.println("Q" +)
                    jobList.add(newJob);
                }
            }
            done = (t > simulationTime);
            for (int i = 0; i < numStations; i++)
            {
                if (t >= nextFreeTime[i] && !stationQ[i].isEmpty())
                {
                    // print the next job:
                    AirPort nextJob = stationQ[i].poll();
                    int printTime = nextJob.numPeople * numSecondsPerStation;
                    nextJob.finishTime = t + printTime;
                    nextFreeTime[i] = t + printTime + 1;
                }
                // check to see if each stationQ is empty
                done = done && stationQ[i].isEmpty();
            }
            t++;
        }

        // simulation done, look at statistics:
        int longestWaitTime = 0;
        AirPort longestJob = null;
        double averageWaitTime = 0.0;
        Iterator<AirPort> jobIter = jobList.iterator();
        for (int i = 0; i < jobList.size(); i++)
        {

            largestQ += jobList.get(i).NumPeople();

        }
        while (jobIter.hasNext())
        {
            AirPort nextJob = jobIter.next();
            int waitTime = nextJob.finishTime - nextJob.arrivalTime - nextJob.numPeople * numSecondsPerStation;
            averageWaitTime += waitTime;
            if (waitTime > longestWaitTime)
            {
                longestWaitTime = waitTime;
                longestJob = nextJob;
            }
        }
        averageWaitTime /= jobList.size();
        System.out.println("\nNumber of Stations: " + numStations);
        System.out.println("longest wait time = " + longestWaitTime);
        System.out.println("average wait time = " + averageWaitTime);
        System.out.println("Largest Group was: " + largestQ);
        System.out.println("Q1: " + q1);
        System.out.println("Q2: " + q2);
        System.out.println("Q3: " + q3);

        return longestWaitTime;
    }

    public static void main(String[] args)
    {
        randomGenerator = new Random();
        numStations = 3;
        doSimulation();
    }

}
