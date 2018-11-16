package snake.server;

import java.io.*;
import java.awt.event.*;

public class SnakeServerListener extends Thread
{
    private DataInputStream in;
    private int snakeID;
    
    public SnakeServerListener(DataInputStream i, int id)
    {
        in = i;
        snakeID = id;
    }
    
    public void run()
    {
        int i;
        try
        {
            while((i = in.readInt()) != -222)
            {
                switch(i)
                {
                    case 20: //Change Direction
                        int d = in.readInt();
                        if (SnakeGame.GAME_TYPE == SnakeGame.MULTI_SAME_SCREEN)
                        {
                            SnakeGame.snake1.changeDirection(d);
                            SnakeGame.snake2.changeDirection(d);
                            snake.Snake.frame.serverOut("Received direction change for same screen");
                        }
                        if (snakeID == 1)
                        {
                            SnakeGame.snake1.changeDirection(d);
                            snake.Snake.frame.serverOut("Received direction change for Snake 1");
                        }
                        else
                        {
                            SnakeGame.snake2.changeDirection(d);
                            snake.Snake.frame.serverOut("Received direction change for Snake 2");
                        }
                        break;
                }
            }
        } catch (IOException e)
        {
            //A client disconnected
            snake.Snake.frame.serverOut("Client connection error!");
            snake.Snake.frame.serverOut("Stopping game...");
            SnakeGame.stopGame();
            SnakeServer.clientLeft();
            //e.printStackTrace();
        }
    }
}
