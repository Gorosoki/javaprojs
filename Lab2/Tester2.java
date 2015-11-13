/**
 * 
 * @author Gavin Goroski
 * @version September 10, 2012
 */
public class Tester2 extends junit.framework.TestCase
{
    public static void test()
    {
        Stock msft = new Stock("MSFT", 100, 30.95);
        
        assertEquals ("MSFT", msft.getName());
        assertEquals (100, msft.getShares());
        assertEquals (30.95, msft.getPrice());
        assertEquals (3095.0, msft.getValue());
        
        Stock aapl = new Stock("AAPL", 10, 680.44);
        
        assertEquals ("AAPL", aapl.getName());
        assertEquals (10, aapl.getShares());
        assertEquals (680.44, aapl.getPrice());
        assertEquals (6804.4, .01, aapl.getValue());
    }
}