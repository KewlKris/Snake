package snake.server;

import javax.swing.SwingWorker;
import java.time.Instant;

public class SnakeTimer extends SwingWorker<Void, Void>
{
    public static float TICKRATE = 0.1f; //Time in seconds
    
    public Void doInBackground()
    {
        while(true)
        {
            Instant start = Instant.now();
            while(((float)(Instant.now().toEpochMilli() - start.toEpochMilli()) / 1000f) < TICKRATE)
            {
                if (!SnakeGame.gameInProgress)
                    return null;
            }
            SnakeGame.tick();
        }
    }
    
    
}
