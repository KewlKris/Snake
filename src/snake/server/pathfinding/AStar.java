package snake.server.pathfinding;

import java.awt.Point;
import snake.server.*;

import java.util.ArrayList;

public class AStar
{
    /*
    
    
    AStar is incomplete. It isn't accessible from the UI.
    
    
    */
    public static Point startPos;
    public static Point endPos;
    public static int getNextDirection(Grid[][] g, Point selfPos, Point foodPos)
    {
        startPos = selfPos;
        endPos = foodPos;
        ArrayList<AStarTile> openList = new ArrayList<AStarTile>();
        ArrayList<AStarTile> closedList = new ArrayList<AStarTile>();
        
        openList.add(new AStarTile(distOf(startPos,endPos), 0, startPos, null));
        
        while(openList.size() > 0)
        {
            AStarTile lowest = openList.get(0);
            for(AStarTile t : openList)
            {
                if (t.f < lowest.f)
                    lowest = t;
            }
            openList.remove(lowest);
            
            Point newLoc;
            if (g[lowest.pos.y][lowest.pos.x] != Grid.SnakeID)
            {
                //AStarTile temp = new AStarTile
            }
        }
        return -1;
    }
    
    public static int distOf(Point start, Point end)
    {
        int x = Math.abs(end.x - start.x);
        int y = Math.abs(end.y - start.y);
        return x + y;
    }
}
