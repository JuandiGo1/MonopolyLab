/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.nose;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Nose extends JPanel {

    Image img;
    JLabel etq;

    public Nose(Dimension sz) {
        this.setSize(sz);
        this.setLayout(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(true);
//        setLayout(null);
//        setSize(800, 800);
//        setLocationRelativeTo(null);

        ImageIcon icono = new ImageIcon("C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\Nose\\src\\main\\java\\imagenes\\tablero.jpg");
        img = icono.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        repaint();

        

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
