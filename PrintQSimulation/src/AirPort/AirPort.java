/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AirPort;

/**
 *
 * @author Brendan
 */
public class AirPort {
    
    public int arrivalTime;
    public int finishTime;
    public int numPeople;
    
    public AirPort(int numPages) {
        this.numPeople = numPages;
    }
    public int NumPeople(){
        return numPeople;
    }
}
