package com.behindthewalls.evgeniyChobotar;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GUI extends GameBoard {
    int             player          = 1;
    int             turns           = 9;
    JFrame          frame           = new JFrame();
    JPanel          panel           = new JPanel();
    JLabel          label           = new JLabel();
    JButton[][]     button          = new JButton[3][3];
    String          winner;
    ActionListener  listener        = new ButtonDownAction();
    ImageIcon       XIcon           = createIcon("res/images/X.png");
    ImageIcon       OIcon           = createIcon("res/images/O.png");
    ImageIcon       EmpIcon         = createIcon("res/images/v.png");
    
    public void show() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {              
                if(getPosition(i, j) == 1){ 
                    button[i][j].setIcon(XIcon);
                } else {
                    if(getPosition(i, j) == -1) {
                        button[i][j].setIcon(OIcon);
                    } else {
                        button[i][j].setIcon(EmpIcon);
                    }
                }
            }
        }
        
        frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    class ButtonDownAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            int     i = (int)b.getClientProperty("indI"),
                    j = (int)b.getClientProperty("indJ");
            
            
            if(checkCorrectTurn(i, j, player) && !winnerCheck(player)) {
                setPosition(i,j,player);  
                show();
            }
            if(winnerCheck(player)) {
                    winner = "Winner is "+player;
                    JFrame winframe = new JFrame("Winner");
                    winframe.setSize(300, 100);
                    label.setSize(300,100);
                    label.setText(winner);
                    winframe.add(label);
                    winframe.setVisible(true);
                    winframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else
                    if(turns==0) {
                        
                        JFrame winframe = new JFrame("Winner");
                        winframe.setSize(300, 100);
                        label.setSize(300,100);
                        label.setText("Нічия");
                        winframe.add(label);
                        winframe.setVisible(true);

                        winframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
             turns--;
             player*=-1;
            
        }
    }
        
    void init() {
        this.frame.setSize(300,300);
        this.frame.add(panel);
        this.panel.setLayout(new GridLayout(3,3));        


        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++) {
                this.button[i][j] = new JButton();
                this.button[i][j].putClientProperty("indI", i);
                this.button[i][j].putClientProperty("indJ", j);
                this.button[i][j].addActionListener(listener);
                this.panel.add(button[i][j]);
            }

    }
    
    protected ImageIcon createIcon(String path) {        
        return new ImageIcon(path);        
    }
    
}
