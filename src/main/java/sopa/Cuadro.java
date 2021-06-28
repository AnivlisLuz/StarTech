/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopa;

/**
 *
 * @author USER
 */
public class Cuadro {
    private Cuadro norte;
    private Cuadro sur;
    private Cuadro este;
    private Cuadro oeste;
    private int valor;
    private boolean esCuadro;
    public Cuadro(boolean esCuadro, int valor){
        this.esCuadro=esCuadro;
        this.valor=valor;
    }
    public void setValor(int numero){
        valor=numero;
    }
    public int getValor(){
        return valor;
    }
    
}
