package snake;

import javax.swing.SwingWorker;
import java.time.Instant;

public class SnakeTimer extends SwingWorker<Void, Void>
{
    public static final float TICKRATE = 0.5f; //Time in seconds
    
    public Void doInBackground()
    {
        while(true)
        {
            Instant start = Instant.now();
            while(((float)(Instant.now().toEpochMilli() - start.toEpochMilli()) / 1000f) <= TICKRATE)
            {
                
            }
            SnakeGame.tick();
        }
    }
    
    
}
