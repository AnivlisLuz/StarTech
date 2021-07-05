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
import java.util.Random;

public class Cuestionario {

    public static final int ancho = 800;
    public static final int alto = 600;
    public static JPanel panel;
    public static ImageIcon imagen;
    public static ImageIcon imagen1;
    public static ImageIcon dec;
    private static JFrame ventana;
    private final JLabel etiqueta;
    private final JLabel etiqueta1;
    private final JButton boton;
    private final ActionListener oyenteAccion;

    //Iniciar Cuestionario
    public Cuestionario() {
        ventana = new JFrame();
        panel = new JPanel();
        etiqueta = new JLabel();
        etiqueta1 = new JLabel();
        boton = new JButton();
        
        //imagen = new ImageIcon(getClass().getResource("/app/startech/preguntas/fondo.jpg"));
        imagen = new ImageIcon("C:\\Users\\USER\\Documents\\StarTech\\src\\main\\java\\app\\startech\\preguntas\\fondo.jpg");
        //imagen1 = new ImageIcon(getClass().getResource("/app/startech/preguntas/test.png"));
        imagen1 = new ImageIcon("C:\\Users\\USER\\Documents\\StarTech\\src\\main\\java\\app\\startech\\preguntas\\test.png");
        oyenteAccion = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GrupoPreguntas grupo = new GrupoPreguntas();
                grupo.showQuestionary();
            }
        };
        ventana();
        hoja();
        decorate();
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
        panel.add(etiqueta1);
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
        boton.setBounds((ancho / 2 - 150), alto / 2 - 150, 300, 300);
        //boton.setText("Iniciar Cuestionario");
        boton.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(boton.getWidth() + 50, boton.getHeight() + 50, Image.SCALE_SMOOTH)));
        boton.setEnabled(true);
        boton.addActionListener(oyenteAccion);
        boton.setFont(new Font("calibri", Font.ITALIC, 30));
    }

    public void decorate() {
        Random r = new Random();
        int a = r.nextInt(2);
        int b = r.nextInt(1);
        if (a == 0) {
            //dec = new ImageIcon(getClass().getResource("/app/startech/preguntas/fondo.jpg"));
            dec = new ImageIcon("C:\\Users\\USER\\Documents\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\5.png");
        } else if (a == 1) {
            dec = new ImageIcon("C:\\Users\\USER\\Documents\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\7.png");
        } else if (a == 2) {
            dec = new ImageIcon("C:\\Users\\USER\\Documents\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\9.png");
        }
        if (b == 0) {
            etiqueta1.setBounds(10, 10, 150, 150);
        } else if (b == 1) {
            etiqueta1.setBounds(ancho - 110, 10, 150, 150);
        }
        etiqueta1.setIcon(new ImageIcon(dec.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cuestionario c = new Cuestionario();
            }
        });
        // Ventana ventana = new Ventana();
    }

}
