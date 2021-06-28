/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.preguntas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cuestionario {

    public static final int ancho = 800;
    public static final int alto = 600;
    public static JPanel panel;
    public static ImageIcon imagen;
    public static GrupoPreguntas[] grupos;
    public static Pregunta[] preguntas;
    private static JFrame ventana;
    private final JLabel etiqueta;
    private final JButton boton;
    private final ActionListener oyenteAccion;
    private final Thread thread;

    //Iniciar Cuestionario
    public Cuestionario(GrupoPreguntas[] grupoPreguntas) {
        thread = new Thread();
        ventana = new JFrame();
        panel = new JPanel();
        etiqueta = new JLabel();
        boton = new JButton();
        imagen = new ImageIcon("recursos/imagenes/fondo.jpg");
        oyenteAccion = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GrupoPreguntas grupo = new GrupoPreguntas(preguntas);
            }
        };
        ventana();
        hoja();
        fondo();
        inicio();
    }

    //Metodo para usar cuando ocultar la ventana
    public static void Ocultar() {
        ventana.setVisible(false);
    }

    //Metodo para usar cuando desocultar la ventana
    public static void DesOcultar() {
        ventana.setVisible(true);
    }

    //Ejecuta la ventana del Cuestionario
    public void ventana() {
        thread.start();
        ventana.setVisible(true);
        ventana.setSize(ancho, alto);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().add(panel);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
    }

    //Pone un panel que estara manejando botones, etiquetas
    public void hoja() {
        panel.setSize(ancho, alto);
        panel.setLayout(null);
        panel.add(boton);
        panel.add(etiqueta);
    }

    //Etiqueta que contiene el fondo
    public void fondo() {
        etiqueta.setBounds(0, 0, ancho, alto);
        etiqueta.setOpaque(true);
        etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_SMOOTH)));
    }

    //Establece el boton para entrar al cuestionario
    public void inicio() {
        boton.setBounds((ancho / 2 - 150), alto / 2 - 50, 300, 100);
        boton.setText("Iniciar Cuestionario");
        boton.setEnabled(true);
        boton.addActionListener(oyenteAccion);
        boton.setFont(new Font("calibri", Font.ITALIC, 30));
    }
}
