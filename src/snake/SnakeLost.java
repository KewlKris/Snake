package snake;

import java.awt.*;
import java.time.Instant;

/**
 * The purpose of this class is to handle the display of statistics when the game is lost.
 * @author chamb
 */
public class SnakeLost
{
    public static final float blinkRate = 0.5f;
    
    public static Instant lostTime;
    
    public static void gameLost()
    {
        lostTime = Instant.now();
    }
    
    /**
     * Make the head of the snake blink, showing the fault.
     * @param g Graphics object
     */
    public static void drawBlink(Graphics g, SnakeView view)
    {
        long currentTime_l = Instant.now().toEpochMilli();
        long lostTime_l = lostTime.toEpochMilli();
        
        if (((int)(((currentTime_l - lostTime_l)/1000f) / blinkRate) % 2) == 0)
        {
            
        }
    }
}
