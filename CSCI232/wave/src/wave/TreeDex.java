package wave;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.io.File;
import javax.sound.sampled.*;
/**
 *
 * @author Brendan
 */
public class TreeDex extends JFrame {

    
//    public static ContactPanel contactPanel;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new TreeDex();
        frame.setVisible(true);
    }

    // Constructor
    /**
     * Construct the components and add them to the frame.
     */
    public TreeDex() {
        super("Rolodex");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Get a reference to the content pane.
        Container contentPane = getContentPane();
        // Set the layout manager to grid layout.
        contentPane.setLayout(new GridLayout(2, 1));
//        contactPanel = new ContactPanel();
//        contentPane.add(contactPanel);
        contentPane.add(new ButtonPanel());
        
        
        
        
     
        // Size the frame to fit.
        pack();
    }

    // Inner Classes
    /**
     * Class to respond to new gallons value.
     */


    
    
    public static void printContacts() {
         System.out.println("Contact list:");

    }


public void play(File file) 
{
    try
    {
        final Clip clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));

        clip.addLineListener(new LineListener()
        {
            @Override
            public void update(LineEvent event)
            {
                if (event.getType() == LineEvent.Type.STOP)
                    clip.close();
            }
        });

        clip.open(AudioSystem.getAudioInputStream(file));
        clip.start();
    }
    catch (Exception exc)
    {
        exc.printStackTrace(System.out);
    }
}
}
