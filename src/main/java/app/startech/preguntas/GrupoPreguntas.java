/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.preguntas;

import app.startech.data.DataController;
import app.startech.screens.CategoryScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static app.startech.preguntas.Cuestionario.*;

public class GrupoPreguntas {

    public static ImageIcon imagen1;
    public static ImageIcon imagen2;
    public static JButton categoria0;
    public static JButton reiniciar;
    public static MouseListener comando;
    public static MouseListener comando0;
    public static MouseListener Denuevo;
    private String pregunta0;
    private String[] respuestas;
    private boolean[] incisos;
    private final JLabel etiqueta;
    private final JLabel etiqueta1;
    private final JLabel etiqueta2;
    private final Thread thread;

    public GrupoPreguntas(Pregunta[] preguntas) {
        thread = new Thread();
        thread.start();
        categoria0 = new JButton();
        reiniciar = new JButton();
        etiqueta = new JLabel();
        etiqueta1 = new JLabel();
        etiqueta2 = new JLabel();
        imagen1 = new ImageIcon("recursos/imagenes/perdiste.jpg");
        imagen2 = new ImageIcon("recursos/imagenes/lograste.jpg");

        //Da reaccion al boton de reiniciar Cuestionario
        comando = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                Pregunta.restQuest();
                GrupoPreguntas grupo = new GrupoPreguntas(Cuestionario.preguntas);
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };

        //Da reaccion al boton de iniciar Juego entrando primero a la categoria
        comando0 = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                Cuestionario.Ocultar();
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        DataController.instance.getUsuarioActual().category.suma.setActive(Pregunta.getResulS() >= 1);
                        DataController.instance.getUsuarioActual().category.suma.getLevels()[0].setActive(true);
                        if (Pregunta.getResulS() == 3) {
                            for (int i = 0; i < DataController.instance.getUsuarioActual().category.suma.getLevels().length; i++) {
                                DataController.instance.getUsuarioActual().category.suma.getLevels()[i].setActive(true);
                            }
                        }
                        DataController.instance.getUsuarioActual().category.resta.setActive(Pregunta.getResulR() >= 1);
                        DataController.instance.getUsuarioActual().category.resta.getLevels()[0].setActive(true);
                        if (Pregunta.getResulR() == 3) {
                            for (int i = 0; i < DataController.instance.getUsuarioActual().category.resta.getLevels().length; i++) {
                                DataController.instance.getUsuarioActual().category.resta.getLevels()[i].setActive(true);
                            }
                        }
                        DataController.instance.getUsuarioActual().category.multiplicacion.setActive(Pregunta.getResulM() >= 1);
                        DataController.instance.getUsuarioActual().category.multiplicacion.getLevels()[0].setActive(true);
                        if (Pregunta.getResulM() == 3) {
                            for (int i = 0; i < DataController.instance.getUsuarioActual().category.multiplicacion.getLevels().length; i++) {
                                DataController.instance.getUsuarioActual().category.multiplicacion.getLevels()[i].setActive(true);
                            }
                        }
                        DataController.instance.getUsuarioActual().category.division.setActive(Pregunta.getResulD() >= 1);
                        DataController.instance.getUsuarioActual().category.division.getLevels()[0].setActive(true);
                        if (Pregunta.getResulD() == 3) {
                            for (int i = 0; i < DataController.instance.getUsuarioActual().category.division.getLevels().length; i++) {
                                DataController.instance.getUsuarioActual().category.division.getLevels()[i].setActive(true);
                            }
                        }
                        CategoryScreen categoryScreen = new CategoryScreen(DataController.instance.getUsuarioActual().category.getAllCategories());
                    }
                });
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };

        //Da reaccion al boton de reiniciar el Cuestionario desde el principio
        Denuevo = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                Pregunta.setRestBCateg();
                Pregunta.restQuest();
                GrupoPreguntas grupo = new GrupoPreguntas(Cuestionario.preguntas);

            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };
        condicionDeCategoria();
        if (Pregunta.getCuestio() < 12) {
            if (Pregunta.getResulS() < 3 && Pregunta.getCuestio() == 3) {
                finalizarC();
            } else if (Pregunta.getResulR() < 3 && Pregunta.getCuestio() == 6) {
                finalizarC();
            } else if (Pregunta.getResulM() < 3 && Pregunta.getCuestio() == 9) {
                finalizarC();
            } else if (Pregunta.getResulD() < 3 && Pregunta.getCuestio() == 12) {
                finalizarC();
            } else {
                Pregunta.setCuestionario();
                System.out.println(Pregunta.getCuestio());
                Pregunta pregunta = new Pregunta(pregunta0, respuestas, incisos);
            }

        } else {
            finalizarC();
            if (Pregunta.getS() && Pregunta.getR() && Pregunta.getM() && Pregunta.getD()) {
                etiqueta1.setText("Ya respondiste todas las preguntas");
                reiniciar.setText("Reiniciar todo");
                reiniciar.addMouseListener(Denuevo);
            }
        }

    }

    //Metodo para iniciar el Cuestionario en categoria
    public static void showQuestionary() {
        Pregunta.restQuestChekPoint();
        Pregunta.restQuest();
        Cuestionario.DesOcultar();
        GrupoPreguntas grupo = new GrupoPreguntas(Cuestionario.preguntas);
    }

    //Convierte texto de una linea a muchas lineas mas
    public static String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    //limpia la pantalla
    public static void limpiar() {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    //Boton para ir a categoria
    public static void irCategoria() {
        categoria0.setBounds(ancho - 270, alto - 120, 200, 50);
        categoria0.setText("Jugar");
        categoria0.setHorizontalAlignment(SwingConstants.CENTER);
        categoria0.addMouseListener(comando0);
    }

    //boton para reiniciar
    public static void rst() {
        reiniciar.setBounds(70, alto - 120, 200, 50);
        reiniciar.setText("Reiniciar");
        reiniciar.setHorizontalAlignment(SwingConstants.CENTER);
        reiniciar.addMouseListener(comando);
    }

    //Pone panel para el final del Cuestionario
    public void hoja() {
        panel.add(reiniciar);
        panel.add(categoria0);
        panel.add(etiqueta1);
        panel.add(etiqueta);
    }

    //Pone el fondo
    public void fondo() {
        etiqueta.setBounds(0, 0, ancho, alto);
        etiqueta.setOpaque(true);
        etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_DEFAULT)));
    }

    //Caja de texto que muestra los resultados del Cuestionario
    public void resp() {
        etiqueta1.setBounds(ancho / 2 - 200, 100, 400, 200);
        etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta1.setText(convertToMultiline("respondiste " + Pregunta.getResul() + " preguntas \n Suma " + Pregunta.getResulS() + " \n Resta " + Pregunta.getResulR() + " \n Multiplicacion " + Pregunta.getResulM() + " \n Division " + Pregunta.getResulD()));

    }

    //Metodo para finalizar cuestionario
    public void finalizarC() {

        limpiar();
        hoja();
        fondo();
        resp();
        irCategoria();
        rst();

        if (Pregunta.getResul() == Pregunta.getCuestio()) {
            limpiar();
            panel.add(etiqueta2);
            hoja();
            fondo();

            etiqueta1.setBounds(ancho / 2 - 300, 100, 600, 50);
            etiqueta1.setText("felicidades respondiste todas las preguntas");

            etiqueta2.setBounds(ancho / 2 - 150, alto / 2 - 150, 300, 300);
            etiqueta2.setOpaque(true);
            etiqueta2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_DEFAULT)));

        } else if (Pregunta.getResul() == 0) {
            limpiar();
            panel.add(etiqueta2);
            hoja();
            fondo();

            etiqueta1.setBounds(ancho / 2 - 300, 100, 600, 50);
            etiqueta1.setText("No pudiste responder ninguna pregunta");

            etiqueta2.setBounds(ancho / 2 - 150, alto / 2 - 150, 300, 300);
            etiqueta2.setOpaque(true);
            etiqueta2.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_DEFAULT)));
        }

        etiqueta1.setOpaque(true);
        etiqueta1.setFont(new Font("calibri", Font.ITALIC, 30));

        System.out.println(etiqueta1.getText());

    }

    //Metodo para obtener la condicion al finalizar el cuestionario
    public void condicionDeCategoria() {
        if (Pregunta.getCuestio() == 0) {
            if (Pregunta.getS() == true) {
                Pregunta.setQuestCategory();
                Pregunta.setResulS();
            }
        }
        if (Pregunta.getCuestio() == 3) {
            if (Pregunta.getR() == true) {
                Pregunta.setQuestCategory();
                Pregunta.setResulR();
            }
        }
        if (Pregunta.getCuestio() == 6) {
            if (Pregunta.getM() == true) {
                Pregunta.setQuestCategory();
                Pregunta.setResulM();
            }
        }
        if (Pregunta.getCuestio() == 9) {
            if (Pregunta.getD() == true) {
                Pregunta.setQuestCategory();
                Pregunta.setResulD();
            }
        }
    }
}
