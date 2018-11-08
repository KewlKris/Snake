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
        //Setup Settings
        SnakeSettings.WINDOW_SIZE = new Dimension(720, 440);
        SnakeSettings.GRID_SIZE = new Dimension(64, 36);
        SnakeSettings.BLOCK_SIZE = 10;
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SnakeFrame f = new SnakeFrame();
        f.setVisible(true);
        
        SnakeGame.startGame();
    }
}
