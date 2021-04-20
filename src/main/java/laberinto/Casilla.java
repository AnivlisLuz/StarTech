/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

/**
 *
 * @author Carlos
 */
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Casilla {
    int x, y;
    ArrayList<Casilla> vecinos = new ArrayList<>();
    boolean visitado = false;
    Casilla padre = null;
    boolean enCamino = false;
    double pisada;
    double distancia;
    boolean pared = true;
    boolean abierta = true;
    
    Casilla (int x, int y)
    {
        this (x, y, true);
    }
    
    Casilla (int x, int y, boolean esPared)
    {
        this.x = x;
        this.y = y;
        this.pared = esPared;
    }
    
    void addVecino (Casilla casilla)
    {
        if (!this.vecinos.contains(casilla))
            this.vecinos.add(casilla);
        if (!casilla.vecinos.contains(this))
            casilla.vecinos.add(this);
    }
    
    boolean estaDebajo()
    {
        return this.vecinos.contains(new Casilla(this.x, this.y + 1));
    }
    
    boolean estaDerecha()
    {
        return this.vecinos.contains(new Casilla(this.x + 1, this.y));
    }
    
    @Override
    public String toString()
    {
        return String.format("Casilla(%s, %s)", x, y);
    }
    
    @Override
    public boolean equals (Object casilla)
    {
        if (!(casilla instanceof Casilla))
            return false;
        Casilla aux = (Casilla) casilla;
        return (this.x == aux.x && this.y == aux.y);
    }
    
    @Override
    public int hashCode()
    {
        return this.x + this.y * 256;
    }
}
