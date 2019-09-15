/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diseño;

import java.awt.Color;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import objetosfinal.AdministradorPerfil;
import objetosfinal.Criterio;
import objetosfinal.CriterioCompuesto;
import objetosfinal.CriterioMaximizar;
import objetosfinal.CriterioMinimizar;
import objetosfinal.CriterioSuma;
import objetosfinal.Estrategia;
import objetosfinal.EstrategiaCompuesta;
import objetosfinal.EstrategiaDistintos;
import objetosfinal.EstrategiaGrupal;
import objetosfinal.EstrategiaParecidos;
import objetosfinal.LectorEncuesta;
import objetosfinal.Perfil;
import objetosfinal.Perfil;


public class VistaGeneracionGrupo extends javax.swing.JFrame {

    private DefaultListModel defaultLista1;
    private DefaultListModel defaultList2;
    private DefaultListModel defaultList3;
    private ArrayList<String> encuestas;
    private ArrayList<Criterio> critBelbin;
    private ArrayList<Criterio> critKilmann;
    private ArrayList<Criterio> critSymlog;
    private ArrayList<Criterio> critFelder;
    private ArrayList<Criterio> critFeedback;
    private ArrayList<String> atribBelbin = new ArrayList<>();
    private ArrayList<String> atribKilmann = new ArrayList<>();
    private ArrayList<String> atribSymlog = new ArrayList<>();
    private ArrayList<String> atribFelder = new ArrayList<>();
    private int cantPersonas;
    private AdministradorPerfil adPerfil;
    private boolean efectividad;
    private boolean conformidad;
    private boolean satisfaccion;
    private int nroGrupo;

    public VistaGeneracionGrupo() {
        initComponents();
        
        //CONFIGURACION DE LOS COLORES DE FONDO
        Color unicen = new Color(35, 71, 114);
        Color fondo = new Color(236, 232, 214);
        Color panels = new Color(241, 239, 226);
        Color botones = new Color(35, 71,114);
        this.getContentPane().setBackground(fondo);

        criterios.setBackground(fondo);
        jPanel2.setBackground(fondo);
        jPanel3.setBackground(fondo);
        jPanel4.setBackground(unicen);
        jPanel5.setBackground(fondo);
        jPanel6.setBackground(fondo);
        estrategias.setBackground(fondo);
        
        criterios.setVisible(false);
        estrategias.setVisible(false);
        
        jComboBox1.setBackground(fondo);
        jComboBox3.setBackground(fondo);
        belbin.setBackground(fondo);
        felder.setBackground(fondo);
        conflictos.setBackground(fondo);
        symlog.setBackground(fondo);
        feedback.setBackground(fondo);
        chConformidad.setBackground(fondo);
        chEfectividad.setBackground(fondo);
        chSatisfaccion.setBackground(fondo);
        maxBelbin.setBackground(fondo);
        maxFeedback.setBackground(fondo);
        maxFelder.setBackground(fondo);
        maxKilmann.setBackground(fondo);
        maxSymlog.setBackground(fondo);
        minBelbin.setBackground(fondo);
        minFeedback.setBackground(fondo);
        minFelder.setBackground(fondo);
        minKilmann.setBackground(fondo);
        minSymlog.setBackground(fondo);
        sumaBelbin.setBackground(fondo);
        sumaFeedback.setBackground(fondo);
        sumaFelder.setBackground(fondo);
        sumaKilmann.setBackground(fondo);
        sumaSymlog.setBackground(fondo);
        
        cargarDatos.setBackground(Color.WHITE);
        mover.setBackground(Color.WHITE);
        eliminar.setBackground(Color.WHITE);
        genGrupos.setBackground(botones);
        
        efectividad = false;
        satisfaccion = false;
        conformidad = false;
        
        setLocationRelativeTo(null);
        setResizable(false); //no permite que se agrande la ventana
        setTitle("Formacion de Grupos");//agrega nombre a la ventana 

        
        //INICIALIZACION DE VARIABLES
        defaultLista1 = new DefaultListModel();
        defaultList2 = new DefaultListModel();
        defaultList3 = new DefaultListModel();
        
        adPerfil = new AdministradorPerfil();
        
        encuestas = new ArrayList<>();
        critBelbin = new ArrayList<>();
        critKilmann = new ArrayList<>();
        critSymlog = new ArrayList<>();
        critFelder = new ArrayList<>();
        critFeedback = new ArrayList<>();
        cantPersonas = 0;
        
        atribBelbin.add("implementer");
        atribBelbin.add("coordinator");
        atribBelbin.add("shaper");
        atribBelbin.add("plant");
        atribBelbin.add("resourceInvestigator");
        atribBelbin.add("monitor");
        atribBelbin.add("teamWorker");
        atribBelbin.add("completer");
        
        atribKilmann.add("evasion");
        atribKilmann.add("acomodo");
        atribKilmann.add("compromiso");
        atribKilmann.add("competencia");
        atribKilmann.add("colaboracion");
        
        atribSymlog.add("upward");
        atribSymlog.add("downward");
        atribSymlog.add("positive");
        atribSymlog.add("negative");
        atribSymlog.add("forward");
        atribSymlog.add("backward");
        
        atribFelder.add("activo");
        atribFelder.add("reflexivo");
        atribFelder.add("sensorial");
        atribFelder.add("intuitivo");
        atribFelder.add("secuencial");
        atribFelder.add("global");
        atribFelder.add("verbal");
        atribFelder.add("visual");
               
        this.dehabilitarCriterios();
        
        nroGrupo =0;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cargarDatos = new javax.swing.JButton();
        mover = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        menu = new javax.swing.JButton();
        genGrupos = new javax.swing.JButton();
        restaurar = new javax.swing.JButton();
        criterios = new javax.swing.JPanel();
        belbin = new javax.swing.JCheckBox();
        conflictos = new javax.swing.JCheckBox();
        symlog = new javax.swing.JCheckBox();
        felder = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sumaBelbin = new javax.swing.JCheckBox();
        maxBelbin = new javax.swing.JCheckBox();
        minBelbin = new javax.swing.JCheckBox();
        sumaKilmann = new javax.swing.JCheckBox();
        maxKilmann = new javax.swing.JCheckBox();
        minKilmann = new javax.swing.JCheckBox();
        sumaSymlog = new javax.swing.JCheckBox();
        maxSymlog = new javax.swing.JCheckBox();
        minSymlog = new javax.swing.JCheckBox();
        sumaFelder = new javax.swing.JCheckBox();
        maxFelder = new javax.swing.JCheckBox();
        minFelder = new javax.swing.JCheckBox();
        feedback = new javax.swing.JCheckBox();
        sumaFeedback = new javax.swing.JCheckBox();
        maxFeedback = new javax.swing.JCheckBox();
        minFeedback = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        estrategias = new javax.swing.JPanel();
        chSatisfaccion = new javax.swing.JCheckBox();
        chEfectividad = new javax.swing.JCheckBox();
        chConformidad = new javax.swing.JCheckBox();
        seleccionPanel = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(0, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo exactas.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GENERACION DE GRUPO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Perfiles");

        cargarDatos.setText("Cargar Datos");
        cargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosActionPerformed(evt);
            }
        });

        mover.setForeground(new java.awt.Color(255, 255, 255));
        mover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechaDerecha.jpg"))); // NOI18N
        mover.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverActionPerformed(evt);
            }
        });

        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cruz.png"))); // NOI18N
        eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(mover, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mover, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(154, 154, 154))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Perfiles a agrupar");

        jList2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))))
        );

        menu.setText("Menu Principal");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        genGrupos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        genGrupos.setForeground(new java.awt.Color(255, 255, 255));
        genGrupos.setText("Formar Grupos");
        genGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genGruposActionPerformed(evt);
            }
        });

        restaurar.setText("Restaurar");
        restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(restaurar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(genGrupos)
                .addGap(85, 85, 85)
                .addComponent(menu)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(restaurar)
                    .addComponent(menu)
                    .addComponent(genGrupos)))
        );

        criterios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Encuesta y Criterios a Utilizar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(0, 51, 153))); // NOI18N

        belbin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        belbin.setText("Test Belbin");
        belbin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                belbinActionPerformed(evt);
            }
        });

        conflictos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        conflictos.setText("Kilmann");
        conflictos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conflictosActionPerformed(evt);
            }
        });

        symlog.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        symlog.setText("Symlog");
        symlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symlogActionPerformed(evt);
            }
        });

        felder.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        felder.setText("Test Felder");
        felder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felderActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Suma");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Maximizar");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Minimizar");

        sumaBelbin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaBelbinActionPerformed(evt);
            }
        });

        maxBelbin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxBelbinActionPerformed(evt);
            }
        });

        minBelbin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minBelbinActionPerformed(evt);
            }
        });

        sumaKilmann.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaKilmannActionPerformed(evt);
            }
        });

        maxKilmann.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxKilmannActionPerformed(evt);
            }
        });

        minKilmann.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minKilmannActionPerformed(evt);
            }
        });

        sumaSymlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaSymlogActionPerformed(evt);
            }
        });

        maxSymlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxSymlogActionPerformed(evt);
            }
        });

        minSymlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minSymlogActionPerformed(evt);
            }
        });

        sumaFelder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaFelderActionPerformed(evt);
            }
        });

        maxFelder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxFelderActionPerformed(evt);
            }
        });

        minFelder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minFelderActionPerformed(evt);
            }
        });

        feedback.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        feedback.setText("FeedbackRoles");
        feedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackActionPerformed(evt);
            }
        });

        sumaFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaFeedbackActionPerformed(evt);
            }
        });

        maxFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxFeedbackActionPerformed(evt);
            }
        });

        minFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minFeedbackActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jList3);

        jLabel5.setText("Criterios");

        javax.swing.GroupLayout criteriosLayout = new javax.swing.GroupLayout(criterios);
        criterios.setLayout(criteriosLayout);
        criteriosLayout.setHorizontalGroup(
            criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(criteriosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(belbin, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conflictos, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(symlog, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(felder, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sumaFelder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sumaSymlog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sumaKilmann, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sumaBelbin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sumaFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(maxFelder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maxSymlog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maxKilmann, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maxBelbin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maxFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(minFelder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minSymlog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minKilmann, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minBelbin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(criteriosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        criteriosLayout.setVerticalGroup(
            criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(criteriosLayout.createSequentialGroup()
                .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(criteriosLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(belbin)
                            .addComponent(sumaBelbin)
                            .addComponent(maxBelbin)
                            .addComponent(minBelbin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(conflictos)
                            .addComponent(sumaKilmann)
                            .addComponent(maxKilmann, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minKilmann))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(symlog)
                            .addComponent(sumaSymlog)
                            .addComponent(maxSymlog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minSymlog))
                        .addGap(8, 8, 8)
                        .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(felder)
                            .addComponent(sumaFelder)
                            .addComponent(maxFelder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minFelder))
                        .addGap(9, 9, 9)
                        .addGroup(criteriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(feedback)
                            .addComponent(sumaFeedback)
                            .addComponent(maxFeedback)
                            .addComponent(minFeedback)))
                    .addGroup(criteriosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );

        criteriosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {maxBelbin, minBelbin});

        estrategias.setBorder(javax.swing.BorderFactory.createTitledBorder("Estrategias varias"));

        chSatisfaccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        chSatisfaccion.setText("Satisfaccion");
        chSatisfaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chSatisfaccionActionPerformed(evt);
            }
        });

        chEfectividad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        chEfectividad.setText("Efectividad");
        chEfectividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chEfectividadActionPerformed(evt);
            }
        });

        chConformidad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        chConformidad.setText("Conformidad");
        chConformidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chConformidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout estrategiasLayout = new javax.swing.GroupLayout(estrategias);
        estrategias.setLayout(estrategiasLayout);
        estrategiasLayout.setHorizontalGroup(
            estrategiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(estrategiasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(estrategiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chEfectividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(estrategiasLayout.createSequentialGroup()
                        .addGroup(estrategiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chSatisfaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chConformidad, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        estrategiasLayout.setVerticalGroup(
            estrategiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, estrategiasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chConformidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chEfectividad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chSatisfaccion)
                .addContainerGap())
        );

        seleccionPanel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione opcion", "Estrategia Individual (con criterio)", "Estrategis Grupal" }));
        seleccionPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(estrategias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(criterios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(seleccionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {criterios, jPanel2, jPanel5});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(criterios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estrategias, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        criterios.getAccessibleContext().setAccessibleName("Encuestas y Criterios a Utilizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
       //Se cambia la vista a Main
        Main obj = new Main();
        obj.setVisible(true); //SE NOS HACE VISIBLE LA PANTALLA
        dispose();
    }//GEN-LAST:event_menuActionPerformed

    private void cargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDatosActionPerformed
        //Obtiene todos los perfiles y los lista
        File fileFolder = new File("./Perfiles");
        File[] ficheros = fileFolder.listFiles();//guardo los archivos en arreglog
        
        if (ficheros.length == 0){
            JOptionPane.showMessageDialog(null, "No se posee perfiles por el momento", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for (int x = 0; x < ficheros.length; x++) {
            defaultLista1.addElement(ficheros[x].getName());//obtengo nombre del archivo- carpeta
        }
        jList1.setModel(defaultLista1);
    }//GEN-LAST:event_cargarDatosActionPerformed

    private void moverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverActionPerformed
        //Mueve elementos seleccionados de la lista 1 a la lista 2
        for (int item : jList1.getSelectedIndices()) {
            if(defaultList2.contains(defaultLista1.getElementAt(item))==false)
                defaultList2.addElement(defaultLista1.getElementAt(item));
        }
        jList2.setModel(defaultList2);
        activar();

    }//GEN-LAST:event_moverActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        //Elimina elemento seleccionado de la lista 2
        if (jList2.getSelectedIndex() >= 0) {
            defaultList2.remove(jList2.getSelectedIndex());
        }
        activar();
    }//GEN-LAST:event_eliminarActionPerformed

    private boolean Comprobacion(String factor) {
        //verifica que el factor ingresado sea un numero 
        for (int x = 0 ; x < factor.length() ; x++)
        {
            if ((factor.codePointAt(x) < 48) || (factor.codePointAt(x)) > 57)
            {
                JOptionPane.showMessageDialog(null, "Debe ingresarse solo numeros como factor", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }             
        }
        return true;      
    }
    
    
    private void destildar(){
        //estado inicial de los criterios
        belbin.setSelected(false);
        felder.setSelected(false);
        conflictos.setSelected(false);
        symlog.setSelected(false);
        feedback.setSelected(false);
        sumaBelbin.setSelected(false);
        sumaFelder.setSelected(false);
        sumaKilmann.setSelected(false);
        sumaSymlog.setSelected(false);
        sumaFeedback.setSelected(false);
        maxBelbin.setSelected(false);
        maxFeedback.setSelected(false);
        maxFelder.setSelected(false);
        maxKilmann.setSelected(false);
        maxSymlog.setSelected(false);
        minBelbin.setSelected(false);
        minFeedback.setSelected(false);
        minFelder.setSelected(false);
        minKilmann.setSelected(false);
        minSymlog.setSelected(false);
        chConformidad.setSelected(false);
        chEfectividad.setSelected(false);
        chSatisfaccion.setSelected(false);
        
    }
    
    private void restaurar()
    {
        //SE VUELVE A LOS VALORES INICIALES
        encuestas.clear();
        cantPersonas = 0;
        destildar();
        dehabilitarCriterios();
        defaultLista1.clear();
        defaultList2.clear();
        defaultList3.clear();
        activar();
        
    }
    
    private void activar()
    {
        //Habilita el boton de generacion de grupo una vez que se poseen todos los datos
        if((defaultList2.size()!=0)&&((critBelbin.size()!=0)||(critFeedback.size()!=0)||(critFelder.size()!=0)||(critKilmann.size()!=0)||(critSymlog.size()!=0)))
        {
            genGrupos.setEnabled(true);
        }
        else 
        {
           if ((defaultList2.size()!=0) && (efectividad || satisfaccion || conformidad))
            genGrupos.setEnabled(true);
            else genGrupos.setEnabled(false); 
        }
        
    }
    
    private String mostrarGrupos(ArrayList<ArrayList<Perfil>> grupos){
        //Ventana de resultados de grupos formados
        String linea="";
        int gr =1;
        for (ArrayList<Perfil> list : grupos)
        {
            linea= linea + " | " + "Grupo: "+ gr+ " " + "\n" ;
            
            for(Perfil p : list)
            {
                linea = linea + " - " + p.getNombre() + " "+ "\n";
            }
            gr++;
        }
            
        return linea;
    }
    
    private boolean critSeleccionados(){
        if (belbin.isSelected()==true)
            return true;
        if (conflictos.isSelected()==true)
            return true;
        if (felder.isSelected()==true)
            return true;
        if (symlog.isSelected()==true)
            return true;
        if (feedback.isSelected()==true)
            return true;
        return false;
    }
    
    private boolean estrSeleccionados(){
        if (chEfectividad.isSelected()==true)
            return true;
        if (chConformidad.isSelected()==true)
            return true;
        if (chSatisfaccion.isSelected()==true)
            return true;
        return false;
    }
    
    private ArrayList<Estrategia>formacionGrupoCriterio()
    {
        ArrayList<Estrategia> estrategias = new ArrayList<>();
        if (critSeleccionados())
        {
            if (belbin.isSelected()==true)
            { 
                Criterio criterioBelbin = new CriterioCompuesto(critBelbin);
                Estrategia estrategiaBelbin = new EstrategiaDistintos(criterioBelbin, "belbin",atribBelbin);
                estrategias.add(estrategiaBelbin);
            }
            if (conflictos.isSelected()==true)
            {
                Criterio criterioKilmann = new CriterioCompuesto(critKilmann);
                Estrategia estrategiaKilmann = new EstrategiaDistintos(criterioKilmann, "conflictos", atribKilmann);
                estrategias.add(estrategiaKilmann);
            }
            if(symlog.isSelected()==true)
            {
                Criterio criterioSymlog = new CriterioCompuesto(critSymlog);
                Estrategia estrategiaSymlog = new EstrategiaDistintos(criterioSymlog, "symlog", atribSymlog);
                estrategias.add(estrategiaSymlog);
            }
            if(felder.isSelected()==true)
            {
                Criterio criterioFelder = new CriterioCompuesto(critFelder);
                Estrategia estrategiaFelder = new EstrategiaParecidos(criterioFelder, atribFelder);
                estrategias.add(estrategiaFelder);
            }
            if (feedback.isSelected()==true)
            { 
                Criterio criterioFeedback = new CriterioCompuesto(critFeedback);
                Estrategia estrategiaFeedback = new EstrategiaDistintos(criterioFeedback, "feedbackRoles",atribBelbin);
                estrategias.add(estrategiaFeedback);
            }
        }
        return estrategias;
    }
        
    private ArrayList<Estrategia> estratFeedback()
    {
        ArrayList<Estrategia> resultado = new ArrayList<Estrategia>();
        if (efectividad)
            {
                Estrategia e = new EstrategiaGrupal("efectividad");
                resultado.add(e);
            }
            if (satisfaccion)
            {
                Estrategia e = new EstrategiaGrupal("satisfaccion");
                resultado.add(e);
            }
            if (conformidad)
            {
                Estrategia e = new EstrategiaGrupal("conformidad");
                resultado.add(e);
            }
        return resultado;
    }
    
    private void genGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genGruposActionPerformed
    try{
        //Variables
        ArrayList<Estrategia> estrategias = new ArrayList<Estrategia>();
        ArrayList<ArrayList<Perfil>> resultado;
        boolean tieneEncuestas= true;
        String nombre;
        boolean error = false;
        ArrayList<String> perEliminar= new ArrayList<>();
               
        //Obtenemos la cantidad de personas por grupo (puede diferenciar en 1)
        String cantidad = JOptionPane.showInputDialog(null, "Ingrese la cantidad de personas por grupo");
        cantPersonas = Integer.parseInt(cantidad);
        
        //obtenemos las personas a las cual agruparemos
        ArrayList<Perfil> perfiles = new ArrayList<Perfil>();
       
        for (int i = 0; i < defaultList2.size(); i++) //OBTENGO LOS NOMBRES DE LAS PERSONAS A FORMAR GRUPO
        {
            tieneEncuestas = true;
            nombre = (String)defaultList2.get(i);
            for (String s : encuestas){
            //VERIFICAMOS SI LOS PERFILES POSEEN LAS ENCUESTAS
                if (critSeleccionados())
                {
                    if(adPerfil.getEncuesta(nombre, s) != null) 
                    {
                        Perfil p = new Perfil(nombre, encuestas);
                        perfiles.add(p);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "El Perfil: " + nombre + ", No posee la encuesta "+ s , "Error", JOptionPane.ERROR_MESSAGE);
                        perEliminar.add(nombre);
                    }  
                }
                else  if (estrSeleccionados())
                        {
                        Perfil p = new Perfil(nombre);
                        perfiles.add(p);
                        }
                         
                }
        }
        
        if (cantPersonas > defaultList2.size())
        {
            
                JOptionPane.showMessageDialog(null, "no hay suficiente gente con el test" , "Error", JOptionPane.ERROR_MESSAGE);
                return;
            
        } //SI SE ELIMINAN PERFILES DE LA SEGUNDA LISTA
        
        //Elimina los perfiles que no cumplen con los test
        for(String n : perEliminar)
        {
            defaultList2.removeElement(n);
        }
        
        if(critSeleccionados())
        {
            estrategias = formacionGrupoCriterio();
        }
        else
            estrategias = estratFeedback();


        //Verificamos si hay estrategias de feedback
            
        //agrupamos todas las estrategias en una estrategia compuesta
                
        if(estrategias.size()>1)
        {
            Estrategia e = estrategias.get(0);
            EstrategiaCompuesta ec = new EstrategiaCompuesta(e, estrategias.get(1));
            if (estrategias.size()>2)
            {
                for (int pos=2; pos<estrategias.size();pos++)
                {
                    EstrategiaCompuesta ecAux= new EstrategiaCompuesta(ec, estrategias.get(pos));
                    ec=ecAux;
                }
            }
            //armamos los grupos
            resultado= ec.generarGrupos(perfiles, cantPersonas);          
        }
        else
        {
            //generamos los grupos en caso de tener una sola estrategia
            resultado= estrategias.get(0).generarGrupos(perfiles, cantPersonas);
        }
        //mostramos resultado y volvemos al estado inicial
        //System.out.println(resultado);
        JOptionPane.showMessageDialog(null, mostrarGrupos(resultado)); 
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar los resultados a un archivo?", "Almacenar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) 
        {
            try {
                
                String nombreArch ="";
                nombreArch = JOptionPane.showInputDialog("que nombre desea que tenga el archivo?");
                File carpeta = new File ("./Grupos");
                File file = new File("./Grupos/" + nombreArch + ".txt");
                if (! carpeta.exists()){
                    carpeta.mkdirs();
                    file.createNewFile();
                }
                FileWriter fichero = new FileWriter("./Grupos/"+ nombreArch + ".txt");
                PrintWriter pw = new PrintWriter(fichero);
                String resultados=mostrarGrupos(resultado);
                pw.print(resultados);
                JOptionPane.showMessageDialog(null, "se guardo el archivo" , "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                fichero.close();
            } catch (IOException ex) {
                Logger.getLogger(VistaGeneracionGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        restaurar();
    }
    catch(Exception exc){
        exc.printStackTrace();
         JOptionPane.showMessageDialog(null, "ERROR" , "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_genGruposActionPerformed

    private void belbinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_belbinActionPerformed
        if (estrSeleccionados()==false)//solo se selecciona criterios o estrategias
        {
           //Activar criterios para belbin
            if (belbin.isSelected() == true) {
                encuestas.add("belbin");
                sumaBelbin.setEnabled(true);
                maxBelbin.setEnabled(true);
                minBelbin.setEnabled(true);
            }
            else 
            {
                encuestas.remove("belbin");
                sumaBelbin.setEnabled(false);
                maxBelbin.setEnabled(false);
                minBelbin.setEnabled(false);
            } 
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Solo se pueen seleccionar criterios o estrategias" , "Error", JOptionPane.ERROR_MESSAGE);
            belbin.setSelected(false);
        }
            
        
        activar();
    }//GEN-LAST:event_belbinActionPerformed

    private void felderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felderActionPerformed
        if (estrSeleccionados()==false)//solo se selecciona criterios o estrategias
        {
                //Activar criterios para felder
             if (felder.isSelected() == true) {
                 encuestas.add("felder");
                 sumaFelder.setEnabled(true);
                 maxFelder.setEnabled(true);
                 minFelder.setEnabled(true);
             } else // tenemos en cuenta que el usuario puede deseleccionar despues de haber seleccionado
             if ((felder.isSelected() == false) && (encuestas.contains("felder"))) {
                 encuestas.remove("felder");
                 sumaFelder.setEnabled(false);
                 maxFelder.setEnabled(false);
                 minFelder.setEnabled(false);
             } 
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Solo se pueen seleccionar criterios o estrategias" , "Error", JOptionPane.ERROR_MESSAGE);
            felder.setSelected(false);
        }
        activar();
    }//GEN-LAST:event_felderActionPerformed

    private void conflictosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conflictosActionPerformed
        //Activar criterios para killman
        if (estrSeleccionados()==false)//solo se selecciona criterios o estrategias
        {
            if (conflictos.isSelected() == true) {
                encuestas.add("conflictos");
                sumaKilmann.setEnabled(true);
                maxKilmann.setEnabled(true);
                minKilmann.setEnabled(true);
            } else// tenemos en cuenta que el usuario puede deseleccionar despues de haber seleccionado
            if ((conflictos.isSelected() == false) && (encuestas.contains("conflictos"))) {
                encuestas.remove("conflictos");
                sumaKilmann.setEnabled(false);
                maxKilmann.setEnabled(false);
                minKilmann.setEnabled(false);
            }
        }
         else 
        {
            JOptionPane.showMessageDialog(null, "Solo se pueen seleccionar criterios o estrategias" , "Error", JOptionPane.ERROR_MESSAGE);
            conflictos.setSelected(false);
        }          
        activar();
    }//GEN-LAST:event_conflictosActionPerformed

    private void maxKilmannActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxKilmannActionPerformed
        //Se seleccionan los criterios y el factor a tener en cuenta
        if (maxKilmann.isSelected()==true)
        {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            while (respuesta == JOptionPane.YES_OPTION) {
            String[] atributos = {"competencia", "colaboracion", "compromiso", "evasion", "acomodo"};
            String atributo = (String) JOptionPane.showInputDialog(null, "Que atributo minimizar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
            String factor = JOptionPane.showInputDialog(null, "factor a utilizar", "Factor", JOptionPane.QUESTION_MESSAGE);
            if (Comprobacion(factor))
            {
                Criterio c = new CriterioMaximizar(Integer.parseInt(factor), atributo);
                critBelbin.add(c);
                String criterio = "max: " + atributo+ " " + factor;
                defaultList3.addElement(criterio);
                jList3.setModel(defaultList3);
            }
            System.out.println("atributo: " + atributo + "factor: " + Integer.parseInt(factor));
            System.out.println("criterios" + critKilmann);
            respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            }   
        }
        activar();
        
    }//GEN-LAST:event_maxKilmannActionPerformed

    private void symlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symlogActionPerformed
        if(estrSeleccionados()==false)
        {
            //Activar criterios para symlog
            if (symlog.isSelected() == true) {
                encuestas.add("symlog");
                sumaSymlog.setEnabled(true);
                maxSymlog.setEnabled(true);
                minSymlog.setEnabled(true);
            } else// tenemos en cuenta que el usuario puede deseleccionar despues de haber seleccionado
            if ((symlog.isSelected() == false) && (encuestas.contains("symlog"))) {
                encuestas.remove("symlog");
                sumaSymlog.setEnabled(false);
                maxSymlog.setEnabled(false);
                minSymlog.setEnabled(false);
            } 
        }
         else 
        {
            JOptionPane.showMessageDialog(null, "Solo se pueen seleccionar criterios o estrategias" , "Error", JOptionPane.ERROR_MESSAGE);
            symlog.setSelected(false);
        }
    }//GEN-LAST:event_symlogActionPerformed

    private void dehabilitarCriterios() {
        //deshabilita todos los criterios para que no se selecciones hasta que se seleccione el test
        sumaBelbin.setEnabled(false);
        sumaFelder.setEnabled(false);
        sumaKilmann.setEnabled(false);
        sumaSymlog.setEnabled(false);
        sumaFeedback.setEnabled(false);
        maxBelbin.setEnabled(false);
        minBelbin.setEnabled(false);
        maxFelder.setEnabled(false);
        minFelder.setEnabled(false);
        maxKilmann.setEnabled(false);
        minKilmann.setEnabled(false);
        maxSymlog.setEnabled(false);
        minSymlog.setEnabled(false);
        minFeedback.setEnabled(false);
        maxFeedback.setEnabled(false);
        genGrupos.setEnabled(false);
    }

    private void minSymlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minSymlogActionPerformed
        //Se seleccionan los criterios y el factor a tener en cuenta
        if (minSymlog.isSelected()==true)
        {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            while (respuesta == JOptionPane.YES_OPTION) {
            String[] atributos = {"upward", "downward", "positive", "negative", "forward", "backward"};
            String atributo = (String) JOptionPane.showInputDialog(null, "Que atributo minimizar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
            String factor = JOptionPane.showInputDialog(null, "factor a utilizar", "Factor", JOptionPane.QUESTION_MESSAGE);
            if (Comprobacion(factor))
            {
                Criterio c = new CriterioMaximizar(Integer.parseInt(factor), atributo);
                critBelbin.add(c);
                String criterio = "min: " + atributo+ " " + factor;
                defaultList3.addElement(criterio);
                jList3.setModel(defaultList3);
            }
            respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            } 
        }
        activar();
    }//GEN-LAST:event_minSymlogActionPerformed

    private void sumaBelbinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumaBelbinActionPerformed
        if (sumaBelbin.isSelected() == true) {
            Criterio sumaBelbin = new CriterioSuma();
            critBelbin.add(sumaBelbin);
        }
        activar();
    }//GEN-LAST:event_sumaBelbinActionPerformed

    private void maxBelbinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxBelbinActionPerformed
         //Se seleccionan los criterios y el factor a tener en cuenta
        if (maxBelbin.isSelected()==true){
          int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            while (respuesta == JOptionPane.YES_OPTION) {
                String[] atributos = {"implementer", "coordinator", "shaper", "plant", "resourceInvestigator", "monitor", "teamWorker", "completer"};
                String atributo = (String) JOptionPane.showInputDialog(null, "Que atributo maximizar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
                String factor = JOptionPane.showInputDialog(null, "factor a utilizar", "Factor", JOptionPane.QUESTION_MESSAGE);
                if (Comprobacion(factor))
                {
                    Criterio c = new CriterioMaximizar(Integer.parseInt(factor), atributo);
                    critBelbin.add(c);
                    String criterio = "max: " + atributo+ " " + factor;
                    defaultList3.addElement(criterio);
                    jList3.setModel(defaultList3);
                }
                respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            }  
        }
        activar();
    }//GEN-LAST:event_maxBelbinActionPerformed

    private void minBelbinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minBelbinActionPerformed
        //Se seleccionan los criterios y el factor a tener en cuenta
        if(minBelbin.isSelected()==true)
        {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            while (respuesta == JOptionPane.YES_OPTION) {
                String[] atributos = {"implementer", "coordinator", "shaper", "plant", "resourceInvestigator", "monitor", "teamWorker", "completer"};
                String atributo = (String) JOptionPane.showInputDialog(null, "Que atributo maximizar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
                String factor = JOptionPane.showInputDialog(null, "factor a utilizar", "Factor", JOptionPane.QUESTION_MESSAGE);
                 if (Comprobacion(factor))
                {
                    Criterio c = new CriterioMaximizar(Integer.parseInt(factor), atributo);
                    critBelbin.add(c);
                    String criterio = "min: " + atributo+ " " + factor;
                    defaultList3.addElement(criterio);
                    jList3.setModel(defaultList3);
                }
                respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            }
        }
        activar();
    }//GEN-LAST:event_minBelbinActionPerformed

    private void minKilmannActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minKilmannActionPerformed
        //Se seleccionan los criterios y el factor a tener en cuenta
        if (minKilmann.isSelected()==true)
        {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            while (respuesta == JOptionPane.YES_OPTION) {
                String[] atributos = {"competencia", "colaboracion", "compromiso", "evasion", "acomodo"};
                String atributo = (String) JOptionPane.showInputDialog(null, "Que atributo minimizar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
                String factor = JOptionPane.showInputDialog(null, "factor a utilizar", "Factor", JOptionPane.QUESTION_MESSAGE);
                if (Comprobacion(factor))
                {
                    Criterio c = new CriterioMaximizar(Integer.parseInt(factor), atributo);
                    critBelbin.add(c);
                    String criterio = "min: " + atributo+ " " + factor;
                    defaultList3.addElement(criterio);
                    jList3.setModel(defaultList3);
                }
                System.out.println("atributo: " + atributo + "factor: " + Integer.parseInt(factor));
                System.out.println("criterios" + critKilmann);
                respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            }
        }
        activar();
    }//GEN-LAST:event_minKilmannActionPerformed

    private void maxSymlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxSymlogActionPerformed
        //Se seleccionan los criterios y el factor a tener en cuenta
        if(maxSymlog.isSelected()==true)
        {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            while (respuesta == JOptionPane.YES_OPTION) {
                String[] atributos = {"upward", "downward", "positive", "negative", "forward", "backward"};
                String atributo = (String) JOptionPane.showInputDialog(null, "Que atributo maximizar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
                String factor = JOptionPane.showInputDialog(null, "factor a utilizar", "Factor", JOptionPane.QUESTION_MESSAGE);
                 if (Comprobacion(factor))
                {
                    Criterio c = new CriterioMaximizar(Integer.parseInt(factor), atributo);
                    critBelbin.add(c);
                    String criterio = "max: " + atributo+ " " + factor;
                    defaultList3.addElement(criterio);
                    jList3.setModel(defaultList3);
                }
                System.out.println("atributo: " + atributo + "factor: " + Integer.parseInt(factor));
                System.out.println("criterios" + critSymlog);
                respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            } 
        }
        activar();
    }//GEN-LAST:event_maxSymlogActionPerformed

    private void maxFelderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxFelderActionPerformed
        //Se seleccionan los criterios y el factor a tener en cuenta
        if(maxFelder.isSelected()==true)
        {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            while (respuesta == JOptionPane.YES_OPTION) {
                String[] atributos = {"activo", "reflexivo", "sensorial", "intuitivo", "visual", "verbal", "secuencial", "global"};
                String atributo = (String) JOptionPane.showInputDialog(null, "Que atributo maximizar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
                String factor = JOptionPane.showInputDialog(null, "factor a utilizar", "Factor", JOptionPane.QUESTION_MESSAGE);
                 if (Comprobacion(factor))
                {
                    Criterio c = new CriterioMaximizar(Integer.parseInt(factor), atributo);
                    critBelbin.add(c);
                    String criterio = "max: " + atributo+ " " + factor;
                    defaultList3.addElement(criterio);
                    jList3.setModel(defaultList3);
                }
                System.out.println("atributo: " + atributo + "factor: " + Integer.parseInt(factor));
                System.out.println("criterios" + critFelder);
                respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            }
        }
        activar();
    }//GEN-LAST:event_maxFelderActionPerformed

    private void minFelderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minFelderActionPerformed
       //Se seleccionan los criterios y el factor a tener en cuenta
        if(minFelder.isSelected()==true)
        {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            while (respuesta == JOptionPane.YES_OPTION) {
                String[] atributos = {"activo", "reflexivo", "sensorial", "intuitivo", "visual", "verbal", "secuencial", "global"};
                String atributo = (String) JOptionPane.showInputDialog(null, "Que atributo minimizar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
                String factor = JOptionPane.showInputDialog(null, "factor a utilizar", "Factor", JOptionPane.QUESTION_MESSAGE);
                 if (Comprobacion(factor))
                {
                    Criterio c = new CriterioMaximizar(Integer.parseInt(factor), atributo);
                    critBelbin.add(c);
                    String criterio = "min: " + atributo+ " " + factor;
                    defaultList3.addElement(criterio);
                    jList3.setModel(defaultList3);
                }
                System.out.println("atributo: " + atributo + "factor: " + Integer.parseInt(factor));
                System.out.println("criterios" + critFelder);
                respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            }  
        }
       activar(); 
    }//GEN-LAST:event_minFelderActionPerformed

    private void sumaKilmannActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumaKilmannActionPerformed
        if (sumaKilmann.isSelected() == true) {
            Criterio sumakilmann = new CriterioSuma();
            critKilmann.add(sumakilmann);
        }
        activar();
    }//GEN-LAST:event_sumaKilmannActionPerformed

    private void sumaSymlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumaSymlogActionPerformed
        if (sumaSymlog.isSelected() == true) {
            Criterio sumaSymlog = new CriterioSuma();
            critSymlog.add(sumaSymlog);
        }
        activar();
    }//GEN-LAST:event_sumaSymlogActionPerformed

    private void sumaFelderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumaFelderActionPerformed
        if (sumaFelder.isSelected() == true) {
            Criterio sumaFelder = new CriterioSuma();
            critFelder.add(sumaFelder);
        }
        activar();
    }//GEN-LAST:event_sumaFelderActionPerformed

    private void feedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackActionPerformed
        if (estrSeleccionados()==false)
        {
            //Activar criterios para feedback
            if (feedback.isSelected() == true) {
                encuestas.add("feedbackRoles");
                sumaFeedback.setEnabled(true);
                maxFeedback.setEnabled(true);
                minFeedback.setEnabled(true);
            } else // tenemos en cuenta que el usuario puede deseleccionar despues de haber seleccionado
            if ((felder.isSelected() == false) && (encuestas.contains("feedbackRoles"))) {
                encuestas.remove("feedbackRoles");
                sumaFeedback.setEnabled(false);
                maxFeedback.setEnabled(false);
                minFeedback.setEnabled(false);
            }
        }
         else 
        {
            JOptionPane.showMessageDialog(null, "Solo se pueen seleccionar criterios o estrategias" , "Error", JOptionPane.ERROR_MESSAGE);
            feedback.setSelected(false);
        }
        activar();
    }//GEN-LAST:event_feedbackActionPerformed

    private void sumaFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumaFeedbackActionPerformed
        if (sumaFeedback.isSelected() == true) {
            Criterio sumaFeedback = new CriterioSuma();
            critFeedback.add(sumaFeedback);
        }
        activar();
    }//GEN-LAST:event_sumaFeedbackActionPerformed

    private void maxFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxFeedbackActionPerformed
        //Se seleccionan los criterios y el factor a tener en cuenta
        if(maxFeedback.isSelected()==true)
        {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            while (respuesta == JOptionPane.YES_OPTION) {
                String[] atributos = {"implementer", "coordinator", "shaper", "plant", "resourceInvestigator", "monitor", "teamWorker", "completer"};
                String atributo = (String) JOptionPane.showInputDialog(null, "Que atributo maximizar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
                String factor = JOptionPane.showInputDialog(null, "factor a utilizar", "Factor", JOptionPane.QUESTION_MESSAGE);
                 if (Comprobacion(factor))
                {
                    Criterio c = new CriterioMaximizar(Integer.parseInt(factor), atributo);
                    critBelbin.add(c);
                    String criterio = "max: " + atributo+ " " + factor;
                    defaultList3.addElement(criterio);
                    jList3.setModel(defaultList3);
                }
                System.out.println("atributo: " + atributo + "factor: " + Integer.parseInt(factor));
                System.out.println("criterios" + critBelbin);
                respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            }
        }
        activar();
    }//GEN-LAST:event_maxFeedbackActionPerformed

    private void minFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minFeedbackActionPerformed
        //Se seleccionan los criterios y el factor a tener en cuenta
        if(minFeedback.isSelected()==true)
        {
           int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            while (respuesta == JOptionPane.YES_OPTION) {
                String[] atributos = {"implementer", "coordinator", "shaper", "plant", "resourceInvestigator", "monitor", "teamWorker", "completer"};
                String atributo = (String) JOptionPane.showInputDialog(null, "Que atributo maximizar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
                String factor = JOptionPane.showInputDialog(null, "factor a utilizar", "Factor", JOptionPane.QUESTION_MESSAGE);
                 if (Comprobacion(factor))
                {
                    Criterio c = new CriterioMaximizar(Integer.parseInt(factor), atributo);
                    critBelbin.add(c);
                    String criterio = "min: " + atributo+ " " + factor;
                    defaultList3.addElement(criterio);
                    jList3.setModel(defaultList3);
                }
                System.out.println("atributo: " + atributo + "factor: " + Integer.parseInt(factor));
                System.out.println("criterios" + critBelbin);
                respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar un atributo?", "Seleccion de atributo", JOptionPane.YES_NO_OPTION);
            } 
        }
       activar(); 
    }//GEN-LAST:event_minFeedbackActionPerformed

    
    private void restaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurarActionPerformed
        //Se vuelve a valores iniciales
        restaurar();
    }//GEN-LAST:event_restaurarActionPerformed

    private void chConformidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chConformidadActionPerformed
        if (critSeleccionados()==false)
        {
            if (chConformidad.isSelected()==true)
            {
                conformidad=true;
                encuestas.add("conformidad");
            }
            else {
                conformidad= false;
                encuestas.remove("conformidad");
            }
        }
         else 
        {
            JOptionPane.showMessageDialog(null, "Solo se pueen seleccionar criterios o estrategias" , "Error", JOptionPane.ERROR_MESSAGE);
            chConformidad.setSelected(false);
        }
            
        activar();
    }//GEN-LAST:event_chConformidadActionPerformed

    private void chEfectividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chEfectividadActionPerformed
        if (critSeleccionados()==false)
        {
            if (chEfectividad.isSelected()==true)
            {
                efectividad = true;
                encuestas.add("efectividad");
            }
            else {
                efectividad = false;
                encuestas.remove("efectividad");
            }
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Solo se pueen seleccionar criterios o estrategias" , "Error", JOptionPane.ERROR_MESSAGE);
            chEfectividad.setSelected(false);
        }
        activar();
    }//GEN-LAST:event_chEfectividadActionPerformed

    private void chSatisfaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chSatisfaccionActionPerformed
        if (critSeleccionados()==false)
        {
            if (chSatisfaccion.isSelected() == true)
            {
                satisfaccion = true;
                encuestas.add("satisfaccion");
            }
            else {
                satisfaccion = false;
                encuestas.remove("satisfaccion");
            }
        }
         else 
        {
            JOptionPane.showMessageDialog(null, "Solo se pueen seleccionar criterios o estrategias" , "Error", JOptionPane.ERROR_MESSAGE);
            chSatisfaccion.setSelected(false);
        }
        activar();
    }//GEN-LAST:event_chSatisfaccionActionPerformed

    private void seleccionPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionPanelActionPerformed
        if (seleccionPanel.getSelectedItem().equals("Estrategia Individual (con criterio)"))
        {
            criterios.setVisible(true);
            estrategias.setVisible(false);
            encuestas.clear();
            cantPersonas = 0;
            destildar();
            dehabilitarCriterios();
            defaultList3.clear();
        }
        else if (seleccionPanel.getSelectedItem().equals("Estrategis Grupal"))
        {
            criterios.setVisible(false);
            estrategias.setVisible(true);
            encuestas.clear();
            cantPersonas = 0;
            destildar();
            dehabilitarCriterios();
            defaultList3.clear();
        }
        
    }//GEN-LAST:event_seleccionPanelActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGeneracionGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGeneracionGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGeneracionGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGeneracionGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGeneracionGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox belbin;
    private javax.swing.JButton cargarDatos;
    private javax.swing.JCheckBox chConformidad;
    private javax.swing.JCheckBox chEfectividad;
    private javax.swing.JCheckBox chSatisfaccion;
    private javax.swing.JCheckBox conflictos;
    private javax.swing.JPanel criterios;
    private javax.swing.JButton eliminar;
    private javax.swing.JPanel estrategias;
    private javax.swing.JCheckBox feedback;
    private javax.swing.JCheckBox felder;
    private javax.swing.JButton genGrupos;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox maxBelbin;
    private javax.swing.JCheckBox maxFeedback;
    private javax.swing.JCheckBox maxFelder;
    private javax.swing.JCheckBox maxKilmann;
    private javax.swing.JCheckBox maxSymlog;
    private javax.swing.JButton menu;
    private javax.swing.JCheckBox minBelbin;
    private javax.swing.JCheckBox minFeedback;
    private javax.swing.JCheckBox minFelder;
    private javax.swing.JCheckBox minKilmann;
    private javax.swing.JCheckBox minSymlog;
    private javax.swing.JButton mover;
    private javax.swing.JButton restaurar;
    private javax.swing.JComboBox<String> seleccionPanel;
    private javax.swing.JCheckBox sumaBelbin;
    private javax.swing.JCheckBox sumaFeedback;
    private javax.swing.JCheckBox sumaFelder;
    private javax.swing.JCheckBox sumaKilmann;
    private javax.swing.JCheckBox sumaSymlog;
    private javax.swing.JCheckBox symlog;
    // End of variables declaration//GEN-END:variables


}
