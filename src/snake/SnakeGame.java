package snake;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class SnakeGame
{
    public static boolean gameInProgress = false;
    private static SnakeTimer timer;
    public static SnakeHead snake1;
    public static SnakeView view = new SnakeView(new Point(40, 40));
    public static int[][] collisions = new int[36][64];
    //public static SnakeFood food;
    
    public static void startGame()
    {
        //Create snakes
        snake1 = new SnakeHead(new Point(32, 18), SnakeHead.LEFT);
        //SnakeSegment s1 = new SnakeSegment(snake1, true);
        //snake1.setChild(s1);
        snake1.appendChild(3);
        
        gameInProgress = true;
        timer = new SnakeTimer();
        timer.execute();
        
        //food = new SnakeFood();
    }
    
    public static void updateArray()
    {
        collisions = new int[collisions.length][collisions[0].length];
        snake1.arrayCheck();
    }
    
    /**
    * This method is to be called when the game needs to handle a key press.
    * @param e The KeyEvent from the KeyListener
    */
    public static void keyPresed(KeyEvent e)
    {
        snake1.changeDirection(e);
    }
    
    /**
     * This method is to be called when the grid needs to be updated.
     * @param g The Graphics object on which to draw the grid onto.
     */
    public static void drawEntities(Graphics g)
    {
        snake1.draw(view, g);
        //food.draw(view, g);
    }
    
    public static void tick()
    {
        snake1.move();
    }
    
    public static void resetGame()
    {
        
    }
    
    public static void stopGame()
    {
        gameInProgress = false;
        timer.cancel(true);
        Snake.frame.startButton.setEnabled(true);
    }
}
