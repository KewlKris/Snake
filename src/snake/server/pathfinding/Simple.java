package snake.server.pathfinding;

import snake.server.*;
import java.awt.Point;

public class Simple
{
    public static int getNextDirection(Grid[][] g, Point selfPos, Point foodPos)
    {
        if (selfPos.x < foodPos.x)
        {
            int dir = SnakeHead.RIGHT;
            if (Util.canTurn(dir) && Util.safeDirection(g, selfPos, dir))
            {
                return dir;
            }
            return tryVertical(g, selfPos);
        }
        if (selfPos.x > foodPos.x)
        {
            int dir = SnakeHead.LEFT;
            if (Util.canTurn(dir) && Util.safeDirection(g, selfPos, dir))
            {
                return dir;
            }
            return tryVertical(g, selfPos);
        }
        
        if (selfPos.y > foodPos.y)
        {
            int dir = SnakeHead.UP;
            if (Util.canTurn(dir) && Util.safeDirection(g, selfPos, dir))
            {
                return dir;
            }
            return tryHorizontal(g, selfPos);
        }
        if (selfPos.y < foodPos.y)
        {
            int dir = SnakeHead.DOWN;
            if (Util.canTurn(dir) && Util.safeDirection(g, selfPos, dir))
            {
                return dir;
            }
            return tryHorizontal(g, selfPos);
        }
        return -1;
    }
    
    private static int tryHorizontal(Grid[][] g, Point selfPos)
    {
        if (Util.safeDirection(g, selfPos, SnakeHead.LEFT))
            return SnakeHead.LEFT;
        if (Util.safeDirection(g, selfPos, SnakeHead.RIGHT))
            return SnakeHead.RIGHT;
        return -1;
    }
    
    private static int tryVertical(Grid[][] g, Point selfPos)
    {
        if (Util.safeDirection(g, selfPos, SnakeHead.UP))
            return SnakeHead.UP;
        if (Util.safeDirection(g, selfPos, SnakeHead.DOWN))
            return SnakeHead.DOWN;
        return -1;
    }
}
