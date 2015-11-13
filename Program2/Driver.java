
/**
 * 
 * @author 
 * @version
 */
public class Driver
{
    public static void main (String [] args)
    {
        GringottsAccount harry;         // account for Harry Potter
        GringottsAccount ron;           // account for Ron Weasley
        GringottsAccount ginny;         // account for Ginny Weasley
        GringottsAccount hermione;      // account for Hermione Granger
        GringottsAccount draco;         // account for Draco Malfoy
        
        harry = new GringottsAccount("Harry Potter", 2000, 1000, 492);
        ron = new GringottsAccount("Ron Weasley", 1, 5, 10);
        ginny = new GringottsAccount("Ginny Weasley", 0, 0, 0);
        hermione = new GringottsAccount("Hermione Granger", 350, 51, 290);
        draco = new GringottsAccount("Draco Malfoy", 1000000000, 1000000000, 1000000000);
        
        printInfo(harry);
        printInfo(ron);
        printInfo(ginny);
        printInfo(hermione);
        printInfo(draco);
    }
    
    private static void printInfo (GringottsAccount account)
    {
        System.out.println("The owner of the account is " + account.getOwner());
        System.out.println("Actual number of Galleons in account = " + account.getGalleons());
        System.out.println("Actual number of Sickles in account = " + account.getSickles());
        System.out.println("Actual number of Knuts in account = " + account.getKnuts());
        System.out.println("Possible number of Galleons in account = " + account.calculateMaximumGalleons());
        System.out.println("Possible number of Sickles in account = " + account.calculateMaximumSickles());
        System.out.println("Possible number of Knuts in account = " + account.calculateMaximumKnuts());
        System.out.println();
    }
    
}
