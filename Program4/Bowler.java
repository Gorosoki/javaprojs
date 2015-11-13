import java.lang.Math;
/**
 * Simulates the game of bowling
 * 
 * @author Gavin Goroski & Aaron Mead   
 * @version 10-21-2012
 */
public class Bowler
{
    // instance variables
    private double percentStrikes;
    private double percentSpares;
    private double percentOpenFrames;
    private int framesToBowl;
    private int ballOne;
    private int ballTwo;
    private int ballThree;
    private boolean spareFlag;
    private boolean strikeFlag;
    private double roll;
    private int roundScore;
    private int totalScore;
    private int frame;
    
    /**
     * Constructor for objects of class Bowler
     */
    
    public Bowler(double inPercentStrikes, double inPercentSpares, double inPercentOpenFrames, int inFramesToBowl)
    {
        percentStrikes = inPercentStrikes;
        percentSpares = inPercentSpares;
        percentOpenFrames = inPercentOpenFrames;
        framesToBowl = inFramesToBowl;    
    }
    /**
     * bowlOneGame      //simulates a game of bowling
     */
    public void bowlOneGame()
    {       
        roundScore = 0;
        totalScore = 0;
        boolean spareFlag = false;
        boolean strikeFlag = false;
            
        System.out.format("%-22s%d%n","Frames in game:", framesToBowl);
        System.out.format("%s%8.2f%n","Strike percentage:", percentStrikes);
        System.out.format("%s%9.2f%n", "Spare percentage:", percentSpares);
        System.out.format("%s%4.2f%n", "Open frame percentage:", percentOpenFrames);
        System.out.println();
            for (int frame= 1; frame <= framesToBowl; frame++)          //loop for frames
        {                            
            double div1 = percentOpenFrames;
            double div2 = percentSpares+percentOpenFrames;
            roll = Math.random()*1.0;
            if (roll < div1)
            {
                openFrame(frame);
            }
            else if(roll <= (div1+div2))
            {
                spareFrame(frame);
            }
            else
            {
                strikeFrame(frame);
            }
        }
        System.out.println();
    }    
            
    private void openFrame(int frame)  //deals with open frames
            {
                    if (spareFlag == true)
                    {
                        
                        ballOne = ballThree;
                        ballTwo = (int)(Math.random()*(10-ballOne));
                        roundScore = ballOne + ballTwo;
                        totalScore += roundScore;
                        System.out.println("Frame:"+ frame + "," +" Ball 1= "+ ballOne +","+" Ball 2= "+ ballTwo +","+" total score = "+ totalScore);
                        spareFlag = false;
                        strikeFlag = false;
                    }
                    else
                    {
                        ballOne = (int)(Math.random()*10);
                        ballTwo = (int)(Math.random()*(10-ballOne));
                        roundScore = ballOne + ballTwo;
                        totalScore += roundScore;
                        System.out.println("Frame:"+frame+ "," +" Ball 1= "+ballOne+","+" Ball 2= "+ballTwo+","+" total score = "+totalScore);
                        spareFlag = false;
                    }
            }
            
    private void spareFrame(int frame) //deals with spares
    {
          if (spareFlag == true && frame == framesToBowl)
               {
                  ballOne = ballThree;
                  ballTwo = (int)((10-ballOne));
                  ballThree = (int) (Math.random()*10);
                  roundScore = ballOne + ballTwo + ballThree;                    
                  totalScore += roundScore;                    
                  System.out.println("Frame:"+frame+ "," +" Ball 1= "+ballOne+","+" Ball 2= "+ballTwo+"," + "Ball 3= " + ballThree +"," +" total score = "+totalScore);        
               }
          else if (spareFlag == true)
               {    
                  ballOne = ballThree;
                  ballTwo = (int)((10-ballOne));
                  ballThree = (int) (Math.random()*10);
                  roundScore = ballOne + ballTwo + ballThree;                    
                  totalScore += roundScore;                    
                  System.out.println("Frame:"+frame+ "," +" Ball 1= "+ballOne+","+" Ball 2= "+ballTwo+","+" total score = "+totalScore);
               }
          else if (spareFlag == false)
               {
                  ballOne = (int)(Math.random()*10);
                  ballTwo = (int)((10-ballOne));
                  ballThree = (int) (Math.random()*10);
                  roundScore = ballOne + ballTwo + ballThree;                    
                  totalScore += roundScore;
                  spareFlag = true;
                  System.out.println("Frame:"+frame+ "," +" Ball 1= "+ballOne+","+" Ball 2= "+ballTwo+","+" total score = "+totalScore);
                }
    }
            
    private void strikeFrame(int frame) //deals with strikes
        {
              if (frame == framesToBowl)
              {
               ballOne = 10;
               ballTwo = 10;
               ballThree = 10;
               roundScore = ballOne + ballTwo + ballThree;
               totalScore += roundScore;
               System.out.println("Frame:"+frame+ "," +" Ball 1= "+ballOne+","+ " Ball 2= "+ballTwo+","+ " Ball 3= "+ballThree+","+" total score = "+totalScore);
               spareFlag = false;
              }
  
              else
              {
                  ballOne = 10;
                  strikeFlag = true;
                  ballTwo = 10;
                  ballThree = 10;
                  roundScore = ballOne + ballTwo + ballThree;
                  totalScore += roundScore;
                  System.out.println("Frame:"+frame+ "," +" Ball 1= "+ballOne+","+" total score = "+totalScore);
                  spareFlag = false;
              }
        }
            
    public void setFramesToBowl(int inFramesToBowl)
    {
       framesToBowl = inFramesToBowl;
    }
    public void setSparePercentage(double inSparePercentage)
    {
        percentSpares = inSparePercentage;
    }
    public void setStrikePercentage(double inStrikePercentage)
    {
        percentStrikes = inStrikePercentage;
    }
    public void setOpenFramePercentage(double inOpenFramePercentage)
    {
        percentOpenFrames = inOpenFramePercentage;
    }

}
