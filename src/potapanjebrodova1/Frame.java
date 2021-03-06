package potapanjebrodova1;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author S
 */
public class Frame extends JFrame {

    Board board = new Board();

    JButton pocniIgru;

    public Frame() {

        add(board);

        setJMenuBar(initMenu());

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Potapanje Brodova");
        setVisible(true);

    }

    final JMenuBar initMenu() {
        // Napravimo liniju menija
        JMenuBar menuBar = new JMenuBar();

        // Mapravimo meni
        JMenu gameMenu = new JMenu("Igra");

        // Napravimo stavku za meni
        JMenuItem novaIgra = new JMenuItem("Nova igra");
        novaIgra.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                board.PocniIgru();

            }

        }
        );

        // Dodamo stavku u meni
        gameMenu.add(novaIgra);

        // Dodamo meni u liniju menija
        menuBar.add(gameMenu);

        return menuBar;

    }

}
