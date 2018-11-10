package snake;

import java.awt.*;

public class SnakeView
{
    Point pos;
    public SnakeView(Point p)
    {
        pos = p;
    }
    
    public void drawBorder(Graphics g)
    {
        //Variables for readability
        int bSize = SnakeSettings.BLOCK_SIZE;
        int width = SnakeSettings.GRID_SIZE.width;
        int height = SnakeSettings.GRID_SIZE.height;
        
        //Draw a border around the play area, not including any play area pixels.
        g.setColor(Color.black);
        g.drawRect(pos.x-1, pos.y-1, (width * bSize) + 2, (height * bSize) + 2);
    }
    
    public void fillBackground(Graphics g)
    {
        //Variables for readability
        int bSize = SnakeSettings.BLOCK_SIZE;
        int width = SnakeSettings.GRID_SIZE.width;
        int height = SnakeSettings.GRID_SIZE.height;
        
        //Fill the play area with the background
        g.setColor(Color.WHITE);
        g.fillRect(pos.x, pos.y, width * bSize, height * bSize);
    }
    
    public void setTile(Graphics g, Color c, int x, int y)
    {
        //Variables for readability
        int bSize = SnakeSettings.BLOCK_SIZE;
        int width = SnakeSettings.GRID_SIZE.width;
        int height = SnakeSettings.GRID_SIZE.height;
        int inset = 1;
        
        //Set a tile to a given color
        g.setColor(c);
        g.fillRect(
                pos.x + (bSize * x) + inset,
                pos.y + (bSize * y) + inset,
                bSize - (inset*1), //Intentional
                bSize - (inset*1));
    }
    
    public void drawGrid(Graphics g)
    {
        //Variables for readability
        int bSize = SnakeSettings.BLOCK_SIZE;
        int width = SnakeSettings.GRID_SIZE.width;
        int height = SnakeSettings.GRID_SIZE.height;
        
        //Color init
        g.setColor(new Color(220, 220, 220));
        
        //Do width
        for(int x=0; x<width; x++)
            g.drawLine(pos.x + x*bSize, pos.y, pos.x + x*bSize, pos.y + height*bSize);
        
        //Do Height
        for(int y=0; y<height; y++)
            g.drawLine(pos.x, pos.y + y*bSize, pos.x + width*bSize, pos.y + y*bSize);
            
    }
    
    public void drawScore(Graphics g, int num)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 12));
        g.drawString("Score: " + Integer.toString(num), 5, 14);
    }
}
