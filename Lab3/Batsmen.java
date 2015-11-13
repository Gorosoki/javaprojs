
/**
 * Write a description of class Batsmen here.
 * 
 * @author Gavin Goroski 
 * @version September 17, 2012
 */
public class Batsmen
{
    // instance variables
    private String name;        //name of the player
    private int innings;        //innings played
    private int notOut;         //number of innings player wasn't out
    private int runs;           //number of runs
    private int highScore;      //highscore in a game
    private int ballsFaced;     //number of balls faced

    public Batsmen (String inName, int inInnings, int inNotOut, int inRuns, int inHighScore, int inBallsFaced)
    {
        name = inName;
        innings = inInnings;
        notOut = inNotOut;
        runs = inRuns;
        highScore = inHighScore;
        ballsFaced= inBallsFaced;
    }

    /**
     * getName
     * 
     * @return      returns the name of the player 
     */
    public String getName ()
    {
        return name;
    }
    
    /**
     * getInnings
     * 
     * @return      returns the number of innings played
     */
    public int getInnings ()
    {
        return innings;
    }
    
    /**
     * getNotOut
     * 
     * @return      returns number of times not out
     */
    public int getNotOut ()
    {
        return notOut;
    }
    
    /**
     * getRuns
     * 
     * @return      returns the number of runs brought in
     */
    public int getRuns ()
    {
        return runs;
    }
    
    /**
     * getHighScore
     * 
     * @return      returns the highest score in one game
     */
    public int getHighScore ()
    {
        return highScore;
    }
    
    /**
     * getBallsFaced
     * 
     * @return      returns the number of balls faced
     */
    public int getBallsFaced ()
    {
        return ballsFaced;
    }
    
    /**
     * average
     * 
     * @return      returns the player's batting average (runs / (innings - notOut))
     */
    public double average ()
    {
        return (double) runs / (innings - notOut);
    }
    
    /**
     * scoringRate
     * 
     * @return      returns (runs / ballsFaced) * 100 or Scoring rate of a player
     */
    public double scoringRate ()
    {
        return (double) runs / ballsFaced * 100;
    }
}
