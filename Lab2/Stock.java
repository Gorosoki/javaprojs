
/**
 *
 * @author Gavin Goroski
 * @version September 8, 2012
 */
public class Stock
{
    // instance variables
    private int shares;     //number of shares owned
    private double price;   //price of the stock
    private String name;    //name of the stock

    /**
     * Constructor for objects of class Stock
     * 
     * @param inName        the name of the share, e.g. "Walmart"
     * @param inShares      the number of shares owned, e.g. "120"
     * @param inPrice       the price of the stock, e.g. "7.55"
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
     * @return      returns the number of shares owned
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
     * @return      returns the price multiplied shares owned
     */
    public double getValue ()
    {
        return (shares * price);
    }
}