
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * @author Daniel
 */
public class Rolodex extends JFrame {

    public static ContactPanel contactPanel;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new Rolodex();
        frame.setVisible(true);
        frame.setSize(1300, 1000);
    }

    // Constructor
    /**
     * Construct the components and add them to the frame.
     */
    public Rolodex() {
        super("Rolodex");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Get a reference to the content pane.
        Container contentPane = getContentPane();
        // Set the layout manager to grid layout.
        contentPane.setLayout(new GridLayout(2,0));
        contactPanel = new ContactPanel();
        contentPane.add(contactPanel);
        contentPane.add(new ButtonPanel());
        
        
        // Size the frame to fit.
        //pack();
    }
}
