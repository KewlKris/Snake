//Christopher Chamberlain and Abhishek Choudhury
//AP Computer Science
//Period 3
//11-16-2018

package snake;

import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Point;
import snake.server.SnakeGame;

import java.time.Instant;

public class Snake
{
    public static snake.client.SnakeFrame frame;
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
        
        //Setup frame
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        frame = new snake.client.SnakeFrame();
        frame.setVisible(true);
        
        /* Old test
        snake.server.SnakeGame.startGame(snake.server.SnakeGame.MULTI_SAME_SCREEN, 27010);
        new snake.server.SnakeServer().start();
        
        snake.client.SnakeClient.connect("127.0.0.1", 27010);
        
        snake.server.SnakeServer.sendStart(Instant.now().toEpochMilli());
        */
        
    }
    
}
