/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.combinado;

/**
 *
 * @author Carlos
 */
public class Casilla {
    private int x;
    private int y;
    private String contenido;
    private boolean dato;

    public Casilla(int x, int y, String contenido, boolean dato) {
        this.x = x;
        this.y = y;
        this.contenido = contenido;
        this.dato = dato;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isDato() {
        return dato;
    }

    public void setDato(boolean dato) {
        this.dato = dato;
    }
    
    
}
