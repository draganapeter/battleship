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


public class Polje extends Rectangle.Double implements Objects {

    boolean imaBrod, brodpostavljen, gadjano;

    Random r;

    public Polje(int row, int col) {

       // r = new Random();
        //this.imaBrod = r.nextBoolean();
        gadjano = false;
        x = row * 30;
        y = col * 30;
        width = height = 30;
    }

    public void Gadjaj() {

        gadjano = true;

            //System.out.println("POGODAK!");
    }

    private final Color bojaPromasenog = new Color(72, 118, 255);
    private final Color bojaPogodjenog = Color.RED;
    private final Color borderColor = Color.BLACK;
    private final Color pocetna = Color.BLUE;
    private final Color bojapostavljenog = Color.GREEN;

    @Override
    public void draw(Graphics2D g2) {
        if (gadjano && imaBrod == true) {
            g2.setPaint(bojaPogodjenog);
            g2.fill(this);
        } else if (gadjano && imaBrod == false) {
            g2.setPaint(bojaPromasenog);
            g2.fill(this);
        } else if (gadjano == false && brodpostavljen == false) {
            g2.setPaint(pocetna);
            g2.fill(this);
        } else if (gadjano == false && brodpostavljen == true) {
            g2.setPaint(bojapostavljenog);
            g2.fill(this);
        }


        g2.setPaint(borderColor);
        g2.draw(this);

    }
}
