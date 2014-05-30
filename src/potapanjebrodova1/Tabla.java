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
    
    final int ROWS;
    final int COLS;

    public Tabla(int x, int y) {
        ROWS = 10;
        COLS = 10;
        
        polja = new Polje[ROWS][COLS];
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                polja[i][j] = new Polje(i, j);
            }
        }

    }
    
    public void checkForHit(int x, int y) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(polja[i][j].contains(x, y))
                    polja[i][j].Gadjaj();
            }
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        int ROWS = 10;
        int COLS = 10;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                polja[i][j].draw(g2);
            }
        }
    }
}
