/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package potapanjebrodova1;

import java.awt.Graphics2D;
import javax.swing.JPanel;



/**
 *
 * @author s
 */
public class Tabla extends JPanel implements Objects {
    
  Polje[][] polja;
  
  public Tabla(){
      int ROWS = 10;
      int COLS = 10;
      polja = new Polje[ROWS][COLS];
      for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                polja[i][j] = new Polje(i, j);
            }
        }
      
  }
  public Tabla(int a,int b){
      
      int ROWS = 10;
      int COLS = 10;
      polja = new Polje[ROWS][COLS];
      for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                polja[i][j] = new Polje((800-30*i)/30, j);
            }
        }
  }
  

    @Override
    public void move() {
        
    }

    @Override
    public void draw(Graphics2D g2) {
    int ROWS = 10;
      int COLS = 10;
    for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                polja[i][j].draw(g2);
            }
         
    }

    
}
}
   

