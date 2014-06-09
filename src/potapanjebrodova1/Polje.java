/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potapanjebrodova1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author S
 */
public class Polje extends Rectangle.Double implements Objects {

    enum Stanje {

        NEGADJANO, GADJANO
    }

    boolean imaBrod;

    Random r;

    private Stanje stanje;

    public Polje(int row, int col) {

        r = new Random();

        this.stanje = Stanje.NEGADJANO;
        this.imaBrod = r.nextBoolean();

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
    private final Color bojaPromasenog = new Color(72, 118, 255);
    private final Color bojaPogodjenog = Color.RED;
    private final Color borderColor = Color.BLACK;
    private final Color pocetna = Color.BLUE;

    @Override
    public void draw(Graphics2D g2) {
        if (stanje == Stanje.GADJANO && imaBrod == true) {
            g2.setPaint(bojaPogodjenog);
            g2.fill(this);
        } else if (stanje == Stanje.GADJANO && imaBrod == false) {
            g2.setPaint(bojaPromasenog);
            g2.fill(this);
        } else if (stanje == Stanje.NEGADJANO) {
            g2.setPaint(pocetna);
            g2.fill(this);
        }

        g2.setPaint(borderColor);
        g2.draw(this);

    }
}
