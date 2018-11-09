/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Graphics;
import java.awt.*;

/**
 *
 * @author Anurag
 */
public class SnakeFood {
    
    public static Point pos;
    public Color color = Color.RED;
    
    public SnakeFood()
    {
        setFood();
    }
    
    public void setFood(){
        int randx;
        int randy;
        while(true)
        {
            randx = (int)(Math.random()*64);
            randy = (int)(Math.random()*36);
            SnakeGame.updateArray();
            if(SnakeGame.collisions[randy][randx] == 0)
            {
                pos = new Point(randx,randy); 
                break;
            }
        }
    }
    
    public void draw(SnakeView s, Graphics g)
    {
        s.setTile(g, color, pos.x, pos.y);
    }
    
    public void arrayCheck()
    {
        SnakeGame.collisions[pos.y][pos.x] += 5;
    }        
}
