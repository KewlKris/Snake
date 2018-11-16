package snake.server.pathfinding;

import java.awt.Point;
import snake.server.*;
import java.util.ArrayList;

public class Random
{
    public static int getNextDirection(Grid[][] g, Point selfPos, Point foodPos)
    {
        ArrayList<Integer> dirs = new ArrayList<Integer>();
        
        dirs.add(1);
        dirs.add(2);
        dirs.add(3);
        dirs.add(4);
        
        for(int x=0; x<5; x++)
        {
            int index = (int)(Math.random() * 4);
            int value = dirs.remove(index);
            dirs.add(value);
        }
        for(int x=0; x<4; x++)
        {
            if (Util.canTurn(dirs.get(0)) && Util.safeDirection(g, selfPos, dirs.get(0)))
            {
                return dirs.get(0);
            }
            dirs.remove(0);
        }
        return -1;
    }
}
