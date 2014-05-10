package potapanjebrodova1;


import javax.swing.JFrame;

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
       
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Potapanje Brodova");
        setVisible(true);
        
     
        
    }
 
    }
    

