/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolist;

import java.awt.Color;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static monopolist.Tablero.BuscarTurno;
import static monopolist.Tablero.turnoac;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class Jugadores {

    String nick;
    double dinero = 1500;
    int turno;
    Casillas Propiedades[] = new Casillas[28];
    int CantPropiedades;
    JLabel Ficha, VerDinero;
    int casillaUbicado = 0;
    int NroJugador;
    boolean preso, enApuros, bancarrota;
    boolean salirGratis = false;
    Color selected;
    double deuda = 0;
    Jugadores debe = null;

    Jugadores(String name, int turn, JLabel p, int Nro, JLabel p2) {
        this.nick = name;
        this.turno = turn;
        this.Ficha = p;
        this.VerDinero = p2;
        this.NroJugador = Nro;
        //this.Propiedades = new Casillas[28];
        this.CantPropiedades = 0;
        this.preso = false;
        this.enApuros = false;
        this.bancarrota = false;
        this.selected = null;
    }

    public void Encarcelar() {
        Icon poli = new javax.swing.ImageIcon(getClass().getResource("/imagenes/police.png"));
        new JFXPanel();
        String dd = new File("policia.mp3").toURI().toString();
        new MediaPlayer(new Media(dd)).play();
        JOptionPane.showMessageDialog(null, "<html><p style=\" color:blue; font:20px ;font face='Eras Bold'; \"> ¡A LA CARCEL!<p><html>",
                "VE A LA CARCEL", JOptionPane.PLAIN_MESSAGE, poli);
        this.preso = true;
        this.casillaUbicado = 10;
        switch (this.NroJugador) {
            case 1:

                this.Ficha.setBounds(50, 647, 25, 25);
                break;
            case 2:

                this.Ficha.setBounds(90, 647, 25, 25);
                break;
            case 3:

                this.Ficha.setBounds(50, 687, 25, 25);
                break;
            case 4:

                this.Ficha.setBounds(90, 687, 25, 25);
                break;
        }
        Tablero.comprar.setEnabled(false);
        Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + this.nick + " fue privado de su libertad :(");
    }

    //Para saber cuantas propiedades tiene de un color (para casos como el de estaciones y servicios)
    public int propiedadesConjunto(Color colo) {
        int cant = 0;

        String com = colo + "";

        for (int i = 0; i < this.CantPropiedades; i++) {

            String act = Propiedades[i].color + "";
            if (act.equals(com)) {
                cant++;

            }
        }
        return cant;
    }

    //Para saber si tiene un grupo de color
    public boolean monopoli(Color colo, boolean aumentar) {
        int cant = 0;

        String com = colo + "";
        boolean monopolio = false;
        for (int i = 0; i < this.CantPropiedades; i++) {

            String act = Propiedades[i].color + "";
            if (act.equals(com)) {
                cant++;
                if (aumentar == true) {
                    Propiedades[i].ValRenta *= 2;
                }

            }
        }

        if (colo == Tablero.palido | colo == Tablero.azulOscuro | colo == Tablero.marron) {
            if (cant == 2) {
                monopolio = true;
            }

        } else if (colo == Tablero.blanco) {
            if (cant == 4) {
                monopolio = true;
            }
            
        } else if (colo != Tablero.palido & colo != Tablero.azulOscuro & colo != Tablero.marron & colo != Tablero.blanco) {
            if (cant == 3) {
                monopolio = true;
            }

        }

        return monopolio;
    }

    public void Endeudado(double deuda) {
        this.enApuros = true;
        Icon nohay = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cagaste.png"));
        JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \">Deberás pagar la renta por $" + deuda + ",pero no tienes dinero, te sugiero hipotecar algunas de tus propiedades <p><html>",
                "PAGAR RENTA ", JOptionPane.PLAIN_MESSAGE, nohay);

        propiedades.dineroact.setText("$" + this.dinero);
        propiedades.salir.setEnabled(false);
    }

    public void Bancarrota() {
        this.bancarrota = true;
        for (int i = 0; i < this.CantPropiedades; i++) {
            this.Propiedades[i].propietario = null;

        }

        Icon broke = new javax.swing.ImageIcon(getClass().getResource("/imagenes/broken.png"));
        JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:25px ;font face='Eras Bold'; \">" + this.nick + " ha caido en BANCARROTA :(<p><html>",
                "BANCARROTA ", JOptionPane.PLAIN_MESSAGE, broke);
        switch (this.NroJugador) {
            case 1:
                Tablero.infoj1.setVisible(false);
                Tablero.infoj1.setBackground(Tablero.neutro);
                this.Ficha.setVisible(false);
                break;
            case 2:
                Tablero.infoj2.setVisible(false);
                Tablero.infoj2.setBackground(Tablero.neutro);
                this.Ficha.setVisible(false);
                break;
            case 3:
                Tablero.infoj3.setVisible(false);
                Tablero.infoj3.setBackground(Tablero.neutro);
                this.Ficha.setVisible(false);
                break;
            case 4:
                Tablero.infoj4.setVisible(false);
                Tablero.infoj4.setBackground(Tablero.neutro);
                this.Ficha.setVisible(false);
                break;
        }
    }
}
