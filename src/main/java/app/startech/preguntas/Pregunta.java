/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.preguntas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import static app.startech.preguntas.Cuestionario.*;

public class Pregunta {

    public static JLabel etiqueta;
    public static JLabel etiqueta1;
    public static JButton boton;
    public static JButton boton1;
    public static JButton boton2;
    public static MouseListener oyenteAccion;
    public static MouseListener oyenteAccion1;
    public static MouseListener oyenteAccion2;
    public static String pregunta;
    public static String pregunta1;
    public static String[] respuestas;
    public static boolean[] incisos;
    public static GrupoPreguntas grupo;
    public static GrupoPreguntas[] grupos;
    private static int cuestionario;
    private static int resultado;
    private static int resultadoS;
    private static int resultadoR;
    private static int resultadoM;
    private static int resultadoD;
    private static Boolean resS = false;
    private static Boolean resR = false;
    private static Boolean resM = false;
    private static Boolean resD = false;
    private static int auxiliar;
    private static Thread thread;

    private int esCorrecto;
    
    private String [] resul=new String [3];
    private static String resulT;
    
    private static boolean resulTB;

    public Pregunta(String pregunta, String[] respuesta, boolean[] correcto) {
        thread = new Thread();
        thread.start();
        etiqueta = new JLabel();
        etiqueta1 = new JLabel();
        boton = new JButton();
        boton1 = new JButton();
        boton2 = new JButton();

        //Da reaccion al boton de opcion 1
        oyenteAccion = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                setPreg(resul[0]);
                if (esCorrecto == 0) {
                    resulTB=true;
                    etiqueta1.setBackground(Color.GREEN);
                    etiqueta1.setText("Correcto");
                } else {
                    resulTB=false;
                    etiqueta1.setBackground(Color.RED);
                    etiqueta1.setText("Incorrecto");
                    if (esCorrecto == 1) {
                        boton1.setBackground(Color.GREEN);
                    } else if (esCorrecto == 2) {
                        boton2.setBackground(Color.GREEN);
                    }
                }
            }

            public void mouseReleased(MouseEvent e) {
                esperarDecimo(4);
                if (esCorrecto == 0) {
                    resultado++;
                    if (cuestionario >= 0 && cuestionario <= 3) {
                        resultadoS++;
                    } else if (cuestionario >= 4 && cuestionario <= 6) {
                        resultadoR++;
                    } else if (cuestionario >= 7 && cuestionario <= 9) {
                        resultadoM++;
                    } else if (cuestionario >= 10 && cuestionario <= 12) {
                        resultadoD++;
                    }
                }
                GrupoPreguntas grupo = new GrupoPreguntas();
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };

        //Da reaccion al boton de opcion 2
        oyenteAccion1 = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                setPreg(resul[1]);
                if (esCorrecto == 1) {
                    resulTB=true;
                    etiqueta1.setBackground(Color.GREEN);
                    etiqueta1.setText("Correcto");
                } else {
                    resulTB=false;
                    etiqueta1.setBackground(Color.RED);
                    etiqueta1.setText("Incorrecto");
                }
                if (esCorrecto == 0) {
                    boton.setBackground(Color.GREEN);
                } else if (esCorrecto == 2) {
                    boton2.setBackground(Color.GREEN);
                }
            }

            public void mouseReleased(MouseEvent e) {
                esperarDecimo(4);
                if (esCorrecto == 1) {
                    resultado++;
                    if (cuestionario >= 0 && cuestionario <= 3) {
                        resultadoS++;
                    } else if (cuestionario >= 4 && cuestionario <= 6) {
                        resultadoR++;
                    } else if (cuestionario >= 7 && cuestionario <= 9) {
                        resultadoM++;
                    } else if (cuestionario >= 10 && cuestionario <= 12) {
                        resultadoD++;
                    }
                }
                GrupoPreguntas grupo = new GrupoPreguntas();
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };

        //Da reaccion al boton de opcion 3
        oyenteAccion2 = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                setPreg(resul[2]);
                if (esCorrecto == 2) {
                    resulTB=true;
                    etiqueta1.setBackground(Color.GREEN);
                    etiqueta1.setText("Correcto");
                } else {
                    resulTB=false;
                    etiqueta1.setBackground(Color.RED);
                    etiqueta1.setText("Incorrecto");
                    if (esCorrecto == 0) {
                        boton.setBackground(Color.GREEN);
                    } else if (esCorrecto == 1) {
                        boton1.setBackground(Color.GREEN);
                    }
                }
            }

            public void mouseReleased(MouseEvent e) {
                esperarDecimo(4);
                if (esCorrecto == 2) {
                    resultado++;
                    if (cuestionario >= 0 && cuestionario <= 3) {
                        resultadoS++;
                    } else if (cuestionario >= 4 && cuestionario <= 6) {
                        resultadoR++;
                    } else if (cuestionario >= 7 && cuestionario <= 9) {
                        resultadoM++;
                    } else if (cuestionario >= 10 && cuestionario <= 12) {
                        resultadoD++;
                    }
                }
                GrupoPreguntas grupo = new GrupoPreguntas();
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        };

        //Ejecuta los metodos
        limpiar();
        hoja();
        fondo();
        pregun();
        inciso();
        inciso1();
        inciso2();
        getVRes();
    }

    //Pone el panel que contiene la pregunta
    public static void hoja() {
        panel.add(etiqueta1);
        panel.add(boton);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(etiqueta);
    }

    //Establece el fondo
    public static void fondo() {
        etiqueta.setBounds(0, 0, ancho, alto);
        etiqueta.setOpaque(true);
        etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_SMOOTH)));
    }

    //metodo de espera por segundos
    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //metodo de espera por 0,1 segundos
    public static void esperarDecimo(int segundos) {
        try {
            Thread.sleep(segundos * 100);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Metodo de limpieza para nuevos atributos
    public static void limpiar() {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    //Metodo para reiniciar los resultados del cuestionario
    public static void restQuest() {
        cuestionario = 0;
        resultado = 0;
        resultadoS = 0;
        resultadoR = 0;
        resultadoM = 0;
        resultadoD = 0;
    }

    //Obtencion de booleans por cada categoria


    //obtener el valor de posicion actual del cuestionario
    public static int getCuestio() {
        return cuestionario;
    }

    //establecer finalidad del cuestionario
    public static void setCuestio() {
        cuestionario = 13;
    }

    //establecer siguiente posicion del cuestionario
    public static void setCuestionario() {
        cuestionario++;
    }

    //obtener el valor del resultado final
    public static int getResul() {
        return resultado;
    }

    //obtener el valor del resultado suma
    public static int getResulS() {
        return resultadoS;
    }

    //obtener el valor del resultado resta
    public static int getResulR() {
        return resultadoR;
    }

    //obtener el valor del resultado multiplicacion
    public static int getResulM() {
        return resultadoM;
    }

    //obtener el valor del resultado division
    public static int getResulD() {
        return resultadoD;
    }

    //establecer valor final del suma
    public static void setResulS() {
        resultadoS = 3;
    }

    //establecer valor final del resta
    public static void setResulR() {
        resultadoR = 3;
    }

    //establecer valor final del multiplicacion
    public static void setResulM() {
        resultadoM = 3;
    }

    //establecer valor final del division
    public static void setResulD() {
        resultadoD = 3;
    }

    //obtener el boolean para categoria suma
    public static boolean getS() {
        return resS;
    }

    //obtener el boolean para categoria resta
    public static boolean getR() {
        return resR;
    }

    //obtener el boolean para categoria multiplicacion
    public static boolean getM() {
        return resM;
    }

    //obtener el boolean para categoria division
    public static boolean getD() {
        return resD;
    }

    //establecer posicion de cuestionario por categoria
    public static void setQuestCategory() {
        cuestionario = cuestionario + 3;
    }

    //establecer valor de resultado por categoria
    public static void setRestCategory() {
        resultado = resultado + 3;
    }

    //establecer nulo para las categorias por reinicio total del cuestionario
    public static void setRestBCateg() {
        resS = false;
        resR = false;
        resM = false;
        resD = false;
    }

    //Establece la pregunta
    public void pregun() {
        pregunta = generadorP();
        etiqueta1.setBounds(ancho / 2 - 200, 100, 400, 100);
        etiqueta1.setBackground(Color.CYAN);
        etiqueta1.setText(generadorP());
        etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta1.setOpaque(true);
        etiqueta1.setFont(new Font("calibri", Font.ITALIC, 60));
    }

    //Establece el inciso 1
    public void inciso() {
        String pr1=generadorR();
        boton.setBounds(ancho / 4 - 75, 400, 150, 50);
        boton.setText(pr1);
        boton.addMouseListener(oyenteAccion);
        boton.setOpaque(true);
        boton.setFont(new Font("calibri", Font.ITALIC, 30));
        resul[0]=pr1;
    }

    //Establece el inciso 2
    public void inciso1() {
        String pr2=generadorR();
        boton1.setBounds(ancho / 2 - 75, 400, 150, 50);
        boton1.setText(pr2);
        boton1.setOpaque(true);
        boton1.setFont(new Font("calibri", Font.ITALIC, 30));
        boton1.addMouseListener(oyenteAccion1);
        resul[1]=pr2;
    }

    //Establece el inciso 3
    public void inciso2() {
        String pr3=generadorR();
        boton2.setBounds((ancho * 3) / 4 - 75, 400, 150, 50);
        boton2.setText(pr3);
        boton2.setOpaque(true);
        boton2.setFont(new Font("calibri", Font.ITALIC, 30));
        boton2.addMouseListener(oyenteAccion2);
        resul[2]=pr3;
    }

    //genera la pregunta
    public String generadorP() {
        Random r = new Random();
        int a = r.nextInt(10);
        int b = r.nextInt(10);
        if (cuestionario >= 0 && cuestionario <= 3) {
            auxiliar = a + b;
            pregunta = a + "+" + b;
        } else if (cuestionario >= 4 && cuestionario <= 6) {
            if (a <= b) {
                auxiliar = b - a;
                pregunta = b + "-" + a;
            } else if (b < a) {
                auxiliar = a - b;
                pregunta = a + "-" + b;
            }
        } else if (cuestionario >= 7 && cuestionario <= 9) {
            auxiliar = a * b;
            pregunta = a + "*" + b;
        } else if (cuestionario >= 10 && cuestionario <= 12) {
            int c = r.nextInt(100);
            if (c % 10 == 0) {
                auxiliar = c / 10;
                pregunta = c + "/" + 10;
            } else if (c % 9 == 0) {
                auxiliar = c / 9;
                pregunta = c + "/" + 9;
            } else if (c % 8 == 0) {
                auxiliar = c / 8;
                pregunta = c + "/" + 8;
            } else if (c % 7 == 0) {
                auxiliar = c / 7;
                pregunta = c + "/" + 7;
            } else if (c % 6 == 0) {
                auxiliar = c / 6;
                pregunta = c + "/" + 6;
            } else if (c % 5 == 0) {
                auxiliar = c / 5;
                pregunta = c + "/" + 5;
            } else if (c % 4 == 0) {
                auxiliar = c / 4;
                pregunta = c + "/" + 4;
            } else if (c % 3 == 0) {
                auxiliar = c / 3;
                pregunta = c + "/" + 3;
            } else if (c % 2 == 0) {
                auxiliar = c / 2;
                pregunta = c + "/" + 2;
            } else if (c % 1 == 0) {
                auxiliar = c / 1;
                pregunta = c + "/" + 1;
            }
        }
        return pregunta;
    }

    //genera una respuesta
    public String generadorR() {
        Random r = new Random();
        int a;
        if (cuestionario >= 7 && cuestionario <= 9) {
            a = r.nextInt(100);
        } else {
            a = r.nextInt(20);
        }
        if (auxiliar == a) {
            a++;
        }
        String w = "" + a + "";
        return w;
    }

    //obtiene el valor real
    public void getVRes() {
        Random r = new Random();
        int a = r.nextInt(3);
        esCorrecto = a;
        if (a == 0) {
            boton.setText("" + auxiliar + "");
        } else if (a == 1) {
            boton1.setText("" + auxiliar + "");
        } else if (a == 2) {
            boton2.setText("" + auxiliar + "");
        }
        resul[a]="" + auxiliar + "";
    }

    public static String getPregunta() {
        return pregunta;
    }

    public static int getAuxiliar() {
        return auxiliar;
    }
    
    public void setPreg(String resp){
        resulT=getPregunta()+" = "+resp;
    }
    public static String getPreg(){
        return resulT;
    }
    
    public static boolean getPB(){
        return resulTB;
    }
}
