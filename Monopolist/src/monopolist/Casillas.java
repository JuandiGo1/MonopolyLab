/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolist;

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

    Casillas(String nombre, double ValV, double ValR, int x, int y, int num) {
        this.name = nombre;
        this.ValRenta = ValR;
        this.ValVenta = ValV;
        this.posx = x;
        this.posy = y;
        this.num = num;
    }

}
