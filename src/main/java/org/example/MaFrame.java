package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MaFrame extends JFrame implements MouseListener, ActionListener {
    public MaFrame() {
        setSize(500, 300);
        setTitle("Voila une fenetre");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("bouton pressé");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Souris clickée");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("souris presse fenetre");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("souris relachee dans fenetre");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.getContentPane().setBackground(Color.WHITE);
    }
}
