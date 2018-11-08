package snake;

import java.awt.*;

public class SnakeGame
{
    public static boolean gameInProgress = false;
    private static SnakeTimer timer;
    public static SnakeHead snake1;
    public static SnakeView view = new SnakeView(new Point(40, 40));
    
    public static void startGame()
    {
        //Create snakes
        snake1 = new SnakeHead(new Point(32, 18), SnakeHead.LEFT);
        
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
        System.out.println(snake1.pos);
    }
    
    public static void resetGame()
    {
        
    }
    
    public static void stopGame()
    {
        gameInProgress = false;
    }
    
}
