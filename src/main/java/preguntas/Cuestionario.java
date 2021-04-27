/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preguntas;

import forms.Usuario;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cuestionario {

    private static JFrame ventana;

    private JLabel etiqueta;
    private JButton boton;
    private ActionListener oyenteAccion;

    public static JPanel panel;
    public static ImageIcon imagen;

    public static GrupoPreguntas[] grupos;
    public static Pregunta[] preguntas;

    public static final int ancho = 800;
    public static final int alto = 600;

    private Thread thread;

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

 

    public void ventana() {
        thread.start();
        ventana.setVisible(true);
        ventana.setSize(ancho, alto);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().add(panel);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
    }

    public void hoja() {
        panel.setSize(ancho, alto);
        panel.setLayout(null);
        panel.add(boton);
        panel.add(etiqueta);
    }

    public void fondo() {
        etiqueta.setBounds(0, 0, ancho, alto);
        etiqueta.setOpaque(true);
        etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_SMOOTH)));
    }

    public void inicio() {
        boton.setBounds((ancho / 2 - 150), alto / 2 - 50, 300, 100);
        boton.setText("Iniciar Cuestionario");
        boton.setEnabled(true);
        boton.addActionListener(oyenteAccion);
        boton.setFont(new Font("calibri", Font.ITALIC, 30));
    }

    public static void Ocultar() {
        ventana.setVisible(false);
    }

    public static void DesOcultar() {
        ventana.setVisible(true);
    }
}
