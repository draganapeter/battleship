/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package potapanjebrodova1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class MakingAGrid extends JPanel {
    SquareRx[][] squares;
    final int PAD = 20;
    
    
 
    public MakingAGrid() {
        int ROWS = 10;
        int COLS = 10;
        squares = new SquareRx[ROWS][COLS];
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                squares[i][j] = new SquareRx(i, j);
            }
        }
    }
 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        double xInc = (double)(w - 2*PAD)/squares[0].length;
        double yInc = (double)(h - 2*PAD)/squares.length;
        // Draw vertical grid lines.
        g2.setPaint(Color.BLUE);
        for(int i = 0; i <= squares[0].length; i++) {
            double x = PAD + i*xInc;
            g2.draw(new Line2D.Double(x, PAD, x, h-PAD));
        }
        // Draw horizontal grid lines.
        for(int i = 0; i <= squares.length; i++) {
            double y = PAD + i*yInc;
            g2.draw(new Line2D.Double(PAD, y, w-PAD, y));
        }
    }
}
