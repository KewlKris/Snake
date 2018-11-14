package snake.client;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.time.Instant;

public class SnakeGame
{
    public static boolean gameInProgress = false;
    public static snake.SnakeTile[][] grid = new snake.SnakeTile[snake.SnakeSettings.GRID_SIZE.height][snake.SnakeSettings.GRID_SIZE.width];
    public static int score = 0;
    public static int score2 = 0;
    public static Instant startTime;
    public static int STATUS = 1;
    public static int GAME_TYPE;
    
    public static int looserID;
    
    private static double finalTime;
    
    public static final int WAITING_TO_START=1, IN_PROGRESS=2, GAME_LOST=3;
    public static final int 
            SINGLE=1, SINGLE_WITH_BOT=2, MULTI_SAME_SCREEN=3, MULTI_HOST=4,
            MULTI_JOIN=5;
    
    public static void startGame(int type, long strtTme)
    {
        gameInProgress = true;
        finalTime = 0;
        startTime = Instant.ofEpochSecond(strtTme);
        
        STATUS = IN_PROGRESS;
    }
    
    public static void drawTime(Graphics g)
    {
        if (STATUS == GAME_LOST || !gameInProgress)
        {
            SnakeView.drawTime(g, finalTime);
            return;
        }
        try
        {
            Instant currentTime = Instant.now();
            double sec = (currentTime.toEpochMilli() - startTime.toEpochMilli())/1000d;
            SnakeView.drawTime(g, sec);
        } catch (NullPointerException e)
        {
            SnakeView.drawTime(g, 0d);
        }
    }
    
    public static void lostGame(int l)
    {
        looserID = l;
        stopGame();
        STATUS = GAME_LOST;
        SnakeLost.gameLost(l);
    }
    
    public static void stopGame()
    {
        Instant currentTime = Instant.now();
        finalTime = (currentTime.toEpochMilli() - startTime.toEpochMilli())/1000d;
        gameInProgress = false;
        timer.cancel(true);
        Snake.frame.startButton.setEnabled(true);
        Snake.frame.stopButton.setEnabled(false);
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
