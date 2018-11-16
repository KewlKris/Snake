package snake.server;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.time.Instant;
import java.util.ArrayList;

public class SnakeServer extends Thread
{
    public static Socket client1, client2;
    public static SnakeServerListener client1List, client2List;
    //public static SnakeServerWriter client1Write, client2Write;
    
    public static DataInputStream in1, in2;
    public static DataOutputStream out1, out2;
    
    public static ServerSocket server;
    
    int gametype2, port2;
    
    public SnakeServer(int g, int p)
    {
        gametype2 = g;
        port2 = p;
    }
    public void run()
    {
        startServer(gametype2, port2);
    }
    
    public static void closeAll()
    {
        try
        {
            in1.close();
            out1.close();
            client1.close();
            in2.close();
            out2.close();
            client2.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void startServer(int gametype, int port)
    {
        try
        {
            if (server == null)
            {
                server = new ServerSocket(port);
            }
            client1 = server.accept();
            in1 = new DataInputStream(client1.getInputStream());
            out1 = new DataOutputStream(client1.getOutputStream());
            client1List = new SnakeServerListener(in1, 1);
            client1List.start();
            System.out.println("Client 1 up!");
            if (gametype == SnakeGame.MULTI_HOST)
            {
                client2 = server.accept();
                in2 = new DataInputStream(client2.getInputStream());
                out2 = new DataOutputStream(client2.getOutputStream());
                client2List = new SnakeServerListener(in2, 2);
                //client2Write = new SnakeServerWriter(new DataOutputStream(client2.getOutputStream()));
                client2List.start();
                //client2Write.start();
                System.out.println("Client 2 up!");
            }
            System.out.println("left!");
            
            SnakeGame.startGame(gametype, port);
            sendStart(Instant.now().toEpochMilli());
            
            
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void clientLeft()
    {
        try
        {
            if (client1 != null)
            {
                out1.writeInt(8);
            }
            if (client2 != null)
            {
                out2.writeInt(8);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void setScore(int id, int score)
    {
        try
        {
            if (id == 1)
            {
                out1.writeInt(7); //Command ID
                out1.writeInt(id);
                out1.writeInt(score);
            } else
            {
                out2.writeInt(7); //Command ID
                out2.writeInt(id);
                out2.writeInt(score);
            }
        } catch (IOException e)
        {
            
        }
    }
    
    public static void sendLost(int id, long l)
    {
        try
        {
            out1.writeInt(6); //Command ID
            out1.writeInt(id);
            out1.writeLong(l);
            if (SnakeGame.GAME_TYPE == 4)
            {
                out2.writeInt(6); //Command ID
                out2.writeInt(id);
                out2.writeLong(l);
            }
        } catch (IOException e)
        {
            
        }
    }
    
    public static void sendStart(long s)
    {
        try
        {
            out1.writeInt(5); //Command ID
            out1.writeInt(SnakeGame.GAME_TYPE);
            out1.writeLong(s);
            if (SnakeGame.GAME_TYPE == 4)
            {
                out2.writeInt(5); //Command ID
                out2.writeInt(SnakeGame.GAME_TYPE);
                out2.writeLong(s);
            }
            System.out.println("started");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void sendTiles()
    {
        //Get locations
        ArrayList<Point> snake1List, snake2List;
        snake1List = SnakeGame.snake1.getPos(null);
        if (SnakeGame.GAME_TYPE != SnakeGame.SINGLE)
            snake2List = SnakeGame.snake2.getPos(null);
        else
            snake2List = new ArrayList<Point>();
        
        Point foodPos = SnakeGame.food.pos;
        
        //Convert to Tiles
        snake.SnakeTile[] tiles = new snake.SnakeTile[snake1List.size() + snake2List.size() + 1];
        
        
        int c = 0;
        for(Point p : snake1List)
        {
            tiles[c] = new snake.SnakeTile(p.x, p.y, snake.SnakeTile.RED);
            c++;
        }
        for(Point p : snake2List)
        {
            tiles[c] = new snake.SnakeTile(p.x, p.y, snake.SnakeTile.BLUE);
            c++;
        }
        
        tiles[c] = new snake.SnakeTile(foodPos.x, foodPos.y, snake.SnakeTile.BLACK);
        
        try
        {
            out1.writeInt(4); //Command ID
            out1.writeInt(tiles.length);
            for(snake.SnakeTile t : tiles)
            {
                t.writeToStream(out1);
            }
            
            if (SnakeGame.GAME_TYPE == 4)
            {
                out2.writeInt(4); //Command ID
                out2.writeInt(tiles.length);
                for(snake.SnakeTile t : tiles)
                {
                    t.writeToStream(out2);
                }
            }
        } catch (IOException e)
        {
            
        }
    }
}
