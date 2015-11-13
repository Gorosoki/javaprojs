


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ButtonPanel extends JPanel {

    private JButton clearButton, enterButton, searchButton, printButton, deleteButton;
    private File test;
    public ButtonPanel() {
        setLayout(new FlowLayout());
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearPressed());
        add(clearButton);
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterPressed());
        add(enterButton);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchPressed());
        add(searchButton);
        printButton = new JButton("Print");
        printButton.addActionListener(new PrintPressed());
        add(printButton);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeletePressed());
        add(deleteButton);
        File test = new File("test.wav");
    }

    // Inner Class
    /**
     * The action listener for the button.
     */
    private class ClearPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            play(test);
            TreeDex.contactPanel.clearFields();
            new AePlayWave("test.wav").start();
        }
    }

    private class EnterPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            Contact newContact = new Contact(TreeDex.contactPanel.firstNameField.getText(),
                    TreeDex.contactPanel.lastNameField.getText(),
                    Integer.parseInt(TreeDex.contactPanel.phoneField.getText()),
                    TreeDex.contactPanel.emailField.getText());
            TreeDex.myContacts.insertAlphabetically(new ContactListNode(newContact));

            TreeDex.contactPanel.clearFields();
        }
    }

    private class SearchPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Matchs found:");
            ContactListNode curNode = TreeDex.myContacts.getHead();
            while (curNode != null) {
                Contact curContact = curNode.getContact();
                if (curContact.match(TreeDex.contactPanel.firstNameField.getText(),
                        TreeDex.contactPanel.lastNameField.getText(),
                        TreeDex.contactPanel.phoneField.getText(),
                        TreeDex.contactPanel.emailField.getText())) {
                    // print it out
                    curContact.print();
                }
                curNode = curNode.getNext();
            }
            TreeDex.contactPanel.clearFields();
        }
    }

    private class PrintPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new AePlayWave("test.wav").stop();
            TreeDex.printContacts();
        }
    }

    private class DeletePressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ContactListNode curNode = TreeDex.myContacts.getHead();
            ContactListNode nextNode;
            while (curNode != null) {
                Contact curContact = curNode.getContact();
                if (curContact.match(TreeDex.contactPanel.firstNameField.getText(),
                        TreeDex.contactPanel.lastNameField.getText(),
                        TreeDex.contactPanel.phoneField.getText(),
                        TreeDex.contactPanel.emailField.getText())) {

                    // delete this node:
                    nextNode = curNode.getNext();
                    TreeDex.myContacts.delete(curNode);
                    curNode = nextNode;
                } else {
                    curNode = curNode.getNext();
                }
            }
            TreeDex.contactPanel.clearFields();
        }
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

