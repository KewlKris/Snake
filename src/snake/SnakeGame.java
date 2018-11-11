package snake;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.time.Instant;

public class SnakeGame
{
    public static boolean gameInProgress = false;
    private static SnakeTimer timer;
    public static SnakeHead snake1;
    public static SnakeView view = new SnakeView(new Point(40, 40));
    public static Grid[][] collisions = new Grid[SnakeSettings.GRID_SIZE.height][SnakeSettings.GRID_SIZE.width];
    public static SnakeFood food;
    public static int score = 0;
    public static Instant startTime;
    public static int STATUS = 1;
    
    public static final int WAITING_TO_START=1, IN_PROGRESS=2, GAME_LOST=3;
    
    public static void startGame()
    {
        //Create snakes
        snake1 = new SnakeHead(new Point(32, 18), SnakeHead.LEFT, 1);
        food = new SnakeFood();
        //SnakeSegment s1 = new SnakeSegment(snake1, true);
        //snake1.setChild(s1);
        snake1.appendChild(3);
        
        score = 0;
        startTime = Instant.now();
        gameInProgress = true;
        timer = new SnakeTimer();
        timer.execute();
        
        STATUS = IN_PROGRESS;
    }
    
    public static void drawTime(Graphics g)
    {
        try
        {
            Instant currentTime = Instant.now();
            double sec = (currentTime.toEpochMilli() - startTime.toEpochMilli())/1000d;
            view.drawTime(g, sec);
        } catch (NullPointerException e)
        {
            view.drawTime(g, 0d);
        }
    }
    
    public static void updateArray()
    {
        collisions = new Grid[collisions.length][collisions[0].length];
        snake1.arrayCheck();
        if (food != null)
            food.arrayCheck();
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
        food.draw(view, g);
    }
    
    public static void tick()
    {
        updateArray();
        snake1.move();
    }
    
    public static void resetGame()
    {
        stopGame();
        startGame();
    }
    
    public static void lostGame()
    {
        
    }
    
    public static void stopGame()
    {
        gameInProgress = false;
        timer.cancel(false);
        Snake.frame.startButton.setEnabled(true);
    }
    
    private static void delay(float seconds)
    {
        Instant start = Instant.now();
        while((Instant.now().toEpochMilli() - start.toEpochMilli())/1000f < seconds)
        {
            //Wait
        }
    }
}
