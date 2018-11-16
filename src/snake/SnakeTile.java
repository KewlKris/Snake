package snake;

import java.awt.*;
import java.io.*;

public class SnakeTile
{
    public static int RED=1, BLUE=2, BLACK=3, YELLOW=4; //Color palette
    
    public Point pos;
    public int color;
    
    public SnakeTile(int x, int y, int c)
    {
        pos = new Point(x,y);
        color = c;
    }
    
    public SnakeTile(Point p, int c)
    {
        pos = p;
        color = c;
    }
    
    public Color getColor()
    {
        return intToColor(color);
    }
    
    /**
     * Write this tile to the DataOutputStream
     * @param out The DataOutputStream
     * @throws IOException 
     */
    public void writeToStream(DataOutputStream out) throws IOException
    {
        //Position
        out.writeInt(pos.x);
        out.writeInt(pos.y);
        out.writeInt(color);
    }
    
    public static Color intToColor(int c)
    {
        switch(c)
        {
            case 1: //Red
                return new Color(150, 0, 0);
            case 2: //Blue
                return new Color(0, 0, 150);
            case 3: //Black
                return new Color(0, 0, 0);
            case 4: //Yellow
                return new Color(255, 255, 0);
            default:
                return new Color(100, 100, 100);
        }
    }
}
