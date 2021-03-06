/**
 * Perform JUnit testing on Program 2 solutions.
 * 
 * @author John Paxton
 * @version September 25, 2012
 */

public class TestGringottsAccount extends junit.framework.TestCase
{
    public void testGringottsAccount ()
    {
        GringottsAccount ron = new GringottsAccount("Ron Weasley", 1, 2, 3);

        // Accessor Method Test.

        assertEquals("Ron Weasley", ron.getOwner());
        assertEquals(1, ron.getGalleons());
        assertEquals(2, ron.getSickles());
        assertEquals(3, ron.getKnuts());

        // Test 0.  Use small values where the correct answer is easy to verify.

        assertEquals(1, ron.calculateMaximumGalleons());
        assertEquals(19, ron.calculateMaximumSickles());
        assertEquals(554, ron.calculateMaximumKnuts());

        // Test 1.  Use large values to check for errors
        
       GringottsAccount snape = new GringottsAccount("Prof Snape", 10000000, 10000000, 10000000);
       assertEquals(10608519, snape.calculateMaximumGalleons(), .001);
       assertEquals(180344827, snape.calculateMaximumSickles(), .001);
       assertEquals(5230000000l, snape.calculateMaximumKnuts(), .001);
   
      // Test 2.  You supply the description. 
      
      
      // Test 3.  You supply the description. 
      // Test 4.  You supply the description. 
      // Test 5.  You supply the description.
    }
}
