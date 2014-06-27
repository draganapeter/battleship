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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class Board extends JPanel {

    /**
     * Širina table
     */
    public final int DUZINA_PANELA = 800;
    /**
     * Visina table
     */
    public final int SIRINA_PANELA = 300;

    final Color BACKGROUND_COLOR = Color.ORANGE;

    private ImageIcon Pocetna_slika;
    
    Boolean UIgri;
    Boolean postavljanjebrodova;

    // Objekti u igri
    String Poruka;
    Tabla Komp_tabla;
    Tabla Igraceva_tabla;
    Polje polje;
    JButton pocniIgru;

    /**
     * Podrazumjevani konstruktor. Postavlja veličinu table, boju pozadine i
     * font, inicijalizuje početni rezultat, te objekte u igri. Inicijalizuje i
     * pokreće radnu nit.
     */
    public Board() {

        setPreferredSize(new Dimension(DUZINA_PANELA, SIRINA_PANELA));
        setLayout(null);
        setBackground(BACKGROUND_COLOR);
        setFocusable(true);
        setFont(getFont().deriveFont(Font.BOLD, 18f));
        setDoubleBuffered(true);
        addMouseListener(new HitListener());

        UIgri = false;
        postavljanjebrodova = false;
        Poruka = "";
        pocniIgru = new JButton("Pocni Igru");

        Komp_tabla = new Tabla(0, 0);
        Komp_tabla.postavljanjeBrodova();
        Igraceva_tabla = new Tabla(530, 0);
        pocniIgru.setBounds(330, 0, 150, 30); //navodimo poziciju i veličinu komponente(dugmeta u nasem slucaju)

        
        pocniIgru.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UIgri = true;
                postavljanjebrodova = false;
                remove(pocniIgru);
                repaint();
            }

        });

        Pocetna_slika = new ImageIcon(getClass().getResource("Battleship-review.JPG"));

    }

    @Override

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        if (postavljanjebrodova == false && UIgri == true) { //kada su brodovi postavljeni,iscrtavaju se obje table.
           
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // Iscrtaj teren
            g2.drawRect(0, 0, DUZINA_PANELA, SIRINA_PANELA);

            
            // Iscrtaj sve objekte
            Komp_tabla.draw(g2);
            Igraceva_tabla.draw(g2);
            
            if (Komp_tabla.prebrojavanjepotopljenih() == 10) {
                g2.drawString("Igrac je pobijedio!", 330, 60);
            }
            if (Igraceva_tabla.prebrojavanjepotopljenih() == 10) {
                g2.drawString("Kompjuter je pobijedio!", 305, 60);
            }

            // Sinhronizovanje sa grafičkom kartom
            Toolkit.getDefaultToolkit().sync();

            // Optimizacija upotrebe RAM-a,
            g.dispose();
        }
        if (UIgri == false && postavljanjebrodova == false) {
            g2.drawImage(Pocetna_slika.getImage(), 0, 0, DUZINA_PANELA, SIRINA_PANELA, null);
        }
        if (UIgri == false && postavljanjebrodova == true) { // Iscrtavanje samo table na kojoj igrac treba da postavi svoje brodove.
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // Iscrtaj teren
            g2.drawRect(0, 0, DUZINA_PANELA, SIRINA_PANELA);

           
            // Iscrtaj sve objekte
            Igraceva_tabla.draw(g2);
            
            if (Igraceva_tabla.prebrojavanjeBrodova() == 0) {
                g2.drawString("Postavite 10 brodova!", 30, 60);
            } else if ((Igraceva_tabla.prebrojavanjeBrodova() > 0) && (Igraceva_tabla.prebrojavanjeBrodova() < 10)) {
                g2.drawString("Ostalo je jos " + (10 - Igraceva_tabla.prebrojavanjeBrodova()) + " brodova da postavite.", 30, 60);
            }

            // Sinhronizovanje sa grafičkom kartom
            Toolkit.getDefaultToolkit().sync();

            // Optimizacija upotrebe RAM-a,
            g.dispose();
        }
    }

    private void update() {
    }

    void PocniIgru() {
        UIgri = false;
        postavljanjebrodova = true;
        
        add(pocniIgru);
        pocniIgru.setEnabled(false);

        repaint();
    }

    public void PostaviBrodove() {

        repaint();

    }

    private class HitListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {

            
            if (UIgri == true) {
                
                if (Komp_tabla.ProvjeraZaGdjanje(e.getX(), e.getY()) == true) {
                    repaint();
                    Igraceva_tabla.gadjanjeKomp();
                    repaint();
                }
            }
            if (UIgri == false && postavljanjebrodova == true) {
                if (Igraceva_tabla.prebrojavanjeBrodova() < 10) {
                    Igraceva_tabla.postaviBrod(e.getX(), e.getY());

                    repaint();
                }
                if (Igraceva_tabla.prebrojavanjeBrodova() == 10) {
                    pocniIgru.setEnabled(true);
                }

            }

        }

    }

}
