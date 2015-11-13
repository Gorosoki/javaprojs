

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Gavin Goroski
 * @date 1/24/2014
 */
public class Driver extends JFrame
{
   private JButton clearButton, enterButton, searchButton, quitButton, deleteButton,traverseButton;
    public JTextField firstNameField;
    public JTextField year;
    private int size = 15;
    private TreeNode[] array = new TreeNode[size];
    public static TreeNode treeNode;
    public int i = 10;
    public static BinaryTree t = new BinaryTree(); 

 public static void main(String[] args) {
//        treePanel = new TreePanel();
        JFrame frame = new Driver();
        frame.setVisible(true);
    }
public Driver(){
super("Binary Tree");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        // Set the layout manager to grid layout.
        contentPane.setLayout(new GridLayout(6, 2));
          
//        setLayout(new FlowLayout());
        add(new JLabel("Enter Car Name "));
        firstNameField = new JTextField(15);
        firstNameField.addActionListener(new NewTextFieldValue());
        add(firstNameField);
        add(new JLabel("Enter Car Year "));
        year = new JTextField(15);
        year.addActionListener (new NewTextFieldValue());
        add(year);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearPressed());
        add(clearButton);
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterPressed());
        add(enterButton);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchPressed());
        add(searchButton);
        quitButton = new JButton("Quit");
        quitButton.addActionListener(new QuitPressed());
        add(quitButton);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeletePressed());
        add(deleteButton);
        traverseButton = new JButton("Traverse");
        traverseButton.addActionListener(new TraversePressed());
        add(traverseButton);
//        contentPane.add(treePanel);
//        contentPane.add(new ButtonPanel());
        pack(); 
        
         Random r = new Random();
//        TreeNode[] array = new TreeNode[10];
        Data intNode = new Data("Bus", 1957);
        Data intNode1 = new Data("Car", 1991);
        Data intNode2 = new Data("Truck", 1992);
        Data intNode3 = new Data("SUV", 1999);
        Data intNode4 = new Data("Limo", 2055);
        Data intNode5 = new Data("Truck", 1991);

            array[0] = new TreeNode(intNode4);
            array[1] = new TreeNode(intNode1);
            array[2] = new TreeNode(intNode3);
            array[3] = new TreeNode(intNode2);
            array[4] = new TreeNode(intNode);
            array[5] = new TreeNode(intNode5);
            
            
            
            for (int i = 0; i <=5; i++)
            {
            t.insert(array[i]);
            }

        
         
        printTree();
        System.out.println();
        System.out.print("Pre-order traversal: ");
        BinaryTree.preOrderTraversal(t.getRoot());
        System.out.println();
        System.out.print("In-Order traversal: ");
        BinaryTree.inOrderTraversal(t.getRoot());
        System.out.println();
        System.out.print("Post-order traversal: ");
        BinaryTree.postOrderTraversal(t.getRoot());
        System.out.println();
        System.out.println();
}
        

private class NewTextFieldValue implements ActionListener {

        /**
         * 
         *
         * @param e ActionEvent object
         */
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    public void clearFields() {
        firstNameField.setText("");
        year.setText("");
    }
    
    private class ClearPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clearFields();
        }
    }

    private class EnterPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (firstNameField.getText().equals("") || firstNameField.getText().equals(null))
            {
                System.out.println("Please enter a value in the Name field.");
            }
            else if (year.getText().equals("") || year.getText().equals(null))
            {
                System.out.println("Please enter a value in the Year field.");
            }
            else{
            Data intNode = new Data(firstNameField.getText(), Integer.parseInt(year.getText()));
            i++;
            array[i] = new TreeNode(intNode);
            t.insert(array[i]);
            System.out.println();
            printTree();
            System.out.println(intNode.getYear() + " " + intNode.getName() + " has been inserted into the tree.");
            clearFields();
        }
        
    }
    }

    private class SearchPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
                        if (firstNameField.getText().equals("") || firstNameField.getText().equals(null))
            {
                System.out.println("Please enter a value in the Name field.");
            }
            else if (year.getText().equals("") || year.getText().equals(null))
            {
                System.out.println("Please enter a value in the Year field.");
            }
            else{
            Data search = new Data(firstNameField.getText(), Integer.parseInt(year.getText()));
            System.out.println();
            System.out.println("Your value to search is: " + search.getName() + " " + search.getYear());
            if(t.search(search) == null)
            {
                System.out.println(search + " does not exist in the tree.");
            }
            else{  
            System.out.println(t.search(search) + " exists in the tree.");
            }
            clearFields();
            }
        }
    }

    private class QuitPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class DeletePressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                    if (firstNameField.getText().equals("") || firstNameField.getText().equals(null))
            {
                System.out.println("Please enter a value in the Name field.");
            }
            else if (year.getText().equals("") || year.getText().equals(null))
            {
                System.out.println("Please enter a value in the Year field.");
            }
            else{    
        Data aDelete = new Data(firstNameField.getText(), Integer.parseInt(year.getText()));
        System.out.println();              
        for (int j = 0; j <= array.length-1; j++){
            if (array[j] == (t.search(aDelete))){
                System.out.println("Deleting " + array[j]); 
                t.delete(array[j]);
                PrintTree2.printTree(t);
                System.out.println(array[j] + " has been removed from the tree.");
                j = array.length;
                i--;
            }
            
        }
            clearFields();
            }
        }
           
        }
        
    private class TraversePressed
        implements ActionListener {
        @Override
    public void actionPerformed(ActionEvent e){
        System.out.print("Pre-order traversal: ");
        BinaryTree.preOrderTraversal(t.getRoot());
        System.out.println();
        System.out.print("In-Order traversal: ");
        BinaryTree.inOrderTraversal(t.getRoot());
        System.out.println();
        System.out.print("Post-order traversal: ");
        BinaryTree.postOrderTraversal(t.getRoot());
        System.out.println();
        System.out.println();
        
    }
}
        
    public static void printTree(){
        PrintTree2.printTree(t);
    }

}