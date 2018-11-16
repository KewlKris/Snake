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
        snake.Snake.frame.serverOut(String.format("Starting server thread with port: %d and gametype: %d", port2, gametype2));
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
            snake.Snake.frame.serverOut("Closed sockets");
        } catch (IOException e)
        {
            snake.Snake.frame.serverOut("Error closing sockets");
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
            snake.Snake.frame.serverOut("ServerSocket created");
            snake.Snake.frame.serverOut("Waiting for client 1...");
            client1 = server.accept();
            snake.Snake.frame.serverOut(String.format("Client 1 at %s connected", client1.getInetAddress().getCanonicalHostName()));
            in1 = new DataInputStream(client1.getInputStream());
            snake.Snake.frame.serverOut("Client 1 InputStream opened");
            out1 = new DataOutputStream(client1.getOutputStream());
            snake.Snake.frame.serverOut("Client 1 OutputStream opened");
            client1List = new SnakeServerListener(in1, 1);
            client1List.start();
            snake.Snake.frame.serverOut("Client 1 listener started");
            if (gametype == SnakeGame.MULTI_HOST)
            {
                snake.Snake.frame.serverOut("Waiting for client 2...");
                client2 = server.accept();
                snake.Snake.frame.serverOut(String.format("Client 2 at %s connected", client2.getInetAddress().getCanonicalHostName()));
                in2 = new DataInputStream(client2.getInputStream());
                snake.Snake.frame.serverOut("Client 2 InputStream opened");
                out2 = new DataOutputStream(client2.getOutputStream());
                snake.Snake.frame.serverOut("Client 2 OutputStream opened");
                client2List = new SnakeServerListener(in2, 2);
                client2List.start();
                snake.Snake.frame.serverOut("Client 2 listener started");
            }
            
            SnakeGame.startGame(gametype, port);
            snake.Snake.frame.serverOut("Starting master");
            sendStart(Instant.now().toEpochMilli());
            
            
        } catch (IOException e)
        {
            snake.Snake.frame.serverOut("Error occurred in starting server");
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
                snake.Snake.frame.serverOut("Sent end game code to client 1");
            }
            if (client2 != null)
            {
                out2.writeInt(8);
                snake.Snake.frame.serverOut("Sent end game code to client 2");
            }
        } catch (IOException e)
        {
            snake.Snake.frame.serverOut("Client escape code exception!");
            //e.printStackTrace();
        }
    }
    
    public static void setScore(int id, int score)
    {
        try
        {
            if (SnakeGame.GAME_TYPE == 4)
            {
                out1.writeInt(7); //Command ID
                out1.writeInt(id);
                out1.writeInt(score);
                out2.writeInt(7); //Command ID
                out2.writeInt(id);
                out2.writeInt(score);
                snake.Snake.frame.serverOut(String.format("Score update for snake %d", id));
            } else
            {
                out1.writeInt(7); //Command ID
                out1.writeInt(id);
                out1.writeInt(score);
                snake.Snake.frame.serverOut(String.format("Score update for snake %d", id));
            }
        } catch (IOException e)
        {
            snake.Snake.frame.serverOut("Error setting score");
        }
    }
    
    public static void sendLost(int id, long l)
    {
        try
        {
            out1.writeInt(6); //Command ID
            out1.writeInt(id);
            out1.writeLong(l);
            snake.Snake.frame.serverOut("Sent game lost code to client 1");
            if (SnakeGame.GAME_TYPE == 4)
            {
                out2.writeInt(6); //Command ID
                out2.writeInt(id);
                out2.writeLong(l);
                snake.Snake.frame.serverOut("Sent game lost code to client 2");
            }
        } catch (IOException e)
        {
            snake.Snake.frame.serverOut("Error sending lost code");
        }
    }
    
    public static void sendStart(long s)
    {
        try
        {
            out1.writeInt(5); //Command ID
            out1.writeInt(SnakeGame.GAME_TYPE);
            out1.writeLong(s);
            snake.Snake.frame.serverOut("Sent start game code to client 1");
            if (SnakeGame.GAME_TYPE == 4)
            {
                out2.writeInt(5); //Command ID
                out2.writeInt(SnakeGame.GAME_TYPE);
                out2.writeLong(s);
                snake.Snake.frame.serverOut("Sent start game code to client 2");
            }
        } catch (IOException e)
        {
            snake.Snake.frame.serverOut("Error sending start game code");
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
            snake.Snake.frame.serverOut("Error sending tiles");
        }
    }
}
