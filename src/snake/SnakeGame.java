package snake;

import java.awt.*;
import java.util.Arrays;

public class SnakeGame
{
    public static boolean gameInProgress = false;
    private static SnakeTimer timer;
    public static SnakeHead snake1;
    public static SnakeView view = new SnakeView(new Point(40, 40));
    public static int[][] collisions = new int[36][64];
    
    public static void startGame()
    {
        //Create snakes
        snake1 = new SnakeHead(new Point(32, 18), SnakeHead.LEFT);
        //SnakeSegment s1 = new SnakeSegment(snake1, true);
        //snake1.setChild(s1);
        snake1.appendChild();
        snake1.appendChild();
        snake1.appendChild();
        
        gameInProgress = true;
        timer = new SnakeTimer();
        timer.execute();
    }
    
    public static void drawEntities(Graphics g)
    {
        snake1.draw(view, g);
    }
    
    public static void tick()
    {
        snake1.move();
        snake1.arrayCheck();
        for (int i = 0; i < collisions.length; i++) {
            System.out.println(Arrays.toString(collisions[i]));
        }
    }
    
    public static void resetGame()
    {
        
    }
    
    public static void stopGame()
    {
        gameInProgress = false;
    }
}
