/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package potapanjebrodova1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;

/**
 *
 * @author S
 */
public class Board extends JPanel implements Runnable {
    public final int PANEL_WIDTH = 600;  // širina table
     public final int PANEL_HEIGHT = 600;  // Visina table
    
    final Color BACKGROUND_COLOR = new Color(110,160,200);
   
    
    public Board() {
       
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(BACKGROUND_COLOR);
        setFocusable(true);
        setFont(getFont().deriveFont(Font.BOLD, 18f));
        setDoubleBuffered(true);
        
        
        
}

    /**
     *
     */
    @Override
        public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         
}
