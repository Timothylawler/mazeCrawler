/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import static javax.swing.SwingUtilities.invokeLater;

/**
 *
 * @author timothy
 */
public class Maze {

    public static void main(String[] args) {
        invokeLater(new Runnable(){
           public void run(){
               Frame frame = new Frame();
           }            
        });
    }
    
}
