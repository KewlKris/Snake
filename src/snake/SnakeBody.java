/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Point;

/**
 *
 * @author chamb
 */
abstract public class SnakeBody
{
    SnakeSegment child;
    public int direction;
    protected Point pos;
    boolean hasChild = false;
    
    public void move()
    {
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
    public void addChild(SnakeSegment c)
    {
        hasChild = true;
        child = c;
    }
    
    public void assumeDirection()
    {
        //System.out.println("No source of direction!");
    }
}