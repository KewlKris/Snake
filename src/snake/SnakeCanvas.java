package snake;

import java.awt.*;
import java.awt.event.*;

public class SnakeCanvas extends Canvas
{
    Image frameBuffer;
    public SnakeCanvas()
    {
        this.setSize(SnakeSettings.WINDOW_SIZE);
        this.setBackground(new Color(210, 210, 210));
        
        this.addKeyListener(new SnakeListener());
        //frameBuffer = new Image();
    }
    
    private class SnakeListener implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            //System.out.println(e.getKeyChar());
            System.out.println(e.getExtendedKeyCode());
        }
        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }
    
    public void paint(Graphics g)
    {
        
        SnakeGame.view.drawBorder(g);
        SnakeGame.view.fillBackground(g);
        SnakeGame.view.drawGrid(g);
        
        if (SnakeGame.gameInProgress)
        {
            SnakeGame.drawEntities(g);
        }
        repaint();
    }
}
