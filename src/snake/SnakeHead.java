package snake;

import java.awt.Point;

public class SnakeHead extends SnakeBody
{
    public SnakeHead(Point p)
    {
        super.pos = p;
        super.direction = 4;
    }
}
