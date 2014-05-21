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
    
  Polje[][] computer_table;
  Polje[][] player_table;
  
  public Tabla(){
      int ROWS = 10;
      int COLS = 10;
      computer_table = new Polje[ROWS][COLS];
      player_table = new Polje[ROWS][COLS];
      for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                computer_table[i][j] = new Polje(i, j);
                player_table[i][j] = new Polje((800-30*i)/30, j);
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
                computer_table[i][j].draw(g2);
                player_table[i][j].draw(g2);
            }
         
    }

    
}
}
   

