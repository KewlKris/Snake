/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;
import java.util.Arrays;
import static snake.SnakeGame.collisions;

/**
 *
 * @author chamb
 */
abstract public class SnakeBody
{
    SnakeSegment child;
    public int direction;
    protected Point pos;
    public Color color = Color.BLACK;
    boolean hasChild = false;
    boolean delayed;
    
    public void draw(SnakeView s, Graphics g)
    {
        s.setTile(g, color, pos.x, pos.y);
        if (hasChild)
        {
            child.draw(s, g);
        }
    }
    
    public void move()
    {
        if (delayed)
        {
            delayed = false;
            return;
        }
        
        if (hasChild)
        {
            child.move();
            child.assumeDirection();
        }
        
        switch (direction)
        {
            case 1:
                pos.y--;
                break;
            case 2:
                pos.y++;
                break;
            case 3:
                pos.x--;
                break;
            case 4:
                pos.x++;
                break;
        }
    }
    public void setChild(SnakeSegment c)
    {
        hasChild = true;
        child = c;
    }
    
    public void appendChild()
    {
        if (hasChild)
        {
            child.appendChild();
            return;
        }
        
        SnakeSegment c = new SnakeSegment(this, true);
        setChild(c);
        
    }
    
    public void assumeDirection()
    {
        //System.out.println("No source of direction!");
    }
    
    public void arrayCheck()
    {
        int x = pos.x;
        int y = pos.y;
        if(hasChild)
        {
            x = child.pos.x;
            y = child.pos.y;
            child.arrayCheck();
        }
        collisions[y][x] = 1;
        for (int i = 0; i < collisions.length; i++) {
            System.out.println(Arrays.toString(collisions[i]));
        }
    }
}
