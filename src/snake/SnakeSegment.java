package snake;

import java.awt.*;

public class SnakeSegment extends SnakeBody
{
    SnakeBody parent;
    
    public SnakeSegment(SnakeBody p, boolean delayed)
    {
        parent = p;
        super.pos = p.pos;
        super.direction = p.direction;
        super.delayed = delayed;
    }
    
    public void assumeDirection()
    {
        direction = parent.direction;
    }
    
}
