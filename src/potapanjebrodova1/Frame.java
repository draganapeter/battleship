package potapanjebrodova1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JMenu gameMenu = new JMenu("Game");
        
        // Napravimo stavku za meni
        JMenuItem newGame = new JMenuItem("New game");
        newGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                board.startGame();
            }

           
        });
        
        // Dodamo stavku u meni
        gameMenu.add(newGame);
        
        // Dodamo meni u liniju menija
        menuBar.add(gameMenu);
        
        return menuBar;
    }

    
 
    }
    

