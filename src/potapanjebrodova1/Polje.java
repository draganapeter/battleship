/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package potapanjebrodova1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author S
 */
public class Polje extends Rectangle.Double implements Objects{

    private final int ROW;
    private final int COL;
    public Polje(int r, int c){
        ROW=r;
        COL=c;
    }
    
    public int x;
    public int y;
       

    
    private final Color fillColor = Color.BLUE;
    private Color borderColor = Color.BLACK;
   
    private Rectangle.Double rectangleForDrawing;
    
  

   
        
        @Override
     public void draw(Graphics2D g2) {
        
        rectangleForDrawing = new Rectangle2D.Double(ROW*25,COL*25,10,10);
       
        g2.setPaint(fillColor);
        g2.fill(rectangleForDrawing);
        
        g2.setPaint(borderColor);
        g2.draw(rectangleForDrawing);
     }

    @Override
    public void move() {
       
    }
    
}
     

    
