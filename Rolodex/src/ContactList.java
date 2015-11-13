/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class ContactList {
    // instance variables - replace the example below with your own

    private ContactListNode head, tail;

    /**
     * Constructor for objects of class MyList
     */
    public ContactList() {
        // initialise instance variables
        head = null;
        tail = null;
    }

    public ContactListNode getHead() {
        return head;
    }

    public ContactListNode getTail() {
        return tail;
    }

    public void insertAtEnd(ContactListNode node) {
        if (tail == null) {
            head = node;
            tail = node;
            return;
        }
        // otherwise the list is non-empty:

        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
    }

    public void insertAlphabetically(ContactListNode node) {
        // check if the list is empty:
        if (tail == null) {
            head = node;
            tail = node;
            return;
        }
        // otherwise the list is non-empty:
        ContactListNode curNode = head;
        while (curNode != null) {
            if (curNode.getContact().getFirstName().compareTo(node.getContact().getFirstName()) >= 0) {
                node.setNext(curNode);
                node.setPrev(curNode.getPrev());
                if (curNode.getPrev() != null) {
                    curNode.getPrev().setNext(node);
                } else {
                    head = node;
                }
                curNode.setPrev(node);
                break;
            }
            curNode = curNode.getNext();
        }
        // if we reached the end of the list:
        if (curNode == null) {
            tail.setNext(node);
            node.setPrev(tail);
            node.setNext(null);
            tail = node;
        }
    }

    public void delete(ContactListNode node) {
        if (contains(node)) {
            // node to delete is in the middle of the list:
            if (node != head && node != tail) {
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
            }

            if (node == head) {
                head = node.getNext();
                if (head != null) {
                    head.setPrev(null);
                }
            }
            if (node == tail) {
                tail = node.getPrev();
                if (tail != null) {
                    tail.setNext(null);
                }
            }


            node.setNext(null);
            node.setPrev(null);
        }
    }

    public void printList() {
        ContactListNode currentNode = head;
        while (currentNode != null) {
            currentNode.getContact().print();
            currentNode = currentNode.getNext();
        }
    }

    public ContactListNode find(Contact contact) {
        ContactListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.getContact().match(contact.getFirstName(), contact.getLastName(), Integer.toString(contact.getPhone()), contact.getEmail())) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public boolean contains(ContactListNode node) {
        ContactListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode == node) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }
}
