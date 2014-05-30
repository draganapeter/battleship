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

        NEGADJANO, GADJANO
    }

    private Stanje stanje;

    public Polje(int row, int col) {
        this.stanje = Stanje.NEGADJANO;
        x = row * 30;
        y = col * 30;
        width = height = 30;
    }

    public void Gadjaj() {

        if (stanje == Stanje.NEGADJANO) {
            stanje = Stanje.GADJANO;
            
            //System.out.println("POGODAK!");
        }

    }
    
    private final Color bojapromasenog = Color.WHITE;
    private final Color bojapogodjenog = Color.RED;
    private final Color borderColor = Color.BLUE;
    
    @Override
    public void draw(Graphics2D g2) {

        if (stanje == Stanje.GADJANO) {
            g2.setPaint(bojapromasenog);
            g2.fill(this);
        } else if (stanje == Stanje.NEGADJANO) {
            g2.setPaint(bojapogodjenog);
            g2.fill(this);
        }

        g2.setPaint(borderColor);
        g2.draw(this);

    }
}
