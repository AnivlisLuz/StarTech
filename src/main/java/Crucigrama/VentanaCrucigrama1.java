package Crucigrama;

import app.startech.data.DataController;
import app.startech.laberintos.*;
import app.startech.models.Category;
import app.startech.models.Level;
import app.startech.screens.CategoryScreen;
import app.startech.screens.LevelScreen;
import java.awt.AWTEventMulticaster;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Clase que se encarga de la parte visual del laberinto
public class VentanaCrucigrama1 extends javax.swing.JFrame {

    private Crucigrama crucigrama;
    private JTextField[][] matAux;
    private int cont;
    private final String[] mensajeContinuar = {"Continuar"};//Mensaje/Boton cuando el usuario completa un laberinto
    private final String[] mensajeSinVidas = {"Menú"};//Mensaje/Boton para ir al menú de niveles
    private final String[] mensajeGameOver = {"Menú", "Volver a Intentar"};//Mesaje/Boton para ir al menú de niveles o para reiniciar el laberinto
    private CategoryScreen ventanaCategorias;
    private final Category categoria;
    private LevelScreen ventanaLevel;
    private final Level level;

    public VentanaCrucigrama1(Category categoria, Level level, LevelScreen ventanaLevel, CategoryScreen ventanaCategorias) {
        this.ventanaCategorias = ventanaCategorias;
        this.categoria = categoria;
        this.ventanaLevel = ventanaLevel;
        this.level = level;
        crucigrama = new Crucigrama("Suma", "ave", 1);
        crucigrama.mostrarMatriz(); 
        cont = 0;
        initComponents();
        mostrarCrucigrama();
        setLocationRelativeTo(null);
    }

    //Método para ordenar y mostrar el laberinto de botones
    public void mostrarCrucigrama() {
        jLabel1.setText(crucigrama.getTitulo());//Título. Ejm: Secuencia/Suma/Resta/Multiplicación/Divición
        jLabel2.setText(crucigrama.getCondicion());//Condicion para cada nivel. Ejm: Suma de uno en uno, Resta de dos en dos
        char [][] cruciAux = crucigrama.getMatrizAux();
        char[][] cruci = crucigrama.getMatriz();
        int contAux = contar(cruci);
        int tamX = cruci.length;
        int tamY = cruci[0].length;
        int x=0, y=0, m=40, n=40;
        for(int i=0; i<tamX; i++){
            for(int j=0; j<tamY; j++){
                char act = cruci[i][j];
                JTextField a = new JTextField();
                matAux = new JTextField[tamX][tamY];
                matAux[i][j] = a;
                if(act != '#'){
                    a.setBounds(x, y, m, n);
                    a.setHorizontalAlignment(JTextField.CENTER);
                    if(act != '@'){
                        a.setText(""+ act);
                        a.setEditable(false);
                    }else{
                        String veri = "" + cruciAux[i][j];
                        ActionListener l = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String actual = a.getText();
                                if(esNumero(actual) && actual.equals(veri)){
                                    if(a.getBackground() != Color.GREEN){
                                        cont++;
                                        a.setBackground(Color.GREEN); 
                                        a.setEditable(false); 
                                    }
                                    if(cont == contAux){
                                        int i = JOptionPane.showOptionDialog(null, "Lo lograste!!!", "StarTech", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeContinuar, mensajeContinuar[0]);
                                        if(i==0){
                                            //Siguinte nivel 
                                            Level sig = categoria.nextLevel(level);
                                            if (sig != null) { //si el siguiente nivel es distinto de null
                                                sig.setActive(); //el button (nivel) se activa
                                                java.awt.EventQueue.invokeLater(new Runnable() { //nuevo hilo
                                                    public void run() {
                                                        ventanaCategorias = new CategoryScreen(DataController.instance.getUsuarioActual().category.getAllCategories());
                                                        ventanaCategorias.setVisible(false);
                                                        ventanaLevel = new LevelScreen(categoria, ventanaCategorias);
                                                    }
                                                });
                                            } else { //el siguiente nivel es null, entonces se le activa la siguiente categoría
                                                // Siguiente Categoria
                                                Category cat = ventanaCategorias.nextCategory(categoria);
                                                if (cat != null) { //la siguiente categoria es distinto de null
                                                    java.awt.EventQueue.invokeLater(new Runnable() {//nuevo hilo
                                                        public void run() {
                                                            cat.setActive(true); //se le activa esa siguiente categoria
                                                            cat.getLevels()[0].setActive(); //se le activa el primer nivel de la siguiente categoria
                                                            new CategoryScreen(DataController.instance.getUsuarioActual().category.getAllCategories());
                                                        }
                                                    });
                                                } else { //la siguiente categoria es null, quiere decir que acabo con todas las categorias
                                                    JOptionPane.showMessageDialog(null, "Felicidad!!! Ganaste");
                                                    ventanaCategorias.setVisible(true);
                                                    //System.exit(0); 
                                                }
                                            }
                                            dispose(); //Se cierra la ventana del laberinto
                                        }
                                    }
                                }else{
                                    a.setBackground(Color.red);
                                    if (crucigrama.getVidas() == 0) { //Si el usuario ya no tiene vidas
                                        //ir a Menú
                                        int j = JOptionPane.showOptionDialog(null, "ohh no!!! ya no tienes vidas", "Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeSinVidas, mensajeSinVidas[0]);
                                        if (j == 0) {
                                            ventanaLevel.setVisible(true); //Se muestra la ventana de niveles
                                            dispose();  //Se cierra la ventana del laberinto
                                            crucigrama.restaurarVidas(); //Se restaura las vidas del usuario
                                        }
                                    } else { //El usuario todavia tiene vidas
                                        ocultarVida();
                                        crucigrama.setVidas();
                                    }
                                }
                            }
                        };
                        a.addActionListener(l);
                    }
                    jPanel1.add(a);
                }
                x += m;
            }
            x = 0;
            y += n;
        }
        setLocationRelativeTo(null);
    }
    private int contar(char[][] mat){
        int res = 0;
        for(int i = 0; i<mat.length; i++){
            for(int j= 0; j<mat[0].length; j++){
                char act = mat[i][j];
                if(act == '@'){
                    res++;
                }
            }
        }
        return res;
    }
    private boolean esNumero(String a){
        boolean res = false;
        try {
            int num = Integer.parseInt(a);
            res = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debes introducir un número");
        }
        return res;
    }

    //Pierde una vida. De forma visual oculta el jLabel para simular que pierde una vida
    public void ocultarVida() {
        if (crucigrama.getVidas() == 3) {
            jLabelVida1.setVisible(false);
        } else if (crucigrama.getVidas() == 2) {
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

        jLabelVida3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\VidaRojo.png")); // NOI18N

        jLabelVida2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\VidaRojo.png")); // NOI18N

        jLabelVida1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\VidaRojo.png")); // NOI18N

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
        crucigrama.restaurarVidas();
        dispose();
        //ventanaLevel.setVisible(true);
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
