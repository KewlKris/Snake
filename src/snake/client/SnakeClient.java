package snake.client;

import java.io.*;
import java.net.*;

public class SnakeClient
{
    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;
    
    /*
    20 - Change Direction
    */
    
    public static boolean connect(String host, int port)
    {
        try
        {
            socket = new Socket(host, port);
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
            return false;
        } catch (IOException e)
        {
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
            return false;
        }
        
        return true;
    }
    
    
    
    
}
