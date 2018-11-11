package snake;

import java.awt.*;
import java.awt.event.*;

public class SnakeHead extends SnakeBody
{
    public static final int UP=1, DOWN=2, LEFT=3, RIGHT=4;
       
    public int lastTickedDirection;
    /*The above fixes a bug where the snake could still "turn" into itself
    if it changed its direction twice in-between a tick.*/
    
    public SnakeHead(Point p, int d, int num)
    {
        super.pos = p;
        super.direction = d;
        lastTickedDirection = d;
        super.delayed = false;
        super.number = num;
    }
    
    public void move()
    {
        super.move();
        lastTickedDirection = direction;
        checkTile();
    }
    
    private void checkTile()
    {
        try
        {
            switch(SnakeGame.collisions[pos.y][pos.x])
            {
                case SnakeID: //If it's yourself, you lose
                    SnakeGame.lostGame();
                    break;
                case FoodID: //If it's food, eat it and grow
                    SnakeGame.score += 10;
                    SnakeGame.food.resetFood();
                    SnakeTimer.TICKRATE = SnakeTimer.TICKRATE - SnakeSettings.TICKRATE_DECLINE;
                    appendChild();
                    break;
            }
        } catch (NullPointerException e)
        {
            //Tile is empty, continue
        } catch (ArrayIndexOutOfBoundsException e)
        {
            SnakeGame.lostGame();
        }
    }
    
    /**
     * This method will change the direction of the SnakeHead
     * if the direction is valid.
     * @param e The KeyEvent from the KeyListener
     * @return If the SnakeHead successfully changed direction.
     */
    public boolean changeDirection(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (lastTickedDirection == DOWN)
                    break;
                direction = UP;
                return true;
            case KeyEvent.VK_DOWN:
                if (lastTickedDirection == UP)
                    break;
                direction = DOWN;
                return true;
            case KeyEvent.VK_LEFT:
                if (lastTickedDirection == RIGHT)
                    break;
                direction = LEFT;
                return true;
            case KeyEvent.VK_RIGHT:
                if (lastTickedDirection == LEFT)
                    break;
                direction = RIGHT;
                return true;
            case KeyEvent.VK_ADD:
                appendChild();
                break;
        }
        return false;
    }
}
