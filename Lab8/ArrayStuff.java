/**
 * ArrayStuff provides miscellaneous functions on arrays.
 * 
 * @author Aaron Mead & Gavin Goroski
 * @version October 23, 2012
 */

public class ArrayStuff
{
    private int [] elements;
    private int [] elementsA;
    /**
     * Builds an array of n elements where
     * each element value is the same as its index.
     *
     * @param n the number of elements in the array.
     */

    public ArrayStuff (int n)
    {
        elements = new int[n];
        
        for (int i = 0; i < n; i++)
        {
            elements[i] = i;
        }
    }

    /**
     * Prints out the message passed in and then all the elements in order of
     * the internal array.
     *
     * @param message
     */
    
    public void printArray(String message)
    {
        System.out.print(message);
        for (int element: elements)
        {
            System.out.format("%d ", element);
        }
        System.out.println();
    }

    /**
     * Method 1 for reversing.
     * Reverses the internal array in place by swapping values.
     */
    
    public void reverseArray()
    {
                for (int i = 0; i < elements.length;i++)
        {
            elements[i] = (elements.length - 1)-i;
        }
    }

    /**
     * Method 2 for reversing.
     * Reverses the internal array by utilizing a second temporary array.
     */
    
    public void reverseArray2 ()
    {
       int [] elementsA;
       elementsA = new int[elements.length];
       for (int i = 0; i < elements.length; i++)
       { 
            elementsA[i] = (elements.length - 1) - i;
       }
       elements=elementsA; 
    }
}