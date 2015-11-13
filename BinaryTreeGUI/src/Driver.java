

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gavin Goroski
 */
public class Driver extends JFrame
{
   private JButton clearButton, enterButton, searchButton, quitButton, deleteButton;
    public JTextField firstNameField;
    private int size = 25;
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
        contentPane.setLayout(new GridLayout(4, 2));
          
//        setLayout(new FlowLayout());
        add(new JLabel("Enter, Search, or Delete Value: "));
        firstNameField = new JTextField(15);
        firstNameField.addActionListener(new NewTextFieldValue());
        add(firstNameField);
        add(new JLabel());
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
//        contentPane.add(treePanel);
//        contentPane.add(new ButtonPanel());
        pack(); 
        
         Random r = new Random();
//        TreeNode[] array = new TreeNode[size];
//
        for (int i = 0; i < size; i++) {
            array[i] = new TreeNode(r.nextInt(1000));
            t.insert(array[i]);
        }
        
        printTree();
        System.out.print("Pre-order traversal: ");
        BinaryTree.preOrderTraversal(t.getRoot());
        System.out.println();
        System.out.print("In-Order traversal: ");
        BinaryTree.inOrderTraversal(t.getRoot());
        System.out.println();
        System.out.print("Post-order traversal: ");
        BinaryTree.postOrderTraversal(t.getRoot());
        System.out.println();
}
        

private class NewTextFieldValue implements ActionListener {

        /**
         * 
         *
         * @param e ActionEvent object - not used
         */
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    public void clearFields() {
        firstNameField.setText("");
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
            
            int intNode = Integer.parseInt(firstNameField.getText());
            i++;
            array[i] = new TreeNode(intNode);
            t.insert(array[i]);
            System.out.println();
            printTree();
            System.out.println(intNode + " has been inserted into the tree.");
            clearFields();
        }
    }

    private class SearchPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int search = Integer.parseInt(firstNameField.getText());
            System.out.println();
            System.out.println("Your value to search is: " + search);
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
        int aDelete = Integer.parseInt(firstNameField.getText());
        System.out.println();              
        for (int j = 0; j <= array.length-1; j++){
            if (array[j] == t.search(aDelete)){
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
        
     
        // Size the frame to fit.
        

    // Inner Classes
    /**
     * Class to respond to new gallons value.
     */ 
    public static void printTree(){
        PrintTree2.printTree(t);
    }

}