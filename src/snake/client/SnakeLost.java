package snake.client;

import java.awt.*;
import java.time.Instant;

/**
 * The purpose of this class is to handle the display of statistics when the game is lost.
 * @author chamb
 */
public class SnakeLost
{
    public static final float BLINK_RATE = 0.25f;
    private static final Font LOST_FONT = new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 36);
    private static int looser;
    
    public static Instant lostTime;
    
    public static void gameLost(int l, long lTime)
    {
        lostTime = Instant.ofEpochSecond(lTime);
        looser = l;
    }
    
    /**
     * This will draw and animate the Game End card.
     * @param g The Graphics object
     */
    private static int cardWidth=290, cardHeight=110;
    private static final Point cardEnd = new Point(snake.SnakeSettings.WINDOW_SIZE.width/2, snake.SnakeSettings.WINDOW_SIZE.height/2);
    private static final Point cardStart = new Point(cardEnd.x, cardEnd.y+500);
    private static final float transitionTime = 1f;
    
    public static void drawCard(Graphics g)
    {
        if (lostTime == null)
            return;
        float pathPercent = (((Instant.now().toEpochMilli()-lostTime.toEpochMilli())/1000f) / transitionTime);
        Point currentPos;
        if (pathPercent > 1)
            currentPos = cardEnd;
        else
        {
            currentPos = new Point((int)(cardStart.x + ((cardEnd.x-cardStart.x)*getBezier(pathPercent))), (int)(cardStart.y + ((cardEnd.y-cardStart.y)*getBezier(pathPercent))));
            //System.out.println(pathPercent + " | " + getBezier(pathPercent));
        }
        
        //Draw the box
        g.setColor(new Color(180, 180, 180));
        g.fillRect(currentPos.x - (cardWidth/2), currentPos.y - (cardHeight/2), cardWidth, cardHeight);
        g.setColor(Color.BLACK);
        g.drawRect(currentPos.x - (cardWidth/2), currentPos.y - (cardHeight/2), cardWidth, cardHeight);
        
        //Draw the text
        g.setFont(LOST_FONT);
        String name = "";
        if (looser == 1)
            name = "Red Snake";
        else 
            name = "Blue Snake";
        g.drawString(name + " lost!", currentPos.x-135, currentPos.y+15);
        
    }
    
    private static float getBezier(float x)
    {
        float[] u = new float[] {0.0f, 1.0f, 1.1f, 1.0f}; //Weights
        
        float part1 = u[0] * ((float)Math.pow((1-x),3));
        float part2 = 3 * u[1] * ((float)Math.pow((1-x),2)) * x;
        float part3 = 3 * u[2] * (1-x) * ((float)Math.pow((x),2));
        float part4 = u[3] * ((float)Math.pow((x),3));
        
        return part1 + part2 + part3 + part4;
    }
}
