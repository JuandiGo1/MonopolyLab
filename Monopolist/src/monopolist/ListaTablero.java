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
public class ListaTablero {

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
