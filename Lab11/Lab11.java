/**
 * The recursive methods for Lab 11. 
 * 
 * @author Aaron Mead && Gavin Goroski 
 * @version November 19, 2012
 */

public class Lab11
{
    static String num;
    /**
     * Converts a decimal number to a binary one using recursion.
     * Assume the decimal number is >= 1.
     * 
     * @param       number      the decimal number to convert
     * @return      a String representation of the binary number
     */
    
    public static String convertToBinary(int number)
    {
        num = "";
        if(number > 0)
        {
           convertToBinary(number / 2);
           num += "" + number % 2;
            
        }
        return num;
    }
    
    /**
     * Find the largest item in an array of integers.  
     * Assume the array contains at least one item.
     * 
     * @param       numbers     an array of integers
     * @return      the largest number in the array of intgers
     */
    public static int largestArrayItem(int [] numbers)
    {
        return largestArrayItemAuxiliary(numbers, 0);
    }
    
    /**
     * The helper method for largestArrayItem.
     * 
     * @param       numbers     an array of integers
     * @param       index       the current index in the array to examine
     * @return      the largest number in the array of integers
     */
    
    private static int largestArrayItemAuxiliary(int [] numbers, int index)
    {
        if (index == numbers.length - 1) 
        {
            return numbers[index];
        }
        
        int result = largestArrayItemAuxiliary(numbers, index + 1);
        
        if (numbers[index] > result)
        {
            return numbers[index];
        }
        
        else
        {
            return result;
        }
    }
}