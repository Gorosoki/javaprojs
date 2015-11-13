
/**
 * Write a description of class MyList here.
 *
 * @author Gavin Goroski
 * @version 1/29/13
 */
public class MyList {
    // instance variables - replace the example below with your own

    private ListNode head;
    private ListNode tail;

    /**
     * Constructor for objects of class MyList
     */
    public MyList() {
        // initialise instance variables
        head = null;
    }

    public void insertAtEnd(ListNode node) {
        if (head == null) {
            head = node;
            return;
        }
        // otherwise the list is non-empty:
        ListNode currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        // at this point currentNode points to the last element in the list.
        currentNode.setNext(node);

    }

    public void printList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getString());
            currentNode = currentNode.getNext();
        }
    }

    public void recPrintList() {
        if (head == null) {
            System.out.println();
            return;
        }
        
        MyList remainder = new MyList();
        remainder.insertAtEnd(head.getNext());
        remainder.recPrintList();
        tail = head;
        System.out.println(tail.getString());
    }

    public ListNode find(String str) {
        ListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.getString().equals(str)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
}
