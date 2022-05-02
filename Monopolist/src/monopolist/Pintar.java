/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolist;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class Pintar extends JPanel {

    Image img;
    JLabel etq;

    public Pintar(Dimension sz, int el) {
        this.setSize(sz);
        this.setLayout(null);
        ImageIcon icono = null;
        if(el ==1){
            icono = new ImageIcon("C:\\Users\\ASUS TUF GAMING F15\\Desktop\\LAB\\Monopolist\\src\\imagenes\\tablero.jpg");
           
        }else if(el==2){
            icono = new ImageIcon("C:\\Users\\ASUS TUF GAMING F15\\Desktop\\LAB\\Monopolist\\src\\imagenes\\Panel1.png");
        }
            
        //ImageIcon icono = new ImageIcon("C:\\Users\\ASUS TUF GAMING F15\\Desktop\\LAB\\Monopolist\\src\\imagenes\\tablero.jpg");
        img = icono.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        repaint();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
