
/**
 * Stock info for MSFT
 * 
 * @author Gavin Goroski
 * @version September 10, 2012
 */
public class Tester1
{
    public static void main (String [] args)
    {
        Stock msft;
        
        msft = new Stock("MSFT", 100, 30.95);
        
        System.out.println("CSCI 111, In Lab 2, Tester1");
        System.out.println("");
        System.out.println("The stock's symbol is " + msft.getName());
        System.out.println("The number of shares is " + msft.getShares());
        System.out.println("The value of a share is " + msft.getPrice());
        System.out.println("The value of all the shares is " + msft.getValue());
        
            
        Stock aapl;
        
        aapl = new Stock("AAPL", 10, 680.44);
        
        System.out.println("");
        System.out.println("The stock's symbol is " + aapl.getName());
        System.out.println("The number of shares is " + aapl.getShares());
        System.out.println("The value of a share is " + aapl.getPrice());
        System.out.println("The value of all the shares is " + aapl.getValue()); 
    }
}
