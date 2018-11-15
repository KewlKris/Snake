package snake.server;

import java.io.*;

public class SnakeServerWriter extends Thread
{
    private DataOutputStream out;
    
    public SnakeServerWriter(DataOutputStream o)
    {
        out = o;
    }
    
    public void run()
    {
        
    }
}