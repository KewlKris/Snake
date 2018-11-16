package snake.server;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SnakeHead extends SnakeBody
{
    public static final int UP=1, DOWN=2, LEFT=3, RIGHT=4;
       
    public int lastTickedDirection;
    /*The above fixes a bug where the snake could still "turn" into itself
    if it changed its direction twice in-between a tick.*/
    
    public SnakeHead(Point p, Color c, int d, int num)
    {
        super.pos = p;
        super.direction = d;
        lastTickedDirection = d;
        super.delayed = false;
        super.keyBinding = num;
        super.color = c;
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
                    SnakeGame.lostGame(this);
                    break;
                case FoodID: //If it's food, eat it and grow
                    if (this.keyBinding == 1)
                    {
                        SnakeGame.score += 10;
                        SnakeServer.setScore(1, SnakeGame.score);
                    }
                    else
                    {
                        SnakeGame.score2 += 10;
                        SnakeServer.setScore(2, SnakeGame.score2);
                    }
                    SnakeGame.food.resetFood();
                    SnakeTimer.TICKRATE -= snake.SnakeSettings.TICKRATE_DECLINE;
                    appendChild(3);
                    break;
            }
        } catch (NullPointerException e)
        {
            //Tile is empty, continue
        } catch (ArrayIndexOutOfBoundsException e)
        {
            SnakeGame.lostGame(this);
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
        if (super.keyBinding == 1)
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
        } else
        {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_W:
                    if (lastTickedDirection == DOWN)
                        break;
                    direction = UP;
                    return true;
                case KeyEvent.VK_S:
                    if (lastTickedDirection == UP)
                        break;
                    direction = DOWN;
                    return true;
                case KeyEvent.VK_A:
                    if (lastTickedDirection == RIGHT)
                        break;
                    direction = LEFT;
                    return true;
                case KeyEvent.VK_D:
                    if (lastTickedDirection == LEFT)
                        break;
                    direction = RIGHT;
                    return true;
                case KeyEvent.VK_ADD:
                    appendChild();
                    break;
            }
        }
        return false;
    }
    /**
     * Change the direction from a raw key code
     * @param i The key code value
     * @return Whether the change was successful or not
     */
    
    public boolean changeDirection(int i)
    {
        if (SnakeGame.GAME_TYPE != SnakeGame.MULTI_SAME_SCREEN) //If key doesn't matter
        {
            switch(i)
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
                case KeyEvent.VK_W:
                    if (lastTickedDirection == DOWN)
                        break;
                    direction = UP;
                    return true;
                case KeyEvent.VK_S:
                    if (lastTickedDirection == UP)
                        break;
                    direction = DOWN;
                    return true;
                case KeyEvent.VK_A:
                    if (lastTickedDirection == RIGHT)
                        break;
                    direction = LEFT;
                    return true;
                case KeyEvent.VK_D:
                    if (lastTickedDirection == LEFT)
                        break;
                    direction = RIGHT;
                    return true;
            }
            return true;
        }
        if (super.keyBinding == 1)
        {
            switch(i)
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
        } else
        {
            switch(i)
            {
                case KeyEvent.VK_W:
                    if (lastTickedDirection == DOWN)
                        break;
                    direction = UP;
                    return true;
                case KeyEvent.VK_S:
                    if (lastTickedDirection == UP)
                        break;
                    direction = DOWN;
                    return true;
                case KeyEvent.VK_A:
                    if (lastTickedDirection == RIGHT)
                        break;
                    direction = LEFT;
                    return true;
                case KeyEvent.VK_D:
                    if (lastTickedDirection == LEFT)
                        break;
                    direction = RIGHT;
                    return true;
                case KeyEvent.VK_ADD:
                    appendChild();
                    break;
            }
        }
        return false;
    }
}
