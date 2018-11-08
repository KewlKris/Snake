package snake;

import java.awt.*;

public class SnakeSegment extends SnakeBody
{
    SnakeBody parent;
    
    public SnakeSegment(SnakeBody p)
    {
        parent = p;
        super.pos = p.pos;
        super.direction = p.direction;
    }
    
    public void assumeDirection()
    {
        direction = parent.direction;
    }
    
}
