 /**
 * The Square class holds information about one square on the Minesweeper board.
 * 
 * @author Gavin Goroski & Aaron Mead
 * @version Jan 25, 2013
 */

public class Square
{
    private boolean known;      // has the user already guessed this square?
    private String contents;       // the contents of the square (bomb, number, empty)
   /**
    * Constructor
    */
        
    /**
     * Reader method.    
     * 
     * @return  whether the user has guessed the square
     */
    
    public boolean getKnown()
    {
        return known;
    }
    
    /**
     * Writer method
     * 
     * @param   value indicates whether the user has guessed the square
     */
    
    public void setKnown(boolean value)
    {
        known = value;
    }
    
    /**
     * Reader method.
     * 
     * @return  an character indicating the contents of the square (blank or bomb)
     */
    
    public String getContents()
    {
        return contents;
    }
    
    /**
     * Writer method.
     * 
     * @param   value   indicates the contents of the square (bomb, empty, number)
     */
    
    public void setContents(String value)
    {
        contents = value;
    }    
}