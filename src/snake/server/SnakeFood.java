package snake.server;

import java.awt.Graphics;
import java.awt.*;

/**
 *
 * @author Anurag
 */
public class SnakeFood {
    
    public Point pos;
    public Color color = Color.BLACK;
    boolean isEaten;
    
    public SnakeFood()
    {
        resetFood();
    }
    
    public void resetFood(){
        int randx;
        int randy;
        while(true)
        {
            randx = (int)(Math.random()*snake.SnakeSettings.GRID_SIZE.width);
            randy = (int)(Math.random()*snake.SnakeSettings.GRID_SIZE.height);
            if(SnakeGame.collisions[randy][randx] == null)
            {
                pos = new Point(randx,randy); 
                isEaten = false;
                break;
            }
        }
    }
    
    /*
    public void draw(Graphics g)
    {
        SnakeView.setTile(g, color, pos.x, pos.y);
    }
    */
    
    public void arrayCheck()
    {
        SnakeGame.collisions[pos.y][pos.x] = Grid.FoodID;
    }        
}
