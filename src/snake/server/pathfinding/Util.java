package snake.server.pathfinding;

import snake.server.*;
import java.awt.Point;

public class Util
{
    public static boolean canTurn(int direction)
    {
        switch(direction)
        {
            case SnakeHead.UP:
                if (SnakeGame.snake2.direction == SnakeHead.DOWN)
                    return false;
                return true;
            case SnakeHead.DOWN:
                if (SnakeGame.snake2.direction == SnakeHead.UP)
                    return false;
                return true;
            case SnakeHead.LEFT:
                if (SnakeGame.snake2.direction == SnakeHead.RIGHT)
                    return false;
                return true;
            case SnakeHead.RIGHT:
                if (SnakeGame.snake2.direction == SnakeHead.LEFT)
                    return false;
                return true;
        }
        return false;
    }
    
    public static boolean safeDirection(Grid[][] coords, Point pos, int direction)
    {
        try
        {
            switch(direction)
            {
                case SnakeHead.UP:
                    if (coords[pos.y-1][pos.x] != Grid.SnakeID)
                        return true;
                    return false;
                case SnakeHead.DOWN:
                    if (coords[pos.y+1][pos.x] != Grid.SnakeID)
                        return true;
                    return false;
                case SnakeHead.LEFT:
                    if (coords[pos.y][pos.x-1] != Grid.SnakeID)
                        return true;
                    return false;
                case SnakeHead.RIGHT:
                    if (coords[pos.y][pos.x+1] != Grid.SnakeID)
                        return true;
                    return false;
            }
        } catch (NullPointerException e)
        {
            return true;
        } catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
        return false;
    }
}
