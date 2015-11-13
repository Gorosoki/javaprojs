
import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * Write a description of class TTTPanel here.
 * 
 * @author Gavin Goroski
 * @version Jan 22, 2013
 */
public class TTTPanel extends JPanel
{
    // instance variables - replace the example below with your own
    private int size = 300;
    private TicTacToe tttGame;

    /**
     * Constructor for objects of class MondrianFrame
     */
    public TTTPanel(TicTacToe tttGame1)
    {
        setPreferredSize(new Dimension(size, size));
        addMouseListener(new TTTMouseListener());
        tttGame = tttGame1;
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.drawLine(0,100,300,100);
        g.drawLine(0,200,300,200);
        g.drawLine(100,0,100,300);
        g.drawLine(200,0,200,300);

        Font f = new Font("Times", Font.PLAIN, 45);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();
        
        int a = fm.getAscent();
        int h = fm.getHeight();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char curSquare = tttGame.getSquare(i,j);
                String curSqStr = Character.toString(curSquare);
                int w = fm.stringWidth(curSqStr);
                g.drawString(curSqStr, 100*i + 50 - w/2, 100*j + 50 + a - h/2);
            }
        }
    }

    // INNER CLASS for a Mouse events:

    private class TTTMouseListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX() / 100;
            int y = e.getY() / 100;
            if (tttGame.getSquare(x,y) == ' ' && tttGame.getCurPlayer() == 'X') {
                tttGame.setSquare(x,y, tttGame.getCurPlayer());
                repaint();
                tttGame.switchPlayer();
                tttGame.checkForGameEnd();
                tttGame.aiPlayer();
            }
    }
    }
}