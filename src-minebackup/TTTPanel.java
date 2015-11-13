//
//import javax.swing.*;
//import java.awt.*;
//
//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent;
//
///**
// * Write a description of class TTTPanel here.
// * 
// * @author Brendan
// * @version Jan 21
// */
//public class TTTPanel extends JPanel
//{
//    // instance variables - replace the example below with your own
//    private int size = 750;
//    private TicTacToe tttGame;
//
//    /**
//     * Constructor for objects of class MondrianFrame
//     */
//    public TTTPanel(TicTacToe tttGame1)
//    {
//        setPreferredSize(new Dimension(size, size));
//        addMouseListener(new TTTMouseListener());
//        tttGame = tttGame1;
//    }
//
//    public void paint(Graphics g)
//    {
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, getWidth(), getHeight());
//
//        g.setColor(Color.BLACK);
////        g.drawLine(0,50,300,50);
////        g.drawLine(0,100,300,100);
////        g.drawLine(50,0,50,300);
////        g.drawLine(100,0,100,300);
//        for(int i = 1; i < 16; i++)
//        {
//            g.drawLine(0, (i*50), 750, (i*50));
//        }
//        
//        for(int i = 1; i < 16; i++)
//        {
//            g.drawLine((50*i), (0), (i*50), (750));
//        }
//
//
//        Font f = new Font("Times", Font.PLAIN, 50);
//        g.setFont(f);
//        FontMetrics fm = g.getFontMetrics();
//        
//        int a = fm.getAscent();
//        int h = fm.getHeight();
//
//        for (int i = 0; i < 15; i++) {
//            for (int j = 0; j < 15; j++) {
//                char curSquare = tttGame.getSquare(i,j);
//                String curSqStr = Character.toString(curSquare);
//                int w = fm.stringWidth(curSqStr);
//                g.drawString(curSqStr, 50*i + 25 - w/2, 50*j + (35 + a - h/2));
//            }
//        }
//    }
//
//    // INNER CLASS for a Mouse events:
//
//    private class TTTMouseListener implements MouseListener {
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//        }
//
//        public void mouseReleased(MouseEvent e) {
//        }
//
//        public void mouseEntered(MouseEvent e) {
//        }
//
//        public void mouseExited(MouseEvent e) {
//        }
//
//        public void mouseClicked(MouseEvent e) {
//            int x = e.getX() / 50;
//            int y = e.getY() / 50;
//            if (tttGame.getSquare(x,y) == ' ') {
//                tttGame.setSquare(x,y, tttGame.getCurPlayer());
//                repaint();
//                tttGame.switchPlayer();
//                tttGame.checkForGameEnd();
//
//            }
//        }
//    }
//
//}
