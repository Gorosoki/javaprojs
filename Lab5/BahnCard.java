/**
 * The BahnCard class for lab 5.
 * 
 * @Aaron Mead and Gavin Goroski 
 * @version October 2, 2012
 */

public class BahnCard
{
    private int cardType;
    private int age;
    private boolean isStudent;
    public int desiredClass;
    
    public void setAge (int age)
    {
        this.age = age;
    }
     
    public void setStudent (boolean flag)
    {
        this.isStudent = flag;
    }
   
        public int bahnCard25Price (int desiredClass)
    {
        if (desiredClass == 1)      //first class 25% OFF
    
        {
            return 110;
        }
    
        else if (desiredClass == 2 && this.age < 19)        //second class 25% off and under 19 years old
        {
            return 10;
        }
        
        else if (desiredClass == 2 && this.age >= 19)       // second class 25% off 19 years old and older
        {
            return 55;
        }
        
        else                                                //should not occur
        {
            return -1;
        }
    }
    
    public int bahnCard50Price (int desiredClass)
    {
        if (desiredClass == 1 && this.age <= 17)            //first class 50% off and 17 years old or younger
        {
            return 220;
        }
        
        else if (desiredClass == 1 && this.age >= 60)       //first class 50% off and 60 years old or older
        {
            return 220;
        }
        else if (desiredClass == 1 && this.isStudent && this.age < 27)  //first class 50% off and a student and under 27 years old
        {
            return 220;
        }
        else if (desiredClass == 1)                         //first class 50% off
        {
            return 440;
        }
    
        if (desiredClass == 2 && this.age <= 17)            //second class 50% off and 17 years old or younger
        {
            return 110;
        }
        
        else if (desiredClass == 2 && this.age >= 60)       //second class 50% off and 60 years old or older
        {
            return 110;
        }
        else if (desiredClass == 2 && this.isStudent && this.age < 27)  //second class 50% off and a student and under 27 years old
        {
            return 110;
        }
        else if (desiredClass == 2)                         //second class 50% off
        {
            return 220;
        }
        else                                                //should not occur
        {
            return -1;
        }
    }
    public int bahnCard100Price (int desiredClass)
    {
        if (desiredClass == 1)                              //first class 100% off
        {  
            return 5900;
        } 
        else if (desiredClass == 2)                         //second class 100% off
        {
            return 3500;
        }
        else                                                //should not occur
        {
            return -1;
        }
    }

}