/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package potapanjebrodova1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author S
 */
public class Polje extends Rectangle.Double implements Objects{
    private Stanje stanje;

   
    enum Stanje {NEGADJANO, POGODJENO, PROMASENO}
    private final int w = 30;
    private final int h = 30;
       
    private final Board board;
     private final Color borderColor = Color.BLACK;
      private Color fillColor = Color.BLUE;
    
    
     private Rectangle.Double rectangleForDrawing;
    
    public Polje (Board board) {
        this.board = board;
        this.stanje=Stanje.NEGADJANO;
        
    }

    Polje(Polje polje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void Negadjano(){
        stanje = Stanje.NEGADJANO;
       
    }
     public void Promaseno(){
         stanje = Stanje.PROMASENO;
     }
     public void Pogodjeno(){
         stanje = Stanje.POGODJENO;
     }
    
   public void Promjena(){
       if (stanje == Stanje.POGODJENO) 
        fillColor = Color.RED;
        
       else if (stanje != Stanje.PROMASENO) 
       
           fillColor = Color.WHITE;
       
   
   }
   
    public void draw(Graphics2D g2) {
        
        
        rectangleForDrawing = new Rectangle2D.Double(50, 30, w, h);
       
        g2.setPaint(fillColor);
        g2.fill(rectangleForDrawing);
        
        g2.setPaint(borderColor);
        g2.draw(rectangleForDrawing);
        
        
    }
   

    @Override
    public void move() {
        
    }

    private void reset() {
        
    }

}
