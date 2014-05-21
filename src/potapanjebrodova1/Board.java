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
public class Board extends JPanel implements Runnable {

    /**
     * Širina table
     */
    public final int PANEL_WIDTH = 800;
    /**
     * Visina table
     */
    public final int PANEL_HEIGHT = 800;

    final Color BACKGROUND_COLOR = Color.BLACK;
    final Thread runner;

    private Image image;
    Boolean inGame;

    // Objekti u igri
    String message;
    Tabla tabla;
    Tabla tabla1;

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

        inGame = false;
        message = "BattleShip";

        tabla = new Tabla();
        tabla1 = new Tabla();

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

            //Iscrtaj sliku u pozadini
            image = new ImageIcon(getClass().getResource("Sea.jpg")).getImage();
            g2.drawImage(image, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);

            // Iscrtaj sve objekte
            tabla.draw(g2);
            tabla1.draw(g2);

            // Sinhronizovanje sa grafičkom kartom
            Toolkit.getDefaultToolkit().sync();

            // Optimizacija upotrebe RAM-a,
            g.dispose();
        } else {
            image = new ImageIcon(getClass().getResource("Battleship-review.JPG")).getImage();
            g2.drawImage(image, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);
        }
    }

    private void update() {
        //ball.move();

    }

    @Override
    public void run() {

        while (true) {
            update();
            repaint();
        }
    }

    void startGame() {
        inGame = true;

        // add(tabla);
    }

    private class mouseClicked extends MouseAdapter {

        mouseClicked(MouseEvent e) {

        }
    ;

}
}
