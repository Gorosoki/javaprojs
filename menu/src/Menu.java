
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * RadioButtonDemo generates a simple demonstration of radio buttons.
 *
 * @author Aaron Mead & Gavin Goroski
 * @Date Feb 12, 2013
 *
 */
public class Menu extends JFrame
{

    private JButton clearButton, enterButton, printButton;
    // Data Fields- Radio Buttons Choices
    String[] appetizers =
    {
        "None", "Bacon", "Hashbrowns", "Sausage"
    };
    String[] drinks =
    {
        "None", "Coffee", "Milk", "Orange Juice"
    };
    String[] entrees =
    {
        "None", "Pancakes", "French Toast", "Waffles"
    };
    String[] desserts =
    {
        "None", "Apple Pie", "Cherry Danish", "Cinnamon Roll"
    };
    JRadioButton[] radioButtons = new JRadioButton[appetizers.length];
    ButtonGroup buttonGroup1;
    ButtonGroup buttonGroup2;
    ButtonGroup buttonGroup3;
    ButtonGroup buttonGroup4;
    JTextField nameField;
    //public static OrderList aOrderList;
    OrderList aOrderList = new OrderList();
    // Main Method
    public static void main(String args[])
    {
        // Create a RadioButtonMenu object.
        JFrame aFrame = new Menu();
        // Show it.
        aFrame.setVisible(true);
    }

    // Constructor
    public Menu()
    {
        setTitle("Breakfast Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a JPanel to be used as the content pane.
        JPanel aPanel = new JPanel();
        //aPanel.setLayout(new BoxLayout(aPanel, BoxLayout.Y_AXIS));
        aPanel.setLayout(new GridLayout(0, 5));
        // Creates a button groups for the buttons.

        buttonGroup1 = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();
        buttonGroup3 = new ButtonGroup();
        buttonGroup4 = new ButtonGroup();

        aPanel.add(new JLabel("                      Name:"));        //Adds name field
        nameField = new JTextField();
        nameField.addActionListener(new NewTextFieldValue());
        aPanel.add(nameField);
        aPanel.add(new JLabel(""));
        aPanel.add(new JLabel(""));
        aPanel.add(new JLabel(""));

        JLabel term1 = new JLabel("             Appetizers:");
        JLabel term2 = new JLabel("                     Drinks:");
        JLabel term3 = new JLabel("                  Entrees:");
        JLabel term4 = new JLabel("                Desserts:");

        aPanel.add(term1);              //adds appetizer radio buttons
        for (int i = 0; i < appetizers.length; i++)
        {
            radioButtons[i] = new JRadioButton(appetizers[i]);
            radioButtons[i].getModel().setActionCommand(appetizers[i]);
            buttonGroup1.add(radioButtons[i]);
            aPanel.add(radioButtons[i]);
        }

        aPanel.add(term2);              //adds drinks radio buttons
        for (int i = 0; i < drinks.length; i++)
        {
            radioButtons[i] = new JRadioButton(drinks[i]);
            radioButtons[i].getModel().setActionCommand(drinks[i]);
            buttonGroup2.add(radioButtons[i]);
            aPanel.add(radioButtons[i]);
        }

        aPanel.add(term3);              //adds entree radio buttons
        for (int i = 0; i < entrees.length; i++)
        {
            radioButtons[i] = new JRadioButton(entrees[i]);
            radioButtons[i].getModel().setActionCommand(entrees[i]);
            buttonGroup3.add(radioButtons[i]);
            aPanel.add(radioButtons[i]);
        }

        aPanel.add(term4);              //add dessert radio buttons
        for (int i = 0; i < desserts.length; i++)
        {
            radioButtons[i] = new JRadioButton(desserts[i]);
            radioButtons[i].getModel().setActionCommand(desserts[i]);
            buttonGroup4.add(radioButtons[i]);
            aPanel.add(radioButtons[i]);
        }
        aPanel.add(new JLabel(""));


        /**
         * Next section adds the JButtons Clear, Enter, Print
         */
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearPressed());
        aPanel.add(clearButton);

        enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterPressed());
        aPanel.add(enterButton);

        printButton = new JButton("Print");
        printButton.addActionListener(new PrintPressed());
        aPanel.add(printButton);

        setContentPane(aPanel);
        pack();
    }

    private class NewTextFieldValue implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
        }

    }

    /**
     * clearFields() clears radio button selections and name field
     */
    public void clearFields()
    {
        nameField.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
        buttonGroup4.clearSelection();

    }

    /**
     * Print button //prints Receipt with all of the orders
     */
    private class PrintPressed implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            aOrderList.printList();
        }

    }

    /*
     * Enter button         //saves the order that is entered
     */
    private class EnterPressed implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String appetizer = "";
            String drink = "";
            String entree = "";
            String dessert = "";
            String name = "";

            name = nameField.getText();
            appetizer = buttonGroup1.getSelection().getActionCommand();
            drink = buttonGroup2.getSelection().getActionCommand();
            entree = buttonGroup3.getSelection().getActionCommand();
            dessert = buttonGroup4.getSelection().getActionCommand();

            Order aOrder = new Order(name, appetizer, drink, entree, dessert);

            aOrderList.insertAtEnd(new ListNode(aOrder));

            clearFields();
        }

    }

    /**
     * Clear button //clears radio buttons and Name field
     */
    private class ClearPressed implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            clearFields();
        }

    }

}
