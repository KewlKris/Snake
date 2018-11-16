package snake.client;

import java.io.*;

public class SnakeClientListener extends Thread
{
    private DataInputStream in;
    public SnakeClientListener(DataInputStream i)
    {
        in = i;
    }
    
    public void run()
    {
        /*
        4 - Send tiles {[4] id, [4] number of objects, [...] objects}
        5 - Start game {[4] id, [4] game type, [8] start time}
        6 - Lose game  {[4] id, [4] id of loser, [8] end time}
        7 - Set score  {[4] id, [4] id of snake, [4] value}
        8 - End game   {[4] id}
        */
        try
        {
            int i;
            while((i = in.readInt()) != -222)
            {
                switch(i)
                {
                    case 4: //Send tiles
                        getTiles(in, in.readInt());
                        break;
                    case 5:
                        snake.Snake.frame.clientOut("Start game code received");
                        SnakeGame.startGame(in.readInt(), in.readLong());
                        break;
                    case 6:
                        snake.Snake.frame.clientOut("Lost game code received");
                        SnakeGame.lostGame(in.readInt(), in.readLong());
                        break;
                    case 7:
                        switch(in.readInt())
                        {
                            case 1:
                                snake.Snake.frame.clientOut("Score update for Snake 1");
                                SnakeGame.score = in.readInt();
                                break;
                            case 2:
                                SnakeGame.score = in.readInt();
                                snake.Snake.frame.clientOut("Score update for Snake 2");
                                break;
                        }
                        break;
                    case 8:
                        snake.Snake.frame.clientOut("Game end code received");
                        SnakeGame.stopGame();
                        SnakeGame.resetVars();
                        break;
                    default:
                        snake.Snake.frame.clientOut(String.format("Unknown code received: %d", i));
                        break;
                }
            }
        } catch (IOException e)
        {
            //Lost connection to server
            snake.Snake.frame.clientOut("Lost connection to server!");
            snake.Snake.frame.clientOut("Closing socket");
            SnakeClient.closeAll();
            //e.printStackTrace();
        }
    }
    
    private void getTiles(DataInputStream in, int tileCount) throws IOException
    {
        snake.SnakeTile[] tempTiles = new snake.SnakeTile[tileCount];
        for(int x=0; x<tileCount; x++)
        {
            tempTiles[x] = new snake.SnakeTile(in.readInt(), in.readInt(), in.readInt());
        }
        
        SnakeGame.activeTiles = tempTiles;
    }
}
