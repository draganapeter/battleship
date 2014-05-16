package potapanjebrodova1;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import javax.swing.JPanel;
/**
*
* @author Administrator
*/
public class Board extends JPanel implements Runnable {
    
     /**
* Širina table
*/
    public final int PANEL_WIDTH = 800;
    /**
* Visina table
*/
    public final int PANEL_HEIGHT = 800;
    
    final Color BACKGROUND_COLOR = new Color(75,250,70);
    final Thread runner;
    
      Boolean inGame;
      
    // Objekti u igri
     
   
    String message;
    Polje polje;
    
    
    /**
* Podrazumjevani konstruktor. Postavlja veličinu table, boju pozadine i font,
* inicijalizuje početni rezultat, te objekte u igri. Inicijalizuje i pokreće
* radnu nit.
*/
    public Board() {
      
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(BACKGROUND_COLOR);
        setFocusable(true);
        setFont(getFont().deriveFont(Font.BOLD, 18f));
        setDoubleBuffered(true);
        
        inGame = false;
        message = "BattleShip";
        
        //add(tabla);
       polje = new Polje(0,0);
                
        runner = new Thread(this);
        runner.start();
      
    }

    
    
  
    @Override
    public void paint(Graphics g) {
        super.paint(g);
             
         Graphics2D g2 = (Graphics2D) g;
        
        if (inGame) {
            // Savjeti pri iscrtavanju
        
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // Iscrtaj teren

            g2.drawRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
      
            
            // Iscrtaj sve objekte

            polje.draw(g2);
                    
          
            // Sinhronizovanje sa grafičkom kartom
            Toolkit.getDefaultToolkit().sync();

            // Optimizacija upotrebe RAM-a,
            g.dispose();
        } else {
            int messageWidth = getFontMetrics(getFont()).stringWidth(message);
            g2.drawString(message, PANEL_WIDTH/2 - messageWidth/2, PANEL_HEIGHT/2);
        }
    }

 private void update() {
        //ball.move();
        
    }

    @Override
    public void run() {
               
        while(true) {
            update();
            repaint();
        }
    }

    void startGame() {
       inGame = true;
       
      // add(tabla);
    }
    
 
}