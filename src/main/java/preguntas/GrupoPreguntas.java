/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preguntas;

import app.startech.models.Category;
import app.startech.screens.CategoryScreen;
import data.DataController;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static preguntas.Cuestionario.alto;
import static preguntas.Cuestionario.ancho;
import static preguntas.Cuestionario.imagen;
import static preguntas.Cuestionario.panel;

public class GrupoPreguntas {

    public static void showQuestionary() {
        Pregunta.restQuest();
        Cuestionario.DesOcultar();
        GrupoPreguntas grupo = new GrupoPreguntas(Cuestionario.preguntas);
    }

    private String pregunta0;
    private String[] respuestas;
    private boolean[] incisos;

    public static ImageIcon imagen1;
    public static ImageIcon imagen2;

    private JLabel etiqueta;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    public static JButton categoria0;
    public static JButton reiniciar;

    public static MouseListener comando;
    public static MouseListener comando0;

    private Thread thread;

    //public static Category[] ca;
    public GrupoPreguntas(Pregunta[] preguntas) {
        thread = new Thread();
        thread.start();
        categoria0 = new JButton();
        reiniciar = new JButton();
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
        comando0 = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                Cuestionario.Ocultar();
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        DataController.suma.setActive(Pregunta.getResulS() == 3);
                        DataController.resta.setActive(Pregunta.getResulR() == 3);
                        DataController.multiplicacion.setActive(Pregunta.getResulM() == 3);
                        DataController.division.setActive(Pregunta.getResulD() == 3);
                        CategoryScreen categoryScreen = new CategoryScreen(DataController.getAllCategories());
                    }
                });
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };
        if (Pregunta.getCuestio() < 12) {
            Pregunta.setCuestionario();
            System.out.println(Pregunta.getCuestio());
            Pregunta pregunta = new Pregunta(pregunta0, respuestas, incisos);
        } else {
            etiqueta = new JLabel();
            etiqueta1 = new JLabel();
            etiqueta2 = new JLabel();
            imagen1 = new ImageIcon("recursos/imagenes/perdiste.jpg");
            imagen2 = new ImageIcon("recursos/imagenes/lograste.jpg");

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

    }

    public void hoja() {
        panel.add(reiniciar);
        panel.add(categoria0);
        panel.add(etiqueta1);
        panel.add(etiqueta);
    }

    public void fondo() {
        etiqueta.setBounds(0, 0, ancho, alto);
        etiqueta.setOpaque(true);
        etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_DEFAULT)));
    }

    public void resp() {
        etiqueta1.setBounds(ancho / 2 - 200, 100, 400, 200);
        etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta1.setText(convertToMultiline("respondiste " + Pregunta.getResul() + " preguntas \n Suma " + Pregunta.getResulS() + " \n Resta " + Pregunta.getResulR() + " \n Multiplicacion " + Pregunta.getResulM() + " \n Division " + Pregunta.getResulD()));

    }

    public static String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    public static void limpiar() {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    public static void irCategoria() {
        categoria0.setBounds(ancho - 270, alto - 120, 200, 50);
        categoria0.setText("Jugar");
        categoria0.setHorizontalAlignment(SwingConstants.CENTER);
        categoria0.addMouseListener(comando0);
    }

    public static void rst() {
        reiniciar.setBounds(70, alto - 120, 200, 50);
        reiniciar.setText("Reiniciar");
        reiniciar.setHorizontalAlignment(SwingConstants.CENTER);
        reiniciar.addMouseListener(comando);
    }
}
