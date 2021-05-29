package app.startech.laberintos;

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
        mostrarLaberinto();
        setLocationRelativeTo(null);
    }

    //Método para ordenar y mostrar el laberinto de botones
    public void mostrarLaberinto() {
        jLabel1.setText(laberinto.getTitulo());//Título. Ejm: Secuencia/Suma/Resta/Multiplicación/Divición
        jLabel2.setText(laberinto.getCondicion());//Condicion para cada nivel. Ejm: Suma de uno en uno, Resta de dos en dos
        jTextArea1.setText(laberinto.getMensaje());//Mensaje motivacional que aparece en cada laberinto.
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setEditable(false);
        int aux = laberinto.getMatriz().getLaberinto().length;//Tamaño del laberinto (todos los laberintos son cuadrados)
        int x = 0, y = 0, m = 0, n = 0;//x,y: posicion en pantalla. m,n: tamaño del boton
        if (aux == 3) {//En estos if/else se modifica la posicion y el tamaño de los botones segun el tamaño del laberinto
            x = 100;
            y = 0;
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
                b.setBackground(null);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelVida3 = new javax.swing.JLabel();
        jLabelVida2 = new javax.swing.JLabel();
        jLabelVida1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 0, 65));
        jLabel1.setFont(new java.awt.Font("Impact", 1, 50)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A");

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

        jTextArea1.setBackground(new Color(0,0,0,0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\recursos\\boton menú 1.png")); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabelVida3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\recursos\\VidaRojo.png")); // NOI18N

        jLabelVida2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\recursos\\VidaRojo.png")); // NOI18N

        jLabelVida1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\recursos\\VidaRojo.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelVida1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelVida2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelVida3)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelVida3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelVida2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelVida1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton para cerrar la ventana del laberinto y volver a la ventana del menú de niveles 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        laberinto.restaurarVidas();
        dispose();
        ventanaLevel.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelVida1;
    private javax.swing.JLabel jLabelVida2;
    private javax.swing.JLabel jLabelVida3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
