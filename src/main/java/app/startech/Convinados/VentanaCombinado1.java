package app.startech.Convinados;

import app.startech.Persistencia.PersistenciaSaver;
import app.startech.data.DataController;
import app.startech.imagenes.Images;
import app.startech.models.Category;
import app.startech.models.Level;
import app.startech.screens.CategoryScreen;
import app.startech.screens.LevelScreen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


//Clase que se encarga de la parte visual del laberinto
public class VentanaCombinado1 extends javax.swing.JFrame {

    private Combinado combinado;
    private JTextField[][] matAux;
    private int cont;
    private final String[] mensajeContinuar = {"Continuar"};//Mensaje/Boton cuando el usuario completa un laberinto
    private final String[] mensajeSinVidas = {"Menú"};//Mensaje/Boton para ir al menú de niveles
    private final String[] mensajeGameOver = {"Menú", "Volver a Intentar"};//Mesaje/Boton para ir al menú de niveles o para reiniciar el laberinto
    private final Category categoria;
    private final Level level;
    private LevelScreen ventanaLevel;
    private CategoryScreen ventanaCategoria;

    public VentanaCombinado1(Category c, Level l, LevelScreen ventanaLevel, CategoryScreen ventanaCategory) {
        this.ventanaCategoria = ventanaCategory;
        this.ventanaLevel = ventanaLevel;
        categoria = c;
        level = l;
        combinado = new Combinado("Suma", "ave", 1);
        combinado.mostrarMatriz(); 
        cont = 0;
        initComponents();
        mostrarCrucigrama();
        setLocationRelativeTo(null);
    }
    public void mostrarCrucigrama() {
        jLabel1.setText(combinado.getTitulo());//Título. Ejm: Secuencia/Suma/Resta/Multiplicación/Divición
        jLabel2.setText(combinado.getCondicion());//Condicion para cada nivel. Ejm: Suma de uno en uno, Resta de dos en dos
        String[][] cruci = combinado.getCombinadoMatriz();
        String[][] cruciAux = combinado.getMatrizAux();
        int contAux = contar(cruci);
        int tamX = cruci.length;
        int tamY = cruci[0].length;
        int x=0, y=0, m=40, n=40;
        for(int i=0; i<tamX; i++){
            for(int j=0; j<tamY; j++){
                String act = cruci[i][j];
                JTextField a = new JTextField();
                matAux = new JTextField[tamX][tamY];
                matAux[i][j] = a;
                if(!act.equals("#")){
                    a.setBounds(x, y, m, n);
                    a.setHorizontalAlignment(JTextField.CENTER);
                    if(!act.equals("@")){
                        a.setText(act);
                        a.setEditable(false);
                    }else{
                        String veri = cruciAux[i][j];
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
                                        PersistenciaSaver persis = new PersistenciaSaver();
                                        int i = JOptionPane.showOptionDialog(null, "Lo lograste!!!", "StarTech", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeContinuar, mensajeContinuar[0]);
                                        if(i==0){
                                            //Siguinte nivel 
                                            Level sig = categoria.nextLevel(level);
                                            if (sig != null) { //si el siguiente nivel es distinto de null
                                                persis.buscarUsuario(DataController.instance.getUsuarioActual(), categoria.getId(), sig.getId());
                                                sig.setActive(); //el button (nivel) se activa
                                                java.awt.EventQueue.invokeLater(new Runnable() { //nuevo hilo
                                                    public void run() {
                                                        ventanaCategoria = new CategoryScreen(DataController.instance.getUsuarioActual().category.getAllCategories());
                                                        ventanaCategoria.setVisible(false);
                                                        ventanaLevel = new LevelScreen(categoria, ventanaCategoria);
                                                    }
                                                });
                                            } else { //el siguiente nivel es null, entonces se le activa la siguiente categoría
                                                // Siguiente Categoria
                                                Category cat = ventanaCategoria.nextCategory(categoria);
                                                if (cat != null) { //la siguiente categoria es distinto de null
                                                    persis.buscarUsuario(DataController.instance.getUsuarioActual(), cat.getId(), 1);
                                                    java.awt.EventQueue.invokeLater(new Runnable() {//nuevo hilo
                                                        public void run() {
                                                            cat.setActive(true); //se le activa esa siguiente categoria
                                                            if(cat.getId() != 8){
                                                                cat.getLevels()[0].setActive(); //se le activa el primer nivel de la siguiente categoria
                                                            }
                                                            new CategoryScreen(DataController.instance.getUsuarioActual().category.getAllCategories());
                                                        }
                                                    });
                                                } else { //la siguiente categoria es null, quiere decir que acabo con todas las categorias
                                                    JOptionPane.showMessageDialog(null, "Felicidad!!! Ganaste");
                                                    ventanaCategoria.setVisible(true);
                                                    //System.exit(0); 
                                                }
                                            }
                                            dispose(); //Se cierra la ventana del laberinto
                                        }
                                    }
                                }else{
                                    a.setBackground(Color.red);
                                    if (combinado.getVidas() == 0) { //Si el usuario ya no tiene vidas
                                        //ir a Menú
                                        int j = JOptionPane.showOptionDialog(null, "ohh no!!! ya no tienes vidas", "Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeSinVidas, mensajeSinVidas[0]);
                                        if (j == 0) {
                                            ventanaLevel.setVisible(true); //Se muestra la ventana de niveles
                                            dispose();  //Se cierra la ventana del laberinto
                                            combinado.restaurarVidas(); //Se restaura las vidas del usuario
                                        }
                                    } else { //El usuario todavia tiene vidas
                                        ocultarVida();
                                        combinado.setVidas();
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
    private int contar(String[][] mat){
        int res = 0;
        for(int i = 0; i<mat.length; i++){
            for(int j= 0; j<mat[0].length; j++){
                String act = mat[i][j];
                if(act.equals("@")){
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

    //se refresca el mismo laberinto, cambiando a su color inicial de los botones     
    

    //Pierde una vida. De forma visual oculta el jLabel para simular que pierde una vida
    public void ocultarVida() {
        if (combinado.getVidas() == 3) {
            jLabelVida1.setVisible(false);
        } else if (combinado.getVidas() == 2) {
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

        jLabelVida3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\VidaRojo.png")); // NOI18N
        jPanel3.add(jLabelVida3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        jLabelVida2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\VidaRojo.png")); // NOI18N
        jPanel3.add(jLabelVida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        jLabelVida1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\VidaRojo.png")); // NOI18N
        jPanel3.add(jLabelVida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\1.png")); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 210, 220));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\2.png")); // NOI18N
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
        jTextField1.setText("Comienza donde estás. Usa lo que tienes. Haz lo que puedas. Arthur Ashe");
        jTextField1.setToolTipText("");
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 710, 1010, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\BTN.png")); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\fondo1.1.jpg")); // NOI18N
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
        combinado.restaurarVidas();
        dispose();
        ventanaLevel.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
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
