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
    protected Point pos = new Point(0,0);
    public Color color = Color.BLACK;
    boolean hasChild = false;
    boolean delayed;
    public int number;
    
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
    
    /**
     * This method adds children to the snake.
     * @param childCount The amount of children to add.
     */
    public void appendChild(int childCount)
    {
        for(int x=0; x<childCount; x++)
        {
            appendChild();
        }
    }
    
    public void assumeDirection()
    {
        //System.out.println("No source of direction!");
    }
    
    public void arrayCheck()
    {
        if (delayed)
            return;
        collisions[pos.y][pos.x] = Grid.SnakeID;
        if(hasChild)
        {
            child.arrayCheck();
        }
    }
}
