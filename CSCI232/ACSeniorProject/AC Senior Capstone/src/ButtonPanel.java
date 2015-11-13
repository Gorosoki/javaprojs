import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * @author Daniel
 */
public class ButtonPanel extends JPanel {

    private JButton nextButton;
    private JButton prevButton;
    private Thread worker;
    int count = 0;
    boolean stopCount = false;
    private int songCount = 0;

    public ButtonPanel() {
        setLayout(new FlowLayout());
        
        prevButton = new JButton("Prev");
        prevButton.addActionListener(new PrevPressed());
        add(prevButton);
        nextButton = new JButton("Next");
        nextButton.addActionListener(new NextPressed());
        add(nextButton);
        component.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),
                            "pressed");
        
    }
    // Inner Class
    /**
     * The action listener for the button.
     */
	
		
    private class NextPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (stopCount) {
            worker.stop();
            }
            stopCount = true;
            
            if (songCount < 9) {
            songCount++;
            }
            
//            if (songCount == 0 && stopCount)
//            {
//                worker.stop();
//            }
            
            if (songCount == 1) {
            Runnable task = new Sound("Page 1.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 2) {
            Runnable task = new Sound("Page 2.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 3) {
            Runnable task = new Sound("Page 3.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 4) {
            Runnable task = new Sound("Page 4.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 5) {
            Runnable task = new Sound("Page 5.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 6) {
            Runnable task = new Sound("Page 6.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 7) {
            Runnable task = new Sound("Page 7.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 8) {
            Runnable task = new Sound("Page 8.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 9) {
            Runnable task = new Sound("Page 9.wav");
            worker = new Thread(task);
            worker.start();
            }
//            else if (songCount > 9) {
//            Runnable task = new Sound("Page 10.wav");
//            worker = new Thread(task);
//            worker.start();
//            }
            
            if (count < 9) {
            count++;
            }
            try {
                Rolodex.contactPanel.clearFields(count);
            } catch (IOException ex) {
                Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class PrevPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (stopCount) {
            worker.stop();
            }
            stopCount = true;
            
            if (songCount > 0) {
            songCount--;
            }
            
            if (songCount == 1) {
            Runnable task = new Sound("Page 1.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 2) {
            Runnable task = new Sound("Page 2.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 3) {
            Runnable task = new Sound("Page 3.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 4) {
            Runnable task = new Sound("Page 4.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 5) {
            Runnable task = new Sound("Page 5.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 6) {
            Runnable task = new Sound("Page 6.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 7) {
            Runnable task = new Sound("Page 7.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 8) {
            Runnable task = new Sound("Page 8.wav");
            worker = new Thread(task);
            worker.start();
            }
            else if (songCount == 9) {
            Runnable task = new Sound("Page 9.wav");
            worker = new Thread(task);
            worker.start();
            }
//            else if (songCount > 9) {
//            Runnable task = new Sound("Page 10.wav");
//            worker = new Thread(task);
//            worker.start();
//            }
            
            if (count > 0) {
            count--;
            }
            try {
                Rolodex.contactPanel.clearFields(count);
            } catch (IOException ex) {
                Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
