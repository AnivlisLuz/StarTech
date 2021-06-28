/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.sopa;

import java.util.Random;

/**
 *
 * @author USER
 */
public class SopaDeResultados {

    private int x;
    private int y;
    private Matriz matriz;
    private int[] resultados;
    private boolean[] respondidos;
    private boolean tocado;
    private int primerDigito;
    private int segundoDigito;
    private int posicionXdigitoUno;
    private int posicionYdigitoUno;

    private int primerDigitoTomado;

    private int vidas;

    public SopaDeResultados() {
        Random r = new Random();
        x = r.nextInt(5) + 6;
        y = r.nextInt(5) + 6;
        matriz = new Matriz(x, y);
        tocado = false;
        vidas = 3;
    }

    public Cuadro[][] generarMatriz() {
        Random r = new Random();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j <= x; j++) {
                int z = r.nextInt(10);
                Cuadro cuadro = new Cuadro(true, z);
                matriz.anadir(cuadro);
            }
        }
        return matriz.getMatriz();
    }

    public String[] getNumeros() {
        Random r = new Random();
        int cuantosNumeros = r.nextInt(4) + 5;
        if (x * y < 60) {
            cuantosNumeros = r.nextInt(2) + 5;
        } else if (x * y < 101) {
            cuantosNumeros = r.nextInt(2) + 7;
        }
        int[] numero1 = new int[cuantosNumeros];
        int[] numero2 = new int[cuantosNumeros];
        String[] operaciones = new String[cuantosNumeros];
        resultados = new int[cuantosNumeros];
        respondidos = new boolean[cuantosNumeros];
        for (int i = 0; i < cuantosNumeros; i++) {
            int num1, num2;
            int signo = r.nextInt(4);
            if (signo == 0) {
                num1 = r.nextInt(45) + 5;
                num2 = r.nextInt(46) + 5;
                numero1[i] = num1;
                numero2[i] = num2;
                resultados[i] = num1 + num2;
                operaciones[i] = num1 + "+" + num2;
            } else if (signo == 1) {
                num1 = r.nextInt(50) + 50;
                num2 = r.nextInt(41);
                numero1[i] = num1;
                numero2[i] = num2;
                resultados[i] = num1 - num2;
                operaciones[i] = num1 + "-" + num2;
            } else if (signo == 2) {
                num1 = r.nextInt(8) + 4;
                num2 = r.nextInt(7) + 3;
                numero1[i] = num1;
                numero2[i] = num2;
                resultados[i] = num1 * num2;
                operaciones[i] = num1 + "*" + num2;
            } else {
                int[] aux1 = {100, 108, 104, 140, 180, 155, 160, 135, 172, 96};
                int[] aux2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
                int aux = r.nextInt(10);
                num1 = aux1[aux];
                num2 = aux2[aux];
                numero1[i] = num1;
                numero2[i] = num2;
                resultados[i] = num1 / num2;
                operaciones[i] = num1 + "/" + num2;
            }

        }
        return operaciones;
    }

    public int[] getResultados() {
        return resultados;
    }

    public int getResultado(int posicion) {
        return resultados[posicion];
    }

    public boolean getTocado() {
        return tocado;
    }

    public void setTocado(boolean a) {
        tocado = a;
    }

    public void setPrimerDigito(int numero) {
        primerDigito = numero;
    }

    public void setSegundoDigito(int numero) {
        segundoDigito = numero;
    }

    public int getPrimerD() {
        return primerDigito;
    }

    public int getSegundoD() {
        return segundoDigito;
    }

    public void setRespondidos(int posicion) {
        respondidos[posicion] = true;
    }

    public boolean todoRespondido() {
        for (int i = 0; i < respondidos.length; i++) {
            if (respondidos[i] == false) {
                return false;
            }
        }
        return true;
    }

    public void tocoPrimero(int y, int x) {
        posicionXdigitoUno = x;
        posicionYdigitoUno = y;
    }

    public int getTocoPrimeroX() {
        return posicionXdigitoUno;
    }

    public int getTocoPrimeroY() {
        return posicionYdigitoUno;
    }

    public void setPrimerDigitoTomado(int numero) {
        primerDigitoTomado = numero;
    }

    public int getPrimerDigitoTomado() {
        return primerDigitoTomado * 10;
    }

    public int getVidas() {
        return vidas;
    }

    public void perderVida() {
        vidas--;
    }

    public void establecerVidas() {
        vidas = 3;
    }
}
