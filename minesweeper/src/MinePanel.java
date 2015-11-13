
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
/*
 * Draws border and square
 * 
 */

/**
 *
 * @author Gavin Goroski && Aaron Mead
 * @date Jan 27, 2013
 */
public class MinePanel extends JPanel
{
    // instance variables - replace the example below with your own

    private int size = 750;
    private Minesweeper mineGame;
    private int x;
    private int y;
    private int paints;
    /**
     * Constructor for objects of class MondrianFrame
     */
    public MinePanel(Minesweeper MineGame1)
    {
        paints = 0;
        setPreferredSize(new Dimension(size, size));
        addMouseListener(new MinePanel.mineMouseListener());
        mineGame = MineGame1;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        paints++;
        g.setColor(Color.BLACK);
        for (int i = 1; i < 16; i++)
        {
            g.drawLine(0, (i * 50), 750, (i * 50));
        }
        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {

                if (mineGame.getFound(i, j))
                {

                    g.setColor(Color.WHITE);
                    g.fillRect((i * 50), ((j * 50) + 1), 49, 49);
                }
            }
        }

        g.setColor(Color.BLACK);
        for (int i = 1;
                i < 16; i++)
        {
            g.drawLine((50 * i), (0), (i * 50), (750));
        }
        Font f = new Font("Times", Font.PLAIN, 45);

        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();
        int a = fm.getAscent();
        int h = fm.getHeight();
        for (int i = 0;
                i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                if (mineGame.getFound(i, j))
                {
                    String curSqStr;
                    curSqStr = mineGame.getStuff(i, j);
                    int w = fm.stringWidth(curSqStr);
                    g.drawString(curSqStr, 50 * i + 25 - w / 2, 50 * j + (30 + a - h / 2));
                }
            }
        }
    }

// INNER CLASS for a Mouse events:
    private class mineMouseListener implements MouseListener
    {

        @Override
        public void mousePressed(MouseEvent e)
        {
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
        }

        public void mouseEntered(MouseEvent e)
        {
        }

        public void mouseExited(MouseEvent e)
        {
        }

        public void mouseClicked(MouseEvent e)
        {
            x = e.getX() / 50;
            y = e.getY() / 50;
            mineGame.player(x, y);

        }

    }

}
