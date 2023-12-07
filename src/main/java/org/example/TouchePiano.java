package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TouchePiano extends JButton implements ActionListener {
    public TouchePiano(){
        super();
        initBouton();
    }
    public TouchePiano(String titre){
        super(titre);
        initBouton();
    }
    public void initBouton(){
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Je suis me bouton"+this.getText()+" et je suis pressé");
    }

}
