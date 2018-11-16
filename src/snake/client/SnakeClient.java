package snake.client;

import java.io.*;
import java.net.*;

public class SnakeClient
{
    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;
    
    /*
    20 - Change Direction  {[4] id, [4] direction}
    */
    
    public static boolean connect(String host, int port)
    {
        try
        {
            socket = new Socket(host, port);
            snake.Snake.frame.clientOut(String.format("Connected to %s:%d", host, port));
            in = new DataInputStream(socket.getInputStream());
            snake.Snake.frame.clientOut("Opened InputStream");
            out = new DataOutputStream(socket.getOutputStream());
            snake.Snake.frame.clientOut("Opened OutputStream");
            SnakeClientListener listener = new SnakeClientListener(in);
            listener.start();
            snake.Snake.frame.clientOut("SnakeClientListener listening on InputStream");
            
        } catch (UnknownHostException e)
        {
            snake.Snake.frame.clientOut(String.format("Unknown host %s:%d", host, port));
            return false;
        } catch (IOException e)
        {
            snake.Snake.frame.clientOut("Error connecting to host");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean sendDirection(int i)
    {
        try
        {
            out.writeInt(20);
            out.writeInt(i);
        } catch (IOException e)
        {
            if (!SnakeGame.gameInProgress)
                return true;
            snake.Snake.frame.clientOut("Failed to send direction to server!");
            return false;
        } catch (NullPointerException e)
        {
            
        }
        
        return true;
    }
    
    public static void closeAll()
    {
        try
        {
            in.close();
            out.close();
            socket.close();
            snake.Snake.frame.clientOut("Socket closed");
        } catch (IOException e)
        {
            snake.Snake.frame.clientOut("Error closing socket");
            e.printStackTrace();
        }
    }
    
    
    
}
