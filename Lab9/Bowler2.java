/**
 * Partial solution to Program 4 for open frames and spares (but no strikes).
 *
 * @author John Paxton
 * @version October 29, 2012
 */

public class Bowler2
{
    private double percentStrikes;    // percentage of time to bowl a strike
    private double percentSpares;     // percentage of time to bowl a spare
    private double percentOpen;       // percentage of time for open frame
    private int frames;               // number of frames to bowl
    
    private int currentScore;         // bowler's current score
    private boolean buildingOnSpare;  // was the previous frame a spare:
    private int ball_3;               // the third roll from the previous frame
    private boolean buildingOnStrike; // was the previous frame a strike:
    private int ball_2;               // the second roll 

    public Bowler2 (double percentStrikes, double percentSpares, double percentOpen, int frames)
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
        percentStrikes = percentage;
    }

    public void setSparePercentage (double percentage)
    {
        percentSpares = percentage;
    }

    public void setOpenFramePercentage (double percentage)
    {
        percentOpen = percentage;
    }
    
    public void bowlOneGame()
    {
        currentScore = 0;
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
            else if (ball_3 == 10)
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
        if (buildingOnStrike)
        {
            ball_3 = firstRoll();
        }
        else
        {
            ball_3 = 0;
        }
       
            this.currentScore += ball_1 + ball_2 + ball_3;
           
            System.out.print("Frame: " + frame + ", ball 1 = " + ball_1);
             if ( ball_1 == 10)
            {
                System.out.print(",ball 2 = 0");
            }
            else 
            {
                System.out.print(", ball 2 = " + ball_2);
            }
            if ((frame == frames) && buildingOnSpare)
            {
                System.out.print(", ball 3 = " + ball_3);
            }
            System.out.println(", total score = " + currentScore);    
    }
    
    private int firstRoll()
    {
        if (Math.random() > percentOpen + percentSpares)
        {
            buildingOnStrike = true;
            return 10;  
        }
        else
        {
            return (int) (Math.random() * 10);
        }
    }
    
    private int secondRoll (int ball_1)
    {
        double randNum = Math.random() * .5;
        if (randNum < (percentOpen / (percentSpares + percentOpen + percentStrikes)))
        {
            return (int) (Math.random() * (10 - ball_1));
        }
        else if (randNum < (percentSpares / (percentOpen + percentSpares + percentStrikes)))
        {
            buildingOnSpare = true;
            return (10 - ball_1); 
        }
        else if (randNum < (percentStrikes / (percentOpen + percentSpares + percentStrikes)))
        {
            buildingOnStrike = true;
            return 10;
        }
        else
        {
            return (10 - ball_1);
        }
    }
}