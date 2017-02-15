/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Crawls maze using DFS
 * @author timothy
 */
public class MazeCrawler {
    
    private final Stack<Cell> stack;
    private List<Cell> grid;
    private int cellCounter, cellSize, w, h;
    //  Number of horizontal and vertical cells
    private final int hCells, vCells;
    
    public MazeCrawler(List<Cell> grid, int cellSize, int w, int h){
        this.grid       = (ArrayList)grid;
        this.cellSize   = cellSize;
        this.w          = w;
        this.h          = h;
        this.stack      = new Stack();
        this.hCells     = w/cellSize;
        this.vCells     = h/cellSize;
        //  Add starting point, mark as visited and increment counter
        stack.push(this.grid.get(0));
        stack.peek().visit();
        cellCounter = 1;
    }
    
    public void start(){
        Cell current;
        while(cellCounter < grid.size() && !stack.empty()){
            current = stack.pop();
            current.visit();
            //  Get neighbors of top cell
            addNeighbors(current);
            //  Remove wall, mark visited and pop the visited one
            
        }
    }
    
    private void addNeighbors(Cell current){
        //  Add unvisited neighbors to the stack
        int currentIndex = grid.indexOf(current);
        
        //  Top
        if(currentIndex > hCells){
            if(!(grid.get(currentIndex-hCells)).isVisited()){
                stack.push(grid.get(currentIndex-hCells));
            }
        }
        //  Check if at right side
        if((currentIndex % hCells) != hCells-1 && currentIndex != grid.size()-1){
            if(!(grid.get(currentIndex+1)).isVisited()){
                stack.push(grid.get(currentIndex+1));
            }
        }
        
        //  Bottom
        if((currentIndex+hCells) < (vCells*hCells)){
            if(!(grid.get(currentIndex+hCells)).isVisited()){
                stack.push(grid.get(currentIndex+hCells));
            }
        }
        //  Left
        if((currentIndex % hCells) != 0 && currentIndex != 0){
            if(!(grid.get(currentIndex-1)).isVisited()){
                stack.push(grid.get(currentIndex-1));
            }
        }
    }
    
    public void step(){
        Cell current;
        current = stack.pop();
        current.visit();
        //  Get neighbors of top cell
        addNeighbors(current);
        //  Remove wall, mark visited and pop the visited one
    }
    
    
    
}
