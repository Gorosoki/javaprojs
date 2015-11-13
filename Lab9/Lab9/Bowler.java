/**
 * Lab8 Bowling Program
 *
 * @author Aaron Mead & Gavin Goroski
 * @version October 30, 2012
 */

public class Bowler
{
    private double percentStrikes;    // percentage of time to bowl a strike
    private double percentSpares;     // percentage of time to bowl a spare
    private double percentOpen;       // percentage of time for open frame
    private int frames;               // number of frames to bowl
    
    private int currentScore;         // bowler's current score
    private boolean buildingOnSpare;  // was the previous frame a spare:
    private int ball_3;               // the third roll from the previous frame
    private boolean buildingOnStrike; // was the previous frame a strike
    private int ball_2;               // the second roll of the frame
    private double bowl;

    public Bowler (double percentStrikes, double percentSpares, double percentOpen, int frames)
    {
        this.percentStrikes = percentStrikes;
        this.percentSpares = percentSpares;
        this.percentOpen = percentOpen;
        this.frames = frames;
    }

    public void setFramesToBowl (int inFrames)
    {
        frames = inFrames;
    }

    public void setStrikePercentage (double percentage)
    {
        percentStrikes = percentage*(100);
    }

    public void setSparePercentage (double percentage)
    {
        percentSpares = percentage*(100);
    }

    public void setOpenFramePercentage (double percentage)
    {
        percentOpen = percentage*(100);
    }
    
    /**
     * bowlOneGame
     * 
     * no return        bowls the given number of frames
     */
    public void bowlOneGame()
    {
        currentScore = 0;
        ball_2 = 0;
        ball_3 = 0;
        buildingOnSpare = false;
        buildingOnStrike = false;
        
        System.out.format("%n%-23s%d%n", "Frames in game: ", frames);
        System.out.format("%-23s%.2f%n", "Strike percentage: ", percentStrikes);
        System.out.format("%-23s%.2f%n", "Spare percentage: ", percentSpares);
        System.out.format("%s%.2f%n%n", "Open frame percentage: ", percentOpen);
        
        for (int frame = 1; frame <= frames; frame++)
        {
            bowlOneFrame(frame);
        }
    }
    /**
     * bowlOneFrame
     * 
     * no return        bowls one frame of the game
     */
    private void bowlOneFrame(int frame)
    {
        int ball_1;
        
        if (buildingOnSpare)
        {
            ball_1 = ball_3;
            buildingOnSpare = false;
            ball_2 = secondRoll(ball_1);
        }
        else if (buildingOnStrike)
        {
            ball_1 = ball_2;
            ball_2 = ball_3;
            
            if (ball_2 == 10)
            {
                buildingOnStrike = true;
            }
            else
            {
                buildingOnStrike = false;
            }
        }
        else
        {
            ball_1 = firstRoll();
            ball_2 = secondRoll(ball_1);
        }
                
        
        if (buildingOnSpare)
        {
            ball_3 = firstRoll();
        }
        else if (buildingOnStrike)
        {
            ball_2 = firstRoll();
            if (ball_2 == 10)
            {
                ball_3 = firstRoll();
            }
            else
            {
                ball_3 = secondRoll(ball_2);
            }
        }
        else
        {
            ball_3 = 0;
        }
               
        this.currentScore += ball_1 + ball_2 + ball_3;
        if (ball_1 == 10)
        {
            System.out.print("Frame: " + frame + ", ball 1 = " + ball_1 + ", ball 2 = " + "0");
        }
        else
        {
            System.out.print("Frame: " + frame + ", ball 1 = " + ball_1 + ", ball 2 = " + ball_2);
        }
        
        if ((frame == frames) && buildingOnSpare)
        {
            System.out.print(", ball 3 = " + ball_3);
        }
        else if ((frame == frames) && buildingOnStrike)
        {
            System.out.print(", ball 3 = " + ball_3);
        }
        
        System.out.println(", total score = " + currentScore);
    }
    /**
     * firstRoll
     * 
     * @return      returns the value of ball one
     */
    private int firstRoll()
    {
        bowl = Math.random()*100;
        if ( bowl > (percentOpen + percentSpares))
        {
            buildingOnStrike = true;
            return 10;
        }
        else
        {
            return (int) (Math.random() * 10);
        }
    }
    /**
     * secondRoll
     * 
     * @return      returns the value of ball two
     */
    private int secondRoll (int ball_1)
    {
        
        if (bowl < percentOpen /(percentOpen + percentSpares))
        {
             return (int) (Math.random() * (10 - ball_1));
        }
        else if (bowl > percentSpares/(percentOpen + percentSpares))
        { 
            buildingOnSpare = true;
            return (10 - ball_1);
        }
        else
        {
            return (int) (Math.random() * (10 - ball_1));
        }
        
     }
}
