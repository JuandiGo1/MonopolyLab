/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolist;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class Inicio extends javax.swing.JFrame {

    Pintar Q;
    JLabel ficha1, ficha2;
    JComboBox<String> model;
    boolean active = true;

    public Inicio() {
        initComponents();
        generarModelo();
        //Q = new Pintar(Inicio.getSize(), 2);
        //Inicio.add(Q);
    }

    void generarModelo() {

        // modelo de combobox independiente a los valores que selecionado del primer combox
        model = new JComboBox<>();
        for (int i = 0; i < J1Ficha.getItemCount(); i++) {
            model.addItem(J1Ficha.getItemAt(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Inicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jugar = new javax.swing.JButton();
        J1box = new javax.swing.JCheckBox();
        J2box = new javax.swing.JCheckBox();
        J1Name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        J2Name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        J1Ficha = new javax.swing.JComboBox<>();
        J2Ficha = new javax.swing.JComboBox<>();
        J3box = new javax.swing.JCheckBox();
        J3Name = new javax.swing.JTextField();
        J3Ficha = new javax.swing.JComboBox<>();
        J4box = new javax.swing.JCheckBox();
        J4Name = new javax.swing.JTextField();
        J4Ficha = new javax.swing.JComboBox<>();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Inicio.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Elija los jugadores");

        jugar.setBackground(new java.awt.Color(246, 59, 59));
        jugar.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24)); // NOI18N
        jugar.setForeground(new java.awt.Color(255, 255, 255));
        jugar.setText("J U G A R");
        jugar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        J1box.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        J1box.setForeground(new java.awt.Color(0, 0, 0));
        J1box.setSelected(true);
        J1box.setText("Jugador 1");
        J1box.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        J1box.setEnabled(false);
        J1box.setOpaque(false);

        J2box.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        J2box.setForeground(new java.awt.Color(0, 0, 0));
        J2box.setSelected(true);
        J2box.setText("Jugador 2");
        J2box.setEnabled(false);
        J2box.setOpaque(false);

        J1Name.setText("P1");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ficha");

        J2Name.setText("P2");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nicks");

        J1Ficha.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        J1Ficha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rojo", "Azul", "Amarillo", "Verde" }));
        J1Ficha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J1FichaActionPerformed(evt);
            }
        });

        J2Ficha.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        J2Ficha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rojo", "Azul", "Amarillo", "Verde" }));
        J2Ficha.setSelectedIndex(1);
        J2Ficha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J2FichaActionPerformed(evt);
            }
        });

        J3box.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        J3box.setForeground(new java.awt.Color(0, 0, 0));
        J3box.setText("Jugador 3");
        J3box.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        J3box.setOpaque(false);
        J3box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J3boxActionPerformed(evt);
            }
        });

        J3Name.setEnabled(false);

        J3Ficha.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        J3Ficha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rojo", "Azul", "Amarillo", "Verde" }));
        J3Ficha.setSelectedIndex(2);
        J3Ficha.setEnabled(false);
        J3Ficha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J3FichaActionPerformed(evt);
            }
        });

        J4box.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        J4box.setForeground(new java.awt.Color(0, 0, 0));
        J4box.setText("Jugador 4");
        J4box.setOpaque(false);
        J4box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J4boxActionPerformed(evt);
            }
        });

        J4Name.setEnabled(false);

        J4Ficha.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        J4Ficha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rojo", "Azul", "Amarillo", "Verde" }));
        J4Ficha.setSelectedIndex(3);
        J4Ficha.setEnabled(false);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoM.png"))); // NOI18N

        javax.swing.GroupLayout InicioLayout = new javax.swing.GroupLayout(Inicio);
        Inicio.setLayout(InicioLayout);
        InicioLayout.setHorizontalGroup(
            InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InicioLayout.createSequentialGroup()
                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InicioLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InicioLayout.createSequentialGroup()
                                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(J2box)
                                    .addComponent(J1box, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(InicioLayout.createSequentialGroup()
                                        .addComponent(J2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(J2Ficha, 0, 84, Short.MAX_VALUE))
                                    .addGroup(InicioLayout.createSequentialGroup()
                                        .addComponent(J1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(J1Ficha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(InicioLayout.createSequentialGroup()
                                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(J4box)
                                    .addComponent(J3box, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(InicioLayout.createSequentialGroup()
                                        .addComponent(J4Name, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(J4Ficha, 0, 84, Short.MAX_VALUE))
                                    .addGroup(InicioLayout.createSequentialGroup()
                                        .addComponent(J3Name, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(J3Ficha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(InicioLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InicioLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
            .addGroup(InicioLayout.createSequentialGroup()
                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InicioLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InicioLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(logo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InicioLayout.setVerticalGroup(
            InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InicioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InicioLayout.createSequentialGroup()
                        .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(J1Ficha, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(J1Name))
                        .addGap(18, 18, 18)
                        .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(J2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(J2Ficha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(InicioLayout.createSequentialGroup()
                        .addComponent(J1box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(J2box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InicioLayout.createSequentialGroup()
                        .addComponent(J3box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(InicioLayout.createSequentialGroup()
                        .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(J3Ficha)
                            .addComponent(J3Name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(J4Name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(J4box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(J4Ficha))
                        .addGap(60, 60, 60)))
                .addComponent(jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        this.setVisible(false);
        DecidirTurno T = new DecidirTurno();
        T.setVisible(true);
    }//GEN-LAST:event_jugarActionPerformed

    private void J3boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J3boxActionPerformed
        if (J3box.isSelected()) {
            J3Name.setEnabled(true);
            J3Ficha.setEnabled(true);
        } else {
            J3Name.setText("");
            J3Name.setEnabled(false);
            J3Ficha.setEnabled(false);
        }
    }//GEN-LAST:event_J3boxActionPerformed

    private void J4boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J4boxActionPerformed
        if (J4box.isSelected()) {
            J4Name.setEnabled(true);
            J4Ficha.setEnabled(true);
        } else {
            J4Name.setText("");
            J4Name.setEnabled(false);
            J4Ficha.setEnabled(false);
        }
    }//GEN-LAST:event_J4boxActionPerformed

    private void J1FichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J1FichaActionPerformed
        active = false;
        generarModelo();
        J2Ficha.setModel(model.getModel());
        J2Ficha.setSelectedIndex(0);
        J2Ficha.removeItem(J1Ficha.getSelectedItem());

        J3Ficha.setSelectedIndex(0);

        active = true;

    }//GEN-LAST:event_J1FichaActionPerformed

    private void J2FichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J2FichaActionPerformed
        if (active) {

            active = false;
            generarModelo();
            J3Ficha.setModel(model.getModel());
            J3Ficha.setSelectedIndex(0);
            J3Ficha.removeItem(J2Ficha.getSelectedItem());
            J3Ficha.removeItem(J1Ficha.getSelectedItem());
            active = true;

        }

    }//GEN-LAST:event_J2FichaActionPerformed

    private void J3FichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J3FichaActionPerformed
          if (active) {

            active = false;
            generarModelo();
            J4Ficha.setModel(model.getModel());
            J4Ficha.setSelectedIndex(0);
            J4Ficha.removeItem(J3Ficha.getSelectedItem());
            J4Ficha.removeItem(J2Ficha.getSelectedItem());
            J4Ficha.removeItem(J1Ficha.getSelectedItem());
            active = true;

        }
    }//GEN-LAST:event_J3FichaActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Inicio;
    public static javax.swing.JComboBox<String> J1Ficha;
    public static javax.swing.JTextField J1Name;
    private javax.swing.JCheckBox J1box;
    public static javax.swing.JComboBox<String> J2Ficha;
    public static javax.swing.JTextField J2Name;
    private javax.swing.JCheckBox J2box;
    public static javax.swing.JComboBox<String> J3Ficha;
    public static javax.swing.JTextField J3Name;
    public static javax.swing.JCheckBox J3box;
    public static javax.swing.JComboBox<String> J4Ficha;
    public static javax.swing.JTextField J4Name;
    public static javax.swing.JCheckBox J4box;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jugar;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
