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
import static preguntas.Cuestionario.cuestionario;
import static preguntas.Cuestionario.imagen;
import static preguntas.Cuestionario.panel;
import static preguntas.Cuestionario.ventana;
import static preguntas.Pregunta.resultado;
import static preguntas.Pregunta.resultadoD;
import static preguntas.Pregunta.resultadoM;
import static preguntas.Pregunta.resultadoR;
import static preguntas.Pregunta.resultadoS;


public class GrupoPreguntas {
    public String pregunta0;
    public String[] respuestas;
    public boolean[] incisos;
    
    public static ImageIcon imagen1;
    public static ImageIcon imagen2;
    
    public static JLabel etiqueta;
    public static JLabel etiqueta1;
    public static JLabel etiqueta2;
    public static JButton categoria0;
    public static JButton reiniciar;
    
    public static MouseListener comando;
    public static MouseListener comando0;
    
    public static Thread thread;
    
    public static Category[] ca;
    
    public GrupoPreguntas(Pregunta[] preguntas){
        thread=new Thread();
        thread.start();
        categoria0=new JButton();
        reiniciar=new JButton();
        comando=new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }
            
            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
               cuestionario=0;
               resultadoS=0;
               resultadoR=0;
               resultadoM=0;
               resultadoD=0;
               resultado=0;
               GrupoPreguntas grupo=new GrupoPreguntas(Cuestionario.preguntas);
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };
        comando0=new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                ventana.setVisible(false);
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CategoryScreen categoryScreen = new CategoryScreen(DataController.exampleCategory);
            }
        });
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };
        if(cuestionario<12){
            cuestionario=cuestionario+1;
            System.out.println(cuestionario);
            Pregunta pregunta=new Pregunta(pregunta0,respuestas,incisos);
        }else{
            etiqueta=new JLabel();
            etiqueta1=new JLabel();
            etiqueta2=new JLabel();
            imagen1=new ImageIcon("recursos/imagenes/perdiste.jpg");
            imagen2=new ImageIcon("recursos/imagenes/lograste.jpg");
            
            limpiar();
            hoja();
            fondo();
            resp();
            irCategoria();
            rst();
            
            if(resultado==cuestionario){
                limpiar();
                panel.add(etiqueta2);
                hoja();
                fondo();
                
                etiqueta1.setBounds(ancho/2-300,100,600,50);
                etiqueta1.setText("felicidades respondiste todas las preguntas");
                
                etiqueta2.setBounds(ancho/2-150,alto/2-150,300,300);
                etiqueta2.setOpaque(true);
                etiqueta2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(etiqueta2.getWidth(),etiqueta2.getHeight(),Image.SCALE_DEFAULT)));

            }else if(resultado==0){
                limpiar();
                panel.add(etiqueta2);
                hoja();
                fondo();           
                
                etiqueta1.setBounds(ancho/2-300,100,600,50);
                etiqueta1.setText("No pudiste responder ninguna pregunta");
                
                etiqueta2.setBounds(ancho/2-150,alto/2-150,300,300);
                etiqueta2.setOpaque(true);
                etiqueta2.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(etiqueta2.getWidth(),etiqueta2.getHeight(),Image.SCALE_DEFAULT)));
            }
            
            etiqueta1.setOpaque(true);
            etiqueta1.setFont(new Font("calibri",Font.ITALIC,30));
            
            System.out.println(etiqueta1.getText());
            
        }
        
    }
    public void hoja(){
        panel.add(reiniciar);
        panel.add(categoria0);
        panel.add(etiqueta1);
        panel.add(etiqueta);
    }
    public void fondo(){
        etiqueta.setBounds(0,0,ancho,alto);
        etiqueta.setOpaque(true);
        etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(),etiqueta.getHeight(),Image.SCALE_DEFAULT)));
    }
    public void resp(){
        etiqueta1.setBounds(ancho/2-200,100,400,200);
        etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta1.setText(convertToMultiline("respondiste "+resultado+" preguntas \n Suma "+resultadoS+" \n Resta "+resultadoR+" \n Multiplicacion "+resultadoM+" \n Division "+resultadoD));

    }
    public static String convertToMultiline(String orig) { 
        return "<html>" + orig.replaceAll("\n", "<br>"); 
    } 
    
    public static void limpiar(){
            panel.removeAll();
            panel.repaint();
            panel.revalidate();
    }
    public static void irCategoria(){
        categoria0.setBounds(ancho-270,alto-120,200,50);
        categoria0.setText("Jugar");
        categoria0.setHorizontalAlignment(SwingConstants.CENTER);
        categoria0.addMouseListener(comando0);
    }
    public static void rst(){
        reiniciar.setBounds(70,alto-120,200,50);
        reiniciar.setText("Reiniciar");
        reiniciar.setHorizontalAlignment(SwingConstants.CENTER);
        reiniciar.addMouseListener(comando);
    }
}
