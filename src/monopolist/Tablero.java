/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolist;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static monopolist.Inicio.J4box;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class Tablero extends javax.swing.JFrame {

    Pintar P;
    JLabel ficha1, ficha2, ficha3, ficha4;
    static int x, y, turnoac = 1, dobles = 0;
    static int d1, d2, result;
    static Color marron = new Color(101, 54, 33);
    Color azulito = new Color(153, 204, 255);
    Color naranja = new Color(255, 140, 4);
    Color fucsia = new Color(255, 23, 145);
    static Color azulOscuro = new Color(0, 102, 204);
    Color verde = new Color(0, 102, 51);
    static Color blanco = new Color(255, 255, 255);
    Color chance = new Color(255, 102, 51);
    static Color palido = new Color(224, 226, 219);
    static Color neutro = new Color(51, 51, 55);
    Icon doble = new javax.swing.ImageIcon(getClass().getResource("/imagenes/doble.png"));
    Icon escape = new javax.swing.ImageIcon(getClass().getResource("/imagenes/salirGratis.png"));

    static Jugadores J[] = new Jugadores[4];

    static ListaTablero Tab = new ListaTablero();
    ListaCartas Chance = new ListaCartas();
    ListaCartas chest = new ListaCartas();
    Jugadores J1, J2, J3, J4, tempo;
    int perdieron = 0;

    ;
    fondoP fond = new fondoP();

    public Tablero() {
        this.setContentPane(fond);
        initComponents();

        LeerArchivo(2);

        infoj3.setVisible(false);
        infoj4.setVisible(false);

        P = new Pintar(Panel.getSize(), 1);
        Panel.add(P);

        ficha1 = new JLabel();
        ficha2 = new JLabel();
        ficha3 = new JLabel();
        ficha4 = new JLabel();
        Icon roja = new javax.swing.ImageIcon(getClass().getResource("/imagenes/Roja.png"));
        Icon azuli = new javax.swing.ImageIcon(getClass().getResource("/imagenes/Azul.png"));
        Icon amarilla = new javax.swing.ImageIcon(getClass().getResource("/imagenes/Amarilla.png"));
        Icon verd = new javax.swing.ImageIcon(getClass().getResource("/imagenes/Verde.png"));

        ficha1.setBounds(867, 667, 25, 25);
        if(!"".equals(Inicio.J1Name.getText())){
            J1 = new Jugadores(Inicio.J1Name.getText(), DecidirTurno.turno[0], ficha1, 1, j1dinero);
        }else{
            J1 = new Jugadores("P1", DecidirTurno.turno[0], ficha1, 1, j1dinero);
        }
        
        J[0] = J1;

        j1name.setText(J1.nick);
        String Select = Inicio.J1Ficha.getSelectedItem().toString();
        if (null != Select) {
            switch (Select) {
                case "Rojo":
                    //ficha1.setBackground(Color.red);
                    ficha1.setIcon(roja);
                    J1.selected = Color.red;
                    break;
                case "Azul":
                    //ficha1.setBackground(Color.blue);
                    ficha1.setIcon(azuli);
                    J1.selected = Color.blue;
                    break;
                case "Amarillo":
                    //ficha1.setBackground(Color.yellow);
                    ficha1.setIcon(amarilla);
                    J1.selected = Color.yellow;
                    break;
                case "Verde":
                    //ficha1.setBackground(Color.green);
                    ficha1.setIcon(verd);
                    J1.selected = Color.green;
                    break;
                default:
                    break;
            }
        }

        ficha1.setOpaque(false);

        ficha2.setBounds(867, 707, 25, 25);
        if(!"".equals(Inicio.J2Name.getText())){
            J2 = new Jugadores(Inicio.J2Name.getText(), DecidirTurno.turno[1], ficha2, 2, j1dinero2);
        }else{
            J2 = new Jugadores("P2", DecidirTurno.turno[1], ficha2, 2, j1dinero2);
        }
        J[1] = J2;
        j2name.setText(J2.nick);
        String Select2 = Inicio.J2Ficha.getSelectedItem().toString();
        if (null != Select2) {
            switch (Select2) {
                case "Rojo":

                    ficha2.setIcon(roja);
                    J2.selected = Color.red;

                    break;
                case "Azul":
                    ficha2.setIcon(azuli);
                    J2.selected = Color.blue;
                    break;
                case "Amarillo":

                    ficha2.setIcon(amarilla);
                    J2.selected = Color.yellow;
                    break;
                case "Verde":
                    J2.selected = Color.green;
                    ficha2.setIcon(verd);
                    break;
                default:
                    break;
            }
        }

        ficha2.setOpaque(false);
        if (Inicio.J3box.isSelected()) {
            if(!"".equals(Inicio.J3Name.getText())){
                J3 = new Jugadores(Inicio.J3Name.getText(), DecidirTurno.turno[2], ficha3, 3, j1dinero3);
            }else{
                J3 = new Jugadores("P3", DecidirTurno.turno[2], ficha3, 3, j1dinero3);
            }
            J[2] = J3;
            ficha3.setBounds(907, 707, 25, 25);
            j3name.setText(J3.nick);
            infoj3.setVisible(true);
            String Select3 = Inicio.J3Ficha.getSelectedItem().toString();
            if (null != Select3) {
                switch (Select3) {
                    case "Rojo":
                        J3.selected = Color.red;
                        ficha3.setIcon(roja);
                        break;
                    case "Azul":
                        J3.selected = Color.blue;
                        ficha3.setIcon(azuli);
                        break;
                    case "Amarillo":
                        J3.selected = Color.yellow;
                        ficha3.setIcon(amarilla);
                        break;
                    case "Verde":
                        J3.selected = Color.green;
                        ficha3.setIcon(verd);
                        break;
                    default:
                        break;
                }
                ficha3.setOpaque(false);
                P.add(ficha3);
            }
        }
        if (Inicio.J4box.isSelected()) {
            if(Inicio.J4Name.getText().isEmpty()==false){
                J4 = new Jugadores(Inicio.J4Name.getText(), DecidirTurno.turno[3], ficha4, 4, j1dinero4);
            }else{
                J4 = new Jugadores("P4", DecidirTurno.turno[3], ficha4, 4, j1dinero4);
            }
            J[3] = J4;
            ficha4.setBounds(907, 667, 25, 25);

            j4name.setText(J4.nick);

            infoj4.setVisible(true);
            String Select3 = Inicio.J4Ficha.getSelectedItem().toString();
            if (null != Select3) {
                switch (Select3) {
                    case "Rojo":

                        ficha4.setIcon(roja);
                        J4.selected = Color.red;
                        break;
                    case "Azul":
                        J4.selected = Color.blue;
                        ficha4.setIcon(azuli);
                        break;
                    case "Amarillo":
                        J4.selected = Color.yellow;
                        ficha4.setIcon(amarilla);
                        break;
                    case "Verde":
                        J4.selected = Color.green;
                        ficha4.setIcon(verd);
                        break;
                    default:
                        break;
                }
                ficha4.setOpaque(false);
                P.add(ficha4);
            }
        }
        P.add(ficha1);
        P.add(ficha2);
        turnojugar.setText("Turno de: " + BuscarTurno(turnoac, J).nick);
        lanzar.setBackground(BuscarTurno(turnoac, J).selected);
        tempo = BuscarTurno(turnoac, J);
        LeerArchivo(1);
        LeerArchivo(3);
    }

    public void LeerArchivo(int op) {
        FileReader archivo;
        BufferedReader lector;

        try {
            switch (op) {
                case 1:
                    archivo = new FileReader("src\\recursos\\chance.txt");
                    lector = new BufferedReader(archivo);
                    String linea;

                    while ((linea = lector.readLine()) != null) {
                        String[] splited = linea.split(";");
                        CartasSuerte Cart = new CartasSuerte(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));
                        Chance.addNode(Cart);

                    }
                    archivo.close();
                    break;
                case 2:
                    archivo = new FileReader("src\\recursos\\casillas.txt");
                    lector = new BufferedReader(archivo);
                    String renglon;

                    //Casillas(String nombre, double ValV, double ValR, int x, int y, int num, Color col)
                    while ((renglon = lector.readLine()) != null) {
                        String[] splited = renglon.split(",");
                        Color actual = null;
                        switch (splited[6]) {
                            case "marron":
                                actual = marron;
                                break;
                            case "azulito":
                                actual = azulito;
                                break;
                            case "naranja":
                                actual = naranja;
                                break;
                            case "fucsia":
                                actual = fucsia;
                                break;
                            case "azulOscuro":
                                actual = azulOscuro;
                                break;
                            case "verde":
                                actual = verde;
                                break;
                            case "blanco":
                                actual = blanco;
                                break;
                            case "Color.red":
                                actual = Color.red;
                                break;
                            case "Color.yellow":
                                actual = Color.yellow;
                                break;
                            case "palido":
                                actual = palido;
                                break;

                        }
                        Casillas C = new Casillas(splited[0], Double.parseDouble(splited[1]), Double.parseDouble(splited[2]),
                                Integer.parseInt(splited[3]), Integer.parseInt(splited[4]), Integer.parseInt(splited[5]), actual);
                        Tab.addNode(C);

                    }
                    archivo.close();
                    break;
                case 3:
                    archivo = new FileReader("src\\recursos\\chest.txt");
                    lector = new BufferedReader(archivo);
                    String line;

                    while ((line = lector.readLine()) != null) {
                        String[] splited = line.split(";");
                        CartasSuerte Cart = new CartasSuerte(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));
                        chest.addNode(Cart);

                    }
                    archivo.close();
                    break;
            }

            System.out.println("Archivo leido");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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

        Panel = new javax.swing.JPanel();
        infoj1 = new javax.swing.JPanel();
        j1name = new javax.swing.JLabel();
        money = new javax.swing.JLabel();
        prop = new javax.swing.JLabel();
        pl = new javax.swing.JLabel();
        tai = new javax.swing.JLabel();
        pm = new javax.swing.JLabel();
        bws = new javax.swing.JLabel();
        st = new javax.swing.JLabel();
        lcs = new javax.swing.JLabel();
        rs = new javax.swing.JLabel();
        kcs = new javax.swing.JLabel();
        ec = new javax.swing.JLabel();
        ww = new javax.swing.JLabel();
        mrs = new javax.swing.JLabel();
        oxs = new javax.swing.JLabel();
        cvs = new javax.swing.JLabel();
        fls = new javax.swing.JLabel();
        mbs = new javax.swing.JLabel();
        wh = new javax.swing.JLabel();
        er = new javax.swing.JLabel();
        my = new javax.swing.JLabel();
        lss = new javax.swing.JLabel();
        fss = new javax.swing.JLabel();
        bs = new javax.swing.JLabel();
        pcd = new javax.swing.JLabel();
        trs = new javax.swing.JLabel();
        vns = new javax.swing.JLabel();
        nda = new javax.swing.JLabel();
        pr = new javax.swing.JLabel();
        okr = new javax.swing.JLabel();
        wr = new javax.swing.JLabel();
        j1dinero = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ProName = new javax.swing.JLabel();
        alquiler = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        dado2 = new javax.swing.JLabel();
        turnojugar = new javax.swing.JLabel();
        dado1 = new javax.swing.JLabel();
        lanzar = new javax.swing.JButton();
        Tot = new javax.swing.JTextField();
        info = new javax.swing.JLabel();
        comprar = new javax.swing.JButton();
        pasar = new javax.swing.JButton();
        tomar = new javax.swing.JButton();
        Pagar = new javax.swing.JButton();
        manejar = new javax.swing.JButton();
        quebrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Historial = new javax.swing.JTextArea();
        infoj2 = new javax.swing.JPanel();
        j2name = new javax.swing.JLabel();
        money1 = new javax.swing.JLabel();
        prop4 = new javax.swing.JLabel();
        pl4 = new javax.swing.JLabel();
        tai4 = new javax.swing.JLabel();
        pm4 = new javax.swing.JLabel();
        bws4 = new javax.swing.JLabel();
        st4 = new javax.swing.JLabel();
        lcs4 = new javax.swing.JLabel();
        rs4 = new javax.swing.JLabel();
        kcs4 = new javax.swing.JLabel();
        ec4 = new javax.swing.JLabel();
        ww4 = new javax.swing.JLabel();
        mrs4 = new javax.swing.JLabel();
        oxs4 = new javax.swing.JLabel();
        cvs4 = new javax.swing.JLabel();
        fls4 = new javax.swing.JLabel();
        mbs4 = new javax.swing.JLabel();
        wh4 = new javax.swing.JLabel();
        er4 = new javax.swing.JLabel();
        my4 = new javax.swing.JLabel();
        lss4 = new javax.swing.JLabel();
        fss4 = new javax.swing.JLabel();
        bs4 = new javax.swing.JLabel();
        pcd4 = new javax.swing.JLabel();
        trs4 = new javax.swing.JLabel();
        vns4 = new javax.swing.JLabel();
        nda4 = new javax.swing.JLabel();
        pr4 = new javax.swing.JLabel();
        okr4 = new javax.swing.JLabel();
        wr4 = new javax.swing.JLabel();
        j1dinero2 = new javax.swing.JLabel();
        salir4 = new javax.swing.JLabel();
        infoj3 = new javax.swing.JPanel();
        j3name = new javax.swing.JLabel();
        money2 = new javax.swing.JLabel();
        prop5 = new javax.swing.JLabel();
        pl5 = new javax.swing.JLabel();
        tai5 = new javax.swing.JLabel();
        pm5 = new javax.swing.JLabel();
        bws5 = new javax.swing.JLabel();
        st5 = new javax.swing.JLabel();
        lcs5 = new javax.swing.JLabel();
        rs5 = new javax.swing.JLabel();
        kcs5 = new javax.swing.JLabel();
        ec5 = new javax.swing.JLabel();
        ww5 = new javax.swing.JLabel();
        mrs5 = new javax.swing.JLabel();
        oxs5 = new javax.swing.JLabel();
        cvs5 = new javax.swing.JLabel();
        fls5 = new javax.swing.JLabel();
        mbs5 = new javax.swing.JLabel();
        wh5 = new javax.swing.JLabel();
        er5 = new javax.swing.JLabel();
        my5 = new javax.swing.JLabel();
        lss5 = new javax.swing.JLabel();
        fss5 = new javax.swing.JLabel();
        bs5 = new javax.swing.JLabel();
        pcd5 = new javax.swing.JLabel();
        trs5 = new javax.swing.JLabel();
        vns5 = new javax.swing.JLabel();
        nda5 = new javax.swing.JLabel();
        pr5 = new javax.swing.JLabel();
        okr5 = new javax.swing.JLabel();
        wr5 = new javax.swing.JLabel();
        j1dinero3 = new javax.swing.JLabel();
        salir5 = new javax.swing.JLabel();
        infoj4 = new javax.swing.JPanel();
        j4name = new javax.swing.JLabel();
        money3 = new javax.swing.JLabel();
        prop6 = new javax.swing.JLabel();
        pl6 = new javax.swing.JLabel();
        tai6 = new javax.swing.JLabel();
        pm6 = new javax.swing.JLabel();
        bws6 = new javax.swing.JLabel();
        st6 = new javax.swing.JLabel();
        lcs6 = new javax.swing.JLabel();
        rs6 = new javax.swing.JLabel();
        kcs6 = new javax.swing.JLabel();
        ec6 = new javax.swing.JLabel();
        ww6 = new javax.swing.JLabel();
        mrs6 = new javax.swing.JLabel();
        oxs6 = new javax.swing.JLabel();
        cvs6 = new javax.swing.JLabel();
        fls6 = new javax.swing.JLabel();
        mbs6 = new javax.swing.JLabel();
        wh6 = new javax.swing.JLabel();
        er6 = new javax.swing.JLabel();
        my6 = new javax.swing.JLabel();
        lss6 = new javax.swing.JLabel();
        fss6 = new javax.swing.JLabel();
        bs6 = new javax.swing.JLabel();
        pcd6 = new javax.swing.JLabel();
        trs6 = new javax.swing.JLabel();
        vns6 = new javax.swing.JLabel();
        nda6 = new javax.swing.JLabel();
        pr6 = new javax.swing.JLabel();
        okr6 = new javax.swing.JLabel();
        wr6 = new javax.swing.JLabel();
        j1dinero4 = new javax.swing.JLabel();
        salir6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.green);
        setResizable(false);

        Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );

        infoj1.setBackground(new java.awt.Color(204, 255, 204));

        j1name.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        j1name.setForeground(new java.awt.Color(255, 51, 51));
        j1name.setText("Name1");

        money.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        money.setForeground(new java.awt.Color(255, 51, 51));
        money.setText("Money$ :");

        prop.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        prop.setForeground(new java.awt.Color(255, 51, 51));
        prop.setText("Propiedades");

        pl.setToolTipText("Park Lane");
        pl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pl.setOpaque(true);

        tai.setToolTipText("The Angel Islington");
        tai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tai.setOpaque(true);

        pm.setToolTipText("Pall Mall");
        pm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pm.setOpaque(true);

        bws.setToolTipText("Bow Street");
        bws.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bws.setOpaque(true);

        st.setToolTipText("Strand");
        st.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        st.setOpaque(true);

        lcs.setToolTipText("Leicester Square");
        lcs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lcs.setOpaque(true);

        rs.setToolTipText("Regent Street");
        rs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rs.setOpaque(true);

        kcs.setToolTipText("King Cross Station");
        kcs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kcs.setOpaque(true);

        ec.setToolTipText("Electric Company");
        ec.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ec.setOpaque(true);

        ww.setToolTipText("Water Works");
        ww.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ww.setOpaque(true);

        mrs.setToolTipText("Marylebone Station");
        mrs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mrs.setOpaque(true);

        oxs.setToolTipText("Oxford Street");
        oxs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oxs.setOpaque(true);

        cvs.setToolTipText("Conventry Street");
        cvs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cvs.setOpaque(true);

        fls.setToolTipText("Fleet Street");
        fls.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fls.setOpaque(true);

        mbs.setToolTipText("Marlborough Street");
        mbs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mbs.setOpaque(true);

        wh.setToolTipText("Whitehall");
        wh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wh.setOpaque(true);

        er.setToolTipText("Euston Road");
        er.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        er.setOpaque(true);

        my.setToolTipText("Myfair");
        my.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        my.setOpaque(true);

        lss.setToolTipText("Liverpool st station");
        lss.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lss.setOpaque(true);

        fss.setToolTipText("Fenchurch st station");
        fss.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fss.setOpaque(true);

        bs.setToolTipText("Bond Street");
        bs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bs.setOpaque(true);

        pcd.setToolTipText("Piccadilly");
        pcd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pcd.setOpaque(true);

        trs.setToolTipText("Trafalgar Sqare");
        trs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        trs.setOpaque(true);

        vns.setToolTipText("Vine Street");
        vns.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        vns.setOpaque(true);

        nda.setToolTipText("Northumrld Avenue");
        nda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nda.setOpaque(true);

        pr.setToolTipText("Pentonville Road");
        pr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pr.setOpaque(true);

        okr.setToolTipText("Old Kent Road");
        okr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        okr.setOpaque(true);

        wr.setToolTipText("Whitechaper Road");
        wr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wr.setOpaque(true);

        j1dinero.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        j1dinero.setForeground(new java.awt.Color(0, 204, 0));
        j1dinero.setText("$1500");

        salir.setToolTipText("Salir de la carcel");
        salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salir.setOpaque(true);

        javax.swing.GroupLayout infoj1Layout = new javax.swing.GroupLayout(infoj1);
        infoj1.setLayout(infoj1Layout);
        infoj1Layout.setHorizontalGroup(
            infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoj1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoj1Layout.createSequentialGroup()
                        .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(j1name, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j1dinero, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoj1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(prop, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infoj1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(infoj1Layout.createSequentialGroup()
                                        .addComponent(okr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bws, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lcs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(kcs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ec, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(infoj1Layout.createSequentialGroup()
                                        .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(infoj1Layout.createSequentialGroup()
                                                .addComponent(wr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(my, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(infoj1Layout.createSequentialGroup()
                                                .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nda, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vns, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(trs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pcd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lss, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fss, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(infoj1Layout.createSequentialGroup()
                                                .addComponent(er, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mbs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fls, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cvs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(oxs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mrs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ww, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        infoj1Layout.setVerticalGroup(
            infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoj1Layout.createSequentialGroup()
                .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoj1Layout.createSequentialGroup()
                        .addComponent(prop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bws, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(st, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lcs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(kcs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoj1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(j1name)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(my, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(wh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mbs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fls, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cvs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oxs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(er, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mrs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ww, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(wr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(money))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vns, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pcd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fss, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j1dinero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lss, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ProName.setBackground(new java.awt.Color(255, 255, 255));
        ProName.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        ProName.setForeground(new java.awt.Color(0, 0, 0));
        ProName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProName.setText("TITULO");
        ProName.setOpaque(true);

        alquiler.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        alquiler.setForeground(new java.awt.Color(0, 0, 0));
        alquiler.setText("Alquiler: $ ");

        precio.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        precio.setForeground(new java.awt.Color(0, 0, 0));
        precio.setText("Precio: $");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alquiler, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(ProName, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alquiler, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        dado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cara2.png"))); // NOI18N

        turnojugar.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        turnojugar.setForeground(new java.awt.Color(255, 0, 51));
        turnojugar.setText("TURNO: 1");

        dado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cara1.png"))); // NOI18N

        lanzar.setBackground(new java.awt.Color(153, 153, 153));
        lanzar.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        lanzar.setForeground(new java.awt.Color(0, 0, 0));
        lanzar.setText("LANZAR");
        lanzar.setToolTipText("LANZAR");
        lanzar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lanzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lanzar.setName(""); // NOI18N
        lanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lanzarActionPerformed(evt);
            }
        });

        Tot.setEditable(false);
        Tot.setBackground(new java.awt.Color(204, 255, 204));
        Tot.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        Tot.setForeground(new java.awt.Color(0, 0, 0));
        Tot.setBorder(null);

        info.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        info.setForeground(new java.awt.Color(255, 51, 51));
        info.setText("Info Casilla");

        comprar.setBackground(new java.awt.Color(255, 102, 102));
        comprar.setFont(new java.awt.Font("Eras Bold ITC", 3, 14)); // NOI18N
        comprar.setText("COMPRAR");
        comprar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comprar.setEnabled(false);
        comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarActionPerformed(evt);
            }
        });

        pasar.setBackground(new java.awt.Color(102, 204, 255));
        pasar.setFont(new java.awt.Font("Eras Bold ITC", 3, 14)); // NOI18N
        pasar.setText("Pasar Turno");
        pasar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pasar.setEnabled(false);
        pasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarActionPerformed(evt);
            }
        });

        tomar.setBackground(new java.awt.Color(102, 204, 255));
        tomar.setFont(new java.awt.Font("Eras Bold ITC", 3, 14)); // NOI18N
        tomar.setText("Tomar carta");
        tomar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tomar.setEnabled(false);
        tomar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomarActionPerformed(evt);
            }
        });

        Pagar.setBackground(new java.awt.Color(255, 153, 102));
        Pagar.setFont(new java.awt.Font("Eras Bold ITC", 3, 14)); // NOI18N
        Pagar.setText("Pagar");
        Pagar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Pagar.setEnabled(false);
        Pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagarActionPerformed(evt);
            }
        });

        manejar.setBackground(new java.awt.Color(255, 102, 102));
        manejar.setFont(new java.awt.Font("Eras Bold ITC", 3, 14)); // NOI18N
        manejar.setText("Manejar Propiedades");
        manejar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        manejar.setEnabled(false);
        manejar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manejarActionPerformed(evt);
            }
        });

        quebrar.setBackground(new java.awt.Color(153, 153, 153));
        quebrar.setFont(new java.awt.Font("Eras Bold ITC", 3, 14)); // NOI18N
        quebrar.setForeground(new java.awt.Color(255, 255, 255));
        quebrar.setText("Bancarrota");
        quebrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        quebrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quebrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(manejar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tomar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comprar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pasar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Pagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lanzar, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dado1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(turnojugar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dado2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Tot, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))
                    .addComponent(quebrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(dado1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(dado2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(turnojugar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tot, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pasar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tomar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manejar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quebrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Historial.setEditable(false);
        Historial.setBackground(new java.awt.Color(204, 255, 204));
        Historial.setColumns(20);
        Historial.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        Historial.setForeground(new java.awt.Color(255, 51, 51));
        Historial.setRows(5);
        jScrollPane1.setViewportView(Historial);

        infoj2.setBackground(new java.awt.Color(204, 255, 204));

        j2name.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        j2name.setForeground(new java.awt.Color(255, 51, 51));
        j2name.setText("Name1");

        money1.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        money1.setForeground(new java.awt.Color(255, 51, 51));
        money1.setText("Money$ :");

        prop4.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        prop4.setForeground(new java.awt.Color(255, 51, 51));
        prop4.setText("Propiedades");

        pl4.setToolTipText("Park Lane");
        pl4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pl4.setOpaque(true);

        tai4.setToolTipText("The Angel Islington");
        tai4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tai4.setOpaque(true);

        pm4.setToolTipText("Pall Mall");
        pm4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pm4.setOpaque(true);

        bws4.setToolTipText("Bow Street");
        bws4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bws4.setOpaque(true);

        st4.setToolTipText("Strand");
        st4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        st4.setOpaque(true);

        lcs4.setToolTipText("Leicester Square");
        lcs4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lcs4.setOpaque(true);

        rs4.setToolTipText("Regent Street");
        rs4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rs4.setOpaque(true);

        kcs4.setToolTipText("King Cross Station");
        kcs4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kcs4.setOpaque(true);

        ec4.setToolTipText("Electric Company");
        ec4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ec4.setOpaque(true);

        ww4.setToolTipText("Water Works");
        ww4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ww4.setOpaque(true);

        mrs4.setToolTipText("Marylebone Station");
        mrs4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mrs4.setOpaque(true);

        oxs4.setToolTipText("Oxford Street");
        oxs4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oxs4.setOpaque(true);

        cvs4.setToolTipText("Conventry Street");
        cvs4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cvs4.setOpaque(true);

        fls4.setToolTipText("Fleet Street");
        fls4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fls4.setOpaque(true);

        mbs4.setToolTipText("Marlborough Street");
        mbs4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mbs4.setOpaque(true);

        wh4.setToolTipText("Whitehall");
        wh4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wh4.setOpaque(true);

        er4.setToolTipText("Euston Road");
        er4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        er4.setOpaque(true);

        my4.setToolTipText("Myfair");
        my4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        my4.setOpaque(true);

        lss4.setToolTipText("Liverpool st station");
        lss4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lss4.setOpaque(true);

        fss4.setToolTipText("Fenchurch st station");
        fss4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fss4.setOpaque(true);

        bs4.setToolTipText("Bond Street");
        bs4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bs4.setOpaque(true);

        pcd4.setToolTipText("Piccadilly");
        pcd4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pcd4.setOpaque(true);

        trs4.setToolTipText("Trafalgar Sqare");
        trs4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        trs4.setOpaque(true);

        vns4.setToolTipText("Vine Street");
        vns4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        vns4.setOpaque(true);

        nda4.setToolTipText("Northumrld Avenue");
        nda4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nda4.setOpaque(true);

        pr4.setToolTipText("Pentonville Road");
        pr4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pr4.setOpaque(true);

        okr4.setToolTipText("Old Kent Road");
        okr4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        okr4.setOpaque(true);

        wr4.setToolTipText("Whitechaper Road");
        wr4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wr4.setOpaque(true);

        j1dinero2.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        j1dinero2.setForeground(new java.awt.Color(0, 204, 0));
        j1dinero2.setText("$1500");

        salir4.setToolTipText("Salir de la carcel");
        salir4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salir4.setOpaque(true);

        javax.swing.GroupLayout infoj2Layout = new javax.swing.GroupLayout(infoj2);
        infoj2.setLayout(infoj2Layout);
        infoj2Layout.setHorizontalGroup(
            infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoj2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoj2Layout.createSequentialGroup()
                        .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(j2name, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j1dinero2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoj2Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(prop4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infoj2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(infoj2Layout.createSequentialGroup()
                                        .addComponent(okr4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pl4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tai4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pm4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bws4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(st4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lcs4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rs4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(kcs4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ec4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(infoj2Layout.createSequentialGroup()
                                        .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(infoj2Layout.createSequentialGroup()
                                                .addComponent(wr4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(my4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(salir4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(infoj2Layout.createSequentialGroup()
                                                .addComponent(pr4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nda4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vns4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(trs4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pcd4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bs4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lss4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fss4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(infoj2Layout.createSequentialGroup()
                                                .addComponent(er4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wh4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mbs4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fls4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cvs4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(oxs4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mrs4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ww4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addComponent(money1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        infoj2Layout.setVerticalGroup(
            infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoj2Layout.createSequentialGroup()
                .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoj2Layout.createSequentialGroup()
                        .addComponent(prop4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pm4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bws4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(st4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lcs4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rs4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tai4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okr4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(kcs4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ec4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoj2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(j2name)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(my4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(wh4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mbs4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fls4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cvs4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oxs4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(er4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mrs4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ww4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(wr4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(money1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nda4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vns4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trs4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pcd4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bs4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pr4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fss4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j1dinero2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lss4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoj3.setBackground(new java.awt.Color(204, 255, 204));

        j3name.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        j3name.setForeground(new java.awt.Color(255, 51, 51));
        j3name.setText("Name1");

        money2.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        money2.setForeground(new java.awt.Color(255, 51, 51));
        money2.setText("Money$ :");

        prop5.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        prop5.setForeground(new java.awt.Color(255, 51, 51));
        prop5.setText("Propiedades");

        pl5.setToolTipText("Park Lane");
        pl5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pl5.setOpaque(true);

        tai5.setToolTipText("The Angel Islington");
        tai5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tai5.setOpaque(true);

        pm5.setToolTipText("Pall Mall");
        pm5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pm5.setOpaque(true);

        bws5.setToolTipText("Bow Street");
        bws5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bws5.setOpaque(true);

        st5.setToolTipText("Strand");
        st5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        st5.setOpaque(true);

        lcs5.setToolTipText("Leicester Square");
        lcs5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lcs5.setOpaque(true);

        rs5.setToolTipText("Regent Street");
        rs5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rs5.setOpaque(true);

        kcs5.setToolTipText("King Cross Station");
        kcs5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kcs5.setOpaque(true);

        ec5.setToolTipText("Electric Company");
        ec5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ec5.setOpaque(true);

        ww5.setToolTipText("Water Works");
        ww5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ww5.setOpaque(true);

        mrs5.setToolTipText("Marylebone Station");
        mrs5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mrs5.setOpaque(true);

        oxs5.setToolTipText("Oxford Street");
        oxs5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oxs5.setOpaque(true);

        cvs5.setToolTipText("Conventry Street");
        cvs5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cvs5.setOpaque(true);

        fls5.setToolTipText("Fleet Street");
        fls5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fls5.setOpaque(true);

        mbs5.setToolTipText("Marlborough Street");
        mbs5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mbs5.setOpaque(true);

        wh5.setToolTipText("Whitehall");
        wh5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wh5.setOpaque(true);

        er5.setToolTipText("Euston Road");
        er5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        er5.setOpaque(true);

        my5.setToolTipText("Myfair");
        my5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        my5.setOpaque(true);

        lss5.setToolTipText("Liverpool st station");
        lss5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lss5.setOpaque(true);

        fss5.setToolTipText("Fenchurch st station");
        fss5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fss5.setOpaque(true);

        bs5.setToolTipText("Bond Street");
        bs5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bs5.setOpaque(true);

        pcd5.setToolTipText("Piccadilly");
        pcd5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pcd5.setOpaque(true);

        trs5.setToolTipText("Trafalgar Sqare");
        trs5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        trs5.setOpaque(true);

        vns5.setToolTipText("Vine Street");
        vns5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        vns5.setOpaque(true);

        nda5.setToolTipText("Northumrld Avenue");
        nda5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nda5.setOpaque(true);

        pr5.setToolTipText("Pentonville Road");
        pr5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pr5.setOpaque(true);

        okr5.setToolTipText("Old Kent Road");
        okr5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        okr5.setOpaque(true);

        wr5.setToolTipText("Whitechaper Road");
        wr5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wr5.setOpaque(true);

        j1dinero3.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        j1dinero3.setForeground(new java.awt.Color(0, 204, 0));
        j1dinero3.setText("$1500");

        salir5.setToolTipText("Salir de la carcel");
        salir5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salir5.setOpaque(true);

        javax.swing.GroupLayout infoj3Layout = new javax.swing.GroupLayout(infoj3);
        infoj3.setLayout(infoj3Layout);
        infoj3Layout.setHorizontalGroup(
            infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoj3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoj3Layout.createSequentialGroup()
                        .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(j3name, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j1dinero3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoj3Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(prop5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infoj3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(infoj3Layout.createSequentialGroup()
                                        .addComponent(okr5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pl5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tai5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pm5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bws5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(st5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lcs5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rs5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(kcs5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ec5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(infoj3Layout.createSequentialGroup()
                                        .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(infoj3Layout.createSequentialGroup()
                                                .addComponent(wr5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(my5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(salir5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(infoj3Layout.createSequentialGroup()
                                                .addComponent(pr5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nda5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vns5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(trs5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pcd5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bs5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lss5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fss5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(infoj3Layout.createSequentialGroup()
                                                .addComponent(er5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wh5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mbs5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fls5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cvs5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(oxs5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mrs5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ww5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addComponent(money2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        infoj3Layout.setVerticalGroup(
            infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoj3Layout.createSequentialGroup()
                .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoj3Layout.createSequentialGroup()
                        .addComponent(prop5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pm5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bws5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(st5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lcs5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rs5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tai5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okr5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(kcs5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ec5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoj3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(j3name)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(my5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(wh5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mbs5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fls5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cvs5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oxs5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(er5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mrs5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ww5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(wr5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(money2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nda5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vns5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trs5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pcd5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bs5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pr5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fss5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j1dinero3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lss5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoj4.setBackground(new java.awt.Color(204, 255, 204));

        j4name.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        j4name.setForeground(new java.awt.Color(255, 51, 51));
        j4name.setText("Name1");

        money3.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        money3.setForeground(new java.awt.Color(255, 51, 51));
        money3.setText("Money$ :");

        prop6.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        prop6.setForeground(new java.awt.Color(255, 51, 51));
        prop6.setText("Propiedades");

        pl6.setToolTipText("Park Lane");
        pl6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pl6.setOpaque(true);

        tai6.setToolTipText("The Angel Islington");
        tai6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tai6.setOpaque(true);

        pm6.setToolTipText("Pall Mall");
        pm6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pm6.setOpaque(true);

        bws6.setToolTipText("Bow Street");
        bws6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bws6.setOpaque(true);

        st6.setToolTipText("Strand");
        st6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        st6.setOpaque(true);

        lcs6.setToolTipText("Leicester Square");
        lcs6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lcs6.setOpaque(true);

        rs6.setToolTipText("Regent Street");
        rs6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rs6.setOpaque(true);

        kcs6.setToolTipText("King Cross Station");
        kcs6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kcs6.setOpaque(true);

        ec6.setToolTipText("Electric Company");
        ec6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ec6.setOpaque(true);

        ww6.setToolTipText("Water Works");
        ww6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ww6.setOpaque(true);

        mrs6.setToolTipText("Marylebone Station");
        mrs6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mrs6.setOpaque(true);

        oxs6.setToolTipText("Oxford Street");
        oxs6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oxs6.setOpaque(true);

        cvs6.setToolTipText("Conventry Street");
        cvs6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cvs6.setOpaque(true);

        fls6.setToolTipText("Fleet Street");
        fls6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fls6.setOpaque(true);

        mbs6.setToolTipText("Marlborough Street");
        mbs6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mbs6.setOpaque(true);

        wh6.setToolTipText("Whitehall");
        wh6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wh6.setOpaque(true);

        er6.setToolTipText("Euston Road");
        er6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        er6.setOpaque(true);

        my6.setToolTipText("Myfair");
        my6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        my6.setOpaque(true);

        lss6.setToolTipText("Liverpool st station");
        lss6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lss6.setOpaque(true);

        fss6.setToolTipText("Fenchurch st station");
        fss6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fss6.setOpaque(true);

        bs6.setToolTipText("Bond Street");
        bs6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bs6.setOpaque(true);

        pcd6.setToolTipText("Piccadilly");
        pcd6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pcd6.setOpaque(true);

        trs6.setToolTipText("Trafalgar Sqare");
        trs6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        trs6.setOpaque(true);

        vns6.setToolTipText("Vine Street");
        vns6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        vns6.setOpaque(true);

        nda6.setToolTipText("Northumrld Avenue");
        nda6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nda6.setOpaque(true);

        pr6.setToolTipText("Pentonville Road");
        pr6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pr6.setOpaque(true);

        okr6.setToolTipText("Old Kent Road");
        okr6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        okr6.setOpaque(true);

        wr6.setToolTipText("Whitechaper Road");
        wr6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wr6.setOpaque(true);

        j1dinero4.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        j1dinero4.setForeground(new java.awt.Color(0, 204, 0));
        j1dinero4.setText("$1500");

        salir6.setToolTipText("Salir de la carcel");
        salir6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salir6.setOpaque(true);

        javax.swing.GroupLayout infoj4Layout = new javax.swing.GroupLayout(infoj4);
        infoj4.setLayout(infoj4Layout);
        infoj4Layout.setHorizontalGroup(
            infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoj4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoj4Layout.createSequentialGroup()
                        .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(j4name, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j1dinero4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoj4Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(prop6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infoj4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(infoj4Layout.createSequentialGroup()
                                        .addComponent(okr6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pl6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tai6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pm6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bws6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(st6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lcs6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rs6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(kcs6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ec6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(infoj4Layout.createSequentialGroup()
                                        .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(infoj4Layout.createSequentialGroup()
                                                .addComponent(wr6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(my6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(salir6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(infoj4Layout.createSequentialGroup()
                                                .addComponent(pr6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nda6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vns6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(trs6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pcd6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bs6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lss6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fss6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(infoj4Layout.createSequentialGroup()
                                                .addComponent(er6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wh6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mbs6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fls6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cvs6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(oxs6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mrs6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ww6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addComponent(money3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        infoj4Layout.setVerticalGroup(
            infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoj4Layout.createSequentialGroup()
                .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoj4Layout.createSequentialGroup()
                        .addComponent(prop6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pm6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bws6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(st6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lcs6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rs6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tai6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okr6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(kcs6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ec6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoj4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(j4name)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(my6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(wh6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mbs6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fls6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cvs6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oxs6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(er6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mrs6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ww6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(wr6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(money3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nda6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vns6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trs6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pcd6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bs6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pr6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fss6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(j1dinero4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoj4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lss6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoj1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(infoj2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoj3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoj4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoj1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoj2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoj3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoj4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static Jugadores BuscarTurno(int turno, Jugadores vector[]) {

        boolean encontrado = false;
        int i = 0;
        while (i < vector.length & encontrado == false) {

            if (vector[i].turno == turno) {

                encontrado = true;

            } else {
                i++;
            }

        }
        return vector[i];
    }


    private void lanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lanzarActionPerformed

        new JFXPanel();
        String dd = new File("dados.mp3").toURI().toString();
        new MediaPlayer(new Media(dd)).play();

        d1 = (int) (Math.random() * 6) + 1;
        d2 = (int) (Math.random() * 6) + 1;
        result = d1 + d2;

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
        Jugadores tem = BuscarTurno(turnoac, J);
        if (tem.preso == false) {
            Pagar.setVisible(false);
            Tab.MoverFicha(tem, result, tem.NroJugador);
        } else {

            Historial.setText(Historial.getText() + "\n" + tem.nick + " está en la carcel, puede salir sacando un doble o pagando $50");
        }

        if (d1 == d2) {

            Pagar.setVisible(false);
            Pagar.setEnabled(false);

            if (tem.preso == true) {
                tem.preso = false;
                Historial.setText(Historial.getText() + "\n" + tem.nick + " ¡Ya es libre!");
            }
            dobles++;
            JOptionPane.showMessageDialog(null, "<html><p style=\" color:yellow; font:20px; \"> ¡SACASTE DOBLE! <p><html>",
                    "Dobles ", JOptionPane.PLAIN_MESSAGE, doble);
            pasar.setEnabled(false);
            switch (dobles) {
                case 1:
                    Historial.setText(Historial.getText() + "\n" + tem.nick + " sacó doble, puede tirar nuevamente");
                    break;
                case 2:
                    Historial.setText(Historial.getText() + "\n" + tem.nick + " sacó doble nuevamente, cuidado con sacar el tercer doble..");
                    break;
                case 3:
                    tem.Encarcelar();
                    break;
                default:
                    break;
            }

        } else {
            dobles = 0;
            if (ListaTablero.debeSacar == true) {
                pasar.setEnabled(false);

            } else {
                
                    pasar.setEnabled(true);
                
                
            }

            lanzar.setEnabled(false);
        }
        if(tem.enApuros==true){
            pasar.setEnabled(false);
            manejar.setEnabled(true);
            lanzar.setEnabled(false);
        }


    }//GEN-LAST:event_lanzarActionPerformed

    private void comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarActionPerformed

        Tab.ComprarPropiedad(BuscarTurno(turnoac, J));


    }//GEN-LAST:event_comprarActionPerformed

    private void pasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarActionPerformed

        info.setText("");
        lanzar.setEnabled(true);

        if (d1 != d2) {
            do {
                if (turnoac < DecidirTurno.players) {
                    turnoac++;
                } else if (turnoac >= DecidirTurno.players) {
                    turnoac = 1;
                }

            } while (BuscarTurno(turnoac, J).bancarrota == true);

            lanzar.setBackground(BuscarTurno(turnoac, J).selected);
        }
        if (BuscarTurno(turnoac, J).preso == true) {
            if (BuscarTurno(turnoac, J).salirGratis == true) {
                Pagar.setText("Usar Carta");
            } else {
                Pagar.setText("Pagar");
            }
            Pagar.setVisible(true);
            Pagar.setEnabled(true);
        } else {
            Pagar.setVisible(false);
            Pagar.setEnabled(false);
        }
        turnojugar.setText("Turno de: " + BuscarTurno(turnoac, J).nick);
        pasar.setEnabled(false);

        comprar.setEnabled(false);
        if (BuscarTurno(turnoac, J).CantPropiedades > 0) {
            manejar.setEnabled(true);
        } else {
            manejar.setEnabled(false);
        }
        quebrar.setEnabled(true);
    }//GEN-LAST:event_pasarActionPerformed

    public static String ToHTML(String cad) {
        return "<html><p>" + cad + "</p></html>";
    }

    public void ilumSalirCarcel(int NroJug, Color ilum) {
        switch (NroJug) {
            case 1:
                salir.setBackground(ilum);
                break;
            case 2:
                salir4.setBackground(ilum);
                break;
            case 3:
                salir5.setBackground(ilum);
                break;
            case 4:
                salir6.setBackground(ilum);

                break;
        }
    }

    private void tomarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomarActionPerformed
        new JFXPanel();
        String dd = "";
        Jugadores act = BuscarTurno(turnoac, J);
        if (ListaTablero.chest == true) {
            dd = new File("cofre.mp3").toURI().toString();
            new MediaPlayer(new Media(dd)).play();
        } else {
            dd = new File("carta.mp3").toURI().toString();
            new MediaPlayer(new Media(dd)).play();
        }

        especiales T = new especiales();
        T.setVisible(true);
        String cad;
        //si chest=true entonces muestra una carta de comunidad, sino una de chance
        if (ListaTablero.chest == true) {
            especiales.fondo.setBackground(Color.yellow);
            int Nro = (int) (Math.random() * (15 - 1)) + 1;
            if (Nro == 13) {
                if (act.salirGratis == false) {
                    act.salirGratis = true;
                    ilumSalirCarcel(act.NroJugador, Color.YELLOW);
                } else {
                    while (Nro == 13) {
                        Nro = (int) (Math.random() * (15 - 1)) + 1;
                    }
                }

            }
            //se genera un numero random y se busca en la lista donde estan las cartas para luego mostrar la info en pantalla
            cad = chest.BuscarCarta(Nro, act).descrip;
        } else {

            especiales.fondo.setBackground(chance);
            int Nro = (int) (Math.random() * (20 - 1)) + 1;
            if (Nro == 9) {
                if (act.salirGratis == false) {
                    act.salirGratis = true;
                    ilumSalirCarcel(act.NroJugador, Color.orange);
                } else {
                    while (Nro == 9) {
                        Nro = (int) (Math.random() * (20 - 1)) + 1;
                    }
                }

            }
            cad = Chance.BuscarCarta(Nro, act).descrip;
        }

        especiales.desc.setText(ToHTML(cad));

        tomar.setEnabled(false);
        ListaTablero.debeSacar = false;
        ListaTablero.chest = false;
        if (d1 != d2) {
            pasar.setEnabled(true);
        }
        Pagar.setEnabled(false);
    }//GEN-LAST:event_tomarActionPerformed

    private void PagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagarActionPerformed
        Jugadores Jug = BuscarTurno(turnoac, J);
        if (Jug.preso == true) {
            Pagar.setEnabled(true);
            if (Jug.salirGratis == true) {
                Historial.setText(Historial.getText() + "\n" + Jug.nick + " Usó una carta para salir de la carcel");
                Jug.salirGratis = false;
                ilumSalirCarcel(Jug.NroJugador, neutro);
                JOptionPane.showMessageDialog(null, "<html><p style=\" color:green; font:15px ;font face='Eras Bold'; \"> ¡Usaste tu carta para escapar! <p><html>",
                        "Pa' fuera", JOptionPane.PLAIN_MESSAGE, escape);
                Jug.preso = false;
            } else {
                Jug.dinero -= 50;
                Jug.VerDinero.setText("$ " + Jug.dinero);
                Historial.setText(Historial.getText() + "\n" + Jug.nick + " pagó para salir de la carcel..");
                Jug.preso = false;
            }

        }
        Pagar.setEnabled(false);
    }//GEN-LAST:event_PagarActionPerformed

    private void manejarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manejarActionPerformed
        propiedades Prop = new propiedades();
        Prop.setVisible(true);
        tempo = BuscarTurno(turnoac, J);
        for (int i = 0; i < tempo.CantPropiedades; i++) {

            switch (tempo.Propiedades[i].num) {
                case 1:
                    propiedades.okr.setBackground(tempo.Propiedades[i].color);
                    propiedades.okr.setEnabled(true);
                    break;
                case 3:
                    propiedades.wr.setBackground(tempo.Propiedades[i].color);
                    propiedades.wr.setEnabled(true);
                    break;
                case 5:
                    propiedades.kcs.setBackground(tempo.Propiedades[i].color);
                    propiedades.kcs.setEnabled(true);
                    break;
                case 6:
                    propiedades.tai.setBackground(tempo.Propiedades[i].color);
                    propiedades.tai.setEnabled(true);
                    break;
                case 8:
                    propiedades.er.setBackground(tempo.Propiedades[i].color);
                    propiedades.er.setEnabled(true);
                    break;
                case 9:
                    propiedades.pr.setBackground(tempo.Propiedades[i].color);
                    propiedades.pr.setEnabled(true);
                    break;
                case 11:
                    propiedades.pm.setBackground(tempo.Propiedades[i].color);
                    propiedades.pm.setEnabled(true);
                    break;
                case 12:
                    propiedades.ec.setBackground(tempo.Propiedades[i].color);
                    propiedades.ec.setEnabled(true);
                    break;
                case 13:
                    propiedades.wh.setBackground(tempo.Propiedades[i].color);
                    propiedades.wh.setEnabled(true);
                    break;
                case 14:
                    propiedades.nda.setBackground(tempo.Propiedades[i].color);
                    propiedades.nda.setEnabled(true);
                    break;
                case 15:
                    propiedades.mrs.setBackground(tempo.Propiedades[i].color);
                    propiedades.mrs.setEnabled(true);
                    break;
                case 16:
                    propiedades.bws.setBackground(tempo.Propiedades[i].color);
                    propiedades.bws.setEnabled(true);
                    break;
                case 18:
                    propiedades.mbs.setBackground(tempo.Propiedades[i].color);
                    propiedades.mbs.setEnabled(true);
                    break;
                case 19:
                    propiedades.vns.setBackground(tempo.Propiedades[i].color);
                    propiedades.vns.setEnabled(true);
                    break;
                case 21:
                    propiedades.st.setBackground(tempo.Propiedades[i].color);
                    propiedades.st.setEnabled(true);
                    break;
                case 23:
                    propiedades.fls.setBackground(tempo.Propiedades[i].color);
                    propiedades.fls.setEnabled(true);
                    break;
                case 24:
                    propiedades.trs.setBackground(tempo.Propiedades[i].color);
                    propiedades.trs.setEnabled(true);
                    break;
                case 25:
                    propiedades.fss.setBackground(tempo.Propiedades[i].color);
                    propiedades.fss.setEnabled(true);
                    break;
                case 26:
                    propiedades.lcs.setBackground(tempo.Propiedades[i].color);
                    propiedades.lcs.setEnabled(true);
                    break;
                case 27:
                    propiedades.cvs.setBackground(tempo.Propiedades[i].color);
                    propiedades.cvs.setEnabled(true);
                    break;
                case 28:
                    propiedades.ww.setBackground(tempo.Propiedades[i].color);
                    propiedades.ww.setEnabled(true);
                    break;
                case 29:
                    propiedades.pcd.setBackground(tempo.Propiedades[i].color);
                    propiedades.pcd.setEnabled(true);
                    break;
                case 31:
                    propiedades.rs.setBackground(tempo.Propiedades[i].color);
                    propiedades.rs.setEnabled(true);
                    break;
                case 32:
                    propiedades.oxs.setBackground(tempo.Propiedades[i].color);
                    propiedades.oxs.setEnabled(true);
                    break;
                case 34:
                    propiedades.bs.setBackground(tempo.Propiedades[i].color);
                    propiedades.bs.setEnabled(true);
                    break;
                case 35:
                    propiedades.lss.setBackground(tempo.Propiedades[i].color);
                    propiedades.lss.setEnabled(true);
                    break;
                case 37:
                    propiedades.pl.setBackground(tempo.Propiedades[i].color);
                    propiedades.pl.setEnabled(true);
                    break;
                case 39:
                    propiedades.my.setBackground(tempo.Propiedades[i].color);
                    propiedades.my.setEnabled(true);
                    break;
            }

            propiedades.dineroact.setText("$" + tempo.dinero);

        }
    }//GEN-LAST:event_manejarActionPerformed

    private void quebrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quebrarActionPerformed
        BuscarTurno(turnoac, J).Bancarrota();
        comprar.setEnabled(false);
        lanzar.setEnabled(false);
        manejar.setEnabled(false);
        Pagar.setEnabled(false);
        tomar.setEnabled(false);
        ListaTablero.debeSacar = false;
        ListaTablero.chest = false;
        pasar.setEnabled(true);
        perdieron += 1;
        if (perdieron == DecidirTurno.players - 1) {
            System.out.println("fin");
            this.setVisible(false);
            ganador fin = new ganador();
            fin.setVisible(true);
            Jugadores win = null;
            for (int i = 0; i < DecidirTurno.players; i++) {
                if(J[i].bancarrota==false){
                    win = J[i];
                }
            }
            ganador.winner.setText("NICK: "+win.nick);
            ganador.money.setText("DINERO: $"+win.dinero);
            ganador.prop.setText("PROPIEDADES: "+win.CantPropiedades);
        }
        quebrar.setEnabled(false);

    }//GEN-LAST:event_quebrarActionPerformed

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
    public static javax.swing.JTextArea Historial;
    public static javax.swing.JButton Pagar;
    private javax.swing.JPanel Panel;
    public static javax.swing.JLabel ProName;
    private javax.swing.JTextField Tot;
    public static javax.swing.JLabel alquiler;
    public static javax.swing.JLabel bs;
    public static javax.swing.JLabel bs4;
    public static javax.swing.JLabel bs5;
    public static javax.swing.JLabel bs6;
    public static javax.swing.JLabel bws;
    public static javax.swing.JLabel bws4;
    public static javax.swing.JLabel bws5;
    public static javax.swing.JLabel bws6;
    public static javax.swing.JButton comprar;
    public static javax.swing.JLabel cvs;
    public static javax.swing.JLabel cvs4;
    public static javax.swing.JLabel cvs5;
    public static javax.swing.JLabel cvs6;
    private javax.swing.JLabel dado1;
    private javax.swing.JLabel dado2;
    public static javax.swing.JLabel ec;
    public static javax.swing.JLabel ec4;
    public static javax.swing.JLabel ec5;
    public static javax.swing.JLabel ec6;
    public static javax.swing.JLabel er;
    public static javax.swing.JLabel er4;
    public static javax.swing.JLabel er5;
    public static javax.swing.JLabel er6;
    public static javax.swing.JLabel fls;
    public static javax.swing.JLabel fls4;
    public static javax.swing.JLabel fls5;
    public static javax.swing.JLabel fls6;
    public static javax.swing.JLabel fss;
    public static javax.swing.JLabel fss4;
    public static javax.swing.JLabel fss5;
    public static javax.swing.JLabel fss6;
    public static javax.swing.JLabel info;
    public static javax.swing.JPanel infoj1;
    public static javax.swing.JPanel infoj2;
    public static javax.swing.JPanel infoj3;
    public static javax.swing.JPanel infoj4;
    public static javax.swing.JLabel j1dinero;
    public static javax.swing.JLabel j1dinero2;
    public static javax.swing.JLabel j1dinero3;
    public static javax.swing.JLabel j1dinero4;
    private javax.swing.JLabel j1name;
    private javax.swing.JLabel j2name;
    private javax.swing.JLabel j3name;
    private javax.swing.JLabel j4name;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel kcs;
    public static javax.swing.JLabel kcs4;
    public static javax.swing.JLabel kcs5;
    public static javax.swing.JLabel kcs6;
    public static javax.swing.JButton lanzar;
    public static javax.swing.JLabel lcs;
    public static javax.swing.JLabel lcs4;
    public static javax.swing.JLabel lcs5;
    public static javax.swing.JLabel lcs6;
    public static javax.swing.JLabel lss;
    public static javax.swing.JLabel lss4;
    public static javax.swing.JLabel lss5;
    public static javax.swing.JLabel lss6;
    public static javax.swing.JButton manejar;
    public static javax.swing.JLabel mbs;
    public static javax.swing.JLabel mbs4;
    public static javax.swing.JLabel mbs5;
    public static javax.swing.JLabel mbs6;
    private javax.swing.JLabel money;
    private javax.swing.JLabel money1;
    private javax.swing.JLabel money2;
    private javax.swing.JLabel money3;
    public static javax.swing.JLabel mrs;
    public static javax.swing.JLabel mrs4;
    public static javax.swing.JLabel mrs5;
    public static javax.swing.JLabel mrs6;
    public static javax.swing.JLabel my;
    public static javax.swing.JLabel my4;
    public static javax.swing.JLabel my5;
    public static javax.swing.JLabel my6;
    public static javax.swing.JLabel nda;
    public static javax.swing.JLabel nda4;
    public static javax.swing.JLabel nda5;
    public static javax.swing.JLabel nda6;
    public static javax.swing.JLabel okr;
    public static javax.swing.JLabel okr4;
    public static javax.swing.JLabel okr5;
    public static javax.swing.JLabel okr6;
    public static javax.swing.JLabel oxs;
    public static javax.swing.JLabel oxs4;
    public static javax.swing.JLabel oxs5;
    public static javax.swing.JLabel oxs6;
    public static javax.swing.JButton pasar;
    public static javax.swing.JLabel pcd;
    public static javax.swing.JLabel pcd4;
    public static javax.swing.JLabel pcd5;
    public static javax.swing.JLabel pcd6;
    public static javax.swing.JLabel pl;
    public static javax.swing.JLabel pl4;
    public static javax.swing.JLabel pl5;
    public static javax.swing.JLabel pl6;
    public static javax.swing.JLabel pm;
    public static javax.swing.JLabel pm4;
    public static javax.swing.JLabel pm5;
    public static javax.swing.JLabel pm6;
    public static javax.swing.JLabel pr;
    public static javax.swing.JLabel pr4;
    public static javax.swing.JLabel pr5;
    public static javax.swing.JLabel pr6;
    public static javax.swing.JLabel precio;
    private javax.swing.JLabel prop;
    private javax.swing.JLabel prop4;
    private javax.swing.JLabel prop5;
    private javax.swing.JLabel prop6;
    public static javax.swing.JButton quebrar;
    public static javax.swing.JLabel rs;
    public static javax.swing.JLabel rs4;
    public static javax.swing.JLabel rs5;
    public static javax.swing.JLabel rs6;
    public static javax.swing.JLabel salir;
    public static javax.swing.JLabel salir4;
    public static javax.swing.JLabel salir5;
    public static javax.swing.JLabel salir6;
    public static javax.swing.JLabel st;
    public static javax.swing.JLabel st4;
    public static javax.swing.JLabel st5;
    public static javax.swing.JLabel st6;
    public static javax.swing.JLabel tai;
    public static javax.swing.JLabel tai4;
    public static javax.swing.JLabel tai5;
    public static javax.swing.JLabel tai6;
    public static javax.swing.JButton tomar;
    public static javax.swing.JLabel trs;
    public static javax.swing.JLabel trs4;
    public static javax.swing.JLabel trs5;
    public static javax.swing.JLabel trs6;
    private javax.swing.JLabel turnojugar;
    public static javax.swing.JLabel vns;
    public static javax.swing.JLabel vns4;
    public static javax.swing.JLabel vns5;
    public static javax.swing.JLabel vns6;
    public static javax.swing.JLabel wh;
    public static javax.swing.JLabel wh4;
    public static javax.swing.JLabel wh5;
    public static javax.swing.JLabel wh6;
    public static javax.swing.JLabel wr;
    public static javax.swing.JLabel wr4;
    public static javax.swing.JLabel wr5;
    public static javax.swing.JLabel wr6;
    public static javax.swing.JLabel ww;
    public static javax.swing.JLabel ww4;
    public static javax.swing.JLabel ww5;
    public static javax.swing.JLabel ww6;
    // End of variables declaration//GEN-END:variables
    class fondoP extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondoJ.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
