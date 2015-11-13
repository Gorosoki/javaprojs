
/**
 * Write a description of class TestMyList here.
 *
 * @author Gavin Goroski
 * @version 1/29/13
 */

import java.util.Scanner;
import java.util.ArrayList;

public class TestMyList {

    public static void doFind(MyList myList, String string) {
        ListNode node = myList.find(string);
        if (node != null) {
            System.out.println("found!");
            System.out.println(node.getString());
        } else {
            System.out.println("not found!");
        }
    }

    public static void main(String[] args) {
        MyList myList = new MyList();

        myList.insertAtEnd(new ListNode("one"));
        myList.insertAtEnd(new ListNode("two"));
        myList.insertAtEnd(new ListNode("three"));
        System.out.println("printing list using iterative approach...");
        myList.printList();
    
//        doFind(myList, "three");
//        doFind(myList, "four");
        System.out.println("printing list using recursive approach...");
        myList.recPrintList();


    }
}
