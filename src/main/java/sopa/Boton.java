/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Boton extends JButton implements MouseListener {

    private final String[] mensajeContinuar = {"Continuar"};//Mensaje/Boton cuando el usuario completa un laberinto
    private final String[] mensajeSinVidas = {"Menú"};//Mensaje/Boton para ir al menú de niveles
    private final String[] mensajeGameOver = {"Menú", "Volver a Intentar"};//Mesaje/Boton para ir al menú de niveles o para reiniciar el laberinto
    private Cuadro[][] cuadros;
    private SopaDeResultados sopa;
    private int i;
    private int j;
    private boolean tocado;
    private Ventana ventana;
    private int primerDigito;
    private int segundoDigito;

    public Boton(int posx, int posy, int ancho, int alto, int i, int j, Cuadro[][] cuadros, SopaDeResultados sopa, Ventana ventana) {
        this.cuadros = cuadros;
        this.sopa = sopa;
        this.i = i;
        this.j = j;
        this.ventana = ventana;
        setBounds(posx, posy, ancho, alto);//posicion y tamaño del boton
        setFont(new Font("calibri", Font.ITALIC, 20));
        addMouseListener(this);

    }

    //Método para cambiar el texto del botón
    public void cambiarNombre(String nombre) {
        setText(nombre);
    }

    public boolean correcto() {
        int[] resultados = sopa.getResultados();
        for (int a = 0; a < resultados.length; a++) {
            if (resultados[a] / 10 == cuadros[i][j].getValor()) {
                sopa.setPrimerDigitoTomado(cuadros[i][j].getValor());
                return true;
            }
        }
        return false;
    }

    public boolean correcto2() {
        int[] resultados = sopa.getResultados();
        for (int a = 0; a < resultados.length; a++) {
            if (resultados[a] == (sopa.getPrimerDigitoTomado()) + (cuadros[i][j].getValor())) {
                return true;
            }
        }
        return false;
    }

    public static void esperarM(int segundos) {
        try {
            Thread.sleep(segundos);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (sopa.getTocado()) {
            if (correcto2() && ventana.verificarMovimiento(j, i)) {
                sopa.setSegundoDigito(cuadros[i][j].getValor());
                setBackground(Color.GREEN);
                ventana.correcto((sopa.getPrimerD() * 10) + sopa.getSegundoD());
                setEnabled(false);
            } else {
                setBackground(Color.RED);
                esperarM(500);
                ventana.reiniciarFallo();
                setBackground(Color.white);

            }
            sopa.setTocado(false);
        } else {
            if (correcto()) {
                sopa.setPrimerDigito(cuadros[i][j].getValor());
                sopa.setTocado(true);
                setBackground(Color.GREEN);
                setEnabled(false);
                sopa.tocoPrimero(i, j);
            } else {
                setBackground(Color.RED);
                esperarM(500);
                setBackground(Color.white);
            }
        }
        if (sopa.todoRespondido()) {
            System.out.println("Encontraste todos los numeros");
            ventana.reiniciar();
        }
        int a = cuadros[i][j].getValor();
        System.out.println("" + a);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
