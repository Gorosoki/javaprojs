
/**
 * Assists in entering notes into the Score ArrayList
 * 
 * @author Gavin Goroski & Aaron Mead
 * @version November 8, 2012
 */
public class Note
{
    private String note;
    private int beats;
    
    /**
     * Contructor
     */
    Note(String inNote, int inBeats)
    {
        note = inNote;
        beats = inBeats;
    }

    /**
     * getNote
     * 
     * @return      returns note
     */
    public String getNote()
    {
        return note;
    }
    
    /**
     * getLength
     * 
     * @return      returns the length of the note
     */
    public int getBeats()
    {
        return beats;
    }
    
}
