
/**
 * Write a description of class MyStack here.
 * 
 * @author Aaron Mead and Gavin Goroski
 * @version 2/22/13
 */
public class MyStack
{
    // instance variables - replace the example below with your own
    private StackNode top;

    /**
     * Constructor for objects of class MyStack
     */
    public MyStack()
    {
        // initialize instance variables
        top = null;
    }

    public void push(StackNode node) {
        if (node != null) {
            StackNode oldTop = top;
            top = node;
            top.setPrevious(oldTop);
        }
    }
    
    public StackNode peek() {
        return top;
    }
    
    public StackNode pop() {
        StackNode curTop = top;
        if (top != null)
            top = top.getPrevious();
       return curTop;
    }
}
