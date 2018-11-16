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
                        if (snakeID == 1)
                            SnakeGame.snake1.changeDirection(in.readInt());
                        else
                            SnakeGame.snake2.changeDirection(in.readInt());
                        break;
                }
            }
        } catch (IOException e)
        {
            //A client disconnected
            SnakeGame.stopGame();
            //e.printStackTrace();
        }
    }
}
