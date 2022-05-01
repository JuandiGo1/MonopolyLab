/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

/**
 *
 * @author Usuario
 */
public class ListaTablero {

    public class Tablero {

        class Celda {

            Casillas Casilla;
            Celda next;
            Celda prev;

            public Celda(Casillas d) {
                this.Casilla = d;
                this.next = null;
                this.prev = null;

            }
        }
        //Represent the head and tail of the singly linked list
        Celda head = null;
        Celda tail = null;

        public void addNode(Casillas Casilla) {
            Celda P = new Celda(Casilla);
            if (head == null) {
                head = P;
                tail = P;
            } else {
                tail.next = P;
                P.prev = tail;
                tail = P;
            }

            head.prev = tail;
            tail.next = head;
        }
    }

}
