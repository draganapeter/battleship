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
public class Polje extends Rectangle.Double implements Objects {

    enum Stanje {

        NEGADJANO, PROMASENO, POGODJENO
    }

    private final int ROW;
    private final int COL;

    private Stanje stanje;

    public Polje(int r, int c) {
        ROW = r;
        COL = c;
        this.stanje = Stanje.NEGADJANO;
    }

    private Color bojapromasenog = Color.WHITE;
    private Color bojapogodjenog = Color.RED;
    private Color borderColor = Color.BLACK;

    private Rectangle.Double rectangleForDrawing;

    public int x;
    public int y;

    @Override
    public void draw(Graphics2D g2) {

        rectangleForDrawing = new Rectangle2D.Double(ROW * 30, COL * 30, 30, 30);

        g2.setPaint(bojapromasenog);
        g2.fill(rectangleForDrawing);

        g2.setPaint(borderColor);
        g2.draw(rectangleForDrawing);
    }

}
     

    
