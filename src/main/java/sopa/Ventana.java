/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class Ventana {

    private int ancho = 1000;
    private int alto = 800;
    private Cuadro[][] matriz;
    private Boton[][] botones;
    private int iniX = 0;
    private int iniY = 0;
    private int x;
    private int y;
    private int numeros[];
    private String operaciones[];
    private JFrame pantalla;
    private JPanel panel;
    private JLabel etiqueta;
    private JLabel esCorrecto;
    private JLabel titulo;
    private JButton boton;
    private ActionListener oyente;
    private SopaDeResultados sopa;
    private int[] resultados;
    private int[] primerDigito;
    private int[] segundoDigito;
    private boolean[][] ocupado;
    private int auxPR = 0;
    private int aux = 0;
    private int bucle = 0;

    public Ventana() {
        pantalla = new JFrame();
        panel = new JPanel();
        oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p = iniX;
                int q = iniY;
                System.out.println(p + "gi" + q);
            }
        };

        sopa = new SopaDeResultados();
        matriz = sopa.generarMatriz();

        x = matriz[0].length - 1;
        y = matriz.length - 1;

        botones = new Boton[y + 1][x + 1];

        operaciones = sopa.getNumeros();

        //genera el tamaño dependiendo de la matriz
        if ((x + 1) * (y + 1) < 50) {
            ancho = 800;
            alto = 600;
        } else if ((x + 1) * (y + 1) < 75) {
            ancho = 900;
            alto = 700;
        } else if ((x + 1) * (y + 1) < 101) {
            ancho = 1000;
            alto = 800;
        }

        //generar sopa
        resultados = sopa.getResultados();
        primerDigito = new int[resultados.length];
        segundoDigito = new int[resultados.length];
        ocupado = new boolean[matriz.length][matriz[0].length];
        for (int i = 0; i < resultados.length; i++) {
            primerDigito[i] = resultados[i] / 10;
            segundoDigito[i] = resultados[i] % 10;
        }

        // obtenerMatrizJuego();
        obtenerMatrizJuego1();
        pantalla();
        panel();
        titulo();
        botones();
        juego();
    }

    public void pantalla() {
        pantalla.setVisible(true);
        pantalla.setSize(ancho, alto);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.getContentPane().add(panel);
        pantalla.setLocationRelativeTo(null);
        pantalla.setResizable(false);
    }

    public void panel() {
        panel.setSize(ancho, alto);
        panel.setLayout(null);
    }

    public void titulo() {
        titulo = new JLabel("Sopa de Resultados");
        titulo.setBounds(ancho / 2 - 150, 5, 300, 80);
        titulo.setFont(new Font("calibri", Font.ITALIC, 30));
        panel.add(titulo);
    }

    public void botones() {
        Random r = new Random();
        int a = 50;
        int b = 100;
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                Boton c = new Boton(a, b, 50, 50, i, j, matriz, sopa, this);
                botones[i][j] = c;
                int nom = matriz[i][j].getValor();
                String nomCadena = String.valueOf(nom);
                botones[i][j].setText(nomCadena);
                botones[i][j].setBackground(Color.white);
                panel.add(botones[i][j]);
                a = a + 50;
                if (x == j) {
                    a = 50;
                }
            }
            b = b + 50;
        }
    }

    public void juego() {
        int aux = alto - 250;
        for (int j = 0; j < operaciones.length; j++) {
            etiqueta = new JLabel();
            etiqueta.setBounds(ancho - 200, aux, 100, 100);
            etiqueta.setText(operaciones[j]);
            etiqueta.setFont(new Font("calibri", Font.ITALIC, 25));
            panel.add(etiqueta);
            aux = aux - 30;
        }
    }

    public void ponerSegundoDigitoVI(int y, int x, int i) {
        int a = x;
        int b = y;
        if (b - 1 >= 0) {
            matriz[b - 1][a].setValor(segundoDigito[i]);
        } else if (b + 1 < matriz.length) {
            matriz[b + 1][a].setValor(segundoDigito[i]);
        } else if (a - 1 >= 0) {
            matriz[b][a - 1].setValor(segundoDigito[i]);
        } else if (a + 1 < matriz[0].length) {
            matriz[b][a + 1].setValor(segundoDigito[i]);
        }
    }

    public void ponerSegundoDigitoHI(int y, int x, int i) {
        int a = x;
        int b = y;
        if (a - 1 >= 0) {
            matriz[b][a - 1].setValor(segundoDigito[i]);
        } else if (a + 1 < matriz[0].length) {
            matriz[b][a + 1].setValor(segundoDigito[i]);
        } else if (b - 1 >= 0) {
            matriz[b - 1][a].setValor(segundoDigito[i]);
        } else if (b + 1 < matriz.length) {
            matriz[b + 1][a].setValor(segundoDigito[i]);
        }
    }

    public void ponerSegundoDigitoVD(int y, int x, int i) {
        int a = x;
        int b = y;
        if (b + 1 < matriz.length) {
            matriz[b + 1][a].setValor(segundoDigito[i]);
        } else if (b - 1 >= 0) {
            matriz[b - 1][a].setValor(segundoDigito[i]);
        } else if (a + 1 < matriz[0].length) {
            matriz[b][a + 1].setValor(segundoDigito[i]);
        } else if (a - 1 >= 0) {
            matriz[b][a - 1].setValor(segundoDigito[i]);
        }
    }

    public void ponerSegundoDigitoHD(int y, int x, int i) {
        int a = x;
        int b = y;
        if (a + 1 < matriz[0].length) {
            matriz[b][a + 1].setValor(segundoDigito[i]);
        } else if (a - 1 >= 0) {
            matriz[b][a - 1].setValor(segundoDigito[i]);
        } else if (b + 1 < matriz.length) {
            matriz[b + 1][a].setValor(segundoDigito[i]);
        } else if (b - 1 >= 0) {
            matriz[b - 1][a].setValor(segundoDigito[i]);
        }
    }

    public void obtenerMatrizJuego1() {
        int tamanoX = matriz[0].length;
        int posicionX;
        int aux;
        boolean auxP = true;

        //36<60
        int tamanoY = matriz.length;
        int posicionY;
        //60<101
        if (tamanoY < 8) {
            if (tamanoX < 8) {
                posicionX = 1;
                posicionY = 1;
                aux = 2;
                for (int i = 0; i < resultados.length; i++) {
                    matriz[posicionY][posicionX].setValor(primerDigito[i]);
                    if (aux == 2) {
                        if (auxP) {
                            ponerSegundoDigitoVI(posicionY, posicionX, i);
                            auxP = false;
                        } else {
                            ponerSegundoDigitoVD(posicionY, posicionX, i);
                            auxP = true;
                        }
                    } else {
                        if (auxP) {
                            ponerSegundoDigitoHI(posicionY, posicionX, i);
                            auxP = false;
                        } else {
                            ponerSegundoDigitoHD(posicionY, posicionX, i);
                            auxP = true;
                        }
                    }
                    posicionX = posicionX + aux;
                    if (posicionX >= tamanoX) {
                        if (aux == 2) {
                            aux = 3;
                        } else if (aux == 3) {
                            aux = 2;
                        }
                        posicionX = 0;
                        posicionY = posicionY + aux;
                    }
                }
            } else {
                posicionX = 2;
                posicionY = 1;
                aux = 3;
                for (int i = 0; i < resultados.length; i++) {
                    matriz[posicionY][posicionX].setValor(primerDigito[i]);
                    if (aux == 3) {
                        if (auxP) {
                            ponerSegundoDigitoVI(posicionY, posicionX, i);
                            auxP = false;
                        } else {
                            ponerSegundoDigitoVD(posicionY, posicionX, i);
                            auxP = true;
                        }
                    } else {
                        if (auxP) {
                            ponerSegundoDigitoHI(posicionY, posicionX, i);
                            auxP = false;
                        } else {
                            ponerSegundoDigitoHD(posicionY, posicionX, i);
                            auxP = true;
                        }
                    }
                    posicionX = posicionX + aux;
                    if (posicionX >= tamanoX) {
                        if (aux == 2) {
                            aux = 3;
                        } else if (aux == 3) {
                            aux = 2;
                        }
                        posicionX = 1;
                        posicionY = posicionY + aux;
                    }
                }
            }
        } else {
            if (tamanoX < 8) {
                posicionX = 1;
                posicionY = 2;
                aux = 2;
                for (int i = 0; i < resultados.length; i++) {
                    matriz[posicionY][posicionX].setValor(primerDigito[i]);
                    if (aux == 2) {
                        if (auxP) {
                            ponerSegundoDigitoVI(posicionY, posicionX, i);
                            auxP = false;
                        } else {
                            ponerSegundoDigitoVD(posicionY, posicionX, i);
                            auxP = true;
                        }
                    } else {
                        if (auxP) {
                            ponerSegundoDigitoHI(posicionY, posicionX, i);
                            auxP = false;
                        } else {
                            ponerSegundoDigitoHD(posicionY, posicionX, i);
                            auxP = true;
                        }
                    }
                    posicionX = posicionX + aux;
                    if (posicionX >= tamanoX) {
                        if (aux == 2) {
                            aux = 3;
                        } else if (aux == 3) {
                            aux = 2;
                        }
                        posicionX = 1;
                        posicionY = posicionY + aux;
                    }
                }
            } else {
                posicionX = 2;
                posicionY = 2;
                aux = 3;
                for (int i = 0; i < resultados.length; i++) {
                    matriz[posicionY][posicionX].setValor(primerDigito[i]);
                    if (aux == 3) {
                        if (auxP) {
                            ponerSegundoDigitoVI(posicionY, posicionX, i);
                            auxP = false;
                        } else {
                            ponerSegundoDigitoVD(posicionY, posicionX, i);
                            auxP = true;
                        }
                    } else {
                        if (auxP) {
                            ponerSegundoDigitoHI(posicionY, posicionX, i);
                            auxP = false;
                        } else {
                            ponerSegundoDigitoHD(posicionY, posicionX, i);
                            auxP = true;
                        }
                    }
                    posicionX = posicionX + aux;
                    if (posicionX >= tamanoX) {
                        if (aux == 2) {
                            aux = 3;
                        } else if (aux == 3) {
                            aux = 2;
                        }
                        posicionX = 1;
                        posicionY = posicionY + aux;
                    }
                }
            }
        }
    }

    public void ponerDigitoDos(int y, int x) {

    }

    public void correcto(int numero) {
        int aux = alto - 250;
        for (int i = 0; i < resultados.length; i++) {
            if (resultados[i] == numero) {
                esCorrecto = new JLabel();
                panel.add(esCorrecto);
                esCorrecto.setBounds(ancho - 120, aux, 100, 100);
                esCorrecto.setText("" + sopa.getResultado(i) + "");
                esCorrecto.setFont(new Font("calibri", Font.ITALIC, 25));
                sopa.setRespondidos(i);
            }
            aux = aux - 30;
        }
    }

    public void reiniciarFallo() {
        botones[sopa.getTocoPrimeroY()][sopa.getTocoPrimeroX()].setEnabled(true);
        botones[sopa.getTocoPrimeroY()][sopa.getTocoPrimeroX()].setBackground(Color.white);
    }

    public boolean getOcupado(boolean es) {
        return es;
    }

    public boolean verificarMovimiento(int x, int y) {
        int unoX = sopa.getTocoPrimeroX();
        int unoY = sopa.getTocoPrimeroY();
        int dosX = x;
        int dosY = y;
        if (unoX + 1 == dosX && unoY == dosY) {
            return true;
        } else if (unoX - 1 == dosX && unoY == dosY) {
            return true;
        } else if (unoY + 1 == dosY && unoX == dosX) {
            return true;
        } else if (unoY - 1 == dosY && unoX == dosX) {
            return true;
        }
        return false;
    }

    public void reiniciar() {
        JLabel etiquetaMenu = new JLabel();
        JButton botonReinicio = new JButton();
        JButton botonCategoria = new JButton();

        panel.add(etiquetaMenu);
        panel.add(botonReinicio);
        panel.add(botonCategoria);

        etiquetaMenu.setBounds(100, 50, 100, 50);
        etiquetaMenu.setText("Lo lograste");
        etiquetaMenu.setFont(new Font("calibri", Font.ITALIC, 20));

        botonReinicio.setBounds(50, alto-10, 100, 50);
        botonReinicio.setText("Reiniciar");
        botonReinicio.setFont(new Font("calibri", Font.ITALIC, 20));

        botonCategoria.setBounds(150, alto-10, 100, 50);
        botonCategoria.setText("Ir a Categoria");
        botonCategoria.setFont(new Font("calibri", Font.ITALIC, 20));

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ventana ventana = new Ventana();
            }
        });
        // Ventana ventana = new Ventana();
    }

}
