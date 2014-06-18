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
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class Board extends JPanel {

    /**
     * Širina table
     */
    public final int PANEL_WIDTH = 800;
    /**
     * Visina table
     */
    public final int PANEL_HEIGHT = 800;

    final Color BACKGROUND_COLOR = Color.BLACK;

    private ImageIcon seaImageIcon;
    private ImageIcon battleShipImageIcon;
    Boolean inGame;
    Boolean postavljanjebrodova;

    // Objekti u igri
    String message;
    Tabla tabla;
    Tabla tabla1;
    Polje polje;

    /**
     * Podrazumjevani konstruktor. Postavlja veličinu table, boju pozadine i
     * font, inicijalizuje početni rezultat, te objekte u igri. Inicijalizuje i
     * pokreće radnu nit.
     */
    public Board() {

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(BACKGROUND_COLOR);
        setFocusable(true);
        setFont(getFont().deriveFont(Font.BOLD, 18f));
        setDoubleBuffered(true);
        addMouseListener(new HitListener());

        inGame = false;
        postavljanjebrodova = false;
        message = "BattleShip";

        tabla = new Tabla(0, 0);
        tabla.postavljanjeBrodova();
        tabla1 = new Tabla(530, 0);

        seaImageIcon = new ImageIcon(getClass().getResource("Sea.jpg"));
        battleShipImageIcon = new ImageIcon(getClass().getResource("Battleship-review.JPG"));

    }

    @Override

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        if (postavljanjebrodova==false && inGame) {
            // Savjeti pri iscrtavanju

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // Iscrtaj teren
            g2.drawRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

            //Iscrtaj sliku u pozadini
            g2.drawImage(seaImageIcon.getImage(), 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);

            // Iscrtaj sve objekte
            tabla.draw(g2);
            tabla1.draw(g2);

            // Sinhronizovanje sa grafičkom kartom
            Toolkit.getDefaultToolkit().sync();

            // Optimizacija upotrebe RAM-a,
            g.dispose();
        } if (inGame==false && postavljanjebrodova==false) {
            g2.drawImage(battleShipImageIcon.getImage(), 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);
        }
        if (inGame==false && postavljanjebrodova==true ){
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // Iscrtaj teren
            g2.drawRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

            //Iscrtaj sliku u pozadini
            g2.drawImage(seaImageIcon.getImage(), 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);

            // Iscrtaj sve objekte
            
            tabla1.draw(g2);

            // Sinhronizovanje sa grafičkom kartom
            Toolkit.getDefaultToolkit().sync();

            // Optimizacija upotrebe RAM-a,
           g.dispose();
        }
    }

    private void update() {
    }

    void startGame() {
        inGame = true;
        postavljanjebrodova = false;
        repaint();
    }

   
    public void PostaviBrodove(){
       postavljanjebrodova=true;
       repaint();
      
    }

    private class HitListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {

            //System.out.println("kliknuto na: " + e.getX() + ", " + e.getY());
            if (inGame==true)
            {tabla.checkForHit(e.getX(), e.getY());
            repaint();
            tabla1.gadjanjeKomp();
            repaint();}
            if (inGame==false && postavljanjebrodova==true)
            {
               
                tabla1.postaviBrod(e.getX(),e.getY());
            repaint();
                
            
            }
                    
            
            
            
            
        }

    }
   
}
