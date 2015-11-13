
/**
 * 
 * @author Gavin Goroski
 * @version September 14, 2012
 */
public class GringottsAccount

{
    //instance variables
    private String owner;
    private int galleons;
    private int sickles;
    private int knuts;
    
    public GringottsAccount(String inOwner, int inGalleons, int inSickles, int inKnuts)
    {
        //initialize instance variables
        owner = inOwner;
        galleons = inGalleons;
        sickles = inSickles;
        knuts = inKnuts;
        
    }
    
    /**
     * getOwner
     * 
     * @return      returns the name of the account owner
     */
    
    public String getOwner ()
        {
            return owner;
        }
    
    /**
     * getgalleons
     * 
     * @return     returns the number of galleons in a given account
     */
    public int getGalleons ()
        {
            return galleons;
        }
        
    /**
     * getSickles
     * 
     * @return      returns the number of sickles in a given account
     */
    public int getSickles ()
        {
            return sickles;
        }
        
    /**
     * getKnuts
     * 
     * @return      returns the number of knuts in a given account
     */
    public int getKnuts ()
        {
            return knuts;
        }
        
    /**
     * calculateMaximumGalleons
     * 
     * @return      returns the maximum number of galleons in an account
     */
    public int calculateMaximumGalleons ()
        {
            int knuts2Sickles = (knuts / 29);
            int sickles2Galleons = (knuts2Sickles + sickles) / 17;
            return sickles2Galleons + galleons;
        }
        
     /**
      * calculateMaximumSickles
      * 
      * @return     returns the currency converted to only sickles for a given account
      */
     public long calculateMaximumSickles ()
        {
            long knuts2Sickles = ((long)knuts / 29);
            long galleons2Sickles = ((long)galleons * 17);
            return (long) sickles + galleons2Sickles + knuts2Sickles;
        }
        
     /**
      * calculateMaxumumKnuts
      * 
      * @return     returns the currency converted to knuts for a given account
      */
   
     public long calculateMaximumKnuts ()
        {
            long galleons2Sickles = (long)galleons * 17;
            long sickles2Knuts = (galleons2Sickles + (long)sickles) * 29;
            
            return (long) knuts + sickles2Knuts;
        }
}
