package snake.server;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.time.Instant;
import java.util.ArrayList;
import snake.SnakeTile;

public class SnakeGame
{
    public static boolean gameInProgress = false;
    private static SnakeTimer timer;
    public static SnakeHead snake1;
    public static SnakeHead snake2;
    public static Grid[][] collisions = new Grid[snake.SnakeSettings.GRID_SIZE.height][snake.SnakeSettings.GRID_SIZE.width];
    public static SnakeFood food;
    public static int score = 0;
    public static int score2 = 0;
    public static Instant startTime;
    public static int STATUS = 1;
    public static int GAME_TYPE;
    public static SnakeHead loser;
    public static int port;
    
    private static double finalTime;
    
    public static final int WAITING_TO_START=1, IN_PROGRESS=2, GAME_LOST=3;
    public static final int 
            SINGLE=1, SINGLE_WITH_BOT=2, MULTI_SAME_SCREEN=3, MULTI_HOST=4,
            MULTI_JOIN=5;
    
    public static void startGame(int type, int p)
    {
        resetVars();
        port = p;
        GAME_TYPE = type;
        
        //Create snakes
        snake1 = new SnakeHead(new Point(36, 18), SnakeTile.intToColor(SnakeTile.RED), SnakeHead.RIGHT, 1);
        snake1.appendChild(3);
        
        if (GAME_TYPE != SINGLE)
        {
            snake2 = new SnakeHead(new Point(28, 18), SnakeTile.intToColor(SnakeTile.BLUE), SnakeHead.LEFT, 2);
            snake2.appendChild(3);
        }
        food = new SnakeFood();
        //SnakeSegment s1 = new SnakeSegment(snake1, true);
        //snake1.setChild(s1);
        
        SnakeTimer.TICKRATE = snake.SnakeSettings.DEFAULT_TICKRATE;
        finalTime = 0;
        score = 0;
        startTime = Instant.now();
        gameInProgress = true;
        timer = new SnakeTimer();
        timer.execute();
        
        STATUS = IN_PROGRESS;
    }
    
    /*
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
    */
    
    public static void updateArray()
    {
        collisions = new Grid[collisions.length][collisions[0].length];
        snake1.arrayCheck();
        if (GAME_TYPE != SINGLE)
            snake2.arrayCheck();
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
        if (GAME_TYPE != SINGLE)
            snake2.changeDirection(e);
    }
    
    public static void tick()
    {
        updateArray();
        snake1.move();
        if (GAME_TYPE != SINGLE)
            snake2.move();
        
        SnakeServer.sendTiles();
    }
    
    public static void lostGame(SnakeHead l)
    {
        loser = l;
        
        Instant currentTime = Instant.now();
        finalTime = (currentTime.toEpochMilli() - startTime.toEpochMilli())/1000d;
        
        stopGame();
        STATUS = GAME_LOST;
        SnakeServer.sendLost(l.keyBinding, currentTime.toEpochMilli());
    }
    
    public static void stopGame()
    {
        STATUS = WAITING_TO_START;
        gameInProgress = false;
        timer.cancel(true);
    }
    
    public static void resetVars()
    {
        gameInProgress = false;
        collisions = new Grid[snake.SnakeSettings.GRID_SIZE.height][snake.SnakeSettings.GRID_SIZE.width];
        score = 0;
        score2 = 0;
        STATUS = WAITING_TO_START;
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
