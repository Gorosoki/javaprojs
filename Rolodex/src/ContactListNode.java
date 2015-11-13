/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Brendan
 */
public class ContactListNode {
    // instance variables - replace the example below with your own

    private Contact contact;
    private ContactListNode next, prev;

    /**
     * Constructor for objects of class ContactListNode
     */
    public ContactListNode(Contact contact) {
        // initialise instance variables
        this.contact = contact;
        next = null;
        prev = null;
    }

    public Contact getContact() {
        return contact;
    }

    public ContactListNode getNext() {
        return next;
    }

    public void setNext(ContactListNode next) {
        this.next = next;
    }

    public ContactListNode getPrev() {
        return prev;
    }

    public void setPrev(ContactListNode prev) {
        this.prev = prev;
    }
}

