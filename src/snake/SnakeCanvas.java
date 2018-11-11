package snake;
//This comment was made by the Abhishek Choudhury gang
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
            SnakeGame.keyPresed(e);
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
        buf.setColor(this.getBackground());
        buf.fillRect(0, 0, SnakeSettings.WINDOW_SIZE.width, SnakeSettings.WINDOW_SIZE.height);
        
        switch(SnakeGame.STATUS)
        {
            case SnakeGame.WAITING_TO_START:
                drawBasics(buf);
                break;
            case SnakeGame.IN_PROGRESS:
                drawBasics(buf);
                SnakeGame.drawEntities(buf);
                break;
        }
        
        g.drawImage(frameBuffer, 0, 0, this);
        repaint();
    }
    
    private void drawBasics(Graphics g)
    {
        SnakeGame.view.drawBorder(g);
        SnakeGame.view.fillBackground(g);
        SnakeGame.view.drawGrid(g);
        SnakeGame.view.drawScore(g, SnakeGame.score);
        
        SnakeGame.drawTime(g);
    }
    
    
    public void update(Graphics g)
    {
        paint(g);
    }
    
}
