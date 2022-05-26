
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolist;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import static monopolist.propiedades.rent;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class Casillas {

    String name;
    double ValVenta;
    double ValRenta;
    int posx, posy;
    int num;
    Color color;
    Jugadores propietario;
    boolean hipotecada;

    Casillas(String nombre, double ValV, double ValR, int x, int y, int num, Color col) {
        this.name = nombre;
        this.ValRenta = ValR;
        this.ValVenta = ValV;
        this.posx = x;
        this.posy = y;
        this.num = num;
        this.color = col;
        this.propietario = null;
        this.hipotecada = false;
    }

    public void Hipotecar() {
        this.hipotecada = true;
        Icon hipo = new javax.swing.ImageIcon(getClass().getResource("/imagenes/credito.png"));
        JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:20px ;font face='Eras Bold'; \">Propiedad hipotecada  <p><html>",
                "Hipoteca " + this.name, JOptionPane.PLAIN_MESSAGE, hipo);
        propiedades.tecar.setEnabled(false);
        this.propietario.dinero += (this.ValVenta / 2);
        this.propietario.VerDinero.setText("$ " + this.propietario.dinero);
        propiedades.dineroact.setText("$" + this.propietario.dinero);
        Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + this.propietario.nick + " hipotecó " + this.name +" por $"+(this.ValVenta / 2));
    }

    public void liberar() {
        this.hipotecada = false;
        Icon free = new javax.swing.ImageIcon(getClass().getResource("/imagenes/liberar.png"));
        JOptionPane.showMessageDialog(null, "<html><p style=\" color:green; font:20px ;font face='Eras Bold'; \">Propiedad liberada.<p><html>",
                "Liberar " + this.name, JOptionPane.PLAIN_MESSAGE, free);
        propiedades.liberar.setEnabled(false);
        double valorFree = ((this.ValVenta / 2) + (this.ValVenta / 2) * 0.1);
        this.propietario.dinero -= valorFree;
        this.propietario.VerDinero.setText("$ " + this.propietario.dinero);
        propiedades.dineroact.setText("$" + this.propietario.dinero);
        Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + this.propietario.nick + " liberó " + this.name+" por $"+valorFree);
    }

}
