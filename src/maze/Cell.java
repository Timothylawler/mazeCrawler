package maze;

import java.awt.Color;
import java.awt.Graphics;

public class Cell {
    
    int x, y, size;
    boolean top,right,bottom,left, visited;
    
    public Cell(int x, int y, int cellSize){
        this.x      = x*cellSize;
        this.y      = y*cellSize;
        this.size   = cellSize;
        this.top    = true;
        this.right  = true;
        this.bottom = true;
        this.left   = true;
        this.visited= false;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        //  Top
        if(top)
            g.drawLine(x, y, x+size, y);
        //  Right
        if(right)
            g.drawLine(x+size, y, x+size, y+size);
        //  Bottom
        if(bottom)
            g.drawLine(x,y+size, x+size, y+size);
        //  Left
        if(left)
            g.drawLine(x, y, x, y+size);
        if(visited)
            fill(g);
    }
    
    /**
     * Fills this node with a background color
     * @param g Graphics
     */
    public void fill(Graphics g){
        g.setColor(Color.MAGENTA);
        //  Fill rectangle and take away 1px for border
        g.fillRect(x+1, y+1, size-1, size-1);
        
    }
    
    /**
     * Marks this cell as visited
     */
    public void visit(){
        this.visited = true;
    }
    
    /**
     * Sets top to false, removes the line for top
     */
    public void removeTop(){
        this.top = false;
    }
    
    /**
     * Sets right to false, removes the line for right
     */
    public void removeRight(){
        this.right = false;
    }
    
    /**
     * Sets bottom to false, removes the line for bottom
     */
    public void removeBottom(){
        this.bottom = false;
    }
    
    /**
     * Sets left to false, removes the line for left
     */
    public void removeLeft(){
        this.left = false;
    }
    
    public boolean getTop() {
        return top;
    }

    public boolean getRight() {
        return right;
    }

    public boolean getBottom() {
        return bottom;
    }

    public boolean getLeft() {
        return left;
    }

    public boolean isVisited() {
        return visited;
    }
}
