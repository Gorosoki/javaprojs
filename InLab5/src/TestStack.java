/**
 *
 * @author Gavin Goroski
 * @date   Feb 12,2013
 */
public class TestStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(('a'));
        myStack.push(('b'));
        myStack.push(('c'));
        
        //System.out.println(myStack.peek());       //peak test
        Character curNode = myStack.pop();
        
        while (curNode != null) {
            int length = (myStack.list.size()-1);
            System.out.println(curNode);
            curNode = myStack.pop();
        }
    }
}
