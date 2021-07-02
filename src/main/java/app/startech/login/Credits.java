/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.login;

import app.startech.login.Login;
import app.startech.models.Category;
import app.startech.preguntas.Cuestionario;
import app.startech.preguntas.GrupoPreguntas;

//import static app.startech.preguntas.Cuestionario.grupos;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static java.awt.BorderLayout.*;

/**
 * @author luzch
 */
public class Credits extends JFrame {

    private final Login login;

    public Credits(Login login) {
        this.login = login;
        initComponent();
        setLocationRelativeTo(null);
    }


    private void initComponent() {
        // Se coloca el tamaño de la pantalla por defecto
        setSize(650, 500);
        // Se configura el titulo
        setTitle("StarTech");
        //Esta porción de código sirve para centrar
        setLocationRelativeTo(null);
        //Esta porción de código sirve para que no se cierra el programa cuando se cierra una sola ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se establece el contenedor de la imagen
        JPanel image = new JPanel(new BorderLayout());
        image.setBackground(new Color(0, 0, 0, 0));
        image.setBorder(new EmptyBorder(30, 0, 0, 0));
        ImageIcon img= new ImageIcon(getClass().getResource("/app/startech/imagenes/creditos.jpg"));
        Icon fondo = new ImageIcon(img.getImage().getScaledInstance(650,358,Image.SCALE_DEFAULT));
        
        JLabel jLabel1 = new JLabel();
        jLabel1.setIcon(fondo);
        image.add(jLabel1);
       
        
        // Se establece el contenedor de abajo 
        JPanel options = new JPanel(new BorderLayout());
        options.setSize(new Dimension(200, 40));
        options.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Se instancia el boton de atras, que lleva al login
        JButton atras = new JButton("Atras");
        atras.addActionListener((action) -> {
            Login abrir = new Login();
            abrir.setVisible(true);
            setVisible(false);
        });
        atras.setPreferredSize(new Dimension(200, 40));
        options.add(atras,WEST);
        // Se estable la ubicación de los distintos contenedores
        add(image, CENTER);
        add(options, SOUTH);

        setVisible(true);
    }

}
