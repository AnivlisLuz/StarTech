/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoc;

/**
 *
 * @author Carlos
 */
public class Punto {
    private int valor;
    private boolean visitada;
    private int posX;
    private int posY;

    public Punto(int valor, boolean visitada, int posX, int posY) {
        this.valor = valor;
        this.visitada = visitada;
        this.posX = posX;
        this.posY = posY;
    }

    public Punto() {
    }
    
    public Punto(int valor, int posX, int posY) {
        this.valor = valor;
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean getVisitada() {
        return visitada;
    }

    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }
    
    public Punto getSiguiente(Punto punto)
    {
        Punto aux = new Punto();
        if (punto.getPosY() + 1 == 0)
        {
            
        }
        return aux;
    }
}
