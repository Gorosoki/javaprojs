package wave;




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

    private JButton playButton, stopButton, pauseButton;
//    private File test;
    private Thread worker;
    private boolean paused = false;
    public ButtonPanel() {
        setLayout(new FlowLayout());
        playButton = new JButton("Play");
        playButton.addActionListener(new PlayPressed());
        add(playButton);
        stopButton = new JButton("Stop");
        stopButton.addActionListener(new StopPressed());
        add(stopButton);
        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new PausePressed());
        add(pauseButton);

        File test = new File("test.wav");
    }

    // Inner Class
    /**
     * The action listener for the button.
     */
    private class PlayPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            play(test);
//            TreeDex.contactPanel.playFields();
            Runnable task =  new AePlayWave2("test.wav");
            worker = new Thread(task);
            worker.start();
//            new AePlayWave("test.wav").run();
        }
    }

    private class StopPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            AePlayWave.stops = false;
            worker.stop();
       

//            TreeDex.contactPanel.playFields();
        }
    }

    private class PausePressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
//            TreeDex.contactPanel.playFields();
            if(!paused)
            {
            worker.suspend();
            paused = true;
            }
            else
            {
                worker.resume();
                paused = false;
            }
        }
    }

    
    
    
//    public void play(File file) 
//{
//    try
//    {
//        final Clip clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
//
//        clip.addLineListener(new LineListener()
//        {
//            @Override
//            public void update(LineEvent event)
//            {
//                if (event.getType() == LineEvent.Type.STOP)
//                    clip.close();
//            }
//        });
//
//        clip.open(AudioSystem.getAudioInputStream(file));
//        clip.start();
//    }
//    catch (Exception exc)
//    {
//        exc.printStackTrace(System.out);
//    }
//}
}

