package snake;

import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Point;

public class Snake
{
    public static void main(String[] args) throws
            ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException
    {
        /*
        SnakeHead head = new SnakeHead(new Point(3,3));
        head.move();
        head.direction = 2;
        head.move();
        SnakeSegment s1 = new SnakeSegment(head);
        head.addChild(s1);
        head.move();
        head.direction = 3;
        head.move();
        */
        
        //Setup Settings
        SnakeSettings.WINDOW_SIZE = new Dimension(720, 440);
        SnakeSettings.GRID_SIZE = new Dimension(64, 36);
        SnakeSettings.BLOCK_SIZE = 10;
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SnakeFrame f = new SnakeFrame();
        f.setVisible(true);
    }
}
