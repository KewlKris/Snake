package snake.server.pathfinding;

import java.awt.Point;

public class AStarTile
{
    public double g;
    public double h;
    public double f;
    public Point pos;
    public AStarTile parent;
    
    public AStarTile(double g, double h, Point p, AStarTile par)
    {
        this.g = g;
        this.h = h;
        this.f = g + h;
        pos = p;
        parent = par;
    }
}
