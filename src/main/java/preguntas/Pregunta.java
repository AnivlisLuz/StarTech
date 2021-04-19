/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preguntas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static preguntas.Cuestionario.alto;
import static preguntas.Cuestionario.ancho;
import static preguntas.Cuestionario.cuestionario;
import static preguntas.Cuestionario.imagen;
import static preguntas.Cuestionario.panel;

public class Pregunta {
    
    public int auxiliar;
    public int esCorrecto;
    public static int resultado;
    public static int resultadoS;
    public static int resultadoR;
    public static int resultadoM;
    public static int resultadoD;
    
    public static JLabel etiqueta;
    public static JLabel etiqueta1;
    public static JButton boton;
    public static JButton boton1;
    public static JButton boton2;
    public static MouseListener oyenteAccion;
    public static MouseListener oyenteAccion1;
    public static MouseListener oyenteAccion2;
    
    public static String pregunta;
    public static String[] respuestas;
    public static boolean[] incisos;
    
    public static GrupoPreguntas grupo;
    public static GrupoPreguntas[] grupos;
    
    private static Thread thread;
    
    public Pregunta(String pregunta, String[] respuesta, boolean[] correcto){
        thread=new Thread();
        thread.start();
        etiqueta=new JLabel();
        etiqueta1=new JLabel();
        boton=new JButton();
        boton1=new JButton();
        boton2=new JButton();
        oyenteAccion=new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                if(esCorrecto==0){
                    etiqueta1.setBackground(Color.GREEN);
                    etiqueta1.setText("Correcto");
                }else{
                    etiqueta1.setBackground(Color.RED);
                    etiqueta1.setText("Incorrecto");
                    if(esCorrecto==1){
                        boton1.setBackground(Color.GREEN);
                    }else if(esCorrecto==2){
                        boton2.setBackground(Color.GREEN);
                    }
                }
            }

            public void mouseReleased(MouseEvent e) {
                esperarDecimo(4);
                if(esCorrecto==0){
                    resultado++;
                    if(cuestionario>=0 && cuestionario<=3){
                        resultadoS++;
                    }else if(cuestionario>=4 && cuestionario<=6){
                        resultadoR++;
                    }else if(cuestionario>=7 && cuestionario<=9){
                        resultadoM++;
                    }else if(cuestionario>=10 && cuestionario<=12){
                        resultadoD++;
                    }
            }
                GrupoPreguntas grupo=new GrupoPreguntas(Cuestionario.preguntas);
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };
        
        oyenteAccion1=new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                if(esCorrecto==1){
                    etiqueta1.setBackground(Color.GREEN);
                    etiqueta1.setText("Correcto");
                }else{
                    etiqueta1.setBackground(Color.RED);
                    etiqueta1.setText("Incorrecto");
                }
                if(esCorrecto==0){
                        boton.setBackground(Color.GREEN);
                    }else if(esCorrecto==2){
                        boton2.setBackground(Color.GREEN);
                    }
            }

            public void mouseReleased(MouseEvent e) {
                esperarDecimo(4);
                if(esCorrecto==1){
                    resultado++;
                    if(cuestionario>=0 && cuestionario<=3){
                        resultadoS++;
                    }else if(cuestionario>=4 && cuestionario<=6){
                        resultadoR++;
                    }else if(cuestionario>=7 && cuestionario<=9){
                        resultadoM++;
                    }else if(cuestionario>=10 && cuestionario<=12){
                        resultadoD++;
                    }
            }
                GrupoPreguntas grupo=new GrupoPreguntas(Cuestionario.preguntas);
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };

        oyenteAccion2=new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                if(esCorrecto==2){
                    etiqueta1.setBackground(Color.GREEN);
                    etiqueta1.setText("Correcto");
                }else{
                    etiqueta1.setBackground(Color.RED);
                    etiqueta1.setText("Incorrecto");
                    if(esCorrecto==0){
                        boton.setBackground(Color.GREEN);
                    }else if(esCorrecto==1){
                        boton1.setBackground(Color.GREEN);
                    }
                }
            }

            public void mouseReleased(MouseEvent e) {
                esperarDecimo(4);
                if(esCorrecto==2){
                    resultado++;
                    if(cuestionario>=0 && cuestionario<=3){
                        resultadoS++;
                    }else if(cuestionario>=4 && cuestionario<=6){
                        resultadoR++;
                    }else if(cuestionario>=7 && cuestionario<=9){
                        resultadoM++;
                    }else if(cuestionario>=10 && cuestionario<=12){
                        resultadoD++;
                    }
            }
                GrupoPreguntas grupo=new GrupoPreguntas(Cuestionario.preguntas);
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };
        limpiar();
        hoja();
        fondo();
        pregun();
        inciso();
        inciso1();
        inciso2();
        getVRes();  
    }   
    public static void hoja(){
        panel.add(etiqueta1);
        panel.add(boton);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(etiqueta);
    }
    public static void fondo(){
        etiqueta.setBounds(0,0,ancho,alto);
        etiqueta.setOpaque(true);
        etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(),etiqueta.getHeight(),Image.SCALE_SMOOTH)));
    }
    public void pregun(){
        pregunta=generadorP();
        etiqueta1.setBounds(ancho/2-100,50,200,50);
        etiqueta1.setBackground(Color.CYAN);
        etiqueta1.setText(generadorP());
        etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta1.setOpaque(true);
        etiqueta1.setFont(new Font("calibri",Font.ITALIC,30));
    }
    public void inciso(){
        boton.setBounds(ancho/4-75, 400, 150, 50);
        boton.setText(generadorR());
        boton.addMouseListener(oyenteAccion);
        boton.setOpaque(true);
        boton.setFont(new Font("calibri",Font.ITALIC,30));
    }
    public void inciso1(){
        boton1.setBounds(ancho/2-75, 400, 150, 50);
        boton1.setText(generadorR());
        boton1.setOpaque(true);
        boton1.setFont(new Font("calibri",Font.ITALIC,30));
        boton1.addMouseListener(oyenteAccion1);
    }
    public void inciso2(){
        boton2.setBounds((ancho*3)/4-75, 400, 150, 50);
        boton2.setText(generadorR());
        boton2.setOpaque(true);
        boton2.setFont(new Font("calibri",Font.ITALIC,30));
        boton2.addMouseListener(oyenteAccion2);
    }
    public String generadorP(){
        Random r = new Random();
        int a = r.nextInt(10);
        int b = r.nextInt(10);
        if(cuestionario>=0 && cuestionario<=3){
            auxiliar = a+b;
            pregunta="Cuanto es "+a+"+"+b;
        }else if(cuestionario>=4 && cuestionario<=6){
            if(a<=b){
                auxiliar = b-a;
                pregunta="Cuanto es "+b+"-"+a;
            }else if(b<a){
                auxiliar = a-b;
                pregunta="Cuanto es "+a+"-"+b;
            }
        }else if(cuestionario>=7 && cuestionario<=9){
            auxiliar = a*b;
            pregunta="Cuanto es "+a+"*"+b;
        }else if(cuestionario>=10 && cuestionario<=12){
            int c =r.nextInt(100);
            if(c%10==0){
            auxiliar = c/10;
            pregunta="Cuanto es "+c+"/"+10;
            }else if(c%9==0){
            auxiliar = c/9;
            pregunta="Cuanto es "+c+"/"+9;
            }else if(c%8==0){
            auxiliar = c/8;
            pregunta="Cuanto es "+c+"/"+8;
            }else if(c%7==0){
            auxiliar = c/7;
            pregunta="Cuanto es "+c+"/"+7;
            }else if(c%6==0){
            auxiliar = c/6;
            pregunta="Cuanto es "+c+"/"+6;
            }else if(c%5==0){
            auxiliar = c/5;
            pregunta="Cuanto es "+c+"/"+5;
            }else if(c%4==0){
            auxiliar = c/4;
            pregunta="Cuanto es "+c+"/"+4;
            }else if(c%3==0){
            auxiliar = c/3;
            pregunta="Cuanto es "+c+"/"+3;
            }else if(c%2==0){
            auxiliar = c/2;
            pregunta="Cuanto es "+c+"/"+2;
            }else if(c%1==0){
            auxiliar = c/1;
            pregunta="Cuanto es "+c+"/"+1;
            }
        }
        return pregunta;
    }
    public String generadorR(){
        Random r = new Random();
        int a;
        if(cuestionario>=7 && cuestionario<=9){
        a = r.nextInt(100);}
        else{
        a = r.nextInt(20);}
        if(auxiliar==a){
        a++;}
        String w=""+a+"";
        return w;
    }
    public void getVRes(){
        Random r = new Random();
        int a = r.nextInt(3);
        esCorrecto=a;
        if(a==0){
            boton.setText(""+auxiliar+"");
        }else if(a==1){
            boton1.setText(""+auxiliar+"");
        }else if(a==2){
            boton2.setText(""+auxiliar+"");
        }
    }
    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }
    public static void esperarDecimo(int segundos){
        try {
            Thread.sleep(segundos * 100);
         } catch (Exception e) {
            System.out.println(e);
         }
    }
    public static void limpiar(){
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }  
}