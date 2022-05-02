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
import static monopolist.Inicio.J4box;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class Tablero extends javax.swing.JFrame {

    Pintar P;
    JLabel ficha1, ficha2, ficha3, ficha4;
    int x, y;
    int d1, d2;

    //Objetos casilla
    Casillas Go = new Casillas("Salida", 0, 0, 887, 687, 0);
    Casillas C1 = new Casillas("Old Kent Road", 60, 2, 780, 687, 1);
    Casillas C2 = new Casillas("Community chest", 0, 0, 700, 687, 2);
    ListaTablero Tab = new ListaTablero();

    ;

    public Tablero() {
        initComponents();
        Tab.addNode(Go);
        Tab.addNode(C1);
        Tab.addNode(C2);

        P = new Pintar(Panel.getSize(), 1);
        Panel.add(P);

        ficha1 = new JLabel();
        ficha2 = new JLabel();
        ficha3 = new JLabel();
        ficha4 = new JLabel();
        Icon carrito = new javax.swing.ImageIcon(getClass().getResource("/imagenes/carrito.png"));
        Icon barco = new javax.swing.ImageIcon(getClass().getResource("/imagenes/barco.png"));
        Icon perrito = new javax.swing.ImageIcon(getClass().getResource("/imagenes/perrito.png"));
        Icon sombrero = new javax.swing.ImageIcon(getClass().getResource("/imagenes/sombrero.png"));

        ficha1.setBounds(867, 667, 25, 25);
        String Select = Inicio.J1Ficha.getSelectedItem().toString();
        if (null != Select) {
            switch (Select) {
                case "Rojo":
                    ficha1.setBackground(Color.red);
                    ficha1.setIcon(carrito);
                    break;
                case "Azul":
                    ficha1.setBackground(Color.blue);
                    ficha1.setIcon(barco);
                    break;
                case "Amarillo":
                    ficha1.setBackground(Color.yellow);
                    ficha1.setIcon(perrito);
                    break;
                case "Verde":
                    ficha1.setBackground(Color.green);
                    ficha1.setIcon(sombrero);
                    break;
                default:
                    break;
            }
        }

        ficha1.setOpaque(true);

        ficha2.setBounds(867, 707, 25, 25);
        String Select2 = Inicio.J2Ficha.getSelectedItem().toString();
        if (null != Select2) {
            switch (Select2) {
                case "Rojo":
                    ficha2.setBackground(Color.red);
                    ficha2.setIcon(carrito);
                    break;
                case "Azul":
                    ficha2.setBackground(Color.blue);
                    ficha2.setIcon(barco);
                    break;
                case "Amarillo":
                    ficha2.setBackground(Color.yellow);
                    ficha2.setIcon(perrito);
                    break;
                case "Verde":
                    ficha2.setBackground(Color.green);
                    ficha2.setIcon(sombrero);
                    break;
                default:
                    break;
            }
        }

        ficha2.setOpaque(true);
        if (Inicio.J3box.isSelected()) {
            ficha3.setBounds(907, 707, 25, 25);
            String Select3 = Inicio.J3Ficha.getSelectedItem().toString();
            if (null != Select3) {
                switch (Select3) {
                    case "Rojo":
                        ficha3.setBackground(Color.red);
                        ficha3.setIcon(carrito);
                        break;
                    case "Azul":
                        ficha3.setBackground(Color.blue);
                        ficha3.setIcon(barco);
                        break;
                    case "Amarillo":
                        ficha3.setBackground(Color.yellow);
                        ficha3.setIcon(perrito);
                        break;
                    case "Verde":
                        ficha3.setBackground(Color.green);
                        ficha3.setIcon(sombrero);
                        break;
                    default:
                        break;
                }
                ficha3.setOpaque(true);
                P.add(ficha3);
            }
        }
        if (Inicio.J4box.isSelected()) {
            ficha4.setBounds(907, 667, 25, 25);
            String Select3 = Inicio.J4Ficha.getSelectedItem().toString();
            if (null != Select3) {
                switch (Select3) {
                    case "Rojo":
                        ficha4.setBackground(Color.red);
                        ficha4.setIcon(carrito);
                        break;
                    case "Azul":
                        ficha4.setBackground(Color.blue);
                        ficha4.setIcon(barco);
                        break;
                    case "Amarillo":
                        ficha4.setBackground(Color.yellow);
                        ficha4.setIcon(perrito);
                        break;
                    case "Verde":
                        ficha4.setBackground(Color.green);
                        ficha4.setIcon(sombrero);
                        break;
                    default:
                        break;
                }
                ficha4.setOpaque(true);
                P.add(ficha4);
            }
        }
        P.add(ficha1);
        P.add(ficha2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        F1 = new javax.swing.JButton();
        Y = new javax.swing.JTextField();
        X = new javax.swing.JTextField();
        F2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dado2 = new javax.swing.JLabel();
        dado1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Tot = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.green);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        F1.setText("F1");
        F1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F1ActionPerformed(evt);
            }
        });

        Y.setText("Y");

        X.setText("X");

        F2.setText("F2");
        F2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        dado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cara2.png"))); // NOI18N
        dado2.setText("jLabel1");

        dado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cara1.png"))); // NOI18N
        dado1.setText("DADO");

        jButton1.setText("LANZAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(dado1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(dado2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tot)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dado2)
                    .addComponent(dado1))
                .addGap(17, 17, 17)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tot, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(X)
                                .addComponent(Y, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Y, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(F1)
                    .addComponent(F2))
                .addGap(125, 125, 125))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void F1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F1ActionPerformed
        x = Integer.parseInt(X.getText());
        y = Integer.parseInt(Y.getText());
        ficha1.setLocation(x, y);
    }//GEN-LAST:event_F1ActionPerformed

    private void F2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F2ActionPerformed
        x = Integer.parseInt(X.getText());
        y = Integer.parseInt(Y.getText());
        ficha2.setLocation(x, y);
    }//GEN-LAST:event_F2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new JFXPanel();
        String dd = new File("dados.mp3").toURI().toString();
        new MediaPlayer(new Media(dd)).play();

        d1 = (int) (Math.random() * 6) + 1;
        d2 = (int) (Math.random() * 6) + 1;
        int result = d1 + d2;

        Icon uno = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cara1.png"));
        Icon dos = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cara2.png"));
        Icon tres = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cara3.png"));
        Icon cuatro = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cara4.png"));
        Icon cinco = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cara5.png"));
        Icon seis = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cara6.png"));

        switch (d1) {
            case 1:
                dado1.setIcon(uno);
                break;
            case 2:
                dado1.setIcon(dos);
                break;
            case 3:
                dado1.setIcon(tres);
                break;
            case 4:
                dado1.setIcon(cuatro);
                break;
            case 5:
                dado1.setIcon(cinco);
                break;
            case 6:
                dado1.setIcon(seis);
                break;
        }
        switch (d2) {
            case 1:
                dado2.setIcon(uno);
                break;
            case 2:
                dado2.setIcon(dos);
                break;
            case 3:
                dado2.setIcon(tres);
                break;
            case 4:
                dado2.setIcon(cuatro);
                break;
            case 5:
                dado2.setIcon(cinco);
                break;
            case 6:
                dado2.setIcon(seis);
                break;
        }
        Tot.setText("Total obtenido: " + result);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton F1;
    private javax.swing.JButton F2;
    private javax.swing.JPanel Panel;
    private javax.swing.JTextField Tot;
    private javax.swing.JTextField X;
    private javax.swing.JTextField Y;
    private javax.swing.JLabel dado1;
    private javax.swing.JLabel dado2;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
