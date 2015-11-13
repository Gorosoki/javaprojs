/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gavin
 */
public class palindrome
{
    
    public static void main(String[] args)
    {
    MyStack myStack = new MyStack();
    myStack.push(new StackNode ('a'));
    myStack.push(new StackNode ('b'));
    myStack.push(new StackNode ('c'));
    
    StackNode curNode = myStack.pop();
    while (curNode != null)
    {
        System.out.println(curNode.getChar());
        curNode = myStack.pop();
    }
    }
}
