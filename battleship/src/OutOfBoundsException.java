/**
 * Custom exception for invalid column. 
 * 
 * @author Aaron Mead & Gavin Goroski
 * @version December 3, 2012
 */

public class OutOfBoundsException extends Exception
{
    public OutOfBoundsException()
    {
    }
    
    public OutOfBoundsException(String message)
    {
        super(message);
    }
}