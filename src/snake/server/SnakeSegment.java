package snake.server;

import java.awt.*;

public class SnakeSegment extends SnakeBody
{
    SnakeBody parent;
    
    public SnakeSegment(SnakeBody p, Color c, boolean delayed)
    {
        parent = p;
        super.pos = (Point)p.pos.clone();
        super.direction = p.direction;
        super.delayed = delayed;
        super.color = c;
    }
    
    public void assumeDirection()
    {
        direction = parent.direction;
    }
    
}
