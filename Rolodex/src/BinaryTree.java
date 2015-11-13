///**
// * @author Aaron Mead
// * @version 3/24/2013
// */
//
//import java.util.Random;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class BinaryTree extends JFrame{
//    
//    private JButton quitButton, insertButton,deleteButton, searchButton;            
//    private JTextField insert, delete, search;                                      
//    private int size = 20;                                                         
//    private TreeNode[] array = new TreeNode[size];                                  
//    public static BinaryTreeProg t = new BinaryTreeProg();                          
//    public static TreeNode tn;                                                      
//    
//    public static void main(String[] args) {
//        JFrame aFrame = new BinaryTree();
//        aFrame.setVisible(true);        
//    }
//    
//    public BinaryTree(){
//        setTitle("Binary Tree with a GUI");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        Container aPanel = getContentPane();
//        aPanel.setLayout(new GridLayout(4,2));
//        insert = new JTextField(10);
//        delete = new JTextField(10);
//        search = new JTextField(10);
//        insertButton = new JButton("Insert node");
//        insertButton.addActionListener(new insertButtonPressed());
//        add(insert);
//        add(insertButton);
//        deleteButton = new JButton("Delete node");
//        deleteButton.addActionListener(new deleteButtonPressed());
//        add(delete);
//        add(deleteButton);
//        searchButton = new JButton("Search for node");
//        searchButton.addActionListener(new searchButtonPressed());
//        add(search);
//        add(searchButton);
//        quitButton = new JButton("Quit");
//        quitButton.addActionListener(new quitButtonPressed());
//        add(quitButton);
//        pack();
//        Random r = new Random();       
//        for (int i = 0; i < 10; i++) {
//            array[i] = new TreeNode(r.nextInt(1000));
//            t.insert(array[i]);
//        }
//        System.out.println("current tree:");
//        PrintTree.printTree(t);
//
//        System.out.println("Pre-order traversal: ");
//        BinaryTreeProg.preOrderTraversal(t.getRoot());
//        System.out.println();
//        System.out.println("In-order traversal: ");
//        BinaryTreeProg.inOrderTraversal(t.getRoot());
//        System.out.println();
//        System.out.println("Post-order traversal: ");
//        BinaryTreeProg.postOrderTraversal(t.getRoot());
//        System.out.println();
//    }
//    
//    public void insertButtonOper(TreeNode[] array){
//        int insertedNode = Integer.parseInt(insert.getText());
//        int i = 10;
//        i++;
//        array[i] = new TreeNode(insertedNode);
//        t.insert(array[i]);
//        System.out.println();
//        System.out.println("Tree with inserted node.");
//        PrintTree.printTree(t);
//    }
//    
//    public void deleteButtonOper(TreeNode[] array){
//        int deleteValue = Integer.parseInt(delete.getText());
//        System.out.println();              
//        for (int j = 0; j <= array.length; j++){
//            if (array[j] == t.search(deleteValue)){
//                System.out.println("Deleting " + array[j]); 
//                t.delete(array[j]);
//                PrintTree.printTree(t);
//                System.out.println(array[j] + " has been deleted from the tree.");
//                j = array.length;
//            }
//        }       
//    }
//    
//    public void searchButtonOper(){
//        int searchValue = Integer.parseInt(search.getText());
//        System.out.println();
//        System.out.println("Your value to search is: " + searchValue);
//        System.out.println(t.search(searchValue) + " exists in the tree.");
//    }
//    
//    private class insertButtonPressed
//        implements ActionListener {        
//        
//        @Override
//        public void actionPerformed(ActionEvent e) {   
//            insertButtonOper(array);
//        }
//    }
//    
//    private class deleteButtonPressed
//        implements ActionListener {
//        
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            deleteButtonOper(array);
//        }
//    }
//    
//    private class searchButtonPressed
//        implements ActionListener {
//        
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            searchButtonOper();             
//        }
//    }    
//    
//    private class quitButtonPressed 
//        implements ActionListener{
//        
//        @Override
//        public void actionPerformed(ActionEvent e){
//            System.exit(0);
//        }
//    }
//    
//}
