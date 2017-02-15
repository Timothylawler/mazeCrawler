/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author timothy
 */
public class Canvas extends JPanel{
    
    private List<Cell> grid;
    private int w=320,h=320;
    private int cellSize = 32;
    private MazeCrawler crawler;
    
    public Canvas(){
        init();
        createGrid();
        crawler = new MazeCrawler(grid, cellSize, w, h);
    }
    
    public void startThread(){
        Thread t = new Thread(new Runnable() { 
            @Override
            public void run() { 
                for(int i = 0; i<100; i++){
                    repaint();
                    crawler.step();
                    
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        t.start();
    }
    
    private void init() {
        
    }
    
    private void createGrid() {
        int horizontal  = (int)w/cellSize;
        int vertical    = (int)h/cellSize;
        grid = new ArrayList();
        for(int y = 0; y< vertical; y++){
            for (int x = 0; x < horizontal; x++) {
                grid.add(new Cell(x,y, cellSize));
            }
        }
    }

    @Override
    public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(new Dimension(w, h)); 
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w,h); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setColor(Color.black);
        for(Cell cell: grid){
            cell.draw(g);
        }
        
    }

    

    
    
    
    
}
