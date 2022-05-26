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
public class ListaCartas {

    class Nodo {

        CartasSuerte Carta;
        Nodo next;
        Nodo prev;

        public Nodo(CartasSuerte d) {
            this.Carta = d;
            this.next = null;
            this.prev = null;

        }
    }

    Nodo head = null;
    Nodo tail = null;

    public void addNode(CartasSuerte carta) {
        Nodo P = new Nodo(carta);
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

    public CartasSuerte BuscarCarta(int Nro, Jugadores J) {
        Nodo P = head;
        Nodo Q = null;

        boolean encontro = false;
        while (P.next != head & encontro == false) {
            if (P.Carta.NroCarta == Nro) {
                Q = P;
                encontro = true;
                switch(P.Carta.accion){
                    case "dar":
                        J.dinero-=P.Carta.valor;
                        J.VerDinero.setText("$ "+J.dinero);
                        Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + J.nick + " pagó $" + P.Carta.valor);
                        break;
                    case "recibir":
                        J.dinero+=P.Carta.valor;
                        J.VerDinero.setText("$ "+J.dinero);
                        Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + J.nick + " obtuvo $" + P.Carta.valor);
                        break;
                    case "carcel":
                        J.Encarcelar();
                        
                        break;
                    case "libre":
                        J.salirGratis=true;
                        break;
                    
                }

            } else {
                P = P.next;
            }
        }
        return Q.Carta;
    }
}
