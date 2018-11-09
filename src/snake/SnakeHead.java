package snake;

import java.awt.Point;

public class SnakeHead extends SnakeBody
{
    public static final int UP=1, DOWN=2, LEFT=3, RIGHT=4;
    
    public SnakeHead(Point p, int d, int num)
    {
        super.pos = p;
        super.direction = d;
        super.delayed = false;
        super.number = num;
    }
}
