/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolist;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static monopolist.Tablero.Historial;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class ListaTablero {

    static boolean debeSacar = false;
    static boolean chest = false;
    Icon pay = new javax.swing.ImageIcon(getClass().getResource("/imagenes/pay.png"));

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

    public Celda Buscar(Jugadores J, boolean mostrar) {
        Celda P = head;
        Celda Q = null;
        boolean encontro = false;
        while (P.next != head & encontro == false) {
            if (P.Casilla.num == J.casillaUbicado) {
                if (mostrar == true) {
                    Tablero.ProName.setBackground(P.Casilla.color);
                    Tablero.ProName.setText(P.Casilla.name);
                    if (P.Casilla.ValVenta > 0) {
                        Tablero.precio.setText("Precio: $" + P.Casilla.ValVenta);
                    } else {
                        Tablero.precio.setText("");
                    }
                    if (P.Casilla.ValVenta == 0 & P.Casilla.ValRenta > 0) {
                        Tablero.alquiler.setText("Impuesto: $" + P.Casilla.ValRenta);
                    } else if (P.Casilla.ValVenta > 0 & P.Casilla.ValRenta > 0) {
                        Tablero.alquiler.setText("Alquiler: $" + P.Casilla.ValRenta);
                    } else {
                        Tablero.alquiler.setText("");
                    }

                }
                encontro = true;
                Q = P;

            } else {
                P = P.next;
            }

        }
        //retorna un nodo con objeto casilla
        return Q;
    }

    public Celda BuscarPorNumer(int num) {
        Celda P = head;
        Celda Q = null;
        boolean encontro = false;
        while (P.next != head & encontro == false) {
            if (P.Casilla.num == num) {

                encontro = true;
                Q = P;

            } else {
                P = P.next;
            }

        }
        //retorna un objeto de tipo Jugadores
        return Q;
    }

    public void BuscarPresionando(int num) {
        Celda P = head;
        Celda Q = null;
        boolean encontro = false;
        while (P.next != head & encontro == false) {
            if (P.Casilla.num == num) {

                encontro = true;
                Q = P;

            } else {
                P = P.next;
            }

        }
        propiedades.colorcart.setBackground(Q.Casilla.color);
        propiedades.titulo.setText(Q.Casilla.name);

        if (num == 5 | num == 15 | num == 25 | num == 35) {
            propiedades.info1.setVisible(false);
            propiedades.info2.setVisible(true);
            String alq = "Si tienes una estacion $25. Si tienes 2 estaciones $50. Si tienes 3 estaciones $100. Si tienes 4 estaciones $200.";
            propiedades.rentesp.setText(Tablero.ToHTML(alq));
            propiedades.hipoes.setText("Valor Hipoteca: $" + (Q.Casilla.ValVenta / 2));
            double valorFree = ((Q.Casilla.ValVenta / 2) + (Q.Casilla.ValVenta / 2) * 0.1);
            propiedades.free2.setText("Liberar: $" + valorFree);
        } else if (num == 12 | num == 28) {
            propiedades.info1.setVisible(false);
            propiedades.info2.setVisible(true);
            String alq = "Si tienes UNA carta de servicio, la renta es 4 veces el valor de los dados. Si tienes DOS la renta es 10 veces el valor de los dados";
            propiedades.rentesp.setText(Tablero.ToHTML(alq));
            propiedades.hipoes.setText("Valor Hipoteca: $" + (Q.Casilla.ValVenta / 2));
            double valorFree = ((Q.Casilla.ValVenta / 2) + (Q.Casilla.ValVenta / 2) * 0.1);
            propiedades.free2.setText("Liberar: $" + valorFree);
        } else {
            propiedades.info1.setVisible(true);
            propiedades.info2.setVisible(false);
            propiedades.rent.setText("Renta: $" + Q.Casilla.ValRenta + "");
            propiedades.rentgrup.setText("Renta con grupo de colores: $" + (Q.Casilla.ValRenta * 2));
            propiedades.valHip.setText("$" + (Q.Casilla.ValVenta / 2));
            double valorFree = ((Q.Casilla.ValVenta / 2) + (Q.Casilla.ValVenta / 2) * 0.1);
            propiedades.free.setText("$" + valorFree);
        }
        if (P.Casilla.hipotecada == false) {
            propiedades.tecar.setEnabled(true);
            propiedades.liberar.setEnabled(false);
        } else {
            propiedades.estado.setVisible(true);
            propiedades.estado.setText("HIPOTECADA");
            propiedades.estado1.setVisible(true);
            propiedades.estado1.setText("HIPOTECADA");
            propiedades.tecar.setEnabled(false);
            propiedades.liberar.setEnabled(true);
        }

    }

    private void rentaEstaciones(Jugadores J, Celda P) {
        if (P.Casilla.propietario != null & J != P.Casilla.propietario) {
            double rent = 0;
            switch (P.Casilla.propietario.propiedadesConjunto(P.Casilla.color)) {
                case 1:
                    rent = 25;
                    break;
                case 2:
                    rent = 50;
                    break;
                case 3:
                    rent = 100;
                    break;
                case 4:
                    rent = 200;
                    break;

            }

            Tablero.alquiler.setText("Alquiler: $" + rent);
            if (J.dinero < rent) {
                J.enApuros = true;
                J.deuda = rent;
                J.debe = P.Casilla.propietario;
                Tablero.pasar.setEnabled(false);
                System.out.println("en apuro");
                Tablero.lanzar.setEnabled(false);

                Tablero.manejar.setEnabled(true);
                Tablero.quebrar.setEnabled(true);
                Icon nohay = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cagaste.png"));

                JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \"> No tienes suficiente dinero para pagar la renta, deberás hipotecar alguna de tus propiedades<p><html>",
                        "SIN DINERO", JOptionPane.PLAIN_MESSAGE, nohay);

                J.VerDinero.setText("$" + J.dinero);
            } else {
                JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \">Esta propiedad le pertenece a  " + P.Casilla.propietario.nick + ", Deberás pagar la renta por $" + rent + "<p><html>",
                        "PAGAR RENTA " + P.Casilla.name, JOptionPane.PLAIN_MESSAGE, pay);
                Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + J.nick + " pagó renta por $" + rent);

                J.dinero -= rent;
                P.Casilla.propietario.dinero += rent;
                J.VerDinero.setText("$ " + J.dinero);
                P.Casilla.propietario.VerDinero.setText("$ " + P.Casilla.propietario.dinero);
            }

        } else {
            String alq = "Si tienes una estacion $25. Si tienes dos estaciones $50. Si tienes 3 estaciones $100. Si tienes 4 estaciones $200.";
            Tablero.alquiler.setText(Tablero.ToHTML(alq));
        }

    }

    public void MoverFicha(Jugadores J, int rdados, int player) {
        Celda P;
        int newx;
        int newy;

        if (J.casillaUbicado + rdados > 39) {
            J.casillaUbicado = (J.casillaUbicado + rdados) - 40;
            J.dinero += 200;
            Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + J.nick + " Obtuvo $200 por pasar la Salida");
            J.VerDinero.setText("$ " + J.dinero);

        } else {
            J.casillaUbicado += rdados;
        }
        P = Buscar(J, true);
        if (J.casillaUbicado != 10) {
            switch (player) {
                case 1:

                    newx = P.Casilla.posx - 20;
                    newy = P.Casilla.posy - 20;
                    J.Ficha.setBounds(newx, newy, 25, 25);
                    break;
                case 2:

                    newx = P.Casilla.posx - 20;
                    newy = P.Casilla.posy + 20;
                    J.Ficha.setBounds(newx, newy, 25, 25);
                    break;
                case 3:

                    newx = P.Casilla.posx + 20;
                    newy = P.Casilla.posy - 20;
                    J.Ficha.setBounds(newx, newy, 25, 25);
                    break;
                case 4:

                    newx = P.Casilla.posx + 20;
                    newy = P.Casilla.posy + 20;
                    J.Ficha.setBounds(newx, newy, 25, 25);
                    break;
            }
        } else {
            switch (player) {
                case 1:

                    newx = P.Casilla.posx;
                    newy = P.Casilla.posy - 30;
                    J.Ficha.setBounds(newx, newy, 25, 25);
                    break;
                case 2:

                    newx = P.Casilla.posx;
                    newy = P.Casilla.posy;
                    J.Ficha.setBounds(newx, newy, 25, 25);
                    break;
                case 3:

                    newx = P.Casilla.posx + 30;
                    newy = P.Casilla.posy;
                    J.Ficha.setBounds(newx, newy, 25, 25);
                    break;
                case 4:

                    newx = P.Casilla.posx + 60;
                    newy = P.Casilla.posy;
                    J.Ficha.setBounds(newx, newy, 25, 25);
                    break;
            }
        }

        Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + J.nick + " se movio a " + P.Casilla.name);
        //Si no tiene dueño se podrá comprar, si tiene dueño se pagará la renta
        if (P.Casilla.ValVenta > 0 & P.Casilla.propietario == null & J.preso != true) {
            Tablero.info.setText("¿Deseas comprar esta propiedad?");
            Tablero.comprar.setEnabled(true);
        } else {

            Tablero.comprar.setEnabled(false);
            if (P.Casilla.hipotecada == false) {
                if (P.Casilla.ValRenta > 0) {

                    if (P.Casilla.propietario != null & P.Casilla.propietario != J) {
                        Tablero.info.setText("Propiedad de " + P.Casilla.propietario.nick);
                        if (J.dinero < P.Casilla.ValRenta) {
                            J.enApuros = true;
                            J.deuda = P.Casilla.ValRenta;
                            J.debe = P.Casilla.propietario;
                            Tablero.pasar.setEnabled(false);
                            System.out.println("en apuro");
                            Tablero.lanzar.setEnabled(false);

                            Tablero.manejar.setEnabled(true);
                            Tablero.quebrar.setEnabled(true);
                            Icon nohay = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cagaste.png"));

                            JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \"> No tienes suficiente dinero para pagar la renta, deberás hipotecar alguna de tus propiedades<p><html>",
                                    "SIN DINERO", JOptionPane.PLAIN_MESSAGE, nohay);

                            J.VerDinero.setText("$" + J.dinero);
                        } else {

                            J.dinero -= P.Casilla.ValRenta;
                            P.Casilla.propietario.dinero += P.Casilla.ValRenta;
                            JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \">Esta propiedad le pertenece a  " + P.Casilla.propietario.nick + ", Deberás pagar la renta por $" + P.Casilla.ValRenta + "<p><html>",
                                    "PAGAR RENTA " + P.Casilla.name, JOptionPane.PLAIN_MESSAGE, pay);
                            J.VerDinero.setText("$" + J.dinero);
                            P.Casilla.propietario.VerDinero.setText("$" + P.Casilla.propietario.dinero);
                            Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + J.nick + " pagó renta por $" + P.Casilla.ValRenta);
                        }

                    }

                } else {
                    Tablero.info.setText("Informacion");
                }
            } else {
                Tablero.info.setText("Informacion");
            }

        }
        switch (J.casillaUbicado) {
            case 2: //chest

                Tablero.tomar.setEnabled(true);
                debeSacar = true;
                chest = true;

                break;
            case 4: //impuestos
                JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \"> ¡A pagar impuestos!, Paga  $" + P.Casilla.ValRenta + "<p><html>",
                        "PAGAR IMPUESTOS ", JOptionPane.PLAIN_MESSAGE, pay);
                J.dinero -= P.Casilla.ValRenta;
                J.VerDinero.setText("$ " + J.dinero);
                Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + J.nick + " pagó $" + P.Casilla.ValRenta + " en impuestos");
                break;

            case 5: //estacion 1
                if (P.Casilla.hipotecada == false) {
                    rentaEstaciones(J, P);
                }

                break;
            case 7: // chance

                Tablero.tomar.setEnabled(true);
                debeSacar = true;

                break;
            case 12:
                double renta = 0;
                if (P.Casilla.hipotecada == false) {
                    if (P.Casilla.propietario != null & J != P.Casilla.propietario) {
                        if (P.Casilla.propietario.propiedadesConjunto(P.Casilla.color) == 2) {

                            renta = Tablero.result * 10;

                        } else {
                            renta = Tablero.result * 4;
                        }
                        if (J.dinero < renta) {
                            J.enApuros = true;
                            J.deuda = renta;
                            J.debe = P.Casilla.propietario;
                            Tablero.pasar.setEnabled(false);
                            System.out.println("en apuro");
                            Tablero.lanzar.setEnabled(false);

                            Tablero.manejar.setEnabled(true);
                            Tablero.quebrar.setEnabled(true);
                            Icon nohay = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cagaste.png"));

                            JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \"> No tienes suficiente dinero para pagar la renta, deberás hipotecar alguna de tus propiedades<p><html>",
                                    "SIN DINERO", JOptionPane.PLAIN_MESSAGE, nohay);

                            J.VerDinero.setText("$" + J.dinero);
                        } else {
                            Tablero.alquiler.setText("Alquiler: $" + renta);
                            JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \">Esta propiedad le pertenece a  " + P.Casilla.propietario.nick + ", Deberás pagar la renta por $" + renta + "<p><html>",
                                    "PAGAR RENTA " + P.Casilla.name, JOptionPane.PLAIN_MESSAGE, pay);

                            J.dinero -= renta;
                            P.Casilla.propietario.dinero += renta;
                            J.VerDinero.setText("$ " + J.dinero);
                            P.Casilla.propietario.VerDinero.setText("$ " + P.Casilla.propietario.dinero);
                        }

                    } else {
                        String alq = "Si tienes UNA carta de servicio, la renta es 4 veces el valor de los dados. Si tienes DOS la renta es 10 veces el valor de los dados";
                        Tablero.alquiler.setText(Tablero.ToHTML(alq));
                    }
                }
                break;
            case 15:
                if (P.Casilla.hipotecada == false) {
                    rentaEstaciones(J, P);
                }
                break;
            case 17: //chest

                Tablero.tomar.setEnabled(true);
                debeSacar = true;
                chest = true;

                break;
            case 22: //chance

                Tablero.tomar.setEnabled(true);
                debeSacar = true;

                break;
            case 25:
                if (P.Casilla.hipotecada == false) {
                    rentaEstaciones(J, P);
                }
                break;
            case 28:
                double renta1 = 0;
                if (P.Casilla.hipotecada == false) {
                    if (P.Casilla.propietario != null & J != P.Casilla.propietario) {
                        if (P.Casilla.propietario.propiedadesConjunto(P.Casilla.color) == 2) {

                            renta1 = Tablero.result * 10;

                        } else {
                            renta1 = Tablero.result * 4;
                        }
                        if (J.dinero < renta1) {
                            J.enApuros = true;
                            J.deuda = renta1;
                            J.debe = P.Casilla.propietario;
                            Tablero.pasar.setEnabled(false);
                            System.out.println("en apuro");
                            Tablero.lanzar.setEnabled(false);

                            Tablero.manejar.setEnabled(true);
                            Tablero.quebrar.setEnabled(true);
                            Icon nohay = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cagaste.png"));

                            JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \"> No tienes suficiente dinero para pagar la renta, deberás hipotecar alguna de tus propiedades<p><html>",
                                    "SIN DINERO", JOptionPane.PLAIN_MESSAGE, nohay);

                            J.VerDinero.setText("$" + J.dinero);
                        } else {
                            Tablero.alquiler.setText("Alquiler: $" + renta1);
                            JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \">Esta propiedad le pertenece a  " + P.Casilla.propietario.nick + ", Deberás pagar la renta por $" + renta1 + "<p><html>",
                                    "PAGAR RENTA " + P.Casilla.name, JOptionPane.PLAIN_MESSAGE, pay);

                            J.dinero -= renta1;
                            P.Casilla.propietario.dinero += renta1;
                            J.VerDinero.setText("$ " + J.dinero);
                            P.Casilla.propietario.VerDinero.setText("$ " + P.Casilla.propietario.dinero);
                        }

                    } else {
                        String alq = "Si tienes UNA carta de servicio, la renta es 4 veces el valor de los dados. Si tienes DOS la renta es 10 veces el valor de los dados";
                        Tablero.alquiler.setText(Tablero.ToHTML(alq));
                    }
                }
                break;
            case 30: //Ve a carcel
                J.Encarcelar();

                break;
            case 33: //chest

                Tablero.tomar.setEnabled(true);
                debeSacar = true;
                chest = true;

                break;
            case 35:
                if (P.Casilla.hipotecada == false) {
                    rentaEstaciones(J, P);
                }
                break;
            case 36: //chance

                Tablero.tomar.setEnabled(true);
                debeSacar = true;

                break;
            case 38: //super tax
                JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \"> ¡A pagar impuestos!, Paga  $" + P.Casilla.ValRenta + "<p><html>",
                        "PAGAR IMPUESTOS ", JOptionPane.PLAIN_MESSAGE, pay);
                J.dinero -= P.Casilla.ValRenta;
                J.VerDinero.setText("$ " + J.dinero);
                Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + J.nick + " pagó $" + P.Casilla.ValRenta + " en impuestos");
                break;

        }
        if (Tablero.d1 != Tablero.d2) {
            Tablero.pasar.setEnabled(true);

        }

    }

    public void ComprarPropiedad(Jugadores J) {
        Celda P = Buscar(J, false);
        if (J.dinero >= P.Casilla.ValVenta && P.Casilla.propietario == null) {
            //Se le asigna el propietario y se agrega la casilla al vector del jugador que la compró
            J.dinero -= P.Casilla.ValVenta;
            P.Casilla.propietario = J;
            J.Propiedades[J.CantPropiedades] = P.Casilla;
            J.CantPropiedades++;
            new JFXPanel();
            String dd = new File("cash.mp3").toURI().toString();
            new MediaPlayer(new Media(dd)).play();
            //Iluminar casilla cuando el jugador la compre
            switch (J.NroJugador) {
                case 1:
                    switch (P.Casilla.num) {
                        case 1:
                            Tablero.okr.setBackground(P.Casilla.color);
                            break;
                        case 3:
                            Tablero.wr.setBackground(P.Casilla.color);
                            break;
                        case 5:
                            Tablero.kcs.setBackground(P.Casilla.color);
                            break;
                        case 6:
                            Tablero.tai.setBackground(P.Casilla.color);
                            break;
                        case 8:
                            Tablero.er.setBackground(P.Casilla.color);
                            break;
                        case 9:
                            Tablero.pr.setBackground(P.Casilla.color);
                            break;
                        case 11:
                            Tablero.pm.setBackground(P.Casilla.color);
                            break;
                        case 12:
                            Tablero.ec.setBackground(P.Casilla.color);
                            break;
                        case 13:
                            Tablero.wh.setBackground(P.Casilla.color);
                            break;
                        case 14:
                            Tablero.nda.setBackground(P.Casilla.color);
                            break;
                        case 15:
                            Tablero.mrs.setBackground(P.Casilla.color);
                            break;
                        case 16:
                            Tablero.bws.setBackground(P.Casilla.color);
                            break;
                        case 18:
                            Tablero.mbs.setBackground(P.Casilla.color);
                            break;
                        case 19:
                            Tablero.vns.setBackground(P.Casilla.color);
                            break;
                        case 21:
                            Tablero.st.setBackground(P.Casilla.color);
                            break;
                        case 23:
                            Tablero.fls.setBackground(P.Casilla.color);
                            break;
                        case 24:
                            Tablero.trs.setBackground(P.Casilla.color);
                            break;
                        case 25:
                            Tablero.fss.setBackground(P.Casilla.color);
                            break;
                        case 26:
                            Tablero.lcs.setBackground(P.Casilla.color);
                            break;
                        case 27:
                            Tablero.cvs.setBackground(P.Casilla.color);
                            break;
                        case 28:
                            Tablero.ww.setBackground(P.Casilla.color);
                            break;
                        case 29:
                            Tablero.pcd.setBackground(P.Casilla.color);
                            break;
                        case 31:
                            Tablero.rs.setBackground(P.Casilla.color);
                            break;
                        case 32:
                            Tablero.oxs.setBackground(P.Casilla.color);
                            break;
                        case 34:
                            Tablero.bs.setBackground(P.Casilla.color);
                            break;
                        case 35:
                            Tablero.lss.setBackground(P.Casilla.color);
                            break;
                        case 37:
                            Tablero.pl.setBackground(P.Casilla.color);
                            break;
                        case 39:
                            Tablero.my.setBackground(P.Casilla.color);
                            break;
                    }
                    Tablero.j1dinero.setText("$ " + J.dinero);
                    break;
                case 2:
                    switch (P.Casilla.num) {
                        case 1:
                            Tablero.okr4.setBackground(P.Casilla.color);
                            break;
                        case 3:
                            Tablero.wr4.setBackground(P.Casilla.color);
                            break;
                        case 5:
                            Tablero.kcs4.setBackground(P.Casilla.color);
                            break;
                        case 6:
                            Tablero.tai4.setBackground(P.Casilla.color);
                            break;
                        case 8:
                            Tablero.er4.setBackground(P.Casilla.color);
                            break;
                        case 9:
                            Tablero.pr4.setBackground(P.Casilla.color);
                            break;
                        case 11:
                            Tablero.pm4.setBackground(P.Casilla.color);
                            break;
                        case 12:
                            Tablero.ec4.setBackground(P.Casilla.color);
                            break;
                        case 13:
                            Tablero.wh4.setBackground(P.Casilla.color);
                            break;
                        case 14:
                            Tablero.nda4.setBackground(P.Casilla.color);
                            break;
                        case 15:
                            Tablero.mrs4.setBackground(P.Casilla.color);
                            break;
                        case 16:
                            Tablero.bws4.setBackground(P.Casilla.color);
                            break;
                        case 18:
                            Tablero.mbs4.setBackground(P.Casilla.color);
                            break;
                        case 19:
                            Tablero.vns4.setBackground(P.Casilla.color);
                            break;
                        case 21:
                            Tablero.st4.setBackground(P.Casilla.color);
                            break;
                        case 23:
                            Tablero.fls4.setBackground(P.Casilla.color);
                            break;
                        case 24:
                            Tablero.trs4.setBackground(P.Casilla.color);
                            break;
                        case 25:
                            Tablero.fss4.setBackground(P.Casilla.color);
                            break;
                        case 26:
                            Tablero.lcs4.setBackground(P.Casilla.color);
                            break;
                        case 27:
                            Tablero.cvs4.setBackground(P.Casilla.color);
                            break;
                        case 28:
                            Tablero.ww4.setBackground(P.Casilla.color);
                            break;
                        case 29:
                            Tablero.pcd4.setBackground(P.Casilla.color);
                            break;
                        case 31:
                            Tablero.rs4.setBackground(P.Casilla.color);
                            break;
                        case 32:
                            Tablero.oxs4.setBackground(P.Casilla.color);
                            break;
                        case 34:
                            Tablero.bs4.setBackground(P.Casilla.color);
                            break;
                        case 35:
                            Tablero.lss4.setBackground(P.Casilla.color);
                            break;
                        case 37:
                            Tablero.pl4.setBackground(P.Casilla.color);
                            break;
                        case 39:
                            Tablero.my4.setBackground(P.Casilla.color);
                            break;
                    }
                    Tablero.j1dinero2.setText("$ " + J.dinero);
                    break;
                case 3:
                    switch (P.Casilla.num) {
                        case 1:
                            Tablero.okr6.setBackground(P.Casilla.color);
                            break;
                        case 3:
                            Tablero.wr5.setBackground(P.Casilla.color);
                            break;
                        case 5:
                            Tablero.kcs5.setBackground(P.Casilla.color);
                            break;
                        case 6:
                            Tablero.tai5.setBackground(P.Casilla.color);
                            break;
                        case 8:
                            Tablero.er5.setBackground(P.Casilla.color);
                            break;
                        case 9:
                            Tablero.pr5.setBackground(P.Casilla.color);
                            break;
                        case 11:
                            Tablero.pm5.setBackground(P.Casilla.color);
                            break;
                        case 12:
                            Tablero.ec5.setBackground(P.Casilla.color);
                            break;
                        case 13:
                            Tablero.wh5.setBackground(P.Casilla.color);
                            break;
                        case 14:
                            Tablero.nda5.setBackground(P.Casilla.color);
                            break;
                        case 15:
                            Tablero.mrs5.setBackground(P.Casilla.color);
                            break;
                        case 16:
                            Tablero.bws5.setBackground(P.Casilla.color);
                            break;
                        case 18:
                            Tablero.mbs5.setBackground(P.Casilla.color);
                            break;
                        case 19:
                            Tablero.vns5.setBackground(P.Casilla.color);
                            break;
                        case 21:
                            Tablero.st5.setBackground(P.Casilla.color);
                            break;
                        case 23:
                            Tablero.fls5.setBackground(P.Casilla.color);
                            break;
                        case 24:
                            Tablero.trs5.setBackground(P.Casilla.color);
                            break;
                        case 25:
                            Tablero.fss5.setBackground(P.Casilla.color);
                            break;
                        case 26:
                            Tablero.lcs5.setBackground(P.Casilla.color);
                            break;
                        case 27:
                            Tablero.cvs5.setBackground(P.Casilla.color);
                            break;
                        case 28:
                            Tablero.ww5.setBackground(P.Casilla.color);
                            break;
                        case 29:
                            Tablero.pcd5.setBackground(P.Casilla.color);
                            break;
                        case 31:
                            Tablero.rs5.setBackground(P.Casilla.color);
                            break;
                        case 32:
                            Tablero.oxs5.setBackground(P.Casilla.color);
                            break;
                        case 34:
                            Tablero.bs5.setBackground(P.Casilla.color);
                            break;
                        case 35:
                            Tablero.lss5.setBackground(P.Casilla.color);
                            break;
                        case 37:
                            Tablero.pl5.setBackground(P.Casilla.color);
                            break;
                        case 39:
                            Tablero.my5.setBackground(P.Casilla.color);
                            break;
                    }
                    Tablero.j1dinero3.setText("$ " + J.dinero);
                    break;
                case 4:
                    switch (P.Casilla.num) {
                        case 1:
                            Tablero.okr6.setBackground(P.Casilla.color);
                            break;
                        case 3:
                            Tablero.wr6.setBackground(P.Casilla.color);
                            break;
                        case 5:
                            Tablero.kcs6.setBackground(P.Casilla.color);
                            break;
                        case 6:
                            Tablero.tai6.setBackground(P.Casilla.color);
                            break;
                        case 8:
                            Tablero.er6.setBackground(P.Casilla.color);
                            break;
                        case 9:
                            Tablero.pr6.setBackground(P.Casilla.color);
                            break;
                        case 11:
                            Tablero.pm6.setBackground(P.Casilla.color);
                            break;
                        case 12:
                            Tablero.ec6.setBackground(P.Casilla.color);
                            break;
                        case 13:
                            Tablero.wh6.setBackground(P.Casilla.color);
                            break;
                        case 14:
                            Tablero.nda6.setBackground(P.Casilla.color);
                            break;
                        case 15:
                            Tablero.mrs6.setBackground(P.Casilla.color);
                            break;
                        case 16:
                            Tablero.bws6.setBackground(P.Casilla.color);
                            break;
                        case 18:
                            Tablero.mbs6.setBackground(P.Casilla.color);
                            break;
                        case 19:
                            Tablero.vns6.setBackground(P.Casilla.color);
                            break;
                        case 21:
                            Tablero.st6.setBackground(P.Casilla.color);
                            break;
                        case 23:
                            Tablero.fls6.setBackground(P.Casilla.color);
                            break;
                        case 24:
                            Tablero.trs6.setBackground(P.Casilla.color);
                            break;
                        case 25:
                            Tablero.fss6.setBackground(P.Casilla.color);
                            break;
                        case 26:
                            Tablero.lcs6.setBackground(P.Casilla.color);
                            break;
                        case 27:
                            Tablero.cvs6.setBackground(P.Casilla.color);
                            break;
                        case 28:
                            Tablero.ww6.setBackground(P.Casilla.color);
                            break;
                        case 29:
                            Tablero.pcd6.setBackground(P.Casilla.color);
                            break;
                        case 31:
                            Tablero.rs6.setBackground(P.Casilla.color);
                            break;
                        case 32:
                            Tablero.oxs6.setBackground(P.Casilla.color);
                            break;
                        case 34:
                            Tablero.bs6.setBackground(P.Casilla.color);
                            break;
                        case 35:
                            Tablero.lss6.setBackground(P.Casilla.color);
                            break;
                        case 37:
                            Tablero.pl6.setBackground(P.Casilla.color);
                            break;
                        case 39:
                            Tablero.my6.setBackground(P.Casilla.color);
                            break;
                    }
                    Tablero.j1dinero4.setText("$ " + J.dinero);
                    break;
            }
            Icon compro = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cart.png"));
            Icon comple = new javax.swing.ImageIcon(getClass().getResource("/imagenes/mono.png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \">¡COMPRASTE ESTA PROPIEDAD!<p><html>",
                    "VENDIDA ", JOptionPane.PLAIN_MESSAGE, compro);
            Tablero.comprar.setEnabled(false);

            Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + J.nick + " COMPRÓ " + P.Casilla.name);
            if (J.monopoli(P.Casilla.color, false) == true) {

                JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:20px ;font face='Eras Bold'; \">¡COLOR COMPLETADO!<p><html>",
                        "COMPLETADO ", JOptionPane.PLAIN_MESSAGE, comple);
                J.monopoli(P.Casilla.color, true);
                Tablero.Historial.setText(Tablero.Historial.getText() + "\n" + J.nick + " ¡COMPLETO UN COLOR!, ahora la renta en esas casillas ha aumentado.");
            }
            Tablero.info.setText("¡Vendida!");
        } else {
            Icon nohay = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cagaste.png"));

            JOptionPane.showMessageDialog(null, "<html><p style=\" color:red; font:15px ;font face='Eras Bold'; \"> No tienes suficiente dinero para comprar esta propiedad <p><html>",
                    "SIN DINERO", JOptionPane.PLAIN_MESSAGE, nohay);
            Tablero.info.setText("No tienes suficiente $$");
        }
    }

}
