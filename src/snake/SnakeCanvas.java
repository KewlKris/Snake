package snake;

import java.awt.*;
import java.awt.event.*;

public class SnakeCanvas extends Canvas
{
    private SnakeView game;
    public SnakeCanvas()
    {
        this.setSize(SnakeSettings.WINDOW_SIZE);
        this.setBackground(new Color(210, 210, 210));
        game = new SnakeView(new Point(40, 40));
        
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
        game.drawBorder(g);
        game.fillBackground(g);
        game.drawGrid(g);
        
        game.setTile(g, Color.red, 0, 0);
        game.setTile(g, Color.red, 1, 0);
        game.setTile(g, Color.red, 0, 1);
    }
}
