package snake;

import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Point;

public class Snake
{
    public static SnakeFrame frame;
    public static void main(String[] args) throws
            ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException
    {
        //Setup Settings
        SnakeSettings.WINDOW_SIZE = new Dimension(720, 440);
        SnakeSettings.GRID_SIZE = new Dimension(64, 36);
        SnakeSettings.BLOCK_SIZE = 10;
        SnakeSettings.DEFAULT_TICKRATE = 0.1f;
        SnakeSettings.TICKRATE_DECLINE = 0.001f;
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        frame = new SnakeFrame();
        frame.setVisible(true);
    }
    
}
