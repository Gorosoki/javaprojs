

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
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
 * @author Gavin Goroski @ Aaron Mead
 */
public class Driver extends JFrame
{
   private JButton clearButton, enterButton, searchButton, quitButton, deleteButton;
    public JTextField word, def;
    private int size = 100;
    private TreeNode[] array = new TreeNode[size];
    public static TreeNode treeNode;
    public int i = 10;
    public static BinaryTree t = new BinaryTree();
    private static String fileName = "./src/vocab10.txt";
    private static int y;
    private static int x;

 public static void main(String[] args) {
//        treePanel = new TreePanel();
        try
        {
            Scanner s = new Scanner(new File(fileName));
            //String size = s.nextLine();

            while (s.hasNextLine())
            {
                    
                    String word = s.next();
                    String line = s.nextLine();
                    System.out.println(word + line);
                    Words inWord = new Words(word, line);  
                    TreeNode wordNode = new TreeNode(inWord);
                    t.insert(wordNode);
                   
                }

            
            s.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        
        JFrame frame = new Driver();
        frame.setVisible(true);
        
 }
public Driver(){
super("Dictionary");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        // Set the layout manager to grid layout.
        contentPane.setLayout(new GridLayout(6, 2));
          
//        setLayout(new FlowLayout());
        add(new JLabel("Enter, Search, or Delete Word: "));
        word = new JTextField(15);
        word.addActionListener(new NewTextFieldValue());
        add(word);
        add(new JLabel("Enter Definition: "));
        def = new JTextField(15);
        def.addActionListener(new NewTextFieldValue());
        add(def);
        
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
//        for (int i = 0; i < size; i++) {
//            array[i] = new TreeNode(r.nextInt(1000));
//            t.insert(array[i]);
//        }
}
        

private class NewTextFieldValue implements ActionListener {

        /**
         * Convert the gallons value to corresponding liters value.
         *
         * @param e ActionEvent object - not used
         */
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    public void clearFields() {
        word.setText("");
        def.setText("");
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
            if(word.getText().equals(""))
            {
                System.out.println("There was nothing to input");
            }
            else{
                String inWords = word.getText();
                String inDefs = def.getText();
                Words inWord = new Words(inWords, inDefs);  
                TreeNode wordNode = new TreeNode(inWord);
                t.insert(wordNode);
                System.out.println();
                printTree();
                System.out.println(inWords + " has been inserted into the tree.");
                clearFields();
            }
        }
    }

    private class SearchPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String search = word.getText();
            System.out.println();
            System.out.println("Your value to search is: " + search);
            if(t.search(search) == null)
            {
                System.out.println(search + " does not exist in the tree.");
                System.out.println("If you would like to add " + "'" + search + "'" + " to the dictionary, add the definition and press Enter.");
            }
            else{  
            System.out.println();
            System.out.println("The definition for '" + t.search(search).getData().getWord() +"' is :" + t.search(search).getData().getDefinition());
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
        String aDelete = word.getText();
        System.out.println();              
            if(t.search(aDelete) == null)
            {
                System.out.println(aDelete + " does not exist in the tree.");
//                System.out.println("If you would like to add " + "'" + search + "'" + " to the dictionary, add the definition and press Enter.");
            }
            else{
                System.out.println("Deleting " + aDelete); 
                t.delete(t.search(aDelete));
                PrintTree2.printTree(t);
                System.out.println(aDelete + " has been removed from the tree.");
                
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