
/**
 * 
 * @author Gavin Goroski
 * @version September 6 2012
 */
public class Stock
{
    //instance variables 
    private int shares;
    private String name;
    private double price;
    /**
     * Contructor for object of class Stock
     * 
     * @param   inName      the name of the share, e.g. "Walmart"
     * @param   inShares    the number of shares, e.g. "350"
     * @param   inPrice     the price of a stock, e.g. "10.22"
     */
    
    public Stock(String inName, int inShares, double inPrice)
    {
            // initialize instance variables
            name = inName;
            shares = inShares;
            price = inPrice;
    }
    /**
     * getName
     * 
     * @return      returns the name of the stock
     */
    
    public String getName ()
    {
        return name;
    }
    /**
     * getShares
     * 
     * @return       returns the number of shares owned
     */
    
    public int getShares ()
    {
        return shares;
    }
    /**
     * getPrice
     * 
     * @return      returns the price of the stock
     */
    
    public double getPrice ()
    {
        return price;
    }
    /**
     * getValue
     * 
     * @return      returns shares owned multiplied by the price
     */
    
    public double getValue ()
    {
        return shares * price;
    }
}
