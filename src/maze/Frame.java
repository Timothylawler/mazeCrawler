/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Frame extends JFrame{
    
    //private int w = 325, h = 340;
    private Canvas canvas;
    
    public Frame(){
        init();
    }

    private void init() {
        setTitle("maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(320,320));
        
        //  Add canvas
        canvas = new Canvas();
        add(canvas);
        pack();
        setVisible(true);
        canvas.startThread();
    }
    
    private void update(){
        canvas.repaint();
    }
   
}
