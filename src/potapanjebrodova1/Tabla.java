/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potapanjebrodova1;

import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.JPanel;


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
                polja[i][j] = new Polje((x + 30 * i) / 30, (y + 30 * j) / 30);
            }
        }

    }

    public boolean checkForHit(int x, int y) {
       int b=0;
        for (int i = 0; i < ROWS; i++) 
            for (int j = 0; j < COLS; j++) 
                if (polja[i][j].contains(x, y) && polja[i][j].gadjano==false) {
                    b=b+1;
                    polja[i][j].Gadjaj();
                  
                }
        
            
        
        return b==1;
    }
   

    /**
     *
     * @return
     */
    public int prebrojavanjeBrodova ()
    {
     List <Polje> E;
          Set <Polje> Res;
        Res = new HashSet<>(); 
     E = new ArrayList <>();
        for (int i=0; i<10; i++)
            for (int j=0; j<10; j++) 
                if (polja[i][j].imaBrod==true)
        Res.add(polja[i][j]);
        return Res.size();
            
    }
    
    public boolean imaProstora ()
    {
         List <Polje> E;
          Set <Polje> Res;
        Res = new HashSet<>(); 
     E = new ArrayList <>();
        for (int i=0; i<10; i++)
            for (int j=0; j<10; j++) 
                if (polja[i][j].imaBrod==true)
        Res.add(polja[i][j]);
        return Res.size()<10;
         }
    public void postaviBrod (int x, int y) {
        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++){
                if (polja[i][j].contains(x,y)){
                    {polja[i][j].imaBrod=true;
                polja[i][j].brodpostavljen=true;}
            }
            }
        }
    }
    public void postavljanjeBrodova ()
    {
        Random r;
        r = new Random();
        List <Polje> E;
        E = new ArrayList <>();
        Set <Polje> Res;
        Res = new HashSet<>();
      for (int i=0;i<10;i++)
          for (int j=0;j<10;j++)
              E.add(polja[i][j]);
      while (Res.size()<10){
          int randPos = r.nextInt(100);
          Res.add(E.get(randPos));}
          for (int i=0;i<10;i++)
          for (int j=0;j<10;j++)
          {
              polja[i][j].imaBrod = Res.contains (polja[i][j]);
              
          
      }
    }

    /**
     *
     */
    public void gadjanjeKomp (){
    
        Random r;
        r = new Random();
        List <Polje> E;
        E = new ArrayList <>();
        for (int i=0; i<10; i++)
            for (int j=0; j<10; j++) 
                if (polja[i][j].gadjano==false)
                E.add(polja[i][j]);
        Set <Polje> Res;
        Res = new HashSet<>();
            int RandPos = r.nextInt(E.size());
            E.get(RandPos).Gadjaj();
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
