package snake.client;

import java.io.*;

public class SnakeClientListener extends Thread
{
    public void run(DataInputStream in)
    {
        /*
        4 - Send tiles {[4] id, [4] number of objects, [...] objects}
        5 - Start game {[4] id, [4] game type, [8] start time}
        6 - Lose Game  {[4] id, [4] id of loser, [8] end time}
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
                        SnakeGame.startGame(in.readInt(), in.readLong());
                        break;
                    case 6:
                        SnakeGame.lostGame(in.readInt(), in.readLong());
                        break;
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
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
