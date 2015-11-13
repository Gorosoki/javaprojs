
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Allows the recording of a music score
 * 
 * @author Aaron Mead & Gavin Goroski 
 * @version November 8, 2012
 */
public class MusicScore
{  
   private ArrayList<Note> noteList;
   /**
    * newScore
    * 
    * starts a newScore and clears the old score
    */
   public void newScore()
   {
       noteList = new ArrayList<Note>();
       
   }
   /**
    * addNote
    * 
    * adds a note and length of a note to the existing score
    */
   public void addNote()
   {
       Scanner in = new Scanner (System.in);
      
       System.out.print("\n" + "Enter Note > ");
       String notefirst = in.next();
       
       System.out.print("Enter Length > ");
       int lengthfirst = in.nextInt();
       
       Note score = new Note(notefirst, lengthfirst);
       noteList.add(score);
       
   }
   /**
    * repeatNotes
    * 
    * prints the score and also allows the repetition of notes from the current score
    */
   public void repeatNotes()
   {
       printScore();
       Scanner in = new Scanner (System.in);
       System.out.print("Enter the note number that starts the repetition > ");
       int beginnote = in.nextInt();
       System.out.print("Enter the note number that ends the repetition > ");
       int endnote = in.nextInt();
       if (endnote > noteList.size())
       {
           System.out.println(); 
           System.out.println("Invalid Input!");
           return;
       }
       else if ( beginnote >noteList.size() || beginnote <= 0)
       {
           System.out.println(); 
           System.out.println("Invalid Input!");
           return;
       }
       else
       {
           for (int i = (beginnote - 1); i <= (endnote - 1); i++)
           {
                Note var = noteList.get(i);
                String currentnote = var.getNote();
                int currentlength = var.getBeats();
                Note scorerepeat = new Note(currentnote, currentlength);
                noteList.add(scorerepeat);
           }
       }
   }
   /**
    * printScore
    * 
    * prints the current Score
    */
   public void printScore()
   {
       if (noteList.size() == 0)
       {
           System.out.println("The score is currently empty");
       }
       else
       {
           for (int i=0; i < noteList.size(); i++)
           {    
                 Note var = noteList.get(i);
                 System.out.println ("Note " + (i+1) + ": " + var.getNote()+ " " + var.getBeats());
           }
       }
   }
   
   public void playSong()
   {
        PlaySong.playSong(noteList,140);
   }

}
