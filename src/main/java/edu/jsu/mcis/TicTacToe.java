package edu.jsu.mcis;


import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    
    private JFrame frame;
    private JPanel buttonpanel;
    private ArrayList<JButton> buttonlist;
    
    String player = "X";

    public static void main(String[] args) {

        TicTacToe t = new TicTacToe();
        t.init();

    }
  
    private void init() {
      
        frame = new JFrame("GridLayout");
        buttonpanel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        buttonpanel.setLayout(new GridLayout(3, 3));

        buttonlist = new ArrayList();

        for (int i = 0; i < 9; ++i) {
            
            buttonlist.add(new JButton());
            
            buttonlist.get(i).setActionCommand(String.valueOf(i));
            buttonlist.get(i).addActionListener(this);
            
            buttonpanel.add(buttonlist.get(i));
            
        }

        frame.getContentPane().add(buttonpanel);
        //frame.getContentPane().add(new JLabel("Bottom"));

        frame.pack();
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
      
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {

        int button = Integer.parseInt(e.getActionCommand());

        buttonlist.get(button).setText(player);
        
        if (player.equals("X")) {
            player = "O";
        }
        
        else if (player.equals("O")) {
            player = "X";
        }

    }
	
	

}