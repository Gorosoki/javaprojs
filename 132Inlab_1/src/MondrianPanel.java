
/**
 * Write a description of class MondrianFrame here.
 * 
 * @author Gavin Goroski
 * @version 13 Jan 2013
 */

import java.awt.*;
import javax.swing.*;

public class MondrianPanel extends JPanel
{
    // instance variables
    private int size = 600;

    /**
     * Constructor for objects of class MondrianFrame
     */
    public MondrianPanel()
    {
        setPreferredSize(new Dimension(size, size));
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

    for(int i = 0; i < 5000; i++)
    {
        g.setColor(Color.getHSBColor((float)Math.random(), 1.0f, 1.0f));
        g.fillRect(randomN(getWidth()), randomN(getHeight()), randomN(75), randomN(75));
        
    }
    }
    public int randomN(int num)
    {
       return (int)(Math.random()*(num));
    }
    

}
