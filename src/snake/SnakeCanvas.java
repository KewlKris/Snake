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
            //System.out.println(e.getExtendedKeyCode());
            
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    SnakeGame.snake1.direction = SnakeHead.UP;
                    break;
                case KeyEvent.VK_DOWN:
                    SnakeGame.snake1.direction = SnakeHead.DOWN;
                    break;
                case KeyEvent.VK_LEFT:
                    SnakeGame.snake1.direction = SnakeHead.LEFT;
                    break;
                case KeyEvent.VK_RIGHT:
                    SnakeGame.snake1.direction = SnakeHead.RIGHT;
                    break;
                case KeyEvent.VK_ADD:
                    SnakeGame.snake1.appendChild();
                    break;
            }
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
