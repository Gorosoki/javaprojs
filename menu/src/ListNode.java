/**
 * class assists with Node values
 * 
 * @author Gavin Goroski & Aaron Mead
 */

public class ListNode {
	// instance variables - replace the example below with your own

	private ListNode next, prev;
	private Order order;

	/**
	 * Constructor for objects of class ContactListNode
	 */
	public ListNode(Order order)
	{
		// initialize instance variables
		//this.contact = contact;
		next = null;
		prev = null;
		this.order = order;
	}

	public Order getOrder()
	{
		return order;
	}
	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode getPrev() {
		return prev;
	}

	public void setPrev(ListNode prev) {
		this.prev = prev;
	}
}
