package snake.client;
import java.awt.*;
import java.awt.event.*;
import snake.client.SnakeClient;

public class SnakeCanvas extends Canvas
{
    Image frameBuffer;
    Graphics buf;
    public SnakeCanvas()
    {
        this.setSize(snake.SnakeSettings.WINDOW_SIZE);
        this.setBackground(new Color(210, 210, 210));
        
        this.addKeyListener(new SnakeListener());
    }
    
    private class SnakeListener implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            //System.out.println(e.getKeyChar());
            //System.out.println(e.getExtendedKeyCode());
            SnakeClient.sendDirection(e.getExtendedKeyCode());
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
        buf.fillRect(0, 0, snake.SnakeSettings.WINDOW_SIZE.width, snake.SnakeSettings.WINDOW_SIZE.height);
        
        switch(SnakeGame.STATUS)
        {
            case SnakeGame.WAITING_TO_START:
                drawBasics(buf);
                break;
            case SnakeGame.IN_PROGRESS:
                drawBasics(buf);
                SnakeGame.drawEntities(buf);
                break;
            case SnakeGame.GAME_LOST:
                drawBasics(buf);
                SnakeGame.drawEntities(buf);
                SnakeLost.drawCard(buf);
                break;
        }
        
        g.drawImage(frameBuffer, 0, 0, this);
        repaint();
    }
    
    private void drawBasics(Graphics g)
    {
        SnakeView.drawBorder(g);
        SnakeView.fillBackground(g);
        SnakeView.drawGrid(g);
        SnakeView.drawScore(g, SnakeGame.score, new Point(40,30));
        SnakeView.drawScore(g, SnakeGame.score2, new Point(200,30));
        
        SnakeGame.drawTime(g);
    }
    
    
    public void update(Graphics g)
    {
        paint(g);
    }
    
}