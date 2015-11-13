/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gavin
 */
public class MyStack
{
    private StackNode topNode;
    
    
    public MyStack()
    {
        topNode = null;
    }
    
    //stack operations
    
    public void push(StackNode node)
    {
        node.setPrevious(topNode);
        topNode = node;
    }
    
    public StackNode pop()
    {
        if(topNode == null){
            return null;
        }
        StackNode currentTopNode = topNode;
        topNode = topNode.getPrevious();
        return currentTopNode;
    }
           
}
