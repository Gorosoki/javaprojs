
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

    
/**
 *
 * @author Gavin
 */
public class MinePanel extends JPanel
{
    // instance variables - replace the example below with your own
    private int size = 750;
    private Minesweeper mineGame;

    /**
     * Constructor for objects of class MondrianFrame
     */
    public MinePanel(Minesweeper MineGame1)
    {
        setPreferredSize(new Dimension(size, size));
        addMouseListener(new MinePanel.mineMouseListener());
        mineGame = MineGame1;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
//        g.drawLine(0,50,300,50);
//        g.drawLine(0,100,300,100);
//        g.drawLine(50,0,50,300);
//        g.drawLine(100,0,100,300);
        for(int i = 1; i < 16; i++)
        {
            g.drawLine(0, (i*50), 750, (i*50));
        }
        
        for(int i = 1; i < 16; i++)
        {
            g.drawLine((50*i), (0), (i*50), (750));
        }

       
        Font f = new Font("Times", Font.PLAIN, 45);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();
        
        int a = fm.getAscent();
        int h = fm.getHeight();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                char curSquare = mineGame.getSquare(i,j);
                String curSqStr = Character.toString(curSquare);
                int w = fm.stringWidth(curSqStr);
                g.drawString(curSqStr, 50*i + 25 - w/2, 50*j + (35 + a - h/2));
            }
        }
    }

    // INNER CLASS for a Mouse events:

    private class mineMouseListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
            int x = e.getX() / 50;
            int y = e.getY() / 50;
            //System.out.println(x);
            //System.out.println(y);
            if (mineGame.getSquare(x,y) == ' ') {
                mineGame.setSquare(x, y, mineGame.checkForMines(x,y));
                repaint();
                mineGame.checkForGameEnd();

            }
            else if (mineGame.getSquare(x,y) == '*'){
                mineGame.checkForGameEnd();
            }
            else{
                JOptionPane.showMessageDialog(mineGame, "You have clicked there already!");
                //System.out.println("You have clicked here already!");
            }
        }
    }

}
