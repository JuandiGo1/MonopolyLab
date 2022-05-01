/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

/**
 *
 * @author Usuario
 */
public class Casillas {
    class Casilla{
        String name;
        double ValVenta;
        double ValRenta;
        int posx, posy;
        
        public Casilla(String nombre, double ValV, double ValR, int x, int y){
            this.name = nombre;
            this.ValRenta = ValR;
            this.ValVenta = ValV;
            this.posx = x;
            this.posy = y;
        }
    
}
}
