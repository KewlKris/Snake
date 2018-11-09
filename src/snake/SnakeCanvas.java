package snake;

import java.awt.*;
import java.awt.event.*;

public class SnakeCanvas extends Canvas
{
    Image frameBuffer;
    Graphics buf;
    public SnakeCanvas()
    {
        this.setSize(SnakeSettings.WINDOW_SIZE);
        this.setBackground(new Color(210, 210, 210));
        
        this.addKeyListener(new SnakeListener());
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
        if (frameBuffer == null)
        {
            try
            {
                frameBuffer = createImage(this.getWidth(), this.getHeight());
                buf = frameBuffer.getGraphics();
            } catch (NullPointerException e)
            {
                return;
            }
        }
        SnakeGame.view.drawBorder(buf);
        SnakeGame.view.fillBackground(buf);
        SnakeGame.view.drawGrid(buf);
        
        if (SnakeGame.gameInProgress)
        {
            SnakeGame.drawEntities(buf);
        }
        g.drawImage(frameBuffer, 0, 0, this);
        repaint();
    }
    
    public void update(Graphics g)
    {
        paint(g);
    }
}
