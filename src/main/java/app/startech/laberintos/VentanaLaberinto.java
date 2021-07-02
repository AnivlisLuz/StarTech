package app.startech.laberintos;

import app.startech.imagenes.Images;
import app.startech.models.Category;
import app.startech.models.Level;
import app.startech.screens.CategoryScreen;
import app.startech.screens.LevelScreen;
import java.awt.Color;

//Clase que se encarga de la parte visual del laberinto
public class VentanaLaberinto extends javax.swing.JFrame {

    private Laberinto laberinto;
    private Boton[][] botones;
    private Category category;//--
    private Level level;//--
    private LevelScreen ventanaLevel;
    private CategoryScreen ventanaCategory;//--

    public VentanaLaberinto(Category c, Level l, LevelScreen ventanaLevel, CategoryScreen ventanaCategory) {
        this.ventanaCategory = ventanaCategory;
        this.ventanaLevel = ventanaLevel;
        laberinto = l.getLaberinto();
        category = c;
        level = l;
        laberinto.mostrarMatriz();
        botones = new Boton[laberinto.getMatriz().getLaberinto().length][laberinto.getMatriz().getLaberinto()[0].length];//matriz de botones...para la parte visual
        initComponents();
        pantalla();
        mostrarLaberinto();
        setLocationRelativeTo(null);
    }
    public void pantalla(){
        jLabel4.setIcon(new javax.swing.ImageIcon(laberinto.getDir2())); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(laberinto.getDir1())); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(laberinto.getDirFondo())); // NOI18N
    }
    //Método para ordenar y mostrar el laberinto de botones
    public void mostrarLaberinto() {
        jLabel1.setText(laberinto.getTitulo());//Título. Ejm: Secuencia/Suma/Resta/Multiplicación/Divición
        jLabel2.setText(laberinto.getCondicion());//Condicion para cada nivel. Ejm: Suma de uno en uno, Resta de dos en dos
        jTextField1.setText(laberinto.getMensaje());//Mensaje motivacional que aparece en cada laberinto.
        jTextField1.setOpaque(false);
        
        jTextField1.setEditable(false);
        int aux = laberinto.getMatriz().getLaberinto().length;//Tamaño del laberinto (todos los laberintos son cuadrados)
        int x = 0, y = 0, m = 0, n = 0;//x,y: posicion en pantalla. m,n: tamaño del boton
        if (aux == 3) {//En estos if/else se modifica la posicion y el tamaño de los botones segun el tamaño del laberinto
            x = 100;
            y = 100;
            m = 113;
            n = 116;
        } else if (aux == 4) {
            x = 90;
            y = 0;
            m = 85;
            n = 87;
        } else if (aux == 6) {
            x = 60;
            y = 0;
            m = 73;
            n = 75;
        } else if (aux == 8) {
            m = 67;
            n = 68;
        } else if (aux == 10) {
            m = 54;
            n = 55;
        }
        int[][] laberinto = this.laberinto.getMatriz().getLaberinto();
        int tamX = laberinto.length;
        int tamY = laberinto[0].length;
        for (int i = 0; i < tamX; i++) {
            for (int j = 0; j < tamY; j++) {
                //Creamos un objeto de clase Boton con sus parámetros necesarios
                Boton b = new Boton(x, y, m, n, this.laberinto, i, j, category, level, this, ventanaCategory, ventanaLevel);
                b.setBackground(Color.ORANGE);
                botones[i][j] = b;//añadimos el Boton creado
                int nom = laberinto[i][j];//obtenemos el número del laberinto en la posicion i,j
                String nomCadena = String.valueOf(nom);//convertimos en cadena ese número obtenido
                botones[i][j].setText(nomCadena);//cambiamos el texto del boton por el numero obtenido
                jPanel1.add(botones[i][j]);//se añade el boton en el jPanel
                x += m;//se recorre la posicion para el siguiente Boton
            }
            if (aux == 3) {//En estos if/else se reinicia la posición inicial segun el tamaño del laberinto
                x = 100;
            } else if (aux == 4) {
                x = 90;
            } else if (aux == 6) {
                x = 60;
            } else {
                x = 0;
            }
            y += n;
        }
        setLocationRelativeTo(null);
    }

    //se refresca el mismo laberinto, cambiando a su color inicial de los botones     
    public void refresh() {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones.length; j++) {
                Boton b = botones[i][j];
                b.setBackground(Color.ORANGE);
            }
        }
        laberinto.getMatriz().reset();
    }

    //Pierde una vida. De forma visual oculta el jLabel para simular que pierde una vida
    public void ocultarVida() {
        if (laberinto.getVidas() == 3) {
            jLabelVida1.setVisible(false);
        } else if (laberinto.getVidas() == 2) {
            jLabelVida2.setVisible(false);
        } else {
            jLabelVida3.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelVida3 = new javax.swing.JLabel();
        jLabelVida2 = new javax.swing.JLabel();
        jLabelVida1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setMaximumSize(new java.awt.Dimension(1000, 750));
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 750));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 65));
        jLabel1.setFont(new java.awt.Font("Impact", 1, 55)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 540, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 430, 40));

        jLabelVida3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/startech/imagenes/VidaRojo.png"))); // NOI18N
        jPanel3.add(jLabelVida3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        jLabelVida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/startech/imagenes/VidaRojo.png"))); // NOI18N
        jPanel3.add(jLabelVida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        jLabelVida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/startech/imagenes/VidaRojo.png"))); // NOI18N
        jPanel3.add(jLabelVida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/startech/imagenes/decorate/1.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 210, 220));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/startech/imagenes/decorate/2.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 210, 210));

        jPanel1.setBackground(new Color(0,0,0,0));
        jPanel1.setPreferredSize(new java.awt.Dimension(540, 550));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("jTextField1");
        jTextField1.setToolTipText("");
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 710, 1010, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/startech/imagenes/BTN.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/startech/imagenes/fondo1.1.jpg"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        laberinto.restaurarVidas();
        dispose();
        ventanaLevel.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelVida1;
    private javax.swing.JLabel jLabelVida2;
    private javax.swing.JLabel jLabelVida3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
