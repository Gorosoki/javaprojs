/**
 * class deals with the list
 * 
 * @author Gavin Goroski & Aaron Mead
 */

public class OrderList
{

    private ListNode head;
    private ListNode tail;
    double tprice;
    double receipt;
    int bacon, hashbrowns, sausage, coffee,
            milk, orangeJuice, waffles, pancakes,
            frenchToast, rolls, pie, danish;
    /**
     * Constructor for objects of class MyList
     */
    public OrderList()
    {
                // initialize instance variables
        bacon = 0;
        hashbrowns = 0;
        sausage = 0;
        coffee = 0;
        milk = 0;
        orangeJuice = 0;
        waffles = 0;
        pancakes = 0;
        frenchToast = 0;
        rolls = 0;
        pie = 0;
        danish = 0;
        head = null;
        tail = null;
        tprice = 0;
        receipt = 0;
    }

    public ListNode getHead()
    {
        return head;
    }

    public ListNode getTail()
    {
        return tail;
    }

    public void insertAtEnd(ListNode node)
    {
        if (tail == null)
        {
            head = node;
            tail = node;
        }
        // otherwise the list is non-empty:
        else
        {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
    }
		    
    public void delete(ListNode node)
    {
        if (contains(node))
        {
            // node to delete is in the middle of the list:
            if (node != head && node != tail)
            {
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
            }

            if (node == head)
            {
                head = node.getNext();
                if (head != null)
                {
                    head.setPrev(null);
                }
            }
            if (node == tail)
            {
                tail = node.getPrev();
                if (tail != null)
                {
                    tail.setNext(null);
                }
            }


            node.setNext(null);
            node.setPrev(null);
        }
    }

    public double appPrices(ListNode currentNode)
    {
        String app = currentNode.getOrder().getAppetizers();
        double price = 0.00;

        switch (app)
        {
            case "Bacon":
                price = 1.75;
                bacon++;
                break;
            case "Hashbrowns":
                price = 1.50;
                hashbrowns++;
                break;
            case "Sausage":
                price = 2.00;
                sausage++;
                break;
            case "None":
                price = 0.00;
                break;

        }
        tprice = price + tprice;
        return price;

    }

    public double drinkPrices(ListNode currentNode)
    {
        String drink = currentNode.getOrder().getDrinks();
        double price = 0.00;

        switch (drink)
        {
            case "Milk":
                price = 1.00;
                milk++;
                break;
            case "Coffee":
                price = 0.75;
                coffee++;
                break;
            case "Orange Juice":
                price = 1.25;
                orangeJuice++;
                break;
            case "None":
                price = 0.00;
                break;

        }
        tprice = price + tprice;
        return price;
    }

    public double entreePrices(ListNode currentNode)
    {
        String entree = currentNode.getOrder().getEntrees();
        double price = 0.00;

        switch (entree)
        {
            case "Waffles":
                price = 3.50;
                waffles++;
                break;
            case "Pancakes":
                price = 3.50;
                pancakes++;
                break;
            case "French Toast":
                price = 2.50;
                frenchToast++;
                break;
            case "None":
                price = 0.00;
                break;

        }
        tprice = price + tprice;
        return price;
    }

    public double dessertPrices(ListNode currentNode)
    {
        String dessert = currentNode.getOrder().getDesserts();
        double price = 0.00;

        switch (dessert)
        {
            case "Apple Pie":
                price = 5.00;
                pie++;
                break;
            case "Cherry Danish":
                price = 2.00;
                danish++;
                break;
            case "Cinnamon Roll":
                price = 3.75;
                rolls++;
                break;
            case "None":
                price = 0.00;
                break;

        }
        tprice = price + tprice;
        return price;
    }

    public void printList()
    {
        bacon = 0;
        hashbrowns = 0;
        sausage = 0;
        coffee = 0;
        milk = 0;
        orangeJuice = 0;
        waffles = 0;
        pancakes = 0;
        frenchToast = 0;
        rolls = 0;
        pie = 0;
        danish = 0;
        receipt = 0;
        ListNode currentNode = head;
        while (currentNode != null)
        {
            tprice = 0;
            System.out.println("Name: " + currentNode.getOrder().getName());
            String a = currentNode.getOrder().getAppetizers() + " $" + appPrices(currentNode);
            String b = currentNode.getOrder().getDrinks() + " $" + drinkPrices(currentNode);
            String c = currentNode.getOrder().getEntrees() + " $" + entreePrices(currentNode);
            String d = currentNode.getOrder().getDesserts() + " $" + dessertPrices(currentNode);
            currentNode = currentNode.getNext();
            System.out.println(" $" + tprice);
            receipt = tprice + receipt;
        }
        System.out.println();
        System.out.println("Kitchen Ticket");

        System.out.println("Bacon: " + bacon);
        System.out.println("Hashbrowns: " + hashbrowns);
        System.out.println("Sausage: " + sausage);
        System.out.println("Milk: " + milk);
        System.out.println("Coffee: " + coffee);
        System.out.println("Orange Juice: " + orangeJuice);
        System.out.println("Pancakes: " + pancakes);
        System.out.println("Waffles: " + waffles);
        System.out.println("French Toast: " + frenchToast);
        System.out.println("Apple Pie: " + pie);
        System.out.println("Cherry Danish: " + danish);
        System.out.println("Cinnamon Rolls: " + rolls);
        System.out.println();
            /**
             * the commented section below prints each customers order and what they owe
             */
//        while (currentNode != null)
//        {   
//            tprice = 0;
//            System.out.println("Name: " + currentNode.getOrder().getName());
//            System.out.println("Appetizer: " + currentNode.getOrder().getAppetizers() + " $" + appPrices(currentNode));
//            System.out.println("Drink: " + currentNode.getOrder().getDrinks()+ " $" + drinkPrices(currentNode));
//            System.out.println("Entree: " + currentNode.getOrder().getEntrees()+ " $" + entreePrices(currentNode));
//            System.out.println("Dessert: " + currentNode.getOrder().getDesserts()+ " $" + dessertPrices(currentNode));
//            System.out.println("$" + tprice);
//            currentNode = currentNode.getNext();
//            receipt = tprice + receipt;
//        }
        System.out.println("Your Total is: $" + receipt);
    }

    public boolean contains(ListNode node)
    {
        ListNode currentNode = head;
        while (currentNode != null)
        {
            if (currentNode == node)
            {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

}